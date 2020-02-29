import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SnakeGameTester {
//Have issues when running jUnit Tests, I get that tests were not found.
//I am adding 5 jUnit Test for each method, but I was not able to run them because of the mentioned problem
//But I was able to run them using a different method in order to satisfy the requirements of this lab

    //Method Exhaustive checks
    @Test
    public void test1() {
        boolean[][] board1 = new boolean[][]{{true, false, false}, {true, false, false}, {true, false, false},
                {true, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,0);
        int[] result = new int[]{3, 0, 4};
        assertArrayEquals(result, sg.findTailExhaustive());
    }
    //Test one was made to see how the exhaustive check goes trough all the cells until the tail is found.

    @Test
    public void test2() {
        boolean[][] board1 = new boolean[][]{{true, true, true}, {false, false, false}, {false, false, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,2);
        int[] result = new int[]{0, 0, 1};
        assertArrayEquals(result, sg.findTailExhaustive());
    }
    //Test two was made to see how the exhaustive check stops when the tail is found and returns its position.

    @Test
    public void test3() {
        boolean[][] board1 = new boolean[][]{{true, false, false}, {false, true, false}, {false, true, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,0);
        int[] result = new int[]{2, 1, 3};
        assertArrayEquals(result, sg.findTailExhaustive());
    }
    //This test was made to see how it will work if the tail was located diagonally on the board and see if it
    // will fail or work.

    @Test
    public void test4() {
        boolean[][] board1 = new boolean[][]{{true, false, false}, {false, false, false}, {false, true, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,0);
        int[] result = new int[]{0, 0, 2};
        assertArrayEquals(result, sg.findTailExhaustive());
    }
    //Test was made to see how the code will behave when the snake was split into different areas of the board
    // without being continues.

    @Test
    public void test5() {
        boolean[][] board1 = new boolean[][]{{false, false, false}, {false, false, false}, {false, false, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,0);
        int[] result = new int[]{0, 0, 0};
        assertArrayEquals(result, sg.findTailExhaustive());
    }
    //Test was conducted to analyze how the code will go through the cells and if the correct values where returned
    // if no tail was found since an empty board was given

    //Recursive Method
    @Test
    public void testR1() {
        boolean[][] board1 = new boolean[][]{{true, false, false}, {true, false, false}, {true, false, false},
                {true, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,0);
        int[] result = new int[]{0, 0, 1};
        assertArrayEquals(result, sg.findTailRecursive());
    }
    //Test was mainly conducted to see how the recursive methods works compared to the exhaustive method and analyze
    //which one is more efficient

    @Test
    public void testR2() {
        boolean[][] board1 = new boolean[][]{{true, true, true}, {false, false, false}, {false, false, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,2);
        int[] result = new int[]{0, 0, 3};
        assertArrayEquals(result, sg.findTailRecursive());
    }
    //See if the recursive method could start at a different position and work as expected without having more counts
    //than needed

    @Test
    public void testR3() {
        boolean[][] board1 = new boolean[][]{{true, false, false}, {false, true, false}, {false, true, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,0);
        int[] result = new int[]{2, 1, 3};
        assertArrayEquals(result, sg.findTailRecursive());
    }
    //Test was to see if it will fail when having a diagonal snake on the board or if it would return a result
    //Unfortunately for both, exhaustive and recursive methods, the test was passed

    @Test
    public void testR4() {
        boolean[][] board1 = new boolean[][]{{true, false, false}, {false, false, false}, {false, true, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 2 ,1);
        int[] result = new int[]{0, 0, 1};
        assertArrayEquals(result, sg.findTailRecursive());
    }
    //This was created by dividing the snake into multiple areas of the board and see if it will count all the true
    // elements by providing a head position, or if it will return the head position as the tail since the parts were
    // not connected among them

    @Test
    public void testR5() {
        boolean[][] board1 = new boolean[][]{{false, false, false}, {false, false, false}, {false, false, false},
                {false, false, false}};
        SnakeGame sg = new SnakeGame(board1, 0 ,2);
        int[] result = new int[]{0, 0, 1};
        assertArrayEquals(result, sg.findTailRecursive());
    }
    //Test was set to see if by giving an empty board and a head position, if the recursive method will count 1 or 0
    //since the head is given. Also, to compare results since the exhaustive check test resulted in a 0
}

//Recursive and Exhaustive Checks in a Single Test
//public class SnakeGameTester{
//    1
//    public static void main(String[] args){
//        boolean[][] board = {{true,false,false},{true,false,false},{true,false,false},{true,false,false}};
//        SnakeGame sg = new SnakeGame(board,0,0);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    2
//    public static void main(String[] args){
//        boolean[][] board = {{true, true, true}, {false, false, false}, {false, false, false},
//                {false, false, false}};
//        SnakeGame sg = new SnakeGame(board,0,2);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    3
//    public static void main(String[] args){
//        boolean[][] board = {{true, false, false}, {false, true, false}, {false, true, false},
//                {false, false, false}};
//        SnakeGame sg = new SnakeGame(board,0,0);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    4
//    public static void main(String[] args){
//        boolean[][] board = {{true, false, false}, {false, false, false}, {false, true, false},
//                {false, false, false}};
//        SnakeGame sg = new SnakeGame(board,0,0);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    5
//    public static void main(String[] args){
//        boolean[][] board = {{false, false, false}, {false, false, false}, {false, false, false},
//                {false, false, false}};
//        SnakeGame sg = new SnakeGame(board,0,0);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    6
//    public static void main(String[] args){
//        boolean[][] board = {{true,true,false},{false,false,false},{false,true,false},
//        {false,false,false}};
//        SnakeGame sg = new SnakeGame(board,0,1);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//   7
//    public static void main(String[] args){
//        boolean[][] board = {{false,false,false},{false,false,true},{true,false,true},
//        {true,false,true}};
//        SnakeGame sg = new SnakeGame(board,3,2);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    8
//    public static void main(String[] args){
//        boolean[][] board = {{false,true,true},{false,true,false},{true,false,false},
//        {true,false,false}};
//        SnakeGame sg = new SnakeGame(board,3,0);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    9
//    public static void main(String[] args){
//        boolean[][] board = {{true,false,true},{true,true,true},{false,false,false},
//        {false,false,false}};
//        SnakeGame sg = new SnakeGame(board,0,2);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}

//public class SnakeGameTester{
//    public static void main(String[] args){
//        boolean[][] board = {{true,false,false},{true,false,false},{true,false,true},
//        {true,true,true}};
//        SnakeGame sg = new SnakeGame(board,2,2);
//
//        int[] tail = sg.findTailExhaustive();
//        System.out.println("Exhaustive");
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getExhaustiveChecks());
//
//        System.out.println("Recursive");
//        tail = sg.findTailRecursive();
//        for(int x : tail){
//        System.out.println(x);
//        }
//        System.out.println("checks is " + SnakeGame.getRecursiveChecks());
//            }
//}