package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Maze {

  private List<List<String>> maze;
  private List<List<String>> solvedMaze;

  public Maze(String fileName) throws FileNotFoundException {
    File file = new File("mazes/" + fileName + ".txt");
    Scanner scanner = new Scanner(file);
    maze = solvedMaze = new ArrayList<>();
    initialize(scanner);
  }

  public void initialize(Scanner scanner) {

    while (scanner.hasNext()) {
      String currentLine = scanner.nextLine();
      String[] arrayCurrentLine = currentLine.split("");
      List<String> listCurrentLine = new ArrayList<>();

      for (String i : arrayCurrentLine)
        listCurrentLine.add(i);

      maze.add(listCurrentLine);
      solvedMaze.add(listCurrentLine);
    }

    // System.out.println(maze);

    scanner.close();
  }

  public int solve() {
    long start;
    long end;

    start = System.currentTimeMillis();

    System.out.println();

    end = System.currentTimeMillis();

    return (int) (end - start);
  }

  public void getSolvedPath() {
    System.out.println(solvedMaze);
  }
}