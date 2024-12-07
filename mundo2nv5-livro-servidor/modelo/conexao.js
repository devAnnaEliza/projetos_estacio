const mongoose = require('mongoose');

async function connectToMongoDB() {
  try {
    const options = {
      useUnifiedTopology: true,
      useNewUrlParser: true,
    };

    await mongoose.connect('mongodb://localhost:27017/livraria', options);
    console.log('Conectado ao MongoDB...');
  } catch (error) {
    console.error('Não foi possível conectar ao MongoDB:', error);
  }
}

connectToMongoDB();

module.exports = mongoose;