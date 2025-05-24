package com.gtt.smagtt.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class DailyTradeDto {

    private long id;
    private String shareName;
    private double price;
    private double priceBuy;
    private double priceSell;
    private double target;
    private double gannLevel;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime tradeDate;
}
