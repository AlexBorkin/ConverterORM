package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.entity.HistoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface HistoryQueryRepos extends JpaRepository<HistoryQuery, Long>
{

    @Query("select history from HistoryQuery history " +
           "where history.dateConvert = :dateQuery ")
    List<HistoryQuery>   findHistoryQueryByParams(@Param("dateQuery") Date dateQuery);

    @Query("select history from HistoryQuery history " +
            "where (history.dateConvert = :date) " +
            "and (:currencyFrom is null or history.currencyFrom.currencyCode = :currencyFrom) " +
            "and (:currencyTo is null or history.currencyTo.currencyCode = :currencyTo)")
    List<HistoryQuery>   findHistoryQueryByParams(@Param("currencyFrom") String currencyFrom,
                                                  @Param("currencyTo") String currencyTo,
                                                  @Param("date") Date date);

    @Query("select history from HistoryQuery history " +
          //  "where (:date is null or history.dateConvert = :date) " +
            "where (:currencyFrom is null or history.currencyFrom.currencyCode = :currencyFrom) " +
            "and (:currencyTo is null or history.currencyTo.currencyCode = :currencyTo)")
    List<HistoryQuery>   findHistoryQueryByParams(@Param("currencyFrom") String currencyFrom,
                                                @Param("currencyTo") String currencyTo);
                                               // @Param("date") Date date);

    List<HistoryQuery> findHistoryQueryByCurrencyFromAndAndCurrencyToAndDateConvert(Currency currencyFrom,
                                                                                    Currency currencyTo,
                                                                                    Date date);
//
//    List<HistoryQuery> findHistoryQueryByCurrencyFrom(String currencyFrom);
//
//    List<HistoryQuery> findHistoryQueryByCurrencyTo(String currencyTo);
//
//    List<HistoryQuery> findHistoryQueryByCurrencyFromAndAndCurrencyTo(String currencyFrom,
//                                                                      String currencyTo);
}
