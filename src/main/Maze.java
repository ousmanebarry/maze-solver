package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;

public class Maze {
  protected static final String ENTRANCE_STRING = "E";
  protected static final String EXIT_STRING = "X";
  protected List<List<String>> solvedMaze;
  protected List<List<String>> maze;
  protected int entranceRowIndex = -1;
  protected int exitRowIndex = -1;
  protected int entranceColIndex;
  protected int exitColIndex;

  public Maze(String fileName) throws FileNotFoundException, IllegalStateException {
    File file = new File("mazes/" + fileName + ".txt");
    Scanner scanner = new Scanner(file);
    maze = solvedMaze = new ArrayList<>();
    initialize(scanner);
    entranceColIndex = 0;
    exitColIndex = maze.size() - 1;

    if (entranceRowIndex == -1 || exitRowIndex == -1) {
      throw new IllegalStateException("The maze must have an entrance (E) and an exit (X)");
    }
  }

  public void initialize(Scanner scanner) {

    while (scanner.hasNext()) {
      int counter = 0;
      String currentLine = scanner.nextLine();
      String[] arrayCurrentLine = currentLine.split("");
      List<String> listCurrentLine = new ArrayList<>();

      for (String currentString : arrayCurrentLine) {
        listCurrentLine.add(currentString);
        if (currentString.equals(ENTRANCE_STRING)) {
          entranceRowIndex = counter;
        } else if (currentString.equals(EXIT_STRING)) {
          exitRowIndex = counter;
        }
        counter++;
      }

      maze.add(listCurrentLine);
      solvedMaze.add(listCurrentLine);
    }

    scanner.close();
  }

  public List<List<String>> getSolvedPath() {
    return solvedMaze;
  }
}