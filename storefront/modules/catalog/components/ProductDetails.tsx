import React, { useState } from 'react'
import { ProductDetail } from '../model/ProductDetail'
import { formatPrice } from '@/utils/formatPrice'
import ImageWithFallBack from '@/common/components/ImageWithFallBack'
type ProductDetailProps = {
    product: ProductDetail;
}

export default function ProductDetails({ product }: ProductDetailProps) {
    console.log(product);
    
    return (
        <>
            <div className=" w-full border border-b-slate-800  bg-white mt-5">
                <div className="grid grid-cols-2 container mx-auto ">
                    <div className="border-1 outline-2 outline-offset-2 border-gray-600 p-4 mx-auto">

                        <ImageWithFallBack src={product.thumbnailMediaUrl} className="border border-gray-500  rounded-md" alt={product.name} />
                    </div>
                    <div className="px-10 mt-4 flex flex-col gap-5 ">
                    <div className=" text-center text-2xl">{product.name}</div>
                        <div className=" text-2xl">Tên sản phẩm: {product.name}</div>
                        <div className="flex">
                            <div className="rating">Số lượng đánh giá: {product.ratingsCount}</div>
                        </div>
                        <div className="brand">Thương hiệu: {product.brandName}</div>
                        <div className="price">Gía tiền: {formatPrice(product.price)}</div>
                        <div className="shortdescription">Giới thiệu ngắn: {product.shorTDescription}</div>
                        <div>Hiện có: {product.availability}</div>
                        {/* <div>{product.discountPercentage}</div> */}
                        <div>Cân nặng: {product.itemWeight}</div>
                        <div>Số trang: {product.numPages}</div>
                        <div>Ngày xuất bản: {new Date(product.publishDate).toLocaleDateString()}</div>
                        {/* <div>6{product.ratingsCount}</div>
                        <div>7{product.stockQuantity}</div>
                        <div>8{product.isFeatured}</div>
                        <div>9{product.isPublished}</div> */}
                        <div>123{product.packageDimensions}</div>
                        <div className="border-b-4 border-b-red-700"></div>
                        <div className="flex gap-10 w-[50%]">
                            <div className="flex-grow">
                                <div className="text-left">Lựa chọn</div>
                                <select className="border border-gray-950 w-full  rounded-md p-2 grow">
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                    <option value="3">Option 3</option>
                                </select>
                            </div>
                            <div>
                            <div className="text-left">Số lượng</div>

                            <div className="flex items-center border border-gray-300 rounded-md w-32 grow">
                                <button className="bg-gray-200 px-3 py-2 hover:bg-gray-300 grow">−</button>
                                <input min="1" value="1" className="w-12 text-center border-x border-gray-300 outline-none" />
                                <button className="bg-gray-200 px-3 py-2 hover:bg-gray-300 grow">+</button>
                            </div>
                            </div>

                        </div>
                    </div>
                    <div className="text-center">123</div>
                    <div className="px-10 flex flex-row  gap-8">
                        <div className="">
                            <button></button>
                        </div>
                        <div className="">
                            <button>buy now</button>
                        </div>
                        <div className="">
                            <button>buy now</button>
                        </div>
                    </div>


                </div>

            </div>
            <div className="container mt-10 grid grid-cols-3 gap-5 w-full mx-auto bg-[#fcfbfc] ">
                <div className="col-span-2 border-2">
                    <div className="flex flex-col p-4">
                        <div className="flex gap-10">
                            <div className="flex-grow">SPECFICATION</div>
                            <div className="flex-grow">WARRANTY INFO</div>
                            <div className="flex-grow">SHIPPING INFO</div>
                            <div className="flex-grow">SELLER PROFILE</div>
                        </div>
                        <div>2</div>
                    </div>
                </div>
                <div className="flex flex-col border-2">
                    <div>product1</div>
                    <div>product1</div>
                    <div>product1</div>
                </div>
            </div>
        </>
    )
}