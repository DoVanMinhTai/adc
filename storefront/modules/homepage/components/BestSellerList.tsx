import React, { useState, useEffect } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import ProductCardBase from '@/common/components/ProductCardBase';
import { ProductThumbnail } from '../models/ProductThumbnail';
import { getProductBestSelling } from '../services/ProductService';
import ProductCard from '@/common/components/ProductCard';
const BestSellerList = () => {
    const [products, setProduct] = useState<ProductThumbnail[]>([]);
    const [pageNo, setPageNo] = useState<number>(0);
    const [loading, setLoading] = useState<boolean>(false); // Để theo dõi trạng thái loading
    const [error, setError] = useState<string | null>(null); // Để theo dõi lỗi

    useEffect(() => {
        getProductBestSelling().then((res) => {
            setProduct(res.productList)
            console.log(res);
            
        })
    })

    return (
        // <Container>
        //     {error && <div className="alert alert-danger">{error}</div>}
        //     <Row>
        //         {products?.length > 0 ? (
        //             products.map((product) => (
        //                 <Col key={product.id}>
        //                     <ProductCardBase
        //                         product={{ name: product.name, price: product.price }}
        //                         thumbnailUrl={product.thumbnailUrl}
        //                     />
        //                 </Col>
        //             ))
        //         ) : (
        //             <div>No products available.</div>
        //         )}
        //     </Row>
        // </Container>
        <>
            <div className="container mx-auto w-full px-2 my-4">
                <div className="text-center">Sản phẩm bán chạy</div>
                <div className="flex flex-wrap">
                    <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                    {products.map((product) => (

                       <ProductCard product={product} />
                    ))}
                    </div>
                    <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                        <div className="border rounded-lg p-4 shadow-md">
                            <img src="" alt="" className="w-full h-40 object-cover" />
                            <h2 className="text-lg font-semibold mt-2">"123</h2>
                            <p className="text-gray-500">123 VND</p>

                            <button className="mt-2 bg-blue-500 text-white px-4 py-2 rounded-md">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                    </div>
                    <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                        <div className="border rounded-lg p-4 shadow-md">
                            <img src="" alt="" className="w-full h-40 object-cover" />
                            <h2 className="text-lg font-semibold mt-2">"123</h2>
                            <p className="text-gray-500">123 VND</p>

                            <button className="mt-2 bg-blue-500 text-white px-4 py-2 rounded-md">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                    </div>
                    <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                        <div className="border rounded-lg p-4 shadow-md">
                            <img src="" alt="" className="w-full h-40 object-cover" />
                            <h2 className="text-lg font-semibold mt-2">"123</h2>
                            <p className="text-gray-500">123 VND</p>

                            <button className="mt-2 bg-blue-500 text-white px-4 py-2 rounded-md">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                    </div>
                    <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                        <div className="border rounded-lg p-4 shadow-md">
                            <img src="" alt="" className="w-full h-40 object-cover" />
                            <h2 className="text-lg font-semibold mt-2">"123</h2>
                            <p className="text-gray-500">123 VND</p>

                            <button className="mt-2 bg-blue-500 text-white px-4 py-2 rounded-md">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                    </div>
                    <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                        <div className="border rounded-lg p-4 shadow-md">
                            <img src="" alt="" className="w-full h-40 object-cover" />
                            <h2 className="text-lg font-semibold mt-2">"123</h2>
                            <p className="text-gray-500">123 VND</p>

                            <button className="mt-2 bg-blue-500 text-white px-4 py-2 rounded-md">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                    </div>
                    <div className="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 p-2">
                        <div className="border rounded-lg p-4 shadow-md">
                            <img src="" alt="" className="w-full h-40 object-cover" />
                            <h2 className="text-lg font-semibold mt-2">"123</h2>
                            <p className="text-gray-500">123 VND</p>

                            <button className="mt-2 bg-blue-500 text-white px-4 py-2 rounded-md">
                                Thêm vào giỏ hàng
                            </button>
                        </div>
                    </div>
                </div>

            </div>
        </>
    );
};

export default BestSellerList;
