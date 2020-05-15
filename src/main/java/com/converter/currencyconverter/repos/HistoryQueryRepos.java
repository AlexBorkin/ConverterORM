package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.HistoryQuery;
import org.springframework.data.repository.CrudRepository;

public interface HistoryQueryRepos extends CrudRepository<HistoryQuery, Long>
{
}
