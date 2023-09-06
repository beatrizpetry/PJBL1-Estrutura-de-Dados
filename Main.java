import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("===== PJBL1 - Estrutura de Dados =====");
        System.out.println();
        System.out.print("Beatriz Petry, Julia Engels e Mariana Camily");
        System.out.println();
        int var = 1;
        while (var != 0){
            Scanner inicio = new Scanner(System.in);
            System.out.print("Deseja Utilizar [1] Fila ou [2] Pilha? (Digite qualquer outro n° para sair): ");
            int resposta = inicio.nextInt();
            if (resposta == 1) {
                System.out.print("===== Opção Selecionada: Fila =====");
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite a linha inicial (0-9): ");
                int startX = scanner.nextInt();
                System.out.print("Digite a coluna inicial (0-9): ");
                int startY = scanner.nextInt();
                System.out.print("Digite o novo valor: ");
                int newValue = scanner.nextInt();
                FloodFillFila.floodFillFila(Matriz.matriz, startX, startY, newValue);
                FloodFillFila.printImage(Matriz.matriz);
            }
            else if (resposta == 2){
                System.out.print("===== Opção Selecionada: Pilha =====");
                System.out.println();
                FloodFillPilha fillPilha = new FloodFillPilha(Matriz.matriz);
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite a linha inicial (0-9): ");
                int startX = scanner.nextInt();
                System.out.print("Digite a coluna inicial (0-9): ");
                int startY = scanner.nextInt();
                System.out.print("Digite o novo valor: ");
                int newValue = scanner.nextInt();

                fillPilha.floodFill(startX, startY, newValue);
                fillPilha.printImage();
            }
            else {
                break;
            }
        }
    }
}