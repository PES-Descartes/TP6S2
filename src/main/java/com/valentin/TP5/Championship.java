package com.valentin.TP5;

import java.util.*;
import java.util.stream.Collectors;

public class Championship {
    private String name;
    private HashMap<Team, Integer> teams;
    ArrayList<MatchResult> results;

    public Championship(String name) {
        this.name = name;
        teams = new HashMap<>();
        results = new ArrayList<>();
    }

    public Team getTeam(String name) {
        for (Team team : teams.keySet()) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    public Team getTeam(long uuid) {
        for (Team team : teams.keySet()) {
            if (team.getUuid() == uuid) {
                return team;
            }
        }
        return null;
    }

    public boolean addTeam(Team team) {
        if (teams.containsKey(team)) {
            return false;
        }
        teams.put(team, 0);
        return true;
    }

    public boolean addMatchResult(MatchResult result) {
        if (results.contains(result)) {
            return false;
        }
        results.add(result);
        return true;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "\n\n");
        for(MatchResult result : results) {
            sb.append(result.toString() + "\n");
        }
        return sb.toString();
    }

    public void addTeams(MatchEvaluator evaluator) {
        for(MatchResult result : results) {
            if(!teams.containsKey(result.getHomeTeam())) {
                teams.put(result.getHomeTeam(), computeTeamPoints(evaluator, result.getHomeTeam()));
            } else if(!teams.containsKey(result.getVisitorTeam())) {
                teams.put(result.getVisitorTeam(), computeTeamPoints(evaluator, result.getVisitorTeam()));
            }
        }
    }

    public void sortTeams() {
        this.teams = teams.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public int computeTeamPoints(MatchEvaluator evaluator, Team team) {
        int points = 0;
        for(MatchResult result : results) {
            if(result.getHomeTeam().equals(team)) {
                points += evaluator.getHomeTeamPoints(result);
            } else {
                points += evaluator.getVisitorTeamPoints(result);
            }
        }
        return points;
    }

    public void printPoints(MatchEvaluator evaluator) {
        for(Team team : teams.keySet()) {
            System.out.println(team.getName() + " : " + computeTeamPoints(evaluator, team) + " points");
        }
    }
}
