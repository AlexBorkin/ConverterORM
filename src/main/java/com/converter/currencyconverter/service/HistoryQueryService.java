package com.converter.currencyconverter.service;

import com.converter.currencyconverter.entity.HistoryQuery;
import com.converter.currencyconverter.repos.HistoryQueryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryQueryService
{
    @Autowired
    private HistoryQueryRepos historyQueryRepos;

    //public List<HistoryQuery> getAll()
}
