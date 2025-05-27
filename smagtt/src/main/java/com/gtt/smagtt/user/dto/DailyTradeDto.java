package com.gtt.smagtt.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class DailyTradeDto {

    private long id;

    @NotEmpty
    @NotBlank(message = "Share name must not be blank")
    private String name;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Positive(message = "PriceBuy must be greater than 0")
    private double priceBuy;

    private double priceSell;
    @Positive(message = "Target must be greater than 0")
    private double target;
    @PositiveOrZero(message = "Gann level must be zero or greater")
    private double gannLevel;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @PastOrPresent(message = "Trade date must be in the past or present")
    private LocalDateTime tradeDate;

    private boolean isDeleted;
    private boolean isActive;

    @PastOrPresent(message = "Trade date must be in the past or present")
    private LocalDate date; //"2025-02-22"
    // Computed fields (optional for response)
    private int year;
    private int month;
    private int day;
    private int weekOfYear;

}
