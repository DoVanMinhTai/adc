import React from "react";
import ImageWithFallBack from "@/common/components/ImageWithFallBack";
import { ProductImageGarelly } from "@/common/ProductImageGarelly";
type ProductImageProps = {
    thumbnail: string;
    listImages: string[];
    productName: string;
}

export default function ProductImage({ thumbnail, listImages, productName }: ProductImageProps) {
    return (
        <>
            <div className="border-2  m-4 my-auto h-auto mx-auto">

                <ImageWithFallBack src={thumbnail} className=" rounded-md" alt={productName} />
                <ProductImageGarelly listImage={listImages} />
            </div>

        </>
    )
}