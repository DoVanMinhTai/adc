import "@/styles/globals.css";
import type { AppProps } from "next/app";
import Head from "next/head";
import Layout from "@/common/components/Layout";
import 'bootstrap/dist/css/bootstrap.min.css';
export default function App({ Component, pageProps }: AppProps) {
  return <>
    <Head>
      <meta name="viewport" content="width=device-width, initial-scale=1" />
    </Head>
    <Layout>
      <Component {...pageProps} />
    </Layout>
  </>
}
