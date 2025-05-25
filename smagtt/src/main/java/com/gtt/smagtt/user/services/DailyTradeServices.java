package com.gtt.smagtt.user.services;

import com.gtt.smagtt.user.dto.DailyTradeDto;
import com.gtt.smagtt.user.entity.DailyTrade;
import com.gtt.smagtt.user.mapper.DailyTradeMapper;
import com.gtt.smagtt.user.repo.DailyTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTradeServices {
    @Autowired
    private DailyTradeRepo dailyTradeRepo;

    @Autowired
    private DailyTradeMapper dailyTradeMapper;

    public DailyTradeDto addDailyTrade(DailyTradeDto dailyTradeDto) {
        //  Entity to Dto
        DailyTrade dailyTrade = dailyTradeMapper.mapToDailyTrade(dailyTradeDto);
        // Save entity
        DailyTrade saved = dailyTradeRepo.save(dailyTrade);
        // Convert saved entity back to DTO and return

        return dailyTradeMapper.mapToDailyTradeDto(saved);
    }

    public List<DailyTradeDto> getDailyTradeList() {
        List<DailyTrade> dailyTradeList = dailyTradeRepo.findAll();
        return dailyTradeMapper.mapToDailyTradeDtoList(dailyTradeList);
    }
}
