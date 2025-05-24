package com.gtt.smagtt.user.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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


}
