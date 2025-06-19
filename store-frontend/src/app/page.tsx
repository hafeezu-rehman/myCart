import CartDetailFloating from "./UI/Cart";
import ProductGrid from "./UI/Grid";
import NavBar from "./UI/NavBar";
import ProductSlider from "./UI/Slider";

export default function Home() {
  return (
    <div>
      <NavBar />
      <CartDetailFloating />
      <ProductSlider />
      <ProductGrid />
    </div>
  );
}
