import React from 'react'
import { useState,useEffect } from 'react';
import Link from 'next/link';
import { Button, ButtonGroup, Dropdown, DropdownMenu, DropdownToggle } from 'react-bootstrap';
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
        

                // <div className="dropdown">
                //                     <button className="btn btn-secondary dropdown-toggle">Tài Khoản</button>
                //                     <ul className="dropdown-menu">
                //                         {isLoggedIn ? (
                //                             <li>
                //                                 <a className="dropdown-item" href="SignIn.html">Đăng Xuất</a>
                //                             </li>
                //                         ) : (
                //                             <>                                            <li>
                //                                 <a className="dropdown-item" href="SignIn.html">Đăng Nhập</a>
                //                             </li>
                //                                 <li>
                //                                     <a className="dropdown-item" href="SignUp.html">Đăng Ký</a>
                //                                 </li>
                //                             </>
                //                         )}

                //                     </ul>
                //                 </div>
             
                <>
                                {authenticationInfoVm.isAuthenticated ? (
                                       <Dropdown as={ButtonGroup}>
                    <Dropdown.Toggle split variant="secondary" id="dropdown-split-basic">
                        {authenticationInfoVm.authenticatedUser.username}
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                                    
                    </Dropdown.Menu>
                </Dropdown>
                                ) : (
                                    <div>
                                        <Link href="/autho">Login</Link>
                                    </div>
                      )}
                </>

            );
}

export default AuthenticationInfo