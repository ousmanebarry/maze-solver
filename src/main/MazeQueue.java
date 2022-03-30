package main;

import java.io.FileNotFoundException;
import java.lang.IllegalStateException;

public class MazeQueue extends Maze {

  public MazeQueue(String fileName) throws FileNotFoundException, IllegalStateException {
    super(fileName);
  }

  public void move(String direction) {
    switch (direction) {
      case "L":
        System.out.println("Can move left");
        break;
      case "R":
        System.out.println("Can move right");
        break;
      case "U":
        System.out.println("Can move up");
        break;
      case "D":
        System.out.println("Can move down");
        break;
    }
  }

  public boolean canMove(String direction) {

    return true;
  }

  public int solve() {
    long start, end;

    start = System.currentTimeMillis();

    // System.out.println("Entrance : 0," + entranceRowIndex);
    // System.out.println(maze.get(entranceColIndex).get(entranceRowIndex));
    // System.out.println("Exit : " + (exitColIndex) + "," + exitRowIndex);
    // System.out.println(maze.get(exitColIndex).get(exitRowIndex));

    // System.out.println(maze);

    end = System.currentTimeMillis();

    return (int) (end - start);
  }

}