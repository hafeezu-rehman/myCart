"use client";
import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { RootState } from "../store/store";
import { removeFromCart } from "../store/cartSlice";

const CartDetailFloating: React.FC = () => {
  const cartItems = useSelector((state: RootState) => state.cart.items);
  const dispatch = useDispatch();

  const total = cartItems.reduce(
    (acc, item) => acc + Number(item.price) * item.quantity,
    0
  );

  return (
    <div className="fixed bottom-10-max-lg sm:top-25 right-5 w-80 bg-white shadow-2xl rounded-lg border border-gray-200 z-50">
      <div className="p-4 border-b text-lg font-semibold">🛒 Your Cart</div>
      <div className="max-h-[400px] overflow-y-auto p-4 space-y-4">
        {cartItems.length === 0 ? (
          <p className="text-center text-sm text-gray-500">Cart is empty.</p>
        ) : (
          cartItems.map((item) => (
            <div key={item.prod_id} className="border-b pb-2">
              <div className="flex justify-between items-center">
                <div>
                  <p className="font-medium">{item.name}</p>
                  <p className="text-sm text-gray-500">
                    {item.quantity} × PKR {item.price}
                  </p>
                </div>
                <button
                  onClick={() => dispatch(removeFromCart(item.prod_id))}
                  className="text-xs text-red-500 hover:underline"
                >
                  Remove
                </button>
              </div>
            </div>
          ))
        )}
      </div>
      {cartItems.length > 0 && (
        <div className="p-4 border-t font-semibold text-right">
          Total: PKR {total}
        </div>
      )}
    </div>
  );
};

export default CartDetailFloating;
