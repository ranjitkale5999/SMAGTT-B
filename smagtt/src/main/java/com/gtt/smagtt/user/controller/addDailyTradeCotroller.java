package com.gtt.smagtt.user.controller;

import com.gtt.smagtt.user.dto.DailyTradeDto;
import com.gtt.smagtt.user.entity.DailyTrade;
import com.gtt.smagtt.user.services.DailyTradeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins ="*")
public class addDailyTradeCotroller {
    @Autowired
    private DailyTradeServices dailyTradeServices;

    @PostMapping()
    public DailyTrade addDailyTrade(@RequestBody DailyTrade dailyTrade){
        return dailyTradeServices.addDailyTrade(dailyTrade);
    }

    @GetMapping
    public List<DailyTrade> getDailyTradeList(){
        return dailyTradeServices.getDailyTradeList();
    }
}
