package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.entity.ExchRate;
import com.converter.currencyconverter.repos.ExchRateRepos;
import com.converter.currencyconverter.service.ExchRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class ExchRateController
{
    @Autowired
    private ExchRateService exchRateService;

    @Autowired
    private ExchRateRepos exchRateRepos;

    @GetMapping("/exchrates")
    public String getAll(Map<String, Object> model)
    {
        Iterable<ExchRate> listExchRate = exchRateService.findAll();

        model.put("exchrate", listExchRate);

        return "exchrates";
    }

//    @GetMapping("/exchrates_json")
//    public List<ExchRate> getAllJson()
//    {
//        List<ExchRate> listExchRate = exchRateService.findAll();
//
//        return listExchRate;
//    }
}
