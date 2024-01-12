// pages/ArticlePage.js
import React from 'react';
import ArticleView from '../components/ArticleView';
import './ArticlePageStyles.css';  // Import stylów dla tej strony

const ArticlePage = () => {
    return (
        <div className="article-page-container">  {/* Dodaj klasę dla kontenera strony */}
            <ArticleView />
        </div>
    );
};

export default ArticlePage;
