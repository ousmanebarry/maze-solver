// https://www.w3schools.com/java/java_files_read.asp
// https://thenerdshow.com/amaze.html

package main;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MazeSolver {
  public MazeSolver(String fileName) throws FileNotFoundException {
    File myMazeFile = new File("mazes/" + fileName + ".txt");
    Scanner myMazeScanner = new Scanner(myMazeFile);
    myMazeScanner.close();
  }

  public void solve() {
  }
}