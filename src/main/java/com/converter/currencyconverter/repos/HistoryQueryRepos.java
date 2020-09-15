package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.HistoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryQueryRepos extends JpaRepository<HistoryQuery, Long>
{
}
