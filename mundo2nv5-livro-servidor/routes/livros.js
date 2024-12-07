const express = require('express');
const router = express.Router();
const livroDao = require('../modelo/livro-dao');

router.get('/', async (req, res) => {
  try {
    const livros = await livroDao.obterLivros();
    res.json(livros);
  } catch (error) {
    console.error(`Erro ao obter livros: ${error}`);
    res.status(500).json({ message: 'Erro ao obter livros' });
  }
});

router.post('/', async (req, res) => {
  try {
    const livro = req.body;
    await livroDao.incluir(livro);
    res.json({ message: 'Livro incluído' });
  } catch (error) {
    console.error(`Erro ao incluir livro: ${error}`);
    res.status(500).json({ message: 'Erro ao incluir livro' });
  }
});

router.delete('/:codigo', async (req, res) => {
  try {
    const codigo = req.params.codigo;
    await livroDao.excluir(codigo);
    res.json({ message: 'Livro excluído' });
  } catch (error) {
    console.error(`Erro ao excluir livro: ${error}`);
    res.status(500).json({ message: 'Erro ao excluir livro' });
  }
});

module.exports = router;