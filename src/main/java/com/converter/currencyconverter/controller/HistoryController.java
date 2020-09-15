package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.entity.HistoryQuery;
import com.converter.currencyconverter.service.CurrencyService;
import com.converter.currencyconverter.service.HistoryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HistoryController
{
    @Value("${CurrencyRUR}")
    private Integer currencyRURPos;

    @Value("${CurrencyUSD}")
    private Integer currencyUSDPos;

    List<Currency> currencyListDB;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private HistoryQueryService historyQueryService;

    @GetMapping("/historyQuery")
    public String getAllHistory(Model model)
    {
        List<HistoryQuery> historyQueryList = historyQueryService.getAll();

        currencyListDB = currencyService.listCurrency();

        model.addAttribute("FromCode", currencyListDB.get(currencyRURPos).getCurrencyCode());
        model.addAttribute("FromDescr", currencyListDB.get(currencyRURPos).getFullDescription());

        model.addAttribute("ToCode", currencyListDB.get(currencyUSDPos).getCurrencyCode());
        model.addAttribute("ToDescr", currencyListDB.get(currencyUSDPos).getFullDescription());

        List<Currency> currencyFrom = currencyListDB.stream()
                                        .filter(currency -> !currency.getCurrencyCode().equals(currencyListDB.get(currencyRURPos)))
                                        .collect(Collectors.toList());

        List<Currency> currencyTo = currencyListDB.stream()
                                        .filter(currency -> !currency.getCurrencyCode().equals(currencyListDB.get(currencyUSDPos)))
                                        .collect(Collectors.toList());

        model.addAttribute("currencyFrom", currencyFrom);
        model.addAttribute("currencyTo", currencyTo);

        model.addAttribute("convertDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        model.addAttribute("history", historyQueryList);

        return "historyquery";
    }

}
