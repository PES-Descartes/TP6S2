package com.valentin.TP5.rankings;

import com.valentin.TP5.MatchEvaluator;
import com.valentin.TP5.MatchResult;

public class GoalEvaluator implements MatchEvaluator {
    @Override
    public int getHomeTeamPoints(MatchResult match) {

        return match.getHomeFullTimeGoals() + match.getHalfTimeHomeGoals();
    }

    @Override
    public int getVisitorTeamPoints(MatchResult match) {
        return match.getVisitorFullTimeGoals() + match.getHalfTimeVisitorGoals();
    }
}
