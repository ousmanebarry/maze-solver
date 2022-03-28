package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class MazeSolver {

  List<List<String>> maze = new ArrayList<>();

  public MazeSolver(String fileName) throws FileNotFoundException {
    File myMazeFile = new File("mazes/" + fileName + ".txt");
    Scanner myMazeScanner = new Scanner(myMazeFile);
    myMazeScanner.close();
  }

  public void solve() {
  }
}