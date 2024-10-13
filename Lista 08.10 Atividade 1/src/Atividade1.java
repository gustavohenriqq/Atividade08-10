import java.util.Scanner;
class Atividade1 {
    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {
            int totalPessoas = 0;
            int pessoasCanal4 = 0;
            int pessoasCanal5 = 0;
            int pessoasCanal7 = 0;
            int pessoasCanal12 = 0;

            while (true) {
                System.out.println("Informe o número do canal (4, 5, 7, 12) ou 0 para sair:");
                int canal = entrada.nextInt();

                if (canal == 0) {
                    break;
                }

                if (canal == 4 || canal == 5 || canal == 7 || canal == 12) {
                    System.out.println("Informe o número de pessoas assistindo:");
                    int pessoas = entrada.nextInt();

                    totalPessoas += pessoas;

                    switch (canal) {
                        case 4:
                            pessoasCanal4 += pessoas;
                            break;
                        case 5:
                            pessoasCanal5 += pessoas;
                            break;
                        case 7:
                            pessoasCanal7 += pessoas;
                            break;
                        case 12:
                            pessoasCanal12 += pessoas;
                            break;
                    }
                } else {
                    System.out.println("Número de canal inválido. Tente novamente.");
                }
            }

            if (totalPessoas > 0) {
                System.out.println("Porcentagem de audiência:");
                double porcentagemCanal4 = (pessoasCanal4 * 100.0 / totalPessoas);
                double porcentagemCanal5 = (pessoasCanal5 * 100.0 / totalPessoas);
                double porcentagemCanal7 = (pessoasCanal7 * 100.0 / totalPessoas);
                double porcentagemCanal12 = (pessoasCanal12 * 100.0 / totalPessoas);

                System.out.println("Canal 4: " + porcentagemCanal4 + "%");
                System.out.println("Canal 5: " + porcentagemCanal5 + "%");
                System.out.println("Canal 7: " + porcentagemCanal7 + "%");
                System.out.println("Canal 12: " + porcentagemCanal12 + "%");
            } else {
                System.out.println("Nenhum dado registrado.");


            }
        }
    }
}
