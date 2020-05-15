package com.converter.currencyconverter;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.service.CurrencyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
@EnableScheduling
public class CurrencyconverterApplication
{
	//public static List<Currency> currencyListGlobal;

	public static void main(String[] args)
	{
		SpringApplication.run(CurrencyconverterApplication.class, args);

//		ApplicationContext applicationContext = SpringApplication.run(CurrencyconverterApplication.class, args);

//		CurrencyService currencyServiceApp = (CurrencyService) applicationContext.getBean("currencyService");
//		currencyListGlobal = currencyServiceApp.listCurrency();
	}

}

/*
public static List<Currency> currencyListGlobal;

	public static void main(String[] args)
	{
		Flyway flyway = Flyway.configure().dataSource(dataSource).load();

		ApplicationContext applicationContext = SpringApplication.run(ConverterApplication.class, args);

		CurrencyService	currencyServiceApp = (CurrencyService) applicationContext.getBean("currencyService");
		currencyListGlobal = currencyServiceApp.listCurrency();
	}

 */
