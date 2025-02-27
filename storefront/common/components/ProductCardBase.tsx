import React from 'react'
import { formatPrice } from '@/utils/formatPrice';
interface ProductCardBase {
    product?: {
        name?: string | null;
        price?: number | null;
        slug?: string | null;
    } | null;
    thumbnailUrl?: string | null;
    className?: string[] | null;
}


const ProductCardBase: React.FC<ProductCardBase> = ({product,thumbnailUrl,className}) => {
  return (
    <>
      <div className="product-small box" style={{border: '1px solid #e5e5e5;'}}>
                            <a href="" style={{ marginLeft: 'auto', marginRight: 'auto'}}>
                                <div className="box-image">
                                    <img width="247" height="296"
                                        src="https://banhsinhnhat.com/media/cache/21/b1/21b199ed68dd9b65b4f579e00cbe38aa.jpg"
                                        alt="" style={{ width: '100%' }}/>
                                </div>
                                <div className="box-text text-center">
                                    <div className="title-wrapper">
                                        <p style={{ paddingTop: '10px' }}>
                                            <span className="s3_c">{product?.name}</span>
                                            {/* <span className="s3_c text-fontweight">{formatPrice(product?.price)}</span> */}
                                        </p>
                                    </div>
                                </div>
                            </a>
                        </div>

    </>
  )
}

export default ProductCardBase