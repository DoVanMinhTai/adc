import React from 'react'
import Head from 'next/head'
import Header from './common/Header'
import AuthenticationInfo from './AuthenticationInfo'

type Props =  {
    children:  React.ReactNode;
}
const Layout = ({children} : Props) => {
    return (
        <>
        <Head>
            <title>BookShop</title>
            <meta name="description" content="Yet another shop storefront" />
            <link rel="icon" href="/favicon.ico" />
            </Head>
            <Header>
                <AuthenticationInfo />
            </Header>
            <div className="body">{children}</div>

        </>

    )
}

export default Layout