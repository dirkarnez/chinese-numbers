package com.alex;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public enum Number {
    ZERO("chinese.ZERO"),
    ONE("chinese.ONE"),
    TWO("chinese.TWO"),
    THREE("chinese.THREE"),
    FOUR("chinese.FOUR"),
    FIVE("chinese.FIVE"),
    SIX("chinese.SIX"),
    SEVEN("chinese.SEVEN"),
    EIGHT("chinese.EIGHT"),
    NINE("chinese.NINE"),
    TEN("chinese.TEN"),
    HUNDRED("chinese.HUNDRED"),
    THOUSAND("chinese.THOUSAND"),
    TEN_THOUSAND("chinese.TEN_THOUSAND"),
    BILLION("chinese.BILLION");

    public String getTradChineseNormal() {
        return tradChineseNormal;
    }

    private String tradChineseNormal;
//    private final String tradChineseClassic;
//
//    private final String simpleChineseNormal;
//    private final String simpleChineseClassic;


    Number(String key) {
        try {
            this.tradChineseNormal = new String(ResourceBundle.getBundle("chinese").getString(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}