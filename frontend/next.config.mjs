/** @type {import('next').NextConfig} */

const nextConfig = {
  reactCompiler: true,
  env: {
    NEXT_PUBLIC_API_URL: process.env.NEXT_PUBLIC_API_URL,
  },
};

export default nextConfig;


// // export default nextConfig;
// /** @type {import('next').NextConfig} */
// const nextConfig = {
//   async rewrites() {
//     return [
//       {
//         source: "/api/:path*",
//         destination: "http://localhost:8080/api/:path*",
//       },
//     ];
//   },
// };

// module.exports = nextConfig;
