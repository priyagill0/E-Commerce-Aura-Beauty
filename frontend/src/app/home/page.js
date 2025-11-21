"use client";

import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

export default function HomePage() {
  const [products, setProducts] = useState([]);
  const [productVariants, setProductVariants] = useState([]);
  const [productImages, setProductImages] = useState([]);
  const router = useRouter();
  
  const goToCart = () => {
    router.push("/cart"); // navigate to cart page
  };

//http://localhost:8080/api/cart/add?variantId=c2d3e4f5-a678-90b1-c2d3-e4f5a67890b1&quantity=2
const addToCart = async (variantId, quantity = 1) => {
  try {
    const res = await fetch(
      `http://localhost:8080/api/cart/add?variantId=${variantId}&quantity=${quantity}`,
      { method: "POST", credentials: "include", } //the browser sends the JSESSIONID cookie to backend to save the sessionId.
    );

    if (!res.ok) throw new Error("Failed to add to cart");

    console.log("Added to cart!");
  } catch (error) {
    console.error("Error adding item:", error);
  }
};


  useEffect(() => {
    fetch("http://localhost:8080/api/product")
      .then((res) => res.json())
      .then((data) => {
        console.log("Products:", data);
        setProducts(data);
      })
      .catch((err) => console.error("Error fetching products:", err));
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/api/product_variant")
      .then((res) => res.json())
      .then((data) => {
        console.log("Product Variants:", data);
        setProductVariants(data);
      })
      .catch((err) => console.error("Error fetching products:", err));
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/api/product_image")
    .then((res) => res.json())
      .then((data) => {-
        console.log("Product Image:", data);
        setProductImages(data);
      })
      .catch((err) => console.error("Error fetching products:", err));
  }, []);

  return (
    <div style={{ padding: "2rem" }}>
      <h1>Welcome to My E-Commerce Store!</h1>
      <h2>Here are the products we have:</h2>

      <div>
      <img
        src="/assets/cart.jpg"
        alt="Go to Cart"
        onClick={goToCart}
        style={{
          position: "absolute",
          top: "1rem",
          right: "1rem",
          width: "50px",   // smaller size for corner
          height: "50px",
          cursor: "pointer",
        }}
      />
      </div>

        {products.map((product) => {
          // filter variants for this product
          const variantsForProduct = productVariants.filter(
            (v) => v.product.productId === product.productId
          );
        
          return (
            <div key={product.productId} className="mb-8 p-4 border rounded-lg">
              <h3 className="text-xl font-bold">{product.name}</h3>

              <div>
              <img
                src="/assets/add-to-cart.jpg"
                alt="Add to Cart"
                onClick={() => addToCart(variantsForProduct[0]?.variantId, 1)}
                style={{
                  top: "1rem",
                  right: "1rem",
                  width: "50px",
                  height: "50px",
                  cursor: "pointer"
                }}
              />
              </div>

              <p>{product.description}</p>
              <p className="text-gray-600">Brand: {product.brand}</p>
              <p className="text-gray-600">Type: {product.productType}</p>
        
              <h4 className="font-semibold">Available Sizes:</h4>
              <ul>
                {variantsForProduct.map((variant) => (
                  <li key={variant.variantId}>
                    {variant.size} – ${variant.price} ({variant.quantity} in stock)
                  </li>
                ))}
                {variantsForProduct.length === 0 && <li>No variants found</li>}
              </ul>


              {/* Images */}
              <div className="flex gap-2 mt-2">
                {productImages
                  .filter((img) => img.product.productId === product.productId)
                  .map((img) => (
                    <img
                      key={img.imageId}
                      src={img.imageUrl}
                      alt={product.name}
                      style={{ width: "120px", borderRadius: "8px" }}
                    />
                  ))}

                {productImages.filter((img) => img.product.productId === product.productId).length === 0 && (
                  <p>No images</p>
                )}
              </div>
            </div>
          );
        })}
    </div>
  );
}
