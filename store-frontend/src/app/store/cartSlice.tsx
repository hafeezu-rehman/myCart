import { createSlice, PayloadAction } from "@reduxjs/toolkit";

interface Product {
  prod_id: number;
  name: string;
  price: string;
  image_url: string;
  quantity: number;
}

interface CartState {
  items: Product[];
}

// ✅ Load cart from localStorage (on app start)
const loadFromLocalStorage = (): Product[] => {
  if (typeof window !== "undefined") {
    const data = localStorage.getItem("cart");
    try {
      return data ? JSON.parse(data) : [];
    } catch {
      return [];
    }
  }
  return [];
};

// ✅ Save cart to localStorage
const saveToLocalStorage = (items: Product[]) => {
  if (typeof window !== "undefined") {
    localStorage.setItem("cart", JSON.stringify(items));
  }
};

// ✅ Initial state
const initialState: CartState = {
  items: typeof window !== "undefined" ? loadFromLocalStorage() : [],
};

const cartSlice = createSlice({
  name: "cart",
  initialState,
  reducers: {
    addToCart(state, action: PayloadAction<Product>) {
      const existing = state.items.find(
        (item) => item.prod_id === action.payload.prod_id
      );
      if (existing) {
        existing.quantity += action.payload.quantity;
      } else {
        state.items.push({ ...action.payload });
      }
      saveToLocalStorage(state.items);
    },

    removeFromCart(state, action: PayloadAction<number>) {
      state.items = state.items.filter(
        (item) => item.prod_id !== action.payload
      );
      saveToLocalStorage(state.items);
    },

    clearCart(state) {
      state.items = [];
      saveToLocalStorage(state.items);
    },
  },
});

export const { addToCart, removeFromCart, clearCart } = cartSlice.actions;
export default cartSlice.reducer;
