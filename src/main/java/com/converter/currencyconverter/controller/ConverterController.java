package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.CurrencyconverterApplication;
import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.service.CurrencyService;
import com.converter.currencyconverter.service.ExchRateService;
import com.converter.currencyconverter.service.HistoryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ConverterController
{
    public CurrencyService currencyService;
    public ExchRateService exchRateService;
    public HistoryQueryService historyQueryService;

    @Value("${CurrencyRUR}")
    private Integer currencyRURPos;

    @Value("${CurrencyUSD}")
    private Integer currencyUSDPos;

    List<Currency> currencyListDB;

    @Autowired
    public ConverterController(CurrencyService currencyService, ExchRateService exchRateService, HistoryQueryService historyQueryService) {
        this.currencyService = currencyService;
        this.exchRateService = exchRateService;
        this.historyQueryService = historyQueryService;
    }

    @GetMapping({"/", "/converter"})
    public String converter(Model model)
    {
        List<Currency> resultListFrom = new ArrayList<Currency>();
        List<Currency> resultListTo = new ArrayList<Currency>();

        currencyListDB = currencyService.listCurrency();

//        if (CurrencyconverterApplication.currencyListGlobal.isEmpty())
//        {
//            CurrencyconverterApplication.currencyListGlobal = currencyService.listCurrency();
//        }

        Currency currencyDefFrom = currencyListDB.get(currencyRURPos);
        Currency currencyDefTo   = currencyListDB.get(currencyUSDPos);

        resultListFrom = currencyListDB.stream().filter(x -> !x.getCurrencyCode().equals(currencyDefFrom.getCurrencyCode())).collect(Collectors.toList());
        resultListTo = currencyListDB.stream().filter(x -> !x.getCurrencyCode().equals(currencyDefTo.getCurrencyCode())).collect(Collectors.toList());

        model.addAttribute("currencyFrom", resultListFrom);
        model.addAttribute("currencyTo", resultListTo);
        model.addAttribute("valueFrom",1);
        model.addAttribute("retValue",0.0);

        model.addAttribute("FromCode", currencyDefFrom.getCurrencyCode());
        model.addAttribute("FromDescr", currencyDefFrom.getFullDescription());
        model.addAttribute("ToCode",currencyDefTo.getCurrencyCode());
        model.addAttribute("ToDescr",currencyDefTo.getFullDescription());

        return "converter";
    }

    @PostMapping({"/","/converter"})
    @Transactional
    public String calculate(String currFrom, String currTo, Integer valueFrom, Model model)
    {
        List<Currency> retsultListFrom = new ArrayList<Currency>();
        List<Currency> retsultListTo   = new ArrayList<Currency>();

        if (currencyListDB.isEmpty())
        {
            currencyListDB = currencyService.listCurrency();
        }

        retsultListFrom = currencyListDB.stream().filter(x-> !x.getCurrencyCode().equals(currFrom)).collect(Collectors.toList());
        retsultListTo   = currencyListDB.stream().filter(x-> !x.getCurrencyCode().equals(currTo)).collect(Collectors.toList());

        Double retVal = 0.0;

        retVal = exchRateService.calcValue(currFrom, currTo, valueFrom);

        Currency currDefFrom = currencyService.findByName(currFrom);
        Currency currDefTo   = currencyService.findByName(currTo);

        model.addAttribute("FromCode",  currDefFrom.getCurrencyCode());
        model.addAttribute("FromDescr", currDefFrom.getFullDescription());
        model.addAttribute("ToCode",    currDefTo.getCurrencyCode());
        model.addAttribute("ToDescr",   currDefTo.getFullDescription());

        model.addAttribute("currencyFrom", retsultListFrom);
        model.addAttribute("currencyTo",   retsultListTo);
        model.addAttribute("valueFrom",    valueFrom);
        model.addAttribute("retValue",     retVal);

       // historyQueryService.saveRecord(currFrom, currTo, valueFrom.doubleValue(), retVal, new Date());

        return "converter";
    }

}


