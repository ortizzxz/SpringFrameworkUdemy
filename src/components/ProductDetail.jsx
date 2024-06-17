
export const ProductDetail = ({product = []}) => {
    return (
        <tr>
            <td>{product.nombre}</td>
            <td>{product.indice}</td>
        </tr>
    )
}