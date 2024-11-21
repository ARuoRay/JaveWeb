import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';  // 正确导入 Router 和 Route
import Login from './chat/Login';
import Home from './chat/Home';
import Register from './chat/Register';

function App() {
  return (
    <Router>  {/* 使用 BrowserRouter */}
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/Register" element={<Register />} />
      </Routes>
    </Router>
  );
}

export default App;
