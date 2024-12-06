/**add fornecedor*/ 
import React, { useState, useEffect } from "react";
import { StyleSheet, TextInput, Text, Button, View, Image, Alert, ScrollView } from "react-native";
import { useFornecedores } from 'myapp/dados.js';
import { useNavigation, useRoute } from "@react-navigation/native";
import * as ImagePicker from 'expo-image-picker';
import * as FileSystem from 'expo-file-system';
import AsyncStorage from '@react-native-async-storage/async-storage';

const FormularioFornecedor = () => {
    const route = useRoute();
    const [idEditando, setIdEditando] = useState(route.params?.idEditando || "");
    const [nome, setNome] = useState("");
    const [endereco, setEndereco] = useState("");
    const [contato, setContato] = useState("");
    const [categoria, setCategoria] = useState("");
    const [imagem, setImagem] = useState("");
    const { fornecedores, setFornecedores } = useFornecedores();
    const navigation = useNavigation();

    useEffect(() => {
        if (idEditando && fornecedores) {
            const fornecedorEditando = fornecedores.find(f => f.id === idEditando);
            fornecedorEditando && Object.entries(fornecedorEditando).forEach(([key, value]) => key === 'imagem' ? setImagem(value) : eval(`set${key.charAt(0).toUpperCase() + key.slice(1)}('${value}')`));
        }
    }, [idEditando, fornecedores]);

    const handleSave = async () => {
        const camposObrigatorios = [nome, endereco, contato, categoria, imagem];
        if (camposObrigatorios.some(campo => !campo)) {
            Alert.alert('Erro', 'Todos os campos são obrigatórios');
            return;
        }

        const fornecedoresAtualizados = idEditando ? fornecedores.map(fornecedor => fornecedor.id === idEditando ? { ...fornecedor, nome, endereco, contato, categoria, imagem } : fornecedor) : [...fornecedores, { id: Date.now().toString(), nome, endereco, contato, categoria, imagem }];
        
        try {
            await AsyncStorage.setItem('fornecedores', JSON.stringify(fornecedoresAtualizados));
            setFornecedores(fornecedoresAtualizados);
            Alert.alert('Fornecedor salvo com sucesso!');
            [setNome, setEndereco, setContato, setCategoria, setImagem].forEach(setState => setState(""));
            setIdEditando("");
            navigation.navigate('Lista de Fornecedores');
        } catch (error) {
            Alert.alert('Erro', 'Não foi possível salvar os dados do fornecedor. Por favor, tente novamente.');
        }
    };

    const selecionarImagem = async () => {
        const permissionResult = await ImagePicker.requestMediaLibraryPermissionsAsync();
        if (!permissionResult.granted) return Alert.alert('Permissão necessária', 'Conceder permissão para acessar a galeria?');

        const resultado = await ImagePicker.launchImageLibraryAsync({ mediaTypes: ImagePicker.MediaTypeOptions.Images, allowsEditing: true, aspect: [4, 3], quality: 1 });
        if (resultado.cancelled) return Alert.alert('Imagem não selecionada');

        const firstAsset = resultado.assets?.[0];
        if (!firstAsset?.uri) return Alert.alert('Erro', 'URI da imagem não obtida');

        try {
            const base64Image = firstAsset.uri.startsWith('file://') ? `data:image/jpeg;base64,${await FileSystem.readAsStringAsync(firstAsset.uri, { encoding: FileSystem.EncodingType.Base64 })}` : firstAsset.uri;
            setImagem(base64Image);
        } catch (error) {
            console.error('Erro ao converter imagem:', error);
            Alert.alert('Erro', 'Imagem não convertida para o formato necessário');
        }
    };

    return (
        <ScrollView style={styles.container}>
            {imagem ? <Image source={{ uri: imagem }} style={styles.imagem} /> : null}
            <Button title="Selecionar Imagem" onPress={selecionarImagem} />
            <Text style={styles.texto}>Nome do fornecedor:</Text>
            <TextInput style={styles.input} value={nome} onChangeText={setNome} placeholder="Insira o nome" />
            <Text style={styles.texto}>Endereço:</Text>
            <TextInput style={styles.input} value={endereco} onChangeText={setEndereco} placeholder="Insira o endereço" />
            <Text style={styles.texto}>Contato:</Text>
            <TextInput style={styles.input} value={contato} onChangeText={setContato} placeholder="Insira o contato" />
            <Text style={styles.texto}>Categoria:</Text>
            <TextInput style={styles.input} value={categoria} onChangeText={setCategoria} placeholder="Insira a categoria" />
            <Button title="Salvar" onPress={handleSave} />
        </ScrollView>
    );
};

const styles = StyleSheet.create({
    imagem: { width: 150, height: 150, marginBottom: 10, alignSelf: 'center' },
    texto: { paddingBottom: 5, fontSize: 18, fontWeight: 'bold', color: '#000000' },
    container: { flex: 1, padding: 10, backgroundColor: '#C0D9AF' },
    input: { borderWidth: 1, borderColor: '#ccc', borderRadius: 8, padding: 10, marginBottom: 2, backgroundColor: '#FFFFFF', fontSize: 16, shadowColor: "#000", shadowOffset: { width: 0, height: 2 }, shadowOpacity: 0.1, shadowRadius: 1.41, elevation: 2 },
});

export default FormularioFornecedor;