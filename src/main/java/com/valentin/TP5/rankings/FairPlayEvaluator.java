package com.valentin.TP5.rankings;

import com.valentin.TP5.MatchEvaluator;
import com.valentin.TP5.MatchResult;

public class FairPlayEvaluator implements MatchEvaluator {
    @Override
    public int getHomeTeamPoints(MatchResult match) {
        return (match.getHomeRedCards() * 20 + match.getHomeYellowCards() * 5 + match.getHomeMistakes())*-1;
    }

    @Override
    public int getVisitorTeamPoints(MatchResult match) {
        return (match.getVisitorRedCards() * 20 + match.getVisitorYellowCards() * 5 + match.getVisitorMistakes())*-1;
    }
}
