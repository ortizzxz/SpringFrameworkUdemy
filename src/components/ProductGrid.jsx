import { ProductDetail } from "./ProductDetail"
import { PropTypes } from "prop-types";

export const ProductGrid = ({products = {} }) =>{

    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Indice</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map(product => {
                        return <ProductDetail product={product} key={product.nombre}/>
                    })}
                </tbody>
            </table>  
        </>
    )
}

ProductGrid.propTypes = {
    product: PropTypes.array.isRequired
}