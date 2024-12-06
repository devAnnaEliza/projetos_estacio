/**dados dos fornecedores*/
import React, { useState, useContext, createContext } from 'react';

const DadosFornecedorContext = createContext();

// dados dos fornecedores
export const Dados = ({ children }) => {
    const [fornecedores, setFornecedores] = useState([]);

    // função pra add um fornecedor
    const adicionarFornecedor = fornecedor => {
        setFornecedores([...fornecedores, { ...fornecedor, id: Date.now().toString() }]);
    };

    return (
        <DadosFornecedorContext.Provider value={{ fornecedores, adicionarFornecedor }}>
            {children}
        </DadosFornecedorContext.Provider>
    );
};

export const useFornecedores = () => {
    const context = useContext(DadosFornecedorContext);
    if (!context) {
        throw new Error('useFornecedores deve ser usado com Dados');
    }
    return context;
};
