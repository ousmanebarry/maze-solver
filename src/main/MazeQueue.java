package main;

import java.io.FileNotFoundException;
import java.lang.IllegalStateException;

public class MazeQueue extends Maze {

  public MazeQueue(String fileName) throws FileNotFoundException, IllegalStateException {
    super(fileName);
  }

  public boolean canMove(char direction) {
    return true;
  }

  public int solve() {
    long start, end;

    start = System.currentTimeMillis();

    // System.out.println("Entrance : 0," + entranceRowIndex);
    // System.out.println(maze.get(0).get(entranceRowIndex));
    // System.out.println("Exit : " + (maze.size() - 1) + "," + exitRowIndex);
    // System.out.println(maze.get(maze.size() - 1).get(exitRowIndex));

    System.out.println(maze);

    end = System.currentTimeMillis();

    return (int) (end - start);
  }

}