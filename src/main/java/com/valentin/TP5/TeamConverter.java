package com.valentin.TP5;

import com.opencsv.bean.*;
import java.util.Map;
import java.util.HashMap;

// NE PAS MODIFIER !

public class TeamConverter extends AbstractBeanField {

  private final static Map<String,Team> knownTeamNames = new HashMap<>();

  public void record(String name, Team team) {
    knownTeamNames.put(name,team);
  }

  @Override
  public Object convert(String value) {
    if (!knownTeamNames.containsKey(value)) {
      knownTeamNames.put(value, new Team(value));
    } 
    return knownTeamNames.get(value);
  }

  @Override
  public String convertToWrite(Object team) {
    return team.toString();
  }

}