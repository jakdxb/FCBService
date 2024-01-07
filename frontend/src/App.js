// App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import MatchesComponent from './components/MatchesComponent';
import ArticleList from './components/ArticleList';
import ArticleView from './components/ArticleView';

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar />
                <MatchesComponent />
                <Routes>
                    <Route path="/article/:id" element={<ArticleView />} />
                    <Route path="/" element={<ArticleList />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
