import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import "./ArticleViewStyles.css"

const ArticleView = () => {
    const { id } = useParams();
    const [article, setArticle] = useState(null);

    useEffect(() => {
        const fetchArticle = async () => {
            try {
                const response = await axios.get(`http://localhost:8889/api/articles/${id}`);
                setArticle(response.data);
            } catch (error) {
                console.error('Error fetching article:', error);
            }
        };

        fetchArticle();
    }, [id]);

    if (!article) {
        return <p>Loading...</p>;
    }

    const { title, content, creationDate, comments, imageUrl } = article;

    return (
        <div className="article-view">

            <div className="article-header">
                <h1>{title}</h1>
                <p>{new Date(creationDate).toLocaleString()}</p>
            </div>
            <div className="image-container2">
                <img src={imageUrl} alt={`Thumbnail for ${title}`}/>
            </div>
            <div className="article-content">
                <p>{content}</p>
            </div>


            <div className="article-comments">
                <h2>Comments</h2>
                <ul>
                    {comments.map((comment, index) => (
                        <li key={index}>{comment.text}</li>
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default ArticleView;
