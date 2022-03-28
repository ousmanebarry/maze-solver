// https://www.w3schools.com/java/java_files_read.asp
// https://thenerdshow.com/amaze.html

package main;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MazeSolver {
  public MazeSolver(String fileName) throws FileNotFoundException {
    try {
      File mymazeFile = new File(fileName);
      Scanner myMazeScanner = new Scanner(mymazeFile);
      System.out.println("We're in");
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("The provided file name [" + fileName + "] does not exist in /mazes");
    }
  }

  public void solve() {
  }
}