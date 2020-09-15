package com.converter.currencyconverter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "historyquery")
public class HistoryQuery
{
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Double convertVal;
    private Double resultVal;
    private Date dateConvert;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_User_Id"))
    private User author;

    @ManyToOne(targetEntity = Currency.class)
    @JoinColumn(name="currency_code_from_id", referencedColumnName = "currency_code", foreignKey = @ForeignKey(name = "FK_Currency_From"))
    private Currency currencyFrom;

    @ManyToOne(targetEntity = Currency.class)
    @JoinColumn(name="currency_code_to_id", referencedColumnName = "currency_code", foreignKey = @ForeignKey(name = "FK_Currency_To"))
    private Currency currencyTo;

    public HistoryQuery()
    {
    }

    public HistoryQuery(Double convertVal, Double resultVal, Date dateConvert, Currency currencyFrom, Currency currencyTo)
    {
        this.convertVal = convertVal;
        this.resultVal = resultVal;
        this.dateConvert = dateConvert;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public Double getConvertVal() {
        return convertVal;
    }

    public void setConvertVal(Double convertVal) {
        this.convertVal = convertVal;
    }

    public Double getResultVal() {
        return resultVal;
    }

    public void setResultVal(Double resultVal) {
        this.resultVal = resultVal;
    }

    public Date getDateConvert() {
        return dateConvert;
    }

    public void setDateConvert(Date dateConvert) {
        this.dateConvert = dateConvert;
    }
}
