import { useState } from "react";
import { ProductTabContentTabProps } from "..";

export default function ProductTabs() {
  const [activeTab, setActiveTab] = useState('specification');
  return (<>
    <div className="  gap-10 border-2 p-2">
      <div className="flex-grow flex text-center">
        {[
          { id: "specification", label: "Chi tiết sản phẩm" },
          { id: "warranty", label: "Chính sách đổi trả" },
          { id: "shipping", label: "Thông tin giao hàng" },
          { id: "seller", label: "Nhà cung cấp" },
        ].map((tab) => (
          <div key={tab.id}
            className={`cursor-pointer flex-grow text-center p-2 ${activeTab === tab.id ? "border-4 border-blue-500 font-bold text-blue-500" : "text-gray-600"
              }`}
            onClick={() => setActiveTab(tab.id)}
          >
            {tab.label}
          </div>
        ))

        }
      </div>
        <ProductTabContentTabProps activeTab={activeTab} />

    </div>

  </>
  );
}
