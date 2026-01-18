package com.example.chapter09.practice05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 予約を行う予約サービスを表現するクラス。
 */
public class ReservationService {
    // テストの再現性を高めるため「今日」は固定日付にしておく。
    static final LocalDate TODAY = LocalDate.of(2025, 9, 17);

    /**
     * 予約を作成して返す。
     * 【バグ仕様】現在は不正入力でも自動補正してしまう。
     * 本来は例外を投げるべき。
     *
     * @param checkIn  チェックイン日
     * @param checkOut チェックアウト日
     * @return 予約
     */
    public Reservation reserve(LocalDate checkIn, LocalDate checkOut) {

        // バグ1: チェックイン日よりもチェックアウト日のほうが過去（逆順入力）なら勝手に入れ替えて保存している。
        if (checkOut.isBefore(checkIn)) {
            throw new InvalidStayDatesException("不正な宿泊日です: チェックアウトはチェックインより後である必要があります。");
        }

        // バグ2: 過去のチェックインは本日に丸めてしまっている。
        if (checkIn.isBefore(TODAY)) {
            throw new PastDateBookingException("過去日付での予約はできません: チェックイン " + checkIn + " は本日 " + TODAY + " より過去です。");
        }

        int nights = (int) ChronoUnit.DAYS.between(checkIn, checkOut);
        return new Reservation(checkIn, checkOut, nights);
    }
}