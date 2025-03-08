export default function ProductActions() {
    return (
        <div className="px-10 flex flex-1 gap-5 w-full ">
            <button className="flex-1 bg-blue-600 text-white py-3 rounded-md hover:bg-blue-700 transition">
                Thêm vào giỏ hàng
            </button>
            <button className="flex-1 bg-red-500 text-white py-3 rounded-md hover:bg-red-600 transition">
                Mua Ngay
            </button>
            <button className="flex-1 bg-gray-300 py-3 rounded-md hover:bg-gray-400 transition">
                Lưu sản phẩm
            </button>
        </div>
    )
}
