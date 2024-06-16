import { useEffect, useState } from "react"
import { listProduct } from "../services/ProductService";

export const ProductApp = () => {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        const result  = listProduct();
        setProducts(result);
    }, []);

    return (
        <>
          <h1>Lista de Productos</h1>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Indice</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map(product => {
                        return (<tr key={product.nombre}>
                            <td>{product.nombre}</td>
                            <td>{product.indice}</td>
                        </tr>)
                    })}
                </tbody>
            </table>
        </>
    )
}