package com.gtt.smagtt.user.mapper;

import com.gtt.smagtt.user.dto.DailyTradeDto;
import com.gtt.smagtt.user.entity.DailyTrade;
import org.mapstruct.*;

import java.util.List;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper(componentModel = "spring")
public interface DailyTradeMapper {

    DailyTradeDto mapToDailyTradeDto(DailyTrade dailyTrade);

    DailyTrade mapToDailyTrade(DailyTradeDto dailyTradeDto);

    List<DailyTradeDto> mapToDailyTradeDtoList(List<DailyTrade> dailyTrades);

    List<DailyTrade> mapToDailyTradeList(List<DailyTradeDto> dailyTradeDtos);
}
