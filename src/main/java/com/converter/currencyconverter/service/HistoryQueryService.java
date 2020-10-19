package com.converter.currencyconverter.service;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.entity.HistoryQuery;
import com.converter.currencyconverter.repos.CurrencyRepos;
import com.converter.currencyconverter.repos.HistoryQueryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class HistoryQueryService
{
    @Autowired
    private HistoryQueryRepos historyQueryRepos;

    @Autowired
    private CurrencyRepos currencyRepos;

    public List<HistoryQuery> getAll()
    {
        return historyQueryRepos.findAll();
    }

    public List<HistoryQuery> findByFilters(String currencyFrom, String currencyTo, Date date)
    {
        return historyQueryRepos.findHistoryQueryByParams(currencyFrom, currencyTo, date);
    }

    public void save(HistoryQuery historyQuery)
    {
        historyQueryRepos.save(historyQuery);
    }
}
