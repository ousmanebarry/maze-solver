package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Maze {

  private static final String ENTRANCE_STRING = "E";
  private static final String EXIT_STRING = "X";
  private int entranceRowIndex = -1;
  private int exitRowIndex = -1;
  private int entranceColIndex;
  private int exitColIndex;
  private List<List<String>> maze;
  private List<List<String>> solvedMaze;

  public Maze(String fileName) throws FileNotFoundException, IllegalArgumentException {
    File file = new File("mazes/" + fileName + ".txt");
    Scanner scanner = new Scanner(file);
    maze = solvedMaze = new ArrayList<>();
    initialize(scanner);
    entranceColIndex = 0;
    exitColIndex = maze.size() - 1;

    if (entranceRowIndex == -1 || exitRowIndex == -1) {
      throw new IllegalArgumentException("The maze must have an entrance and an exit");
    }
  }

  public void initialize(Scanner scanner) {

    while (scanner.hasNext()) {
      int counter = 0;
      String currentLine = scanner.nextLine();
      String[] arrayCurrentLine = currentLine.split("");
      List<String> listCurrentLine = new ArrayList<>();

      for (String i : arrayCurrentLine) {
        listCurrentLine.add(i);
        if (i.equals(ENTRANCE_STRING)) {
          entranceRowIndex = counter;
        } else if (i.equals(EXIT_STRING)) {
          exitRowIndex = counter;
        }
        counter++;
      }

      maze.add(listCurrentLine);
      solvedMaze.add(listCurrentLine);
    }

    scanner.close();
  }

  public boolean canMove(char direction) {
    return true;
  }

  public int solve() {
    long start;
    long end;

    start = System.currentTimeMillis();

    // System.out.println("Entrance : 0," + entranceRowIndex);
    // System.out.println(maze.get(0).get(entranceRowIndex));
    // System.out.println("Exit : " + (maze.size() - 1) + "," + exitRowIndex);
    // System.out.println(maze.get(maze.size() - 1).get(exitRowIndex));
    System.out.println(solvedMaze);

    end = System.currentTimeMillis();

    return (int) (end - start);
  }

  public List<List<String>> getSolvedPath() {
    return solvedMaze;
  }
}