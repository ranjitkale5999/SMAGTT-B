package com.gtt.smagtt.user.services;

import com.gtt.smagtt.user.dto.DailyTradeDto;
import com.gtt.smagtt.user.entity.DailyTrade;
import com.gtt.smagtt.user.mapper.DailyTradeMapper;
import com.gtt.smagtt.user.repo.DailyTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        dailyTrade.setDeleted(false);
        dailyTrade.setActive(true);
        // Save entity
        DailyTrade saved = dailyTradeRepo.save(dailyTrade);

        return dailyTradeMapper.mapToDailyTradeDto(saved);
    }

    public List<DailyTradeDto> getDailyTradeList() {
        List<DailyTrade> dailyTradeList = dailyTradeRepo.findAll();
        for(DailyTrade dailyTrade1:dailyTradeList){
            if (dailyTrade1.getYear() > 0 && dailyTrade1.getMonth() > 0 && dailyTrade1.getDay() > 0) {
                LocalDate date = LocalDate.of(dailyTrade1.getYear(), dailyTrade1.getMonth(), dailyTrade1.getDay());
                dailyTrade1.setDate(date); // This sets the transient field
            }
            }
        return dailyTradeMapper.mapToDailyTradeDtoList(dailyTradeList);
    }

    public DailyTradeDto getByIdDailyTrade(Long id) {
        DailyTrade dailyTrade = dailyTradeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("DailyTrade not found with id: " + id));

            if (dailyTrade.getYear() > 0 && dailyTrade.getMonth() > 0 && dailyTrade.getDay() > 0) {
                LocalDate date = LocalDate.of(dailyTrade.getYear(), dailyTrade.getMonth(), dailyTrade.getDay());
                dailyTrade.setDate(date); // This sets the transient field
            }

        return dailyTradeMapper.mapToDailyTradeDto(dailyTrade);
    }

    public boolean delete(Long id) {
        return dailyTradeRepo.findById(id)
                .map(trade -> {
                    trade.setDeleted(true);
                    trade.setActive(false);
                    dailyTradeRepo.save(trade);
                    return true;
                })
                .orElse(false);
    }

    public DailyTradeDto updateDailyTrade(long id, DailyTradeDto dailyTradeDto) {
        DailyTrade existing = dailyTradeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("DailyTrade not found with id: " + id));
        existing.setShareName(dailyTradeDto.getName());
        existing.setPrice(dailyTradeDto.getPrice());
        existing.setPriceBuy(dailyTradeDto.getPriceBuy());
        existing.setPriceSell(dailyTradeDto.getPriceSell());
        existing.setTarget(dailyTradeDto.getTarget());
        existing.setGannLevel(dailyTradeDto.getGannLevel());
        existing.setTradeDate(dailyTradeDto.getTradeDate());
        existing.setDate(dailyTradeDto.getDate());
        DailyTrade updated = dailyTradeRepo.save(existing);
        return dailyTradeMapper.mapToDailyTradeDto(updated);
    }

}
