import { PropTypes } from "prop-types";

export const ProductDetail = ({handlerRemove, product = {} }) => {
    return (
        <tr>
            <td>{product.nombre}</td>
            <td>{product.indice}</td>
            <td>
                <button onClick={() => handlerRemove(product.name)}>
                    remove
                </button>
            </td>
        </tr>
    )
}

