package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;

public class Maze {
  public static final String ENTRANCE = "E";
  public static final String EXIT = "X";
  public static final String WALL = "#";
  public static final String PATH = " ";
  public List<List<String>> solvedMaze;
  public List<List<String>> maze;
  public int entranceColIndex = -1;
  public int exitColIndex = -1;
  public int entranceRowIndex;
  public int exitRowIndex;
  public int playerRowIndex;
  public int playerColIndex;

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
        if (currentString.equals(ENTRANCE)) {
          entranceColIndex = counter;
        } else if (currentString.equals(EXIT)) {
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
    return maze.get(playerRowIndex).get(playerColIndex).equals(EXIT);
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
            && !maze.get(playerRowIndex).get(playerColIndex - 1).equals(WALL);
      case "R":
        return playerColIndex + 1 > 0 && playerColIndex + 1 < maze.get(playerRowIndex).size() - 1
            && !maze.get(playerRowIndex).get(playerColIndex + 1).equals(WALL);
      case "U":
        return playerRowIndex - 1 > 0 && playerRowIndex - 1 < maze.size() - 1
            && !maze.get(playerRowIndex - 1).get(playerColIndex).equals(WALL);
      case "D":
        return playerRowIndex + 1 > 0 && playerRowIndex + 1 < maze.size() - 1
            && !maze.get(playerRowIndex + 1).get(playerColIndex).equals(WALL);
    }
    return false;
  }

  public int solve() {
    throw new UnsupportedOperationException("Not implemented yet");
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