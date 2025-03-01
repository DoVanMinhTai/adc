import React from 'react'
import { formatPrice } from '@/utils/formatPrice';
import ImageWithFallBack from './ImageWithFallBack';
import Link from 'next/link';
interface ProductCardBase {
    product: {
        name: string  ;
        price: number  ;
        slug: string  ;
    };
    thumbnailUrl: string ;
}


const ProductCardBase: React.FC<ProductCardBase> = ({ product, thumbnailUrl }) => {
    return (
        <>
            <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                <div className="border rounded-lg p-4 shadow-md">
                    <Link href={`/products/${product.slug}`}>
                    <ImageWithFallBack src={thumbnailUrl} alt={product.name} />
                    <h2 className="text-lg font-semibold mt-2">"123</h2>
                    <p className="text-gray-500">{formatPrice(product.price)}</p>
                    </Link>
                    <button className="mt-2 bg-blue-500 text-white px-4 py-2 rounded-md">
                        Thêm vào giỏ Hàng
                    </button>
                </div>
            </div>

        </>
    )
}

export default ProductCardBase