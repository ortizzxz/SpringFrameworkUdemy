import { PropTypes } from "prop-types";

export const ProductDetail = ({product = {} }) => {
    return (
        <tr>
            <td>{product.nombre}</td>
            <td>{product.indice}</td>
        </tr>
    )
}

ProductDetail.propTypes = {
    product: PropTypes.array.isRequired
}