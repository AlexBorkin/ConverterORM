package com.converter.currencyconverter;

import com.converter.currencyconverter.entity.Currency;
import com.converter.currencyconverter.service.CurrencyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URI;
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

//	@Bean
//	RouterFunction<ServerResponse> docsRouter() {
//		return route(RequestPredicates.GET("/docs**"), req ->
//				ServerResponse.temporaryRedirect(URI.create("/swagger-ui.html"))
//						.build());
//	}

//	@Bean
//	public Docket swaggerDoc()
//	{
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("converter"))
//				.build();
//	}

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
