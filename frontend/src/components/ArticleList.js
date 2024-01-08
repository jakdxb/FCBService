// ArticleList.js
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { format } from 'date-fns';
import './ArticleListStyles.css';

const ArticleList = () => {
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8889/api/barka/articles')
            .then(response => response.json())
            .then(data => setArticles(data.reverse())) // Odwracamy kolejność artykułów
            .catch(error => console.error('Błąd podczas pobierania danych:', error));
    }, []);

    return (
        <div className="articles-container">
            {articles.map((article, index) => (
                <div key={article.articleId} className={`article-card ${index === 0 ? 'first-article' : ''}`}>
                    <Link to={`/article/${article.articleId}`}>
                        <div className="article-image">
                            <img src={article.imageUrl} alt={`Thumbnail for ${article.title}`} />
                        </div>
                        <div className="article-details">
                            <h3>{article.title}</h3>
                            <p>{article.content}</p>
                            <p>Created on: {format(new Date(article.creationDate), 'yyyy-MM-dd HH:mm:ss')}</p>
                        </div>
                    </Link>
                </div>
            ))}
        </div>
    );
};

export default ArticleList;
