import java.util.Queue;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;

public class MazeQueue extends Maze {

  private boolean visited[][];

  public MazeQueue(String fileName) throws FileNotFoundException, IllegalStateException {
    super(fileName);
  }

  public int solve() {
    long start, end;
    visited = new boolean[maze.size()][maze.get(0).size()];

    start = System.currentTimeMillis();

    int counter = 0;
    Queue<String> q = new LinkedList<String>();
    q.add("");
    while (counter < 10) {
      String s = q.remove();
      q.add(s + "L");
      q.add(s + "R");
      q.add(s + "U");
      q.add(s + "D");
      System.out.println(q);
      counter++;
    }

    end = System.currentTimeMillis();

    return (int) (end - start);
  }
}