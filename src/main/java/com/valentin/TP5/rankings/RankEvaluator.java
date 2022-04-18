package com.valentin.TP5.rankings;

import com.valentin.TP5.MatchEvaluator;
import com.valentin.TP5.MatchResult;

public class RankEvaluator implements MatchEvaluator {
    @Override
    public int getHomeTeamPoints(MatchResult match) {
        int homeTeamPoints = match.getHalfTimeHomeGoals() + match.getHomeFullTimeGoals();
        int visitorTeamPoints = match.getHalfTimeVisitorGoals() + match.getVisitorFullTimeGoals();

        if (homeTeamPoints > visitorTeamPoints) {
            return 3;
        } else if (homeTeamPoints == visitorTeamPoints) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getVisitorTeamPoints(MatchResult match) {
        int homeTeamPoints = match.getHalfTimeHomeGoals() + match.getHomeFullTimeGoals();
        int visitorTeamPoints = match.getHalfTimeVisitorGoals() + match.getVisitorFullTimeGoals();

        if (homeTeamPoints < visitorTeamPoints) {
            return 3;
        } else if (homeTeamPoints == visitorTeamPoints) {
            return 1;
        } else {
            return 0;
        }
    }
}
