// LatestArticles.js
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import './LatestArticlesStyles.css';
const LatestArticles = () => {
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8889/api/articles')
            .then(response => response.json())
            .then(data => {
                const reversedArticles = data.reverse();
                const latestArticles = reversedArticles.slice(1, 4);

                setArticles(latestArticles);
            })
            .catch(error => console.error('Błąd podczas pobierania danych:', error));
    }, []);

    return (
        <div className="articles-container">
            {articles.map((article) => (
                <div key={article.articleId} className="article-card">
                    <Link to={`/article/${article.articleId}`}>
                        <div className="article-image">
                            <img src={article.imageUrl} alt={`Thumbnail for ${article.title}`} />
                        </div>
                        <div className="article-details">
                            <h3>{article.title}</h3>
                        </div>
                    </Link>
                </div>
            ))}
        </div>
    );
};

export default LatestArticles;
