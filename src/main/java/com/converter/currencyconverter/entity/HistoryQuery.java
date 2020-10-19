package com.converter.currencyconverter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    @Temporal(value = TemporalType.DATE)
    public Date dateConvert;

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

    public String getAuthorName()
    {
        return author != null ? author.getUsername() : "<empty>";
    }



    public HistoryQuery(Double convertVal,
                        Double resultVal,
                        Date dateConvert,
                        Currency currencyFrom,
                        Currency currencyTo,
                        User user)
    {
        this.convertVal = convertVal;
        this.resultVal = resultVal;
        this.dateConvert = dateConvert;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.author = user;
    }
//
//
//    public HistoryQuery(double doubleValue,
//                        Double retVal,
//                        Date date,
//                        Currency currDefFrom,
//                        Currency currDefTo,
//                        User user)
//    {
//        this.convertVal = convertVal;
//        this.resultVal = resultVal;
//        this.dateConvert = dateConvert;
//        this.currencyFrom = currencyFrom;
//        this.currencyTo = currencyTo;
//        this.author = user;
//    }
}
