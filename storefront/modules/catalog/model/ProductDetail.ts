export type ProductDetail = {
    id: number;
    name: string;
    brandName: string;
    productCategories: string[];
    shorTDescription: string;
    description: string;
    specification: string;
    isPublished: boolean;
    isFeatured: boolean;
    price: number;
    thumbnailMediaUrl: string;
    productImageMediaUrl: string[];
}