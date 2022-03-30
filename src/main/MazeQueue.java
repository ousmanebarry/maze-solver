package main;

import java.io.FileNotFoundException;
import java.lang.IllegalStateException;

public class MazeQueue extends Maze {

  public MazeQueue(String fileName) throws FileNotFoundException, IllegalStateException {
    super(fileName);
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