"use client";
import React, { useEffect, useState } from "react";
import axios from "axios";
import AddToCartButton from "./AddtoCart";

interface Category {
  categ_id: number;
  name: string;
  description: string;
}

interface Product {
  prod_id: number;
  name: string;
  description: string;
  price: string;
  stock: number;
  image_url: string;
  category: Category;
}

const ProductGrid: React.FC = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const res = await axios.get<Product[]>(
          process.env.NEXT_PUBLIC_PRODUCT_API ||
            "http://localhost:8082/api/product/view"
        );
        setProducts(res.data);
        setLoading(false);
      } catch (error) {
        console.error("API error:", error);
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  if (loading)
    return <div className="text-center py-10">Loading products...</div>;

  return (
    <div className="p-6 ml-10 mr-10 mt-5">
      <h2 className="text-2xl font-bold mb-4">Our Products</h2>
      <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-4 lg:grid-cols-5 gap-6">
        {products.map((product) => (
          <div
            key={product.prod_id}
            className=" bg-white shadow-md rounded-md overflow-hidden transition hover:scale-[1.02]"
          >
            <img
              src={`${process.env.NEXT_PUBLIC_IMAGES_API!}/${
                product.image_url
              }`}
              alt={product.name}
              className="w-full h-48 object-cover"
            />
            <div className="p-4">
              <h3 className="text-lg font-semibold">{product.name}</h3>
              <p className="text-gray-500 text-sm mb-1">
                {product.category.name}
              </p>
              <p className="text-gray-600 mt-1 font-bold">
                PKR/{product.price}
              </p>
            </div>
            <AddToCartButton product={product} />
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProductGrid;
