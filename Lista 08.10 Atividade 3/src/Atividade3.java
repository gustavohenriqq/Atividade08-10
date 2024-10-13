import java.util.Scanner;
class Atividade3 {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {
            int[] idades = new int[10];
            double[] pesos = new double[10];
            double[] alturas = new double[10];

            int totalPesoMaior90AlturaMenor150 = 0;
            int totalIdadeEntre10e30AlturaMaior190 = 0;
            int totalPessoasAlturaMaior190 = 0;
            int somaIdades = 0;

            for (int i = 0; i < 10; i++) {
                System.out.println("Pessoa " + (i + 1) + ":");

                System.out.print("Informe a idade: ");
                idades[i] = entrada.nextInt();

                System.out.print("Informe o peso (em kg): ");
                pesos[i] = entrada.nextDouble();

                System.out.print("Informe a altura (em metros): ");
                alturas[i] = entrada.nextDouble();

                somaIdades += idades[i];

                if (pesos[i] > 90 && alturas[i] < 1.50) {
                    totalPesoMaior90AlturaMenor150++;
                }

                if (alturas[i] > 1.90) {
                    totalPessoasAlturaMaior190++;
                    if (idades[i] >= 10 && idades[i] <= 30) {
                        totalIdadeEntre10e30AlturaMaior190++;
                    }
                }
            }

            double mediaIdades = (double) somaIdades / 10;

            double porcentagemIdadeEntre10e30 = 0;
            if (totalPessoasAlturaMaior190 > 0) {
                porcentagemIdadeEntre10e30 = (totalIdadeEntre10e30AlturaMaior190 * 100.0) / totalPessoasAlturaMaior190;
            }

            System.out.println("Média das idades: " + mediaIdades);
            System.out.println("Total de pessoas com mais de 90 kg e menos de 1,50 m: " + totalPesoMaior90AlturaMenor150);
            System.out.println("Porcentagem de pessoas com idade entre 10 e 30 anos e mais de 1,90 m: " + porcentagemIdadeEntre10e30 + "%");

            System.out.println("\nDados coletados:");
            for (int i = 0; i < 10; i++) {
                System.out.println("Pessoa " + (i + 1) + " - Idade: " + idades[i] + ", Peso: " + pesos[i] + " kg, Altura: " + alturas[i] + " m");
            }
        }


    }
}
