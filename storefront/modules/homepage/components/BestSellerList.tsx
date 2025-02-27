import React from 'react'
import { Container } from 'react-bootstrap'
import { Row, Col } from 'react-bootstrap'
import { useState, useEffect } from 'react'
import ProductCardBase from '@/common/components/ProductCardBase'
import { ProductThumbnail } from '../models/ProductThumbnail'
import { getProductBestSelling } from '../services/ProductService'

const BestSellerList = () => {
    const [products, setProduct] = useState<ProductThumbnail[]>([]);
    const [pageNo, setPageNo] = useState<number>(0);

    useEffect(() => {
        getProductBestSelling(pageNo).then((res) => {
            setProduct(res.productList);

        })
    }, [pageNo]);
    return (
        <>
            <Container>
                <Row>
                    {products.length > 0 && products.map((product) => (
                        <Col key={product.id}>
                            <ProductCardBase    product={{ name: product.name, price: product.price }} 
        thumbnailUrl={product.thumbnailUrl}  />
                        </Col>
                    ))}

                </Row>
            </Container>
        </>
    )
}

export default BestSellerList