/** @type {import('next').NextConfig} */

const nextConfig = {
  /* config options here */
  reactStrictMode: true,
  output: 'standalone',
  images: {
    localPatterns: [
      {
        pathname: '/assets/images/**'
      }
    ]
  }
};

export default nextConfig;
