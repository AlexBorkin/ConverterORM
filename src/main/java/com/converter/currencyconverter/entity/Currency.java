package com.converter.currencyconverter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//@Data
//@AllArgsConstructor
@Entity
@Table(name = "currency", uniqueConstraints = {@UniqueConstraint(columnNames = {"currency_code"})})
public class Currency implements Serializable
{
//    @Id
//    @GeneratedValue(generator="system-uuid", strategy = GenerationType.AUTO)
//    @GenericGenerator(name="system-uuid", strategy = "uuid")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency_code", length = 3, nullable = false, unique = true)
    private String currencyCode;

    @Column(length = 100)
    private String description;

    @Transient
    private String fullDescription;

    @Column
    private int    nominal;

    @Column(length = 3, nullable = false)
    private String numCode;

    @OneToMany(mappedBy = "currency", targetEntity = ExchRate.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ExchRate> exchRateList = new ArrayList<>();

    @OneToMany(mappedBy = "currencyFrom", targetEntity = HistoryQuery.class, cascade = CascadeType.ALL)
    private List<HistoryQuery> historyQueryListFrom;

    @OneToMany(mappedBy = "currencyTo", targetEntity = HistoryQuery.class, cascade = CascadeType.ALL)
    private List<HistoryQuery> historyQueryListTo;

    public Currency()
    {
    }



    public Long getId() {
        return id;
    }

    public Currency(String currencyCode, String description, int nominal, String numCode)
    {
        this.currencyCode = currencyCode;
        this.description = description;
        this.nominal = nominal;
        this.numCode = numCode;
    }

    public void addEchRate(ExchRate exchRate)
    {
       exchRate.setCurrency(this);
       this.exchRateList.add(exchRate);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return "(" + this.currencyCode + ") " + this.description;//fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }
}
