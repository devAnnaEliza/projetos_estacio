/**tela inicial*/
import React from 'react';
import { StyleSheet, Text, View, Image, TouchableOpacity } from 'react-native';

const Home = ({ navigation }) => {
    // função pra ir pra tela de add fornecedor
    const navigateToAddFornecedor = () => {
        navigation.navigate('Cadastro do Fornecedor');
    };

    // função pra ir pra tela da lista de fornecedores
    const navigateToListFornecedores = () => {
        navigation.navigate('Lista de Fornecedores');
    };

    return (
        <View style={styles.container}>
            <View style={styles.logoContainer}>
                <Image style={styles.logo} source={require('.myapp/assets/logocad.png')} />
            </View>
            <Text style={styles.titulo}>Escolha uma opção:</Text>
            <TouchableOpacity
                style={styles.botao}
                onPress={navigateToAddFornecedor}
            >
                <Text style={styles.textoBotao}>Adicionar Fornecedor</Text>
            </TouchableOpacity>
            <TouchableOpacity
                style={styles.botao}
                onPress={navigateToListFornecedores}
            >
                <Text style={styles.textoBotao}>Listar Fornecedores</Text>
            </TouchableOpacity>
            
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'flex-start',
        alignItems: 'center',
        backgroundColor: '#C0D9AF',
        padding: 20,
    },
    logoContainer: {
        alignItems: 'center',
        marginTop: 20,
    },
    logo: {
        width: 200,
        height: 200,
    },
    titulo: {
        fontSize: 20,
        fontWeight: 'bold',
        marginBottom: 20,
    },
    botao: {
        backgroundColor: '#007bff',
        padding: 20,
        borderRadius: 5,
        marginBottom: 10,
        width: 300,
        alignItems: 'center',
    },
    textoBotao: {
        color: '#C0D9AF',
        fontWeight: 'bold',
        fontSize: 20,
    },
});

export default Home;