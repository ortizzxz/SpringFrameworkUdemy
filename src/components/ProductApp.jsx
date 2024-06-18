import { useEffect, useState } from "react"
import { listProduct } from "../services/ProductService";
import { ProductGrid } from "./productGrid";
import { PropTypes } from "prop-types";
import { ProductForm } from "./ProductForm";


export const ProductApp = ({title}) => {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        const result  = listProduct();
        setProducts(result);
    }, []);

    const handlerAddProduct = (product) => {
        console.log(product);

        setProducts([...products, {...product}]);

    };

    const handlerRemoveProduct = (name) => {
        console.log(name);
        setProducts(products.filter(p => p.name != name ));
    }

    return (
        <>
            <div>
                <h1>{ title  }</h1>
                <div>
                    <div>
                        <ProductForm  handlerAdd = { handlerAddProduct }/>
                    </div>

                    <div>
                        <ProductGrid products={ products } handlerRemove={ handlerRemoveProduct }/>
                    </div>
                </div>
            </div>
        </>
    )
}

ProductApp.propTypes = {
    title: PropTypes.string.isRequired 
}