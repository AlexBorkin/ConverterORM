package com.converter.currencyconverter.service;

import com.converter.currencyconverter.dataprovider.ValuteAttribute;
import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.entity.ExchRate;
import com.converter.currencyconverter.repos.CurrencyRepos;
import com.converter.currencyconverter.repos.ExchRateRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

@Service
public class CurrencyService
{
    @Autowired
    private CurrencyRepos currencyRepos;

    @Autowired
    private ExchRateService exchRateService;

    public List<Currency> listCurrency()
    {
        return currencyRepos.findAll();
    }

    public Currency findByName(String string)
    {
        return currencyRepos.findByCurrencyCode(string);
    }

    public void saveAll(Map<String, ValuteAttribute> map)
    {
        Currency        currency;
        ValuteAttribute curAttr;
        ExchRate        exchRate;

        for (Map.Entry<String, ValuteAttribute> curEntry: map.entrySet())
        {
            curAttr = curEntry.getValue();

            try
            {
                currency = currencyRepos.findByCurrencyCode(curAttr.getCharCode());

                if (currency == null)
                {
                    currency = new Currency(curAttr.getCharCode(),
                                            curAttr.getName(),
                                            Integer.parseInt(curAttr.getNominal()),
                                            curAttr.getNumCode());
                }

                try
                {

                    exchRate = new ExchRate(curAttr.getCurDate(),
                                            curAttr.getValue(),
                                            curAttr.getName(),
                                            curAttr.getCharCode());

                    currency.addEchRate(exchRate);

                    currencyRepos.save(currency);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }


}


