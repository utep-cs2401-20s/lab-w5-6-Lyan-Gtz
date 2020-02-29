class SnakeGame {
        // Elements
        private boolean[][] game;
        private int[] headPosition;
        private static int exhaustiveChecks;
        private static int recursiveChecks;

        // Constructor 1
        SnakeGame() {
            this.game = new boolean[1][1];
            resetCounters();
        }

        // Constructor 2
        SnakeGame(boolean[][] board, int x, int y) {
            this.game = board;
            this.headPosition = new int[2];
            headPosition[0] = x;
            headPosition[1] = y;
            resetCounters();
        }

        // Methods
        // Setters
        public int[] findTailExhaustive() {
            int neighbors = 0;
            int size = 0;
            int[] result = new int[3];
            boolean tailFound = false;
            for (int i = 0; i < game.length; i++) {
                for (int j = 0; j < game[i].length; j++) {
                    if (tailFound)
                        break;
                    exhaustiveChecks += 1;
                    if (game[i][j]) { // because is boolean no ==true is needed
                        size++;
                        neighbors = 0;
                        for (int row = i - 1; row <= i + 1; row++) {
                            for (int col = j - 1; col <= j + 1; col++) {
                                if (row < 0 || col < 0 || row >= game.length || col >= game[0].length
                                        || (row == i && col == j)) {
                                    continue;
                                }
                                if (game[row][col]) {
                                    neighbors += 1;
                                }
                            }
                        }
                        if ((neighbors == 1) && ((headPosition[0] != i) || (headPosition[1] != j))) {
                            result[0] = i;
                            result[1] = j;
                            tailFound = true;
                        }
                    }
                }
            }
            result[2] = size;
            return result;
        }

        public int[] findTailRecursive() {
            int[] headCopy = new int[3];
            headCopy[0] = headPosition[0];
            headCopy[1] = headPosition[1];
            headCopy[2] = 1;
            return findTailRecursive(headCopy, headCopy);
        }

        private int[] findTailRecursive(int[] currentPosition, int[] previousPosition) {
            recursiveChecks++;
            int i = currentPosition[0];
            int j = currentPosition[1];
            int size = currentPosition[2];
            for (int row = i - 1; row <= i + 1; row++) {
                for (int col = j - 1; col <= j + 1; col++) {
                    if (row < 0 || col < 0 || row >= game.length || col >= game[0].length || (row == i && col == j)) {
                        continue;
                    }
                    if (game[row][col]) {
                        if (row == previousPosition[0] && col == previousPosition[1]) {
                            continue;
                        } else {
                            int[] next = { row, col, size += 1 };
                            currentPosition = findTailRecursive(next, currentPosition);
                        }
                    }
                }
            }
            return currentPosition;
        }

        private void resetCounters() {
            exhaustiveChecks = 0;
            recursiveChecks = 0;
        }

        // Getters
        public static int getRecursiveChecks() {
            return recursiveChecks;
        } // make public for test cases

        public static int getExhaustiveChecks() {
            return exhaustiveChecks;
        } // make public for test cases
    }
