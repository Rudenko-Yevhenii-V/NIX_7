package ry.rudenko.yevhenii;

import java.util.HashMap;
import java.util.Map;

public class MostProfitableWay {

  Dijkstra dijkstra = new Dijkstra();

  public String mostProfitableWay(String inputCity) {
    StringBuilder retOutput = new StringBuilder();
    Map<String, Integer> cityes = new HashMap<>();
    final String[] split = inputCity.split("\n");
    int valueCityes = Integer.parseInt(split[0]);
    int[][] inputMatrix = new int[valueCityes][valueCityes];
    for (int i = 0; i < inputMatrix.length; i++) {
      for (int i1 = 0; i1 < inputMatrix[i].length; i1++) {
        if(i == i1){
          inputMatrix[i][i1] = 0;
          continue;
        }
        inputMatrix[i][i1] = -1;
      }
    }
    int inputMatrixCount = -1;
    int countCityes = 1;
    for (String s : split) {
      if (s.matches("[^0-9]*") && !(s.matches("[^0-9]*\\s[^0-9]*"))) {
        cityes.put(s, countCityes);
        countCityes++;
        inputMatrixCount++;
        continue;
      }
      if (s.matches("[^0-9]*\\s[^0-9]*")) {
        final String[] split1 = s.split(" ");
        int start = cityes.get(split1[0]);
        int stop = cityes.get(split1[1]);
        int step = inputMatrix.length - (stop - start + 1);
        int[][] adjMatrix = new int[stop - start + 1][stop - start + 1];
        for (int i = 0; i <= stop - start; i++) {
          if (stop - start + 1 >= 0)
            System
                .arraycopy(inputMatrix[start - 1 + i], step, adjMatrix[i], 0, stop - start + 1);
        }
        int[] result = dijkstra.getShortestPaths(adjMatrix);
        String out = split1[0] + " is "+result[result.length - 1]+" hours ahead of "+split1[1]+".";
        retOutput.append(out).append("\n");
        continue;
      }
      if (s.matches("[0-9]*\\s[0-9]*")) {
        final String[] s1 = s.split(" ");
        inputMatrix[inputMatrixCount][Integer.parseInt(s1[0])-1] = Integer.parseInt(s1[1]);
      }
    }
    return retOutput.toString();
  }
}
