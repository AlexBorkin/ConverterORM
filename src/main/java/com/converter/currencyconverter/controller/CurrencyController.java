package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.repos.CurrencyRepos;
import com.converter.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CurrencyController
{
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency")
    public String getAllCurr(Map<String, Object> model)
    {
        List<Currency> currencies = currencyService.listCurrency();

        Currency currency = new Currency("EUR","Евро", 100, "978");

        if (currencies.size() == 0)
        {
            currencies.add(currency);
        }

        model.put("currencyes", currencies);

        return "currency";
    }

//    @GetMapping("/currency_json")
//    public List<Currency> getAllCurrJson()
//    {
//        List<Currency> currencies = currencyService.listCurrency();
//
//        if (currencies.size() == 0)
//        {
//            currencies.add(new Currency("EUR","Евро", 100, "978"));
//        }
//
//        return currencies;
//    }
}
