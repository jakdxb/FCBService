// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import MatchesComponent from './components/MatchesComponent';
import HomePage from './pages/HomePage';
import ArticlePage from './pages/ArticlePage';

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar />
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/article/:id" element={<ArticlePage />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
