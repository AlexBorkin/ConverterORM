package com.converter.currencyconverter.repos;

import com.converter.currencyconverter.entity.Currency;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface CurrencyRepos extends CrudRepository<Currency, Long>
{
     ArrayList<Currency> findAll();

     Currency findByCurrencyCode(String currencyCode);



//     @Override
//     <S extends Currency> Iterable<S> saveAll(Iterable<S> iterable);
//
//     @Query()
//     void saveAll(List<Currency> arrayList);
}
