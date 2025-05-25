package com.gtt.smagtt.user.services;

import com.gtt.smagtt.user.dto.DailyTradeDto;
import com.gtt.smagtt.user.entity.DailyTrade;
import com.gtt.smagtt.user.mapper.DailyTradeMapper;
import com.gtt.smagtt.user.repo.DailyTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public DailyTradeDto getByIdDailyTrade(Long id) {
        DailyTrade dailyTrade = dailyTradeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("DailyTrade not found with id: " + id));
        return dailyTradeMapper.mapToDailyTradeDto(dailyTrade);
    }
    public boolean delete(Long id) {
        return dailyTradeRepo.findById(id)
                .map(trade -> {
                    dailyTradeRepo.delete(trade);
                    return true;
                })
                .orElse(false);
    }

    public DailyTradeDto updateDailyTrade(long id, DailyTradeDto dailyTradeDto) {
        DailyTrade existing = dailyTradeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("DailyTrade not found with id: " + id));

        // Update fields explicitly to avoid overwriting ID or other unwanted fields
        existing.setShareName(dailyTradeDto.getName());
        existing.setPrice(dailyTradeDto.getPrice());
        existing.setPriceBuy(dailyTradeDto.getPriceBuy());
        existing.setPriceSell(dailyTradeDto.getPriceSell());
        existing.setTarget(dailyTradeDto.getTarget());
        existing.setGannLevel(dailyTradeDto.getGannLevel());
        existing.setTradeDate(dailyTradeDto.getTradeDate());

        DailyTrade updated = dailyTradeRepo.save(existing);
        return dailyTradeMapper.mapToDailyTradeDto(updated);
    }
}
