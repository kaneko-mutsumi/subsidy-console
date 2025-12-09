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
      System.out.println(app.summary());
    }
    // 申請金額の合計を計算
    System.out.println("\n=== 申請金額の合計 ===");
    BigDecimal totalAmount = BigDecimal.ZERO;

    for (SubsidyApplication app : applications) {
      totalAmount = totalAmount.add(app.getAmount());
    }
    System.out.println("申請金額の合計: " + totalAmount);

    System.out.println("=== 申請状況（日本語）一覧 ===");
    for (SubsidyApplication app : applications) {
      System.out.println(app.getStatus());
    }
  }
}


