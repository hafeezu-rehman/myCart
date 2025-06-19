import React from "react";
import { useDispatch } from "react-redux";
import { addToCart } from "../store/cartSlice";

interface Product {
  prod_id: number;
  name: string;
  description: string;
  price: string;
  image_url: string;
  quantity?: number;
}

interface Props {
  product: Product;
}

const AddToCartButton: React.FC<Props> = ({ product }) => {
  const dispatch = useDispatch();

  const handleAdd = () => {
    dispatch(addToCart({ ...product, quantity: 1 }));
  };

  return (
    <button
      onClick={handleAdd}
      className="mt-2 w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition"
    >
      Add to Cart
    </button>
  );
};

export default AddToCartButton;
