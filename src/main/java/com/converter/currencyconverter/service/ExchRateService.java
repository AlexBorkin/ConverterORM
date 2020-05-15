package com.converter.currencyconverter.service;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.entity.ExchRate;
import com.converter.currencyconverter.repos.ExchRateRepos;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExchRateService
{
    @Autowired
    private ExchRateRepos exchRateRepos;

    @Autowired
    private CurrencyService currencyService;

    public void saveRecord(Date curDate, String charCode, Double value, String code, Currency currency)
    {
        ExchRate exchRate = new ExchRate(curDate, value, charCode, code, currency);

        exchRateRepos.save(exchRate);
    }

    public void saveRecord(Date curDate, String charCode, Double value, String code)
    {
        ExchRate exchRate = new ExchRate(curDate, value, charCode, code);

        exchRateRepos.save(exchRate);
    }

    public Double calcValue(String currFrom, String currTo, Integer value)
    {
        Double resValue = 0.0;

        Double curValFrom;
        Double curValTo;
        ExchRate exchRateFrom;
        ExchRate exchRateTo;
        Currency currencyFrom;
        Currency currencyTo;

        exchRateFrom = exchRateRepos.findByCurrencyCodeAndDateRateDesc(currFrom);
        exchRateTo   = exchRateRepos.findByCurrencyCodeAndDateRateDesc(currTo);

        currencyFrom = exchRateFrom.getCurrency();
        currencyTo   = exchRateTo.getCurrency();

        resValue = value * ((exchRateFrom.getCurrencyRate() / currencyFrom.getNominal()) / (exchRateTo.getCurrencyRate() / currencyTo.getNominal()));

        return DoubleRounder.round(resValue, 4);
    }
}
