package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.repos.CurrencyRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CurrencyController
{
    @Autowired
    private CurrencyRepos currencyRepos;

    @GetMapping("/currency")
    public String getAllCurr(Map<String, Object> model)
    {
        ArrayList<Currency> currencies = currencyRepos.findAll();

        Currency currency = new Currency("EUR","Евро", 100, "тгьСщв");

        if (currencies.size() == 0)
        {
            currencies.add(currency);
        }

       // if (currencyRepos.)

        model.put("currencyes", currencies);

        return "currency";
    }
}
