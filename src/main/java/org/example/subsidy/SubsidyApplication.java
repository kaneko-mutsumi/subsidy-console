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

  @Override
  public String toString() {
    return "SubsidyApplication{" +
        "id=" + id +
        ", applicantName='" + applicantName + '\'' +
        ", applicationDate=" + applicationDate +
        ", amount=" + amount +
        ", status=" + status +
        '}';
  }

}
