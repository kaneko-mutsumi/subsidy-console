package org.example.subsidy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SubsidyApplication {

  private long id;
  private String applicantName;
  private LocalDate applicationDate;
  private BigDecimal amount;
  private ApplicationStatus status;

  public SubsidyApplication(
      long id,
      String applicantName,
      LocalDate applicationDate,
      BigDecimal amount,
      ApplicationStatus status) {

    this.id = id;
    this.applicantName = applicantName;
    this.applicationDate = applicationDate;
    this.amount = amount;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public String getApplicantName() {
    return applicantName;
  }

  public LocalDate getApplicationDate() {
    return applicationDate;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public ApplicationStatus getStatus() {
    return status;
  }


  public String summary() {
    return String.format(
        "申請ID: %d, 申請者名: %s, 申請日: %s, 金額: %s, 状態: %s",
        id,
        applicantName,
        applicationDate,
        amount,
        status);
  }
}