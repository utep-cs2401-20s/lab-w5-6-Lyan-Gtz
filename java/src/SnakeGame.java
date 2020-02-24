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
        headPosition[0] = x;
        headPosition[1] = y;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.game[i][j] = game[i][j];
            }
        }
    }

    //Methods
    //Setters
    public int[] findTailExhaustive(){
        exhaustiveChecks = 0;
        headPosition;
        int[] tailPosition;
        for(int row = r-1; row <= r + 1; row++) {
            for (int col = c - 1; col <= c + 1; col++) {
                if (row < 0 || col < 0 || row >= size || col >= size || (row == r && col == c)) {
                    continue;
                }
                if (game[row][col] == true) {
                    if (i == headPosition[0] && j == headPosition[1]) {
                        continue;
                    }
                }
                exhaustiveChecks += 1;
            }
        return new int[] finalExhaustive [x, y, exhaustiveChecks];
        }
    }

    public int[] findTailRecursive(){}
    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks = 0;
    }
    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    //Getters
    private static int getRecursiveChecks(){
        return exhaustiveChecks;
    }
    private static int getExhaustiveChecks(){
        return recursiveChecks;
    }

}

//int recursiveCheck, int exhaustiveCheck
//findTailExhaustive 1. reset counters, 2. traverse board: row, 3. traverse board: column, 4. if part snake
//5. if not find, 6. if tail: one neighbor and not head, 7. save tail position, 8.
//else{ exhaustiveCheck --; }

//1. reset counter, 2. start at head position, 3. look for neighbors that are true, 4. make sure the neighbor is not
//where we came from, 5. save tail position, 6. count recChecks, 7. count snake length
// for recursive, return array with [tail x, tail y, length]