import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { format } from 'date-fns';

const ArticleList = () => {
    const [articles, setArticles] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8889/api/barka/articles')
            .then(response => response.json())
            .then(data => setArticles(data))
            .catch(error => console.error('Błąd podczas pobierania danych:', error));
    }, []);

    return (
        <div className="articles-container">
            {articles.map((article) => (
                <div key={article.articleId} className="article-card">
                    <Link to={`/article/${article.articleId}`}>
                        <img src={article.imageUrl} alt={`Thumbnail for ${article.title}`} />
                        <h3>{article.title}</h3>
                    </Link>
                    <p>{article.content}</p>
                    <p>Created on: {format(new Date(article.creationDate), 'yyyy-MM-dd HH:mm:ss')}</p>
                </div>
            ))}
        </div>
    );
};

export default ArticleList;


