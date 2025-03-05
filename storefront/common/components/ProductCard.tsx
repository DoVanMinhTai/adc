import { ProductThumbnail } from '@/modules/homepage/models/ProductThumbnail'
import React, { useState } from 'react'
import ProductCardBase from './ProductCardBase';

export interface Props {
    product: ProductThumbnail;
    thumbnailId?: number;

}

export default function ProductCard({ product, thumbnailId }: Props) {
     console.log("🚀 Product received:", product);
    console.log("🚀 Thumbnail ID:", thumbnailId);

    const [thumbnailUrl,setThumbnailUrl] = useState<string>(thumbnailId ? '' : product.thumbnailUrl)
    console.log("object",product);
    
    return (
            <ProductCardBase product={product} thumbnailUrl={thumbnailUrl} />
    )
}