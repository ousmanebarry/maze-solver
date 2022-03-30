package main;

import java.io.FileNotFoundException;

public class Solver {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage : java main.Solver [filename]");
      return;
    }

    try {
      Maze mazeSolver = new MazeQueue(args[0]);
      int runTime = mazeSolver.solve();
      // System.out.println(mazeSolver.getSolvedPath());
      System.out.println("Run time : " + runTime + " ms");

    } catch (FileNotFoundException e) {
      System.err.printf("File Not Found : The provided file name %s.txt does not exist in /mazes", args[0]);

    } catch (Exception e) {
      System.err.printf("Error : %s", e.getMessage());
    }

  }
}
