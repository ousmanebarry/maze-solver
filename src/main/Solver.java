package main;

import java.io.FileNotFoundException;

public class Solver {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Usage : java main.Solver filename");
      return;
    }

    MazeSolver mazeSolver;

    try {
      mazeSolver = new MazeSolver(args[0]);
      mazeSolver.solve();
    } catch (FileNotFoundException e) {
      System.err.printf("File Not Found : %s", e.getMessage());
    }
  }
}
