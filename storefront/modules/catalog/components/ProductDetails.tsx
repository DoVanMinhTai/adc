import React, { useState } from 'react'
import { ProductDetail } from '../model/ProductDetail'

type ProductDetailProps = {
    product: ProductDetail;
}

export default function ProductDetails({product}: ProductDetailProps) {
    return (
        <>
            <div>{product.brandName}</div>
        </>
    )
}