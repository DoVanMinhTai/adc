package com.adc.order.model.enumeration;

public enum OrderStatus {
    PENDING("PENDING"),       // Đơn hàng mới tạo
    PAID("PAID"),          // Đã thanh toán
    SHIPPING("SHIPPING"),      // Đang giao hàng
    COMPLETED("COMPLETED"),     // Giao hàng thành công
    CANCELLED("CANCELLED")  ;   // Bị hủy

    private final String name;
     OrderStatus(String name) {
        this.name = name;
    }
    public String getName() {
         return name;
    }
}
