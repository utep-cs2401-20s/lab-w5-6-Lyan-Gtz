import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTester {

    @Test
    public void test1() {
        boolean[][] board = {{true, false, false}, {true, false, false}, {true, false, false}, {true, false, false}};
        SnakeGame sg = new SnakeGame(board, 0, 0);
        int[] result = new int[]{3,0,4};
        assertArrayEquals(result, sg.findTailExhaustive());
    }

    @Test
    public void test2() {
        boolean[][] board = {{true, false, false}, {true, false, false}, {true, false, false}, {true, false, false}};
        SnakeGame sg = new SnakeGame(board, 0, 0);
        int[] tail = sg.findTailExhaustive();
        assertEquals(tail, 3);
    }
}

/*public class SnakeGameTester{
    public static void main(String[] args){
        boolean[][] board = {{true,false,false},{true,false,false},{true,false,false},{true,false,false}};
        SnakeGame sg = new SnakeGame(board,0,0);
        
        int[] tail = sg.findTailExhaustive();
        System.out.println("Exhaustive");
        for(int x : tail){
        System.out.println(x);
        }
        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
        
        System.out.println("Recursive");
        tail = sg.findTailRecursive();
        for(int x : tail){
        System.out.println(x);
        }
        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
            }
}