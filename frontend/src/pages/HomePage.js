// pages/HomePage.js
import React from 'react';
import MatchesComponent from "../components/MatchesComponent";
import LatestArticle from "../components/LatestArticle";
import './HomePageStyles.css';  // Import stylów dla tej strony

const HomePage = () => {
    return (
        <div className="home-page-container">  {/* Dodaj klasę dla kontenera strony */}
            <MatchesComponent />
            <LatestArticle />
        </div>
    );
};

export default HomePage;
