package com.lithium.mineraloi.university;


public enum TabsEnum {
    HOME_TAB(1),
    USER_TAB(2),
    POST_TAB(3);

    private final int value;

    TabsEnum(final int val) {
        value = val;
    }

    public int getValue() { return value; }
}