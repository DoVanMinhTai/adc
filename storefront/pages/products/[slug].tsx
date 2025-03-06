import { GetServerSideProps, GetServerSidePropsContext } from "next"
import { ProductDetail } from "@/modules/catalog/model/ProductDetail";
import { getProductDetail } from "@/modules/catalog/services/ProductService";
import Head from "next/head";
import ProductDetails from "@/modules/catalog/components/ProductDetails";
 type Props = {
    product: ProductDetail;
    pvid: string | null;

}



export const getServerSideProps: GetServerSideProps = async (
    context: GetServerSidePropsContext
) => {
    const {slug} = context.query;

    const product =  await getProductDetail(slug as string);
    return {
        props: {
            product
        }
    }
}

const ProductDetailsPage = ({product} : Props) => {
    return (
        <div >
            <Head>{product.name}</Head>

            <ProductDetails product={product} />

            
        </div>
    )
}

export default ProductDetailsPage;