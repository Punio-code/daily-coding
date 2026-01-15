package com.example.chapter05.practice04;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 【問題04：オンライン通話の終了時刻を直そう（LocalDateTime / ZonedDateTime）】
 * 東京で 2025-01-15 20:00 開始、所要時間 30 分間のオンライン通話があります。
 * 現在のプログラムは、東京の「現地の通話開始・終了時刻」だけを表示しています。
 * これに加えて、ロンドンとシドニーの「現地の通話開始・終了時刻」を表示してください。
 * <p>
 * ▼現在の出力（このまま実行した例）
 * [Tokyo] 開始 2025-01-15 20:00 / 終了 2025-01-15 20:30
 * <p>
 * ▼期待される出力（正しく修正できた場合の例）
 * [Tokyo]  開始 2025-01-15 20:00 / 終了 2025-01-15 20:30
 * [London] 開始 2025-01-15 11:00 / 終了 2025-01-15 11:30
 * [Sydney] 開始 2025-01-15 22:00 / 終了 2025-01-15 22:30
 * <p>
 * ▼指示
 * (1) すでに作成済みの東京の ZonedDateTime（開始・終了）から、
 * withZoneSameInstant(...) を使ってロンドン／シドニーの現地時刻を求める。
 * (2) ロンドンとシドニーについても、東京と同じ形式で「開始・終了時刻」を表示する。
 * <p>
 * ▼ヒント（ZoneId）
 * - ロンドン：ZoneId.of("Europe/London")
 * - シドニー：ZoneId.of("Australia/Sydney")
 */
public class Main {

    public static void main(String[] args) {
        // オンライン通話の所要時間
        int durationMinutes = 30;
        // 通話開始時刻（東京）
        LocalDateTime startLocalDateTimeAtTokyo = LocalDateTime.of(2025, 1, 15, 20, 0);
        // 通話終了時刻（東京）
        LocalDateTime endLocalDateTimeAtTokyo = startLocalDateTimeAtTokyo.plusMinutes(durationMinutes);

        // 通話開始・終了時刻（東京）をLocalDateTime → ZonedDateTime に変換する。
        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime startZonedDateTimeAtTokyo = startLocalDateTimeAtTokyo.atZone(tokyoZoneId);
        ZonedDateTime endZonedDateTimeAtTokyo = endLocalDateTimeAtTokyo.atZone(tokyoZoneId);
//*  (1) すでに作成済みの東京の ZonedDateTime（開始・終了）から、
// *      withZoneSameInstant(...) を使ってロンドン／シドニーの現地時刻を求める。
        //「この“現地時間”が示している“実際の瞬間”を基準にして、
        //それが別の場所では何時になるか？」
// *  (2) ロンドンとシドニーについても、東京と同じ形式で「開始・終了時刻」を表示する。
        ZoneId londonZoneId = ZoneId.of("Europe/London");
        ZonedDateTime startZonedDateTimeAtLondon = startZonedDateTimeAtTokyo.withZoneSameInstant(londonZoneId);
        ZonedDateTime endZonedDateTimeAtLondon = endZonedDateTimeAtTokyo.withZoneSameInstant(londonZoneId);
        // 現地の通話開始・終了時刻を表示する。
        ZoneId sydneyZoneId = ZoneId.of("Australia/Sydney");
        ZonedDateTime startZonedDateTimeAtSydney = startZonedDateTimeAtTokyo.withZoneSameInstant(sydneyZoneId);
        ZonedDateTime endZonedDateTimeAtSydney = endZonedDateTimeAtTokyo.withZoneSameInstant(sydneyZoneId);
        System.out.printf(
                "[Tokyo] 開始 %s / 終了 %s%n",
                startZonedDateTimeAtTokyo.toLocalDateTime(),
                endZonedDateTimeAtTokyo.toLocalDateTime()
        );

        System.out.printf(
                "[London] 開始 %s / 終了 %s%n",
                startZonedDateTimeAtLondon.toLocalDateTime(),
                endZonedDateTimeAtLondon.toLocalDateTime()
        );
        System.out.printf(
                "[Sydney] 開始 %s / 終了 %s%n",
                startZonedDateTimeAtSydney.toLocalDateTime(),
                endZonedDateTimeAtSydney.toLocalDateTime()
        );
    }
}