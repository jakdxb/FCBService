// LeagueTable.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import "./LeagueTableStyles.css";

const LeagueTable = () => {
    const [leagueData, setLeagueData] = useState(null);

    useEffect(() => {
        const fetchLeagueData = async () => {
            try {
                const response = await axios.get('http://localhost:8889/api/league/1');
                // Sortowanie zespołów malejąco według ilości punktów
                const sortedTeams = response.data.teams.sort((a, b) => b.points - a.points);
                // Przypisanie indeksów
                const teamsWithRanking = sortedTeams.map((team, index) => ({ ...team, ranking: index + 1 }));
                setLeagueData({ ...response.data, teams: teamsWithRanking });
            } catch (error) {
                console.error('Error fetching league data:', error);
            }
        };

        fetchLeagueData();
    }, []);

    if (!leagueData) {
        return <p>Loading...</p>;
    }

    const { leagueName, teams } = leagueData;

    return (
        <div className="league-table-container">
            <div className="league-title-container">
                <h2>{leagueName} Table</h2>
            </div>
            <table>
                <thead>
                <tr>
                    <th>#</th>
                    <th>Club</th>
                    <th>M</th>
                    <th>W</th>
                    <th>L</th>
                    <th>D</th>
                    <th>P</th>
                    <th>G</th>
                </tr>
                </thead>
                <tbody>
                {teams.map((team) => (
                    <tr key={team.id}>
                        <td>{team.ranking}</td>
                        <td>{team.teamName}</td>
                        <td>{team.matches}</td>
                        <td>{team.wins}</td>
                        <td>{team.loses}</td>
                        <td>{team.draws}</td>
                        <td>{team.points}</td>
                        <td>{`${team.goalsScored} - ${team.goalsConceded}`}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default LeagueTable;
