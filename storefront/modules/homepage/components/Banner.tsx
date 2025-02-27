import React from 'react'
import { Container, Carousel } from 'react-bootstrap'
import ImageWithFallBack from '@/common/components/ImageWithFallBack'

import mainBanner1 from '../../../assets/images/main-banner-1.jpg'
import mainBanner2 from '../../../assets/images/main-banner-2.jpg'
import mainBanner3 from '../../../assets/images/main-banner-3.jpg'

const listMainBanner = [mainBanner1.src, mainBanner2.src, mainBanner3.src]
const Banner = () => {
    return (
        <div>
            <Container>
                <Carousel>
                    {listMainBanner.map((item,index) => (

                    <ImageWithFallBack src={item} alt={`Banner  ${index + 1}`} />
                    
                ))}
                </Carousel>
            </Container>

        </div>
    )
}

export default Banner