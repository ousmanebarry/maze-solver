package main;

import java.io.FileNotFoundException;
import java.lang.IllegalStateException;

public class MazeQueue extends Maze {

  public MazeQueue(String fileName) throws FileNotFoundException, IllegalStateException {
    super(fileName);
  }

  public int solve() {
    long start, end;

    start = System.currentTimeMillis();

    // System.out.println("Entrance : 0," + entranceColIndex);
    // System.out.println(maze.get(entranceRowIndex).get(entranceColIndex));
    // System.out.println("Exit : " + (exitRowIndex) + "," + exitColIndex);
    // System.out.println(maze.get(exitRowIndex).get(exitColIndex));
    // System.out.println("Player : " + playerRowIndex + "," + playerColIndex);

    end = System.currentTimeMillis();

    return (int) (end - start);
  }

}