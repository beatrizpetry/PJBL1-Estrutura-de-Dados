class Pixel {
    int x;
    int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class FloodFillFila {
    public FloodFillFila(int[][] matriz) {
    }

    public void floodFill(int[][] matrix, int startX, int startY, int newValue) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int oldValue = matrix[startX][startY];

        if (oldValue == newValue) {
            return;
        }
        
        int [][] image;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] queue = new int[numRows * numCols][2];
        int front = 0;
        int end = 0;

        queue[end][0] = startX;
        queue[end][1] = startY;
        end++;

        while (front != end) {
            int[] current = queue[front];
            front++;
            int x = current[0];
            int y = current[1];

            if (x < 0 || x >= numRows || y < 0 || y >= numCols || matrix[x][y] != oldValue) {
                continue;
            }

            matrix[x][y] = newValue;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                queue[end][0] = nx;
                queue[end][1] = ny;
                end++;
            }
        }
    }

    public void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}