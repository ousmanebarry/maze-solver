package main;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Maze {

  private List<List<String>> maze;

  public Maze(String fileName) throws FileNotFoundException {
    File file = new File("mazes/" + fileName + ".txt");
    Scanner scanner = new Scanner(file);
    maze = new ArrayList<>();
    initialize(scanner);
  }

  public void initialize(Scanner scanner) {

    while (scanner.hasNext()) {
      String currentLine = scanner.nextLine();
      String[] splitCurrentLine = currentLine.split("");
      List<String> temp = new ArrayList<>();

      for (String i : splitCurrentLine)
        temp.add(i);

      maze.add(temp);
    }

    // System.out.println(maze);

    scanner.close();
  }

  public int solve() {
    long start;
    long end;

    start = System.currentTimeMillis();

    // Write solving logic here

    end = System.currentTimeMillis();

    return (int) (end - start);
  }
}