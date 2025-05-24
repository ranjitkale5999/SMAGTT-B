package com.gtt.smagtt.user.repo;

import com.gtt.smagtt.user.entity.DailyTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyTradeRepo extends JpaRepository<DailyTrade,Long> {
}
