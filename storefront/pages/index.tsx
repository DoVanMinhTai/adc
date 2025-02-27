import { NextPage } from "next";
import { Banner } from "@/modules/homepage/components";
import BestSellerList from "@/modules/homepage/components/BestSellerList";

export default function Home() {
  return (
    <>
      <Banner />

      <BestSellerList />
    </>
  );
}
