import React from 'react'
import { useState,useEffect } from 'react';
const AuthenticationInfo = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    type AuthenticatedUser ={
        username: string;
    }
    type AuthenticationInfoVm = {
        isAuthenticated: boolean;
        authenticatedUser: AuthenticatedUser;
    }
    const [authenticationInfoVm,setAuthenticationInfoVm] = useState<AuthenticationInfoVm>( {
        isAuthenticated: false,
        authenticatedUser: {username: ''},
    })
    async function getAuthenticationInfo(): Promise<AuthenticationInfoVm> {
        const res = await fetch('/authentication');
        return await res.json();   
    }
    useEffect(() => {
        getAuthenticationInfo().then((data) => {
            setAuthenticationInfoVm(data);
        })
    },[])
    return (
                <div className="dropdown">
                                    <button className="btn btn-secondary dropdown-toggle">Tài Khoản</button>
                                    <ul className="dropdown-menu">
                                        {isLoggedIn ? (
                                            <li>
                                                <a className="dropdown-item" href="SignIn.html">Đăng Xuất</a>
                                            </li>
                                        ) : (
                                            <>                                            <li>
                                                <a className="dropdown-item" href="SignIn.html">Đăng Nhập</a>
                                            </li>
                                                <li>
                                                    <a className="dropdown-item" href="SignUp.html">Đăng Ký</a>
                                                </li>
                                            </>
                                        )}

                                    </ul>
                                </div>
    )
}

export default AuthenticationInfo