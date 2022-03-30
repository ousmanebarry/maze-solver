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
  protected int entranceColIndex = -1;
  protected int exitColIndex = -1;
  protected int entranceRowIndex;
  protected int exitRowIndex;
  protected int playerRowIndex;
  protected int playerColIndex;

  public Maze(String fileName) throws FileNotFoundException, IllegalStateException {
    File file = new File("mazes/" + fileName + ".txt");
    Scanner scanner = new Scanner(file);
    maze = new ArrayList<>();
    solvedMaze = new ArrayList<>();
    initialize(scanner);
    entranceRowIndex = 0;
    exitRowIndex = maze.size() - 1;
    playerRowIndex = entranceRowIndex;
    playerColIndex = entranceColIndex;

    if (entranceColIndex == -1 || exitColIndex == -1) {
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
          entranceColIndex = counter;
        } else if (currentString.equals(EXIT_STRING)) {
          exitColIndex = counter;
        }
        counter++;
      }
      maze.add(listCurrentLine);
      solvedMaze.add(listCurrentLine);
    }

    scanner.close();
  }

  public boolean exitFound() {
    return maze.get(playerRowIndex).get(playerColIndex).equals(EXIT_STRING);
  }

  public void move(String direction) {
    switch (direction) {
      case "L":
        playerColIndex--;
        break;
      case "R":
        playerColIndex++;
        break;
      case "U":
        playerRowIndex--;
        break;
      case "D":
        playerRowIndex++;
        break;
    }
  }

  public boolean canMove(String direction) {
    switch (direction) {
      case "L":
        return playerColIndex - 1 > 0 && playerColIndex - 1 < maze.get(playerRowIndex).size() - 1
            && !maze.get(playerRowIndex).get(playerColIndex - 1).equals("#");
      case "R":
        return playerColIndex + 1 > 0 && playerColIndex + 1 < maze.get(playerRowIndex).size() - 1
            && !maze.get(playerRowIndex).get(playerColIndex + 1).equals("#");
      case "U":
        return playerRowIndex - 1 > 0 && playerRowIndex - 1 < maze.size() - 1
            && !maze.get(playerRowIndex - 1).get(playerColIndex).equals("#");
      case "D":
        return playerRowIndex + 1 > 0 && playerRowIndex + 1 < maze.size() - 1
            && !maze.get(playerRowIndex + 1).get(playerColIndex).equals("#");
    }
    return false;
  }

  public String getSolvedPath() {
    String solvedPath = "";

    for (List<String> currentLine : solvedMaze) {
      for (String currentString : currentLine) {
        solvedPath += currentString;
      }
      solvedPath += "\n";
    }

    return solvedPath;
  }
}