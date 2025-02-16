package com.adc.book.model.enumeration;

import lombok.Getter;

@Getter
public enum DimensionUnit {
    CM("cm"),
    GRAM("gram");
    private String name;
    DimensionUnit(String name) {
    }
}
