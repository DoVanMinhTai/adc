package com.example.book.Model.enumeration;

import lombok.Getter;

@Getter
public enum DimensionUnit {
    CM("cm"),
    GRAM("gram");
    private String name;
    DimensionUnit(String name) {
    }
}
