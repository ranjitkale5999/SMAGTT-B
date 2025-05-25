package com.gtt.smagtt.user.controller;

import com.gtt.smagtt.exception.ErrorResponse;
import com.gtt.smagtt.user.dto.DailyTradeDto;
import com.gtt.smagtt.user.entity.DailyTrade;
import com.gtt.smagtt.user.services.DailyTradeServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class addDailyTradeCotroller {
    @Autowired
    private DailyTradeServices dailyTradeServices;

    @PostMapping()
    public ResponseEntity<ErrorResponse<DailyTradeDto>> addDailyTrade(@Valid @RequestBody DailyTradeDto dailyTradeDto) {
        DailyTradeDto dailyTradeDtosave = dailyTradeServices.addDailyTrade(dailyTradeDto);

        ErrorResponse<DailyTradeDto> response = new ErrorResponse<>(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "Daily Trade created successfully",
                dailyTradeDtosave
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ErrorResponse<List<DailyTradeDto>>> getDailyTradeList() {
        List<DailyTradeDto> dailyTrade = dailyTradeServices.getDailyTradeList();

        ErrorResponse<List<DailyTradeDto>> response = new ErrorResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Daily Trade List successfully",
                dailyTrade
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ErrorResponse<DailyTradeDto>> getByIdDailyTrade(@PathVariable Long id) {
        DailyTradeDto dailyTradeDto = dailyTradeServices.getByIdDailyTrade(id);

        ErrorResponse<DailyTradeDto> response = new ErrorResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Daily Trade with ID " + id + " retrieved successfully",
                dailyTradeDto
        );
        return ResponseEntity.ok(response);

    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ErrorResponse<Object>> deleteDailyTrade(@PathVariable Long id) {
//        dailyTradeServices.delete(id);
//
//        ErrorResponse<Object> response = new ErrorResponse<>(
//                LocalDateTime.now(),
//                HttpStatus.OK.value(),
//                "Teacher deleted successfully with ID: " + id,
//                null
//        );
//
//        return ResponseEntity.ok(response);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse<Object>> deleteDailyTrade(@PathVariable Long id) {
        boolean deleted = dailyTradeServices.delete(id);

        if (!deleted) {
            ErrorResponse<Object> response = new ErrorResponse<>(
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND.value(),
                    "DailyTrade not found with ID: " + id,
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ErrorResponse<Object> response = new ErrorResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "DailyTrade soft-deleted successfully with ID: " + id,
                null
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErrorResponse<DailyTradeDto>> updateDailyTrade(
            @PathVariable long id,
            @RequestBody DailyTradeDto dailyTradeDto) {
        DailyTradeDto updated = dailyTradeServices.updateDailyTrade(id, dailyTradeDto);
        ErrorResponse<DailyTradeDto> response = new ErrorResponse<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Teacher updated successfully with ID: " + id,
                updated
        );

        return ResponseEntity.ok(response);
    }

}
