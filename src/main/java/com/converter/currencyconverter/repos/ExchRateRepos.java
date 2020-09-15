package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.ExchRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ExchRateRepos extends JpaRepository<ExchRate, Long>
{
    @Query(value = "select * from exchrate " +
            "where exchrate.currency_code = ?1 " +
            "ORDER BY date_rate desc " +
            "limit 1;", nativeQuery = true)
    ExchRate findByCurrencyCodeAndDateRateDesc(String currencyCode);

    ExchRate findByCurrencyCodeOrderByDateRateDesc(String currencyCode);
}
