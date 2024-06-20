import axios from "axios";

const baseUrl = 'http://localhost:9888/products';

const initProducts = [
    {
        id:1,
        name: 'Monitor Samsung 65',
        price: 500,
        description: 'El monitor es increible!'
    },
    {
        id:2,
        name: 'IPhone 14',
        price: 800,
        description: 'El telefono es muy bueno!'
    }
];

export const listProduct = () => {
    return initProducts; 
}

export const findAll = async () => {
    
    try{
        const response = await axios.get(baseUrl);
        return response;
    }catch(error){
        console.log(error);
    }

    return null;
};

