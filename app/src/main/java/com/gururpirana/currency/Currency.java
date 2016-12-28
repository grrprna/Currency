package com.gururpirana.currency;

/**
 * Created by mobiltrakya on 22/12/16.
 */

public class Currency {


    /**
     * selling : 3.5115
     * update_date : 1482389390
     * currency : 1
     * buying : 3.5096
     * change_rate : 0.0855066267636
     * name : amerikan-dolari
     * full_name : Amerikan Doları
     * code : USD
     */

    private double selling;
    private int update_date;
    private int currency;
    private double buying;
    private double change_rate;
    private String name;
    private String full_name;
    private String code;

    public double getSelling() {
        return selling;
    }

    public void setSelling(double selling) {
        this.selling = selling;
    }

    public int getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(int update_date) {
        this.update_date = update_date;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public double getBuying() {
        return buying;
    }

    public void setBuying(double buying) {
        this.buying = buying;
    }

    public double getChange_rate() {
        return change_rate;
    }

    public void setChange_rate(double change_rate) {
        this.change_rate = change_rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
