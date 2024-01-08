// pages/HomePage.js
import React from 'react';
import ArticleList from '../components/ArticleList';
import MatchesComponent from "../components/MatchesComponent";
import LatestArticle from "../components/LatestArticle";

const HomePage = () => {
    return (
        <div>
            <MatchesComponent />
            <LatestArticle/>
        </div>
    );
};

export default HomePage;
