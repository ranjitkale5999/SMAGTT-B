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
    public DailyTradeDto addDailyTrade(@RequestBody DailyTradeDto dailyTradeDto){
        return dailyTradeServices.addDailyTrade(dailyTradeDto);
    }

    @GetMapping
    public List<DailyTradeDto> getDailyTradeList(){
        return dailyTradeServices.getDailyTradeList();
    }

}
