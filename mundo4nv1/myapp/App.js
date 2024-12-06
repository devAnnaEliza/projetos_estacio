import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import 'react-native-gesture-handler';
import { Dados } from 'myapp/dados.js'; 
import FormularioFornecedores from './myapp/funcoes/cadfornecedor.js'; 
import ListaFornecedores from './myapp/funcoes/listafornecedores.js';
import Home from './myapp/Home.js';

const Stack = createStackNavigator();

const screenOptions = {
  headerStyle: { backgroundColor: '#C0D9AF' },
  headerTintColor: '#000000',
  headerTitleStyle: { fontWeight: 'bold', textAlign: 'center', color: '#000000' },
};

const App = () => (
  <Dados>  
    <NavigationContainer>
      <Stack.Navigator screenOptions={screenOptions}>
        <Stack.Screen name="Home" component={Home} options={{ title: 'Meeting App' }} />
        <Stack.Screen name="Formulário de cadastro do Fornecedor" component={FormularioFornecedores} options={{ title: 'Cadastro de Fornecedores' }} />
        <Stack.Screen name="Lista de Fornecedores" component={ListaFornecedores} options={{ title: 'Lista de Fornecedores' }} />
      </Stack.Navigator>
    </NavigationContainer>
  </Dados>
);

export default App;