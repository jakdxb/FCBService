import React from 'react';
import './ScrollingComponent.css';

const ScrollingComponent = () => {
    return (
        <div className="scrolling-container">
            <div className="featured-article">
                <a href="#article1">
                    <img src="url_do_duzego_zdjecia.jpg" alt="Duże Zdjęcie" />
                    <h2>Tytuł Dużego Artykułu</h2>
                </a>
            </div>

            <div className="article-list">
                <div className="article-item">
                    <a href="#article2">
                        <img src="url_do_malego_zdjecia_1.jpg" alt="Małe Zdjęcie 1" />
                        <h3>Tytuł Artykułu 1</h3>
                    </a>
                </div>

                <div className="article-item">
                    <a href="#article3">
                        <img src="url_do_malego_zdjecia_2.jpg" alt="Małe Zdjęcie 2" />
                        <h3>Tytuł Artykułu 2</h3>
                    </a>
                </div>

                {/* Dodaj kolejne artykuły według potrzeb */}
            </div>
        </div>
    );
};

export default ScrollingComponent;
