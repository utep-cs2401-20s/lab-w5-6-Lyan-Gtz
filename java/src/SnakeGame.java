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
        this.exhaustiveChecks = 0;
        int lengthTail = 0;
        headPosition;
        for(int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i < 0 || j < 0 || i >= size || j >= size || (i == r && j == c)) {
                    continue;
                }
                if (i == headPosition[0] && j == headPosition[1]) {
                    lengthTail += 1;
                    continue;
                }
                else if(this.game[i][j] == 1){
                    lengthTail += 1;
                    exhaustiveChecks += 1;
                }
            }
        }
        return new int[] finalExhaustive [x, y, lengthTail];
    }

    public int[] findTailRecursive(){
        this.recursiveChecks = 0;
        return findTailRecursive();
    }

    private int[] findTailRecursive(int[] currentPosition, int[] previousPosition){
        recursiveChecks = 0;
        int lengthTail = 0;
        currentPosition = this.headPosition;
        previousPosition = currentPosition;
        if(currentPosition[0] + 1 == true && currentPosition[1] == true){
            previousPosition = currentPosition;
            recursiveChecks += 1;
            lengthTail +=1;
            return findTailRecursive(currentPosition[0] + 1, currentPosition[1]);
        }
        if(currentPosition[0] == true && currentPosition[1] + 1 == true){
            previousPosition = currentPosition;
            recursiveChecks += 1;
            lengthTail +=1;
            return findTailRecursive(currentPosition[0], currentPosition[1] + 1);
        }
        return findTailRecursive(currentPosition[0], currentPosition[1],lengthTail)
    }

    private void resetCounters(){
        exhaustiveChecks = this.exhaustiveChecks;
        recursiveChecks = this.recursiveChecks;
    }

    //Getters
    private static int getRecursiveChecks(){
        return exhaustiveChecks;
    } //make public for test cases

    private static int getExhaustiveChecks(){
        return recursiveChecks;
    } //make public for test cases
}

//int recursiveCheck, int exhaustiveCheck
//findTailExhaustive 1. reset counters, 2. traverse board: row, 3. traverse board: column, 4. if part snake
//5. if not find, 6. if tail: one neighbor and not head, 7. save tail position, 8.
//else{ exhaustiveCheck --; }

//1. reset counter, 2. start at head position, 3. look for neighbors that are true, 4. make sure the neighbor is not
//where we came from, 5. save tail position, 6. count recChecks, 7. count snake length
// for recursive, return array with [tail x, tail y, length]