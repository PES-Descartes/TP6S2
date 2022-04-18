package com.valentin.TP5;

import com.opencsv.bean.*;
import com.valentin.TP5.rankings.FairPlayEvaluator;
import com.valentin.TP5.rankings.GoalEvaluator;
import com.valentin.TP5.rankings.RankEvaluator;

import java.io.*;
import java.util.List;

class Main {

  public static void main(String[] args) throws IOException {
    try (InputStream in = Main.class.getResourceAsStream("/F1_2021_2022.csv"); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
      List<MatchResult> matchResults = readDataFile(reader);
      Championship championship = new Championship("Ligue 1 2020/21, France");
      for (MatchResult matchResult : matchResults) {
        championship.addMatchResult(matchResult);
      }
      MatchEvaluator evaluator = new FairPlayEvaluator();
      championship.addTeams(evaluator);
      championship.sortTeams();

      championship.printPoints(evaluator);

      //System.out.println(championship);
    }

    /*
    List<MatchResult> results = readDataFile("F1_2021_2022.csv");
    for (MatchResult result : results) {
      System.out.println(result);
    }*/
  }


  public static List<MatchResult> readDataFile(BufferedReader reader)
    throws IOException 
  {
    CsvToBean<MatchResult> csvToBean = 
      new CsvToBeanBuilder(reader)
       .withSeparator(',')
       .withType(MatchResult.class)
       .build();
    return csvToBean.parse();  
  }
}
