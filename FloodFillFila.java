public class FloodFillFila {
    public static void floodFillFila(int[][] matriz, int startX, int startY, int newValue) {
        int rows = matriz.length;
        int columns = matriz[0].length;
        int oldValue = matriz[startX][startY];

        if (oldValue == newValue) {
            return;
        }

        Fila fila = new Fila(rows * columns); 
        fila.addnewValues(startX * columns + startY); 
        while (!fila.isEmpty()) { 
            int pixel = fila.dequeue(); 
            int x = pixel / columns;
            int y = pixel % columns; 


            if (x < 0 || y < 0 || x >= rows || y >= columns || matriz[x][y] != oldValue) {
                continue;
            }

            matriz[x][y] = newValue; 

            fila.addnewValues((x - 1) * columns + y); 
            fila.addnewValues((x + 1) * columns + y); 
            if (y != 0) {
                fila.addnewValues(x * columns + (y - 1)); 
            }
            if (y != 9) {
                fila.addnewValues(x * columns + (y + 1));
            }
        }
        
    }
    public static void printImage (int[][] matriz){
        for (int[] row : matriz) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();;
        }
    }
}
