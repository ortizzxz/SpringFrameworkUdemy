import { useState } from "react"

const initialDataForm = {
    nombre: '',
    indice: ''
}

export const ProductForm = ({ handlerAdd }) => {

    const [form, setForm] = useState(initialDataForm);

    //desestructurando
    const { nombre, indice} = form; 

    return(
        <form onSubmit={(event) => {
            event.preventDefault();

            if(!nombre || !indice){
                alert('Debe rellenar el form')
                return;
            }

            // console.log(form);  
            handlerAdd({form});

            setForm(initialDataForm);
        }}>
            <input placeholder="Nombre" 
            name="nombre"
            value={nombre}
            onChange={(event) => setForm({
                ...form, nombre: event.target.value
            })}
            />
            
            <input placeholder="Indice" 
            name="indice"
            value={indice}
            onChange={(event) => setForm({
                ...form, indice: event.target.value
            })}
            />
            <button type="submit">
                Crear
            </button>
        </form>
    )
}