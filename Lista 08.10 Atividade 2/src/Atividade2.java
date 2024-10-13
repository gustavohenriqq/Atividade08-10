import java.util.Scanner;
class Atividade2 {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {
            int opcao;

            do {
                System.out.println("Menu de opções:");
                System.out.println("1. Média aritmética");
                System.out.println("2. Média ponderada");
                System.out.println("3. Sair");
                System.out.print("Digite a opção desejada: ");
                opcao = entrada.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Opção 1: Média aritmética");
                        System.out.print("Digite a primeira nota: ");
                        double nota1 = entrada.nextDouble();
                        System.out.print("Digite a segunda nota: ");
                        double nota2 = entrada.nextDouble();
                        double mediaAritmetica = (nota1 + nota2) / 2;
                        System.out.println("A média aritmética é: " + mediaAritmetica);
                        break;

                    case 2:
                        System.out.println("Opção 2: Média ponderada");
                        System.out.print("Digite a primeira nota: ");
                        double notaP1 = entrada.nextDouble();
                        System.out.print("Digite o peso da primeira nota: ");
                        double peso1 = entrada.nextDouble();
                        System.out.print("Digite a segunda nota: ");
                        double notaP2 = entrada.nextDouble();
                        System.out.print("Digite o peso da segunda nota: ");
                        double peso2 = entrada.nextDouble();
                        System.out.print("Digite a terceira nota: ");
                        double notaP3 = entrada.nextDouble();
                        System.out.print("Digite o peso da terceira nota: ");
                        double peso3 = entrada.nextDouble();
                        double mediaPonderada = (notaP1 * peso1 + notaP2 * peso2 + notaP3 * peso3) / (peso1 + peso2 + peso3);
                        System.out.println("A média ponderada é: " + mediaPonderada);
                        break;

                    case 3:
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 3);
        }


    }
}
