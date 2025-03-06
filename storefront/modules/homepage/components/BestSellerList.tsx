import React, { useState, useEffect } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import ProductCardBase from '@/common/components/ProductCardBase';
import { ProductThumbnail } from '../models/ProductThumbnail';
import { getProductBestSelling } from '../services/ProductService';
import ProductCard from '@/common/components/ProductCard';
const BestSellerList = () => {
    const [products, setProducts] = useState<ProductThumbnail[]>([]);

    // const [pageNo, setPageNo] = useState<number>(0);
    // const [loading, setLoading] = useState<boolean>(false); // Để theo dõi trạng thái loading
    // const [error, setError] = useState<string | null>(null); // Để theo dõi lỗi

    useEffect(() => {
        getProductBestSelling()
            .then((res) => {
                const newProducts = Array.isArray(res) ? res : res?.productList ?? [];
                setProducts(newProducts);
            })
            .catch((error) => {
                setProducts([]);
            });
    }, []);




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
                    {products && products.length > 0 ? (
                        products.map((product) => (
                                <ProductCard key={product.id} product={product} />
                        ))
                    ) : (
                        <p>Không có sản phẩm nào</p>
                    )}

                </div>

            </div>
        </>
    );
};

export default BestSellerList;
