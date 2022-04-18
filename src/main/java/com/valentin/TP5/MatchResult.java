package com.valentin.TP5;

import java.time.LocalDate;
import java.time.LocalTime;
import com.opencsv.bean.*;

public class MatchResult {

  @CsvBindByName(required=true, column = "Date", locale="fr-FR")
  @CsvDate("dd/MM/yyyy")
  private LocalDate date;

  @CsvBindByName(required=true, column = "Time", locale="fr-FR")
  @CsvDate("HH:mm")
  private LocalTime time;

  @CsvCustomBindByName(
    required=true, 
    column = "HomeTeam", 
    converter=TeamConverter.class
  )
  private Team homeTeam;

  @CsvCustomBindByName(
    required=true, 
    column = "AwayTeam", 
    converter=TeamConverter.class
  )
  private Team visitorTeam;

  @CsvBindByName(required=true, column = "FTHG")
  private int homeFullTimeGoals;

  @CsvBindByName(required=true, column = "FTAG")
  private int visitorFullTimeGoals;

  @CsvBindByName(required=true, column = "HTHG")
  private int halfTimeHomeGoals;

  @CsvBindByName(required=true, column = "HTAG")
  private int halfTimeVisitorGoals;

  @CsvBindByName(required=true, column = "HF")
  private int homeMistakes;

  @CsvBindByName(required=true, column = "AF")
  private int visitorMistakes;

  @CsvBindByName(required=true, column = "HY")
  private int homeYellowCards;

  @CsvBindByName(required=true, column = "AY")
  private int visitorYellowCards;

  @CsvBindByName(required=true, column = "HR")
  private int homeRedCards;

  @CsvBindByName(required=true, column = "AR")
  private int visitorRedCards;

  public LocalDate getDate() {
    return date;
  }

  public LocalTime getTime() {
    return time;
  }

  public Team getHomeTeam() {
    return homeTeam;
  }

  public Team getVisitorTeam() {
    return visitorTeam;
  }

  public int getHomeFullTimeGoals() {
    return homeFullTimeGoals;
  }

  public int getVisitorFullTimeGoals() {
    return visitorFullTimeGoals;
  }

  public int getHalfTimeHomeGoals() {
    return halfTimeHomeGoals;
  }

  public int getHalfTimeVisitorGoals() {
    return halfTimeVisitorGoals;
  }

  public int getHomeMistakes() {
    return homeMistakes;
  }

  public int getVisitorMistakes() {
    return visitorMistakes;
  }

  public int getHomeYellowCards() {
    return homeYellowCards;
  }

  public int getVisitorYellowCards() {
    return visitorYellowCards;
  }

  public int getHomeRedCards() {
    return homeRedCards;
  }

  public int getVisitorRedCards() {
    return visitorRedCards;
  }

  @Override
  public String toString() {
    return homeTeam.getName() + " " + (homeFullTimeGoals + halfTimeHomeGoals) + " -- " + (visitorFullTimeGoals + halfTimeVisitorGoals) + " " + visitorTeam.getName();
  }
}