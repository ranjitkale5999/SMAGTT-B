package com.gtt.smagtt.user.services;
import com.gtt.smagtt.user.entity.DailyTrade;
import com.gtt.smagtt.user.repo.DailyTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTradeServices {
    @Autowired
    private DailyTradeRepo dailyTradeRepo;

    public  DailyTrade addDailyTrade(DailyTrade dailyTrade){
        return dailyTradeRepo.save(dailyTrade);
    }


    public List<DailyTrade> getDailyTradeList(){
        return dailyTradeRepo.findAll();
    }
}
