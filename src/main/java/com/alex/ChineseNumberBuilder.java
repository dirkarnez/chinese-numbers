package com.alex;

import org.apache.commons.lang.StringUtils;

public class ChineseNumberBuilder {
    private Scenario scenario;

    private static final Number[] CHINESE_NUMS = {
            Number.ZERO,
            Number.ONE,
            Number.TWO,
            Number.THREE,
            Number.FOUR,
            Number.FIVE,
            Number.SIX,
            Number.SEVEN,
            Number.EIGHT,
            Number.NINE
    } ;

    private static final Number[] CHINESE_UNIT_1 = {
            null,
            Number.TEN,
            Number.HUNDRED,
            Number.THOUSAND
    };

    private static final Number[] CHINESE_UNIT_2 = {
            null,
            Number.TEN_THOUSAND,
            Number.BILLION
    };

    public ChineseNumberBuilder(Scenario scenario) {
        this.scenario = scenario != null ? scenario : Scenario.ModernNumber;
    }

    public String build(String str) {
        if (str == null) {
            return "";
        }

        String value = StringUtils.stripStart(str.trim(), "0");

        StringBuilder buffer = new StringBuilder();

        if (value.equals("")) {
            return buffer.append(Number.ZERO.getTradChineseNormal()).toString();
        }

        int i, j;
        for (i = value.length() - 1, j = 0; i >= 0; i--, j++) {
            char n = value.charAt(i);
            if (n == '0') {
                if (i < value.length() - 1 && value.charAt(i + 1) != '0') {
                    buffer.append(Number.ZERO.getTradChineseNormal());
                }
                if (j % 4 == 0) {
                    if(i > 0 && value.charAt(i - 1) != '0'
                            || i > 1 && value.charAt(i - 2) != '0'
                            || i > 2 && value.charAt(i - 3) != '0') {
                        Number unit_2 = CHINESE_UNIT_2[j / 4];
                        if (unit_2 != null) {
                            buffer.append(unit_2.getTradChineseNormal());
                        }
                    }
                }
            } else {
                if (j % 4 == 0) {
                    Number unit_2 = CHINESE_UNIT_2[j / 4];
                    if (unit_2 != null) {
                        buffer.append(unit_2.getTradChineseNormal());
                    }
                }

                Number unit_1 = CHINESE_UNIT_1[j % 4];
                if (unit_1 != null) {
                    buffer.append(unit_1.getTradChineseNormal());
                }

                Number numberToAdd = CHINESE_NUMS[n - '0'];
                String toAdd = numberToAdd.getTradChineseNormal();
                if(toAdd == Number.ONE.getTradChineseNormal() && value.length() < 3 && j != 0) {
                    toAdd = null;
                }

                if (toAdd != null) {
                    buffer.append(toAdd);
                }
            }
        }
        return buffer.reverse().toString();
    }

//    public static void main(String[] args) {
//        System.out.println(toFullChineseNumber("2007"));
//    }

//    public static String toSingleChineseNumber(String str) {
//        if (str == null) {
//            return "";
//        }
//
//        return StringUtils.replaceEach(str, new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" },
//                new String[] {
//                        ONE, TWO,
//                        THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO
//                });
//    }
}


