// LatestArticle.js
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './LatestArticleStyles.css';
const LatestArticle = () => {
    const [latestArticle, setLatestArticle] = useState(null);

    useEffect(() => {
        const fetchLatestArticle = async () => {
            try {
                const response = await axios.get('http://localhost:8889/api/barka/articles/latest');
                setLatestArticle(response.data);
            } catch (error) {
                console.error('Error fetching latest article:', error);
            }
        };

        fetchLatestArticle();
    }, []);

    if (!latestArticle) {
        return <p>Loading latest article...</p>;
    }

    const { articleId, title, content, creationDate, imageUrl } = latestArticle;

    return (
        <div className="latest-article-container left-half">
            <Link to={`/article/${articleId}`} className="latest-article-link">
                <div className="latest-article">
                    <div className="image-container">
                        <img src={imageUrl} alt={`Thumbnail for ${title}`} />
                    </div>
                    <h2>{title}</h2>
                </div>
            </Link>
        </div>
    );

};

export default LatestArticle;
