import LLD.Problems.SnakeFoodGame.Controller.SnakeGame;
import LLD.Problems.SnakeFoodGame.models.food.BonusFood;
import LLD.Problems.SnakeFoodGame.models.food.FoodItem;
import LLD.Problems.SnakeFoodGame.models.food.NormalFood;
import LLD.Problems.SnakeFoodGame.strategy.ConcreteMovementStrategy.HumanMovementStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        FoodItem[] food = {
            new NormalFood(2, 5, 1),
            new BonusFood(5, 10, 3),
            new NormalFood(10, 0, 1),
            new BonusFood(13, 12, 3),
            new NormalFood(1, 9, 1)
        };
        SnakeGame game = new SnakeGame(15, 20, food, new HumanMovementStrategy());
        game.play();
    }
}
