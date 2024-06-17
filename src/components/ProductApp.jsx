import { useEffect, useState } from "react"
import { listProduct } from "../services/ProductService";
import { ProductGrid } from "./productGrid";

export const ProductApp = () => {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        const result  = listProduct();
        setProducts(result);
    }, []);

    return (
        <>
          <h1>Lista de Productos</h1>
          <ProductGrid products={products}/>
        </>
    )
}