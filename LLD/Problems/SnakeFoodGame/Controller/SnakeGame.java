package LLD.Problems.SnakeFoodGame.Controller;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import LLD.Problems.SnakeFoodGame.models.Board;
import LLD.Problems.SnakeFoodGame.models.Cell;
import LLD.Problems.SnakeFoodGame.models.food.FoodItem;
import LLD.Problems.SnakeFoodGame.strategy.IMovementStrategy;

public class SnakeGame {
  Board board;
  private Deque<Cell> snake;
  private Map<Cell, Boolean> snakeMap;
  private FoodItem[] food;
  private int foodIndex;
  private IMovementStrategy movementStrategy;
  private boolean inProgress; 
  private int score;
  
  public SnakeGame(int width, int height, FoodItem[] food, IMovementStrategy movementStrategy) {
    board = Board.getInstance(width, height);
    snake = new LinkedList<>();
    snakeMap = new HashMap<>();
    
    Cell head = new Cell(0, 0);
    snake.addFirst(head);
    snakeMap.put(head, true);

    this.food = food;
    foodIndex = 0;
    
    this.movementStrategy = movementStrategy;
    inProgress = false;
    score = 0;
  }

  public void setMovementStrategy(IMovementStrategy newMovementStrategy) {
    movementStrategy = newMovementStrategy;
  }

  public void play() {
    inProgress = true;
    // Display game instructions
    System.out.println("===== SNAKE GAME =====");
    System.out.println(
            "Controls: UP, DOWN, LEFT, RIGHT, Q (Quit)");
    System.out.println("Eat food to grow your snake and increase your score.");
    System.out.println("Don't hit the walls or bite yourself!");
    System.out.println("=======================");

     // Create scanner for user input
    Scanner scanner = new Scanner(System.in);

    while(inProgress) {
      System.out.print("Enter move (UP/DOWN/LEFT/RIGHT) or Q to quit: ");
      String input = scanner.nextLine().toUpperCase();

      // Handle quit command
      if (input.equals("Q")) {
          System.out.println("Game ended by player. Final score: " + score);
          inProgress = false;
          continue;
      }

      // Skip invalid inputs
      if (input.isEmpty()) {
          System.out.println("Invalid input! Use W/A/S/D to move or Q to quit.");
          continue;
      }
      // Make the move and get the new score
      int updatedScore = handleMove(input);
      // Check for game over
      if (updatedScore == -1) {
          System.out.println("GAME OVER! You hit a wall or bit yourself.");
          System.out.println("Final score: " + score);
          inProgress = false;
      } else {
          this.score = updatedScore;
          System.out.println("Score: " + score);
      }
    }
    scanner.close();
    System.out.println("Thanks for playing!");
  }

  private int handleMove(String input) {
    Cell currentHead = snake.peekFirst();
    Cell nextHead = movementStrategy.nextPosition(currentHead, input);
    int newHeadRow = nextHead.getRow();
    int newHeadColumn = nextHead.getCol();
    
    // check boundary conditions
    boolean crossesBoundary = newHeadRow < 0 || newHeadRow >= this.board.getHeight() || newHeadColumn < 0 || newHeadColumn >= this.board.getWidth();

      // Get current tail for collision check
      Cell currentTail = this.snake.peekLast();

      // Check if snake bites itself (excluding tail which will move away)
      boolean bitesItself = this.snakeMap.containsKey(nextHead) && !(nextHead.getRow() == currentTail.getRow() && nextHead.getCol() == currentTail.getCol());

      // Game over conditions
      if (crossesBoundary || bitesItself) {
          return -1;
      }
      // Check if snake eats food
      boolean ateFood = (this.foodIndex < this.food.length) &&
              (this.food[this.foodIndex].getRow() == newHeadRow) &&
              (this.food[this.foodIndex].getCol() == newHeadColumn);
      if(ateFood) {
        score += this.food[this.foodIndex].getPoints();
        // Increment food index to move to next food
        this.foodIndex++;
      } else {
          // If no food eaten, remove tail
          this.snake.pollLast();
          this.snakeMap.remove(currentTail);
      }
      // Add new head
      this.snake.addFirst(nextHead);
      this.snakeMap.put(nextHead, true);
      return score;
  }

}
