import { ProductThumbnail } from "../models/ProductThumbnail";
import { ProductFeature } from "../models/ProductFeature";
import apiClientService from "@/common/components/services/ApiClientService";

const baseUrl = 'api/product/storefront'

export async function getProductBestSelling() : Promise<ProductFeature> {
    const response = await apiClientService.get(`${baseUrl}/products/productsBestSelling`);
    return response.json();
}
