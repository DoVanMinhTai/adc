import { ProductThumbnail } from "../models/ProductThumbnail";
import { ProductFeature } from "../models/ProductFeature";
import apiClientService from "@/common/components/services/ApiClientService";

const baseUrl = 'http://localhost:8087/api/product/storefront';
const serverSideRenderUrl = `${process.env.API_BASE_PATH}/product/storefront`
export async function getProductBestSelling() : Promise<ProductFeature> {
    const response = await apiClientService.get(`${baseUrl}/products/productsBestSelling`);
    console.log("🔥 Data from API:", response);
    return response.json();
}
