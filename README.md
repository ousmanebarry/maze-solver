## Maze Solver (Work In Progress)

**_Maze Solver_** is a java program that solves mazes. It takes a maze from a text file, transforms it into an ArrayList and runs a breadth first search algorithm to solve the Maze.

## Explanation

- **#** (Delimiter)
- **E** (Entrance)
- **X** (Exit)

![maze1](./public/maze1.png)

<span style="font-size: 15px">_This [text file](/src/mazes/maze1.txt) can be found in `src/mazes/maze1.txt`_</span>

If you wish to generate a random maze, here is a [website](https://thenerdshow.com/amaze.html) that does it for you. _Do not forget to add the **E** and **X** to let the program know of the entrance and the exit._

## Usage

Navigate to the `main` folder and compile the java files with the following command :

```bash
javac *.java
```

Navigate back to the `src` folder and run the `Solver.java` with the following command :

```bash
java main.Solver maze1
```

## Expected Behaviour

Using the previously described algorithm, we solve the maze while keeping track of the amount of time taken. If the maze is solved, we print the solved path and the amount of milliseconds taken to solve to the standard output.

```java
long start = System.currentTimeMillis();
// ...
long end = System.currentTimeMillis();

System.out.println(maze.getSolvedPath()); // Prints solved path
System.out.println("Run time :" + (int) (end - start) + " ms"); // Prints time taken to solve
```

## Contributing

Pull requests are welcome. Feel free to fork this project and implement any other algorithm to solve these mazes in the fastest way possible. You can open a pull request [here](https://github.com/ousmanebarry/MazeSolver/pulls).

## License

This project is licensed under the [MIT](/LICENSE) license.

## Links

- [Maze-solving algorithms](https://en.wikipedia.org/wiki/Maze-solving_algorithm)
- [Random maze generator](https://thenerdshow.com/amaze.html)

![issue video](https://cdn.discordapp.com/attachments/439833184260063233/958864694435786752/2022-03-30_19-02-48.mp4)
