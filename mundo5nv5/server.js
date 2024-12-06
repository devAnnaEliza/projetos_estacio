const express = require('express');
const bodyParser = require('body-parser');
const jwt = require('jsonwebtoken');

// Configurações
const app = express();
const port = process.env.PORT || 3000;
const secretKey = 'chaveSeguraParaToken'; // Substitua por uma chave segura
app.use(bodyParser.json());

// Mock de dados
const users = [
  { username: 'user', password: '123456', id: 123, email: 'user@dominio.com', perfil: 'user' },
  { username: 'admin', password: '123456789', id: 124, email: 'admin@dominio.com', perfil: 'admin' },
  { username: 'colab', password: '123', id: 125, email: 'colab@dominio.com', perfil: 'user' },
];

// Middleware para autenticação JWT
function authenticateToken(req, res, next) {
  const token = req.headers['authorization'];
  if (!token) return res.status(401).json({ message: 'Token necessário' });

  jwt.verify(token, secretKey, (err, user) => {
    if (err) return res.status(403).json({ message: 'Token inválido' });
    req.user = user;
    next();
  });
}

// Função de login
app.post('/api/auth/login', (req, res) => {
  const credentials = req.body;
  const userData = users.find(
    (user) => user.username === credentials.username && user.password === credentials.password
  );

  if (userData) {
    const token = jwt.sign(
      { usuario_id: userData.id, perfil: userData.perfil },
      secretKey,
      { expiresIn: '1h' } // Expira em 1 hora
    );
    return res.json({ token });
  }
  return res.status(401).json({ message: 'Credenciais inválidas' });
});

// Recuperação de dados do usuário logado
app.get('/api/user', authenticateToken, (req, res) => {
  const user = users.find((u) => u.id === req.user.usuario_id);
  res.json({ data: user });
});

// Recuperação de todos os usuários (restrito a admins)
app.get('/api/users', authenticateToken, (req, res) => {
  if (req.user.perfil !== 'admin') {
    return res.status(403).json({ message: 'Acesso restrito a administradores' });
  }
  res.status(200).json({ data: users });
});

// Recuperação de contratos com proteção contra injeção
app.get('/api/contracts/:empresa/:inicio', authenticateToken, (req, res) => {
  if (req.user.perfil !== 'admin') {
    return res.status(403).json({ message: 'Acesso restrito a administradores' });
  }

  const empresa = req.params.empresa;
  const inicio = req.params.inicio;

  // Validação dos parâmetros
  if (!/^[a-zA-Z0-9]+$/.test(empresa) || !/^\d{4}-\d{2}-\d{2}$/.test(inicio)) {
    return res.status(400).json({ message: 'Parâmetros inválidos' });
  }

  // Mock de contratos (apenas para demonstração)
  const contracts = [
    { empresa: 'EmpresaA', inicio: '2024-01-01', dados: 'Contrato A' },
    { empresa: 'EmpresaB', inicio: '2024-02-01', dados: 'Contrato B' },
  ];

  const result = contracts.filter(
    (contract) => contract.empresa === empresa && contract.inicio === inicio
  );

  if (result.length === 0) {
    return res.status(404).json({ message: 'Dados não encontrados' });
  }

  res.status(200).json({ data: result });
});

// Inicialização do servidor
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
