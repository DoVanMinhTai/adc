import React from 'react'

const ProductCardBase = () => {
  return (
    <>
      <div className="product-small box" style="border: 1px solid #e5e5e5;">
                            <a href="" style="margin-left: auto; margin-right: auto;">
                                <div className="box-image">
                                    <img width="247" height="296"
                                        src="https://banhsinhnhat.com/media/cache/21/b1/21b199ed68dd9b65b4f579e00cbe38aa.jpg"
                                        alt="" style="width: 100%;">
                                </div>
                                <div className="box-text text-center">
                                    <div className="title-wrapper">
                                        <p style="padding-top: 10px;">
                                            <span className="s3_c">Bánh kem bó hoa</span>
                                            <span className="s3_c text-fontweight">450,000đ</span>
                                        </p>
                                    </div>
                                </div>
                            </a>
                        </div>

    </>
  )
}

export default ProductCardBase