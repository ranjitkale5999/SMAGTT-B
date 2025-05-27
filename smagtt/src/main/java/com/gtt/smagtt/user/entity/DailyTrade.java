package com.gtt.smagtt.user.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "daily_trade")
public class DailyTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String shareName;
    private double price;
    private double priceBuy;
    private double priceSell;
    private double target;
    private double gannLevel;
    private LocalDateTime tradeDate;

    private boolean isDeleted = false;
    private boolean isActive = true;


    private int year;
    private int month;
    private int day;
    private int weekOfYear;
    @Transient
//    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private LocalDate date;
    @PrePersist
    @PreUpdate
    public void extractDateParts() {
        System.out.println("🔥 @PreUpdate called");
        if (date != null) {
            this.year = date.getYear();
            this.month = date.getMonthValue();
            this.day = date.getDayOfMonth();
            this.weekOfYear = date.get(WeekFields.ISO.weekOfWeekBasedYear());

            System.out.println("✅ Date parts set: " + year + "/" + month + "/" + day + " (Week " + weekOfYear + ")");
        } else {
            System.out.println("⚠️ Date is null");
        }
    }



}
