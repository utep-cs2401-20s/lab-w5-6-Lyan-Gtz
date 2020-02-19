public class SnakeGame {
    //Elements
    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //Constructor 1
    SnakeGame() {
        this.game = new boolean[1][1];
    }

    //Constructor 2
    SnakeGame(int size, int x, int y) {
        this.game = new boolean[size][size];
        this.headPosition = new int[] headPosition;
        this.headPosition[0] = x;
        this.headPosition[1] = y;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.game[i][j] = game[i][j];
            }
        }
    }

    //Methods
    //Setters
    public int[] findTailExhaustive(){}
    public int[] findTailRecursive(){}
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){}
    private void resetCounters(){}

    //Getters
    private static int getRecursiveChecks(){}
    private static int getExhaustiveChecks(){}

}