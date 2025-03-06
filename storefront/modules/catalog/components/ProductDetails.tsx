import React, { useState } from 'react'
import { ProductDetail } from '../model/ProductDetail'
import { formatPrice } from '@/utils/formatPrice'
import ImageWithFallBack from '@/common/components/ImageWithFallBack'
type ProductDetailProps = {
    product: ProductDetail;
}

export default function ProductDetails({ product }: ProductDetailProps) {
    return (
        <>
            <div className=" w-full  bg-white">
                <div className="grid grid-cols-2 ">
                    <div className="border-1 outline-2 outline-offset-2 border-gray-600 p-4 mx-auto">

                        <ImageWithFallBack src={product.thumbnailMediaUrl} className="border border-gray-500  rounded-md" alt={product.name} />
                    </div>
                    <div className="p-10 flex flex-col gap-5 ">
                        <div className=" text-2xl">{product.name}</div>
                        <div className="flex">
                            <div className="rating">1</div>
                            <div className="rating">2</div>
                            <div className="rating">3</div>
                        </div>
                        <div className="price">{formatPrice(product.price)}</div>
                        <div className="description">{product.shorTDescription}</div>
                        <div className="specifation">{product.specification}</div>
                        <div className="flex items-center gap-7">
                            <div className="text-xl text-[#5b5d6e] font-bold">Type:</div>
                            <div className="text-xl">Comic</div>
                        </div>
                        <div className="flex items-center gap-7">
                            <div className="text-xl text-[#5b5d6e] font-bold">Type:</div>
                            <div className="text-xl">Comic</div>
                        </div>
                        <div className="flex items-center gap-7">
                            <div className="text-xl text-[#5b5d6e] font-bold">Type:</div>
                            <div className="text-xl">Comic</div>
                        </div>
                        <div className="flex items-center gap-7">
                            <div className="text-xl text-[#5b5d6e] font-bold">Type:</div>
                            <div className="text-xl">Comic</div>
                        </div>
                        <div className="border-b-4 border-b-red-700"></div>
                        <div className="flex">
                            <select className="border border-gray-950  rounded-md p-2">
                                <option value="1">Option 1</option>
                                <option value="2">Option 2</option>
                                <option value="3">Option 3</option>
                            </select>
                            <div className="flex items-center border border-gray-300 rounded-md w-32">
                                <button className="bg-gray-200 px-3 py-2 hover:bg-gray-300">−</button>
                                <input type="number" min="1" value="1" className="w-12 text-center border-x border-gray-300 outline-none" />
                                <button className="bg-gray-200 px-3 py-2 hover:bg-gray-300">+</button>
                            </div>

                        </div>
                    </div>
                    <div className="text-center">123</div>
                    <div className="px-10 flex flex-row  gap-8">
                        <div className="">
                            <button>buy now</button>
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
            <div className="container w-full mx-9 bg-[#fcfbfc] ">
                <div>1</div>
                <div className="similar-product">

                </div>
            </div>
        </>
    )
}