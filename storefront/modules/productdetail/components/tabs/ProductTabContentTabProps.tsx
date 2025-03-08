
interface ProductTabContentProps {
    activeTab: string;
}

export default function ProductTabContent({ activeTab }: ProductTabContentProps) {
    return (<>
             <div className="mt-5">
      {activeTab === "specification" && <div>Chi tiết sản phẩm...</div>}
      {activeTab === "warranty" && <div>Thông tin bảo hành...</div>}
      {activeTab === "shipping" && <div>Thông tin giao hàng...</div>}
      {activeTab === "seller" && <div>Thông tin người bán...</div>}
    </div>

    </>);
}