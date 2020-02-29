import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTester {

    @Test
    public void test1() {
        boolean[][] board1 = {{true, false, false}, {true, false, false}, {true, false, false}, {true, false, false}};
        SnakeGame board = new SnakeGame(board1, 0 ,0);
        int[] result = {3, 0, 4};
        assertArrayEquals(result, board.findTailExhaustive());
    }
}