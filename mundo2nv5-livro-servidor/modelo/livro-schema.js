const mongoose = require('./conexao.js');

const { Schema, model } = mongoose;

const LivroSchema = new Schema({
  _id: Schema.Types.ObjectId,
  titulo: String,
  codEditora: Number,
  resumo: String,
  autores: [String],
});

module.exports = model('Livro', LivroSchema);
