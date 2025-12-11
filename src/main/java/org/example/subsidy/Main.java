package org.example.subsidy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<SubsidyApplication> applications = Arrays.asList(
        new SubsidyApplication(
            1L,
            "山田太郎",
            java.time.LocalDate.of(2024, 6, 1),
            new java.math.BigDecimal("100000"),
            ApplicationStatus.APPLIED
        ),
        new SubsidyApplication(
            2L,
            "鈴木花子",
            java.time.LocalDate.of(2024, 6, 2),
            new java.math.BigDecimal("200000"),
            ApplicationStatus.APPROVED
        ),

        new SubsidyApplication(
            3L,
            "佐藤次郎",
            java.time.LocalDate.of(2024, 6, 3),
            new java.math.BigDecimal("150000"),
            ApplicationStatus.PAID
        )
    );

    // 申請一覧の表示
    System.out.println("=== 申請一覧 ===");
    for (SubsidyApplication app : applications) {
      printApplication(app);
    }

    // 支払い済み申請の表示
    System.out.println("\n=== 支払済み申請一覧 ===");
    for (SubsidyApplication app : applications) {
      printPaidApplication(app);
    }

    // 申請金額の合計を計算
    System.out.println("\n=== 申請金額の合計 ===");
    BigDecimal totalAmount = calcTotalAmount(applications);
    System.out.println("申請金額の合計: " + totalAmount);

    // ステータス別の合計金額を計算するメソッド
    System.out.println("\n=== ステータスごとの合計金額 ===");
    for (ApplicationStatus status : ApplicationStatus.values()) {
      BigDecimal statusTotal = calcStatusTotalAmount(applications, status);
      System.out.println(status + " の合計金額: " + statusTotal);
    }
  }

  // 1件申請の表示用メソッド
  private static void printApplication(SubsidyApplication app) {
    System.out.println(app.summary());
  }

  // 支払済み申請の表示用メソッド
  private static void printPaidApplication(SubsidyApplication app) {
    if (app.getStatus() == ApplicationStatus.PAID) {
      System.out.println(app.summary());
    }
  }

  // 合計金額を計算するメソッド
  private static BigDecimal calcTotalAmount(List<SubsidyApplication> applications) {
    BigDecimal totalAmount = BigDecimal.ZERO;

    for (SubsidyApplication app : applications) {
      totalAmount = totalAmount.add(app.getAmount());
    }
    return totalAmount;
  }

  // ステータス別の合計金額を計算するメソッド
  private static BigDecimal calcStatusTotalAmount(
      List<SubsidyApplication> applications,
      ApplicationStatus status) {
    BigDecimal statusTotal = BigDecimal.ZERO;

    for (SubsidyApplication app : applications) {
      if (app.getStatus() == status) {
        statusTotal = statusTotal.add(app.getAmount());
      }
    }
    return statusTotal;
  }
}

