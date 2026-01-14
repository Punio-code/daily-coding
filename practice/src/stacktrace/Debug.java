package stacktrace;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;

public final class Debug {

    private Debug() {
    }

    /**
     * ヒープ使用量のスナップショット（JVMが把握している範囲の統計）。
     * ※オブジェクト単位の内訳ではなく、ヒープ全体の大枠。
     */
    public static void dumpHeapStats(String label) {
        Runtime rt = Runtime.getRuntime();

        long max = rt.maxMemory();
        long total = rt.totalMemory();
        long free = rt.freeMemory();
        long used = total - free;

        System.out.println("== HEAP STATS: " + label + " ==");
        System.out.println("  used : " + bytes(used));
        System.out.println("  free : " + bytes(free));
        System.out.println("  total: " + bytes(total));
        System.out.println("  max  : " + bytes(max));
    }

    /**
     * 任意オブジェクトを起点に、参照先を辿って「ヒープ上のオブジェクトのつながり」をツリー表示する。
     * - 循環参照は検出して止める（IdentityHashMap）
     * - 深さや要素数に上限を設けて暴走を防ぐ
     * - static フィールドは除外（ヒープ可視化という目的上ノイズになりやすい）
     */
    public static void dumpObjectGraph(String label, Object root) {
        System.out.println("== OBJECT GRAPH: " + label + " ==");
        IdentityHashMap<Object, Integer> visited = new IdentityHashMap<>();
        dump(root, 0, visited, new Limits(6, 50, 50)); // 深さ6、配列50要素、フィールド50個まで
    }

    // --------- 内部実装 ---------

    private static void dump(Object obj, int depth, IdentityHashMap<Object, Integer> visited, Limits limits) {
        String indent = "  ".repeat(Math.max(0, depth));

        if (obj == null) {
            System.out.println(indent + "null");
            return;
        }

        // 深さ制限
        if (depth > limits.maxDepth()) {
            System.out.println(indent + summary(obj) + "  ... (depth limit)");
            return;
        }

        // 既訪問チェック（同一オブジェクト = 同一identity）
        Integer id = visited.get(obj);
        if (id != null) {
            System.out.println(indent + summary(obj) + "  ↩ already seen #" + id);
            return;
        }
        int newId = visited.size() + 1;
        visited.put(obj, newId);

        Class<?> cls = obj.getClass();
        System.out.println(indent + summary(obj) + "  #" + newId);

        // 値系はここで打ち切り（ヒープの“参照の枝”として重要ではない）
        if (isLeaf(cls)) {
            return;
        }

        // 配列
        if (cls.isArray()) {
            int len = Array.getLength(obj);
            int limit = Math.min(len, limits.maxArrayElements());
            System.out.println(indent + "  [array length=" + len + ", showing=" + limit + "]");
            for (int i = 0; i < limit; i++) {
                Object elem = Array.get(obj, i);
                System.out.println(indent + "  [" + i + "] ->");
                dump(elem, depth + 2, visited, limits);
            }
            if (len > limit) {
                System.out.println(indent + "  ... (array truncated)");
            }
            return;
        }

        // フィールド（インスタンスのみ）
        Field[] fields = cls.getDeclaredFields();
        int shown = 0;
        for (Field f : fields) {
            if (shown >= limits.maxFields()) {
                System.out.println(indent + "  ... (fields truncated)");
                break;
            }
            if (Modifier.isStatic(f.getModifiers())) {
                continue; // staticは除外
            }
            f.setAccessible(true);

            Object value;
            try {
                value = f.get(obj);
            } catch (IllegalAccessException e) {
                System.out.println(indent + "  " + f.getName() + " = <inaccessible>");
                continue;
            }

            System.out.println(indent + "  ." + f.getName() + " ->");
            dump(value, depth + 2, visited, limits);
            shown++;
        }
    }

    private static String summary(Object obj) {
        Class<?> c = obj.getClass();
        String base = c.getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
        if (obj instanceof CharSequence cs) {
            String s = cs.toString();
            s = s.length() > 60 ? s.substring(0, 60) + "..." : s;
            return base + " \"" + s + "\"";
        }
        if (obj instanceof Number || obj instanceof Boolean) {
            return base + " (" + obj + ")";
        }
        return base;
    }

    private static boolean isLeaf(Class<?> cls) {
        return cls.isPrimitive()
                || Number.class.isAssignableFrom(cls)
                || Boolean.class.isAssignableFrom(cls)
                || Character.class.isAssignableFrom(cls)
                || CharSequence.class.isAssignableFrom(cls)
                || Enum.class.isAssignableFrom(cls);
    }

    private static String bytes(long v) {
        // 単純表示（記事用途なら十分）。必要ならKiB/MiB整形に拡張可。
        return v + " bytes";
    }

    private record Limits(int maxDepth, int maxArrayElements, int maxFields) {
    }
}