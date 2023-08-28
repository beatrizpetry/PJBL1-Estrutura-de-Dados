class FloodFillPilha {
    private int[][] image;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public FloodFillPilha(int[][] image) {
        this.image = image;
    }

    private boolean isValid(int x, int y, int oldValue) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oldValue;
    }

    public void floodFill(int startX, int startY, int newValue) {
        int initialValue = image[startX][startY];
        int numRows = image.length;
        int numCols = image[0].length;

        int[][] stackArray = new int[numRows * numCols][2];
        int top = -1;

        stackArray[++top] = new int[]{startX, startY};

        while (top != -1) {
            int[] current = stackArray[top--];
            int x = current[0];
            int y = current[1];

            if (!isValid(x, y, initialValue)) {
                continue;
            }

            image[x][y] = newValue;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                stackArray[++top] = new int[]{nx, ny};
            }
        }
    }

    public void printImage() {
        for (int[] row : image) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}


