package com.converter.currencyconverter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "exchrate", uniqueConstraints = {@UniqueConstraint(name = "UK_DATE_CURRENCY", columnNames = {"date_rate", "currency_code"})})
public class ExchRate
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @Column(name="currency_id")
//    private Long currencyId;

    @Column(name = "date_rate")
    private Date   dateRate;
    private Double currencyRate;

    private String currencyDescription;
    @Transient
    private String fullDescription;

    @Column(name="currency_code")
    private String currencyCode;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="currency_id", foreignKey = @ForeignKey(name = "FK_Currency"))
    private Currency currency;

    public ExchRate()
    {
    }

//    public ExchRate(Date dateRate, Double currencyRate, String currencyDescription, String currencyCode, Currency currency)
//    {
//        this.dateRate = dateRate;
//        this.currencyRate = currencyRate;
//        this.currencyDescription = currencyDescription;
//        this.currencyCode = currencyCode;
//        this.currency = currency;
//    }
//
//    public ExchRate(Date dateRate, Double currencyRate, String currencyDescription, String currencyCode)
//    {
//        this.dateRate = dateRate;
//        this.currencyRate = currencyRate;
//        this.currencyDescription = currencyDescription;
//        this.currencyCode = currencyCode;
//
//    }
//
//    public ExchRate(Long id, Date dateRate, Double currencyRate, String currencyDescription, String fullDescription)
//    {
//        this.id = id;
//        this.dateRate = dateRate;
//        this.currencyRate = currencyRate;
//        this.currencyDescription = currencyDescription;
//        this.fullDescription = fullDescription;
//    }
//
//    public Currency getCurrency()
//    {
//        return currency;
//    }
//
//    public void setCurrency(Currency currency)
//    {
//        this.currency = currency;
//    }
//
//    public Date getDateRate() {
//        return dateRate;
//    }
//
//    public void setDateRate(Date dateRate) {
//        this.dateRate = dateRate;
//    }
//
//    public Double getCurrencyRate() {
//        return currencyRate;
//    }
//
//    public void setCurrencyRate(Double currencyRate) {
//        this.currencyRate = currencyRate;
//    }
//
//    public String getCurrencyDescription() {
//        return currencyDescription;
//    }
//
//    public void setCurrencyDescription(String currencyDescription) {
//        this.currencyDescription = currencyDescription;
//    }
//
//    public String getFullDescription() {
//        return fullDescription;
//    }
//
//    public void setFullDescription(String fullDescription) {
//        this.fullDescription = fullDescription;
//    }
}
