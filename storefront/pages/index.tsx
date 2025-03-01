import { NextPage } from "next";
import { Banner } from "@/modules/homepage/components";
import BestSellerList from "@/modules/homepage/components/BestSellerList";
import FeturedProduct from "@/modules/homepage/components/FeturedProduct";

export default function Home() {
  return (
    <>
      <Banner />

      <BestSellerList />

      <FeturedProduct />
    </>
  );
}
