import React, { useEffect, useState } from 'react';
import "./MatchesStyles.css"
import axios from 'axios';
import { format } from 'date-fns';

const MatchesComponent = () => {
    const [matches, setMatches] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8889/api/matches/latest');
                setMatches(response.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);

    const formatDate = (dateString) => {
        const date = new Date(dateString);
        return format(date, 'dd/MM/yyyy HH:mm');
    };

    return (
        <div className="matches-container">
            {matches.map((match) => (
                <div key={match.id} className="match-card">
                    <div className="team">
                        <img src={match.homeTeamLogoUrl} alt={`${match.homeTeam} Logo`} />
                        <span>{match.homeTeam}</span>
                    </div>

                    <div className="result-date">
                        <div className="score">
                            <span>{match.homeTeamScore} - {match.awayTeamScore}</span>
                        </div>
                        <div className="date">
                            <span>{formatDate(match.date)}</span>
                        </div>
                    </div>
                    <div className="team">
                        <img src={match.awayTeamLogoUrl} alt={`${match.awayTeam} Logo`} />
                        <span>{match.awayTeam}</span>
                    </div>
                </div>
            ))}
        </div>
    );

};

export default MatchesComponent;
