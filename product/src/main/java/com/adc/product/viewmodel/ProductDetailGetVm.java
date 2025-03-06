package com.adc.product.viewmodel;

import com.adc.product.model.Cate;

import java.util.List;

public record ProductDetailGetVm(
        Long id,
        String name,
        String brandName,
        List<String> productCategories,
        String shorTDescription,
        String description,
        String specification,
        boolean isPublished,
        boolean isFeatured,
        boolean isAllowedToOrder,
        Double price,
        String thumbnailMediaUrl,
        List<String> productImageMediaUrl

) {
}
