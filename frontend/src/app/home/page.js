"use client";

import { useEffect, useState } from "react";

export default function HomePage() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    // Fetch all products from the backend
    fetch("http://localhost:8080/api/product")
      .then((res) => res.json())
      .then((data) => setProducts(data))
      .catch((err) => console.error("Error fetching products:", err));
  }, []);

  return (
    <div style={{ padding: "2rem" }}>
      <h1>Welcome to My E-Commerce Store!</h1>
      <h2>Here are the products we have:</h2>

        {products.map((product) => (
          <div
            key={product.id}
          >
            <img
              src={product.imageUrl}
              alt={product.name}
              style={{ width: "200px", height: "200px",  }}
            />
            <h3>{product.name}</h3>
            <p>${product.price}</p>
          </div>
        ))}
      </div>
  );
}
