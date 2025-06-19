"use client";
import React, { useEffect, useState } from "react";
import axios from "axios";

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

const ProductSlider: React.FC = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [current, setCurrent] = useState<number>(0);
  const [fade, setFade] = useState<boolean>(true);

  const fetchProducts = async () => {
    try {
      const res = await axios.get<Product[]>(
        "http://192.168.10.13:8082/api/product/view"
      );
      setProducts(res.data);
    } catch (error) {
      console.error("Failed to fetch products", error);
    }
  };

  const nextSlide = (): void => {
    setFade(false);
    setTimeout(() => {
      setCurrent((prev) => (prev === products.length - 1 ? 0 : prev + 1));
      setFade(true);
    }, 100);
  };

  const prevSlide = (): void => {
    setFade(false);
    setTimeout(() => {
      setCurrent((prev) => (prev === 0 ? products.length - 1 : prev - 1));
      setFade(true);
    }, 100);
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  useEffect(() => {
    const timer = setInterval(() => {
      if (products.length > 0) nextSlide();
    }, 3000);
    return () => clearInterval(timer);
  }, [products]);

  if (products.length === 0) {
    return (
      <div className="text-center py-10 text-gray-500">Loading products...</div>
    );
  }

  const product = products[current];

  return (
    <div className="w-full max-w-5xl mx-auto mt-30 relative">
      <div
        className={`rounded-lg overflow-hidden transition-opacity duration-700 ${
          fade ? "opacity-100" : "opacity-0"
        }`}
      >
        <img
          src={`http://192.168.10.13:8082/images/${product.image_url}`}
          alt={product.name}
          className="w-full h-[450px] object-cover"
        />
        <div className="absolute bottom-0 bg-black bg-opacity-20 text-white w-full p-4">
          <h2 className="text-xl font-semibold">{product.name}</h2>
          <p className="text-sm italic">{product.category.name}</p>
          <p className="text-md">{product.description}</p>
          <p className="text-lg font-bold mt-2">PKR/{product.price}</p>
        </div>
      </div>

      {/* Controls */}
      <button
        onClick={prevSlide}
        className="absolute top-1/2 left-4 transform -translate-y-1/2 bg-white p-2 rounded-full shadow hover:bg-gray-200 z-10"
      >
        ◀
      </button>
      <button
        onClick={nextSlide}
        className="absolute top-1/2 right-4 transform -translate-y-1/2 bg-white p-2 rounded-full shadow hover:bg-gray-200 z-10"
      >
        ▶
      </button>
    </div>
  );
};

export default ProductSlider;
