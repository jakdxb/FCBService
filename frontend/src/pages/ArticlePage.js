// pages/ArticlePage.js
import React from 'react';
import ArticleView from '../components/ArticleView';

const ArticlePage = () => {
    return (
        <div>
            <h1>Article Page</h1>
            {/* Inne elementy strony artykułu, jeśli są */}
            <ArticleView />
        </div>
    );
};

export default ArticlePage;
