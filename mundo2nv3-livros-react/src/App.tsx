import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route, Link }  from 'react-router-dom'; 
import LivroLista from './LivroLista';
import LivroDados from './LivroDados'; 


function App() {
  return (
    <Router>
      <nav className="navbar navbar-dark bg-dark ">
        <div className="container justify-content-start">
          <Link to="/" className="navbar-brand">Catálogo</Link>
          <Link to="/dados" className="navbar-brand">Novo</Link>
        </div>
      </nav>
      <Routes>
        <Route path="/" element={<LivroLista />} />
        <Route path="/dados" element={<LivroDados />} />
      </Routes>
    </Router>
  );
}

export default App; 
