import React, { useState, useEffect } from 'react'
import Link from 'next/link'
type Props = {
    children: React.ReactNode;
}
const Header = ({children} : Props) => { 
    return (
        <header>
            {/* Header Top */}
            <div className="header-wrapper">
                <div className="header-top">
                    <div className="container flex justify-between items-center">
                        <div className="flex flex-col flex-left">
                            <ul className="nav nav-left nav-small">
                                <li className="html li-first delivery-info">Đặt bánh lấy ngay tại Thành phố Hồ Chí Minh</li>
                                <li className="html li-first">Hệ thống bánh sinh nhật chính hãng</li>
                                <li className="html li-first">Hotline: 01234576789</li>
                            </ul>
                        </div>
                        <div className="flex hide-for-medium flex-right">
                            <ul className="nav top-bar-nav nav-right nav-small nav-divided">
                                <li className="html header-social-icons">
                                    <div className="social-icons follow-icons flex gap-2">
                                        {[
                                            "fa-facebook",
                                            "fa-instagram",
                                            "fa-envelope",
                                            "fa-phone",
                                            "fa-pinterest",
                                        ].map((icon, index) => (
                                            <a key={index} href="#" className="button icon circle">
                                                <i className={`fa-brands ${icon}`} />
                                            </a>
                                        ))}
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            {/* Header Center */}
            <div className="header-center color-header-center">
                <div className="container flex w-full">
                    <div className="row row-center flex justify-between items-center w-full">
                        <div className="img-logo w-1/6 pl-2">
                            <Link href="/">
                                <img src="../image/imghomepage/logo/logo1.jpg" alt="Logo" className="img-logo-detail" />
                            </Link>
                        </div>
                        <div className="flex justify-between items-center w-5/6">
                            {/* Navigation */}
                            <ul className="nav flex list-item gap-4">
                                <a href="../pages/homepage.html" className="active">
                                    <li>Trang chủ</li>
                                </a>
                                <div className="dropdown flex items-center">
                                    <a href="../pages/ProductCatalog.html">
                                        <li>Danh mục</li>
                                    </a>
                                    <ul className="dropdown-menu menu-danhmuc">
                                        <p className="font-bold bg-white px-2">Danh mục bánh sinh nhật</p>
                                        {["Bánh Ăn Nhẹ", "Bánh Các Ngày Lễ", "Bánh Chai Rượu", "Bánh Chủ Nhật", "Bánh Công Chúa"].map(
                                            (item, index) => (
                                                <li key={index}>
                                                    <a href="#">{item}</a>
                                                </li>
                                            )
                                        )}
                                    </ul>
                                </div>
                                <a href="../pages/introWebsite.html">
                                    <li>Giới thiệu</li>
                                </a>
                            </ul>

                            {/* Search Bar */}
                            <div className="relative w-1/3">
                                <input
                                    type="search"
                                    id="keyword"
                                    className="form-control w-full px-3 text-base h-8"
                                    placeholder="Tìm kiếm bánh sinh nhật,..."
                                />
                                <i className="fa-solid fa-magnifying-glass absolute right-2 top-1/2 transform -translate-y-1/2 text-gray-500 cursor-pointer"></i>
                            </div>

                            {/* Cart & Account */}
                            <div className="flex gap-4">
                                <div className="flex items-center gap-2">
                                    <i className="fa-solid fa-bag-shopping"></i>
                                    <button id="cart-button" className="bg-none border-none cursor-pointer">
                                        GIỎ HÀNG
                                    </button>
                                </div>
                                <div>
                                    {children}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    );
};
export default Header