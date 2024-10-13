import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMedicos {
    private ArrayList<Medico> medicos;

    public SistemaMedicos() {
        medicos = new ArrayList<>();
    }

    public void cadastrarMedico(Scanner entrada) {
        System.out.print("Registro CRM do médico: ");
        int registroCRM = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nome do médico: ");
        String nome = entrada.nextLine();

        System.out.print("Especialidade do médico: ");
        String especialidade = entrada.nextLine();

        medicos.add(new Medico(registroCRM, nome, especialidade));
        System.out.println("Médico cadastrado com sucesso!");
    }

    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            System.out.println("Lista de Médicos:");
            for (Medico medico : medicos) {
                System.out.println(medico);
            }
        }
    }

    public void removerMedico(Scanner entrada) {
        System.out.print("Digite o CRM do médico a ser removido: ");
        int registroCRM = entrada.nextInt();

        Medico medico = buscarMedico(registroCRM);
        if (medico != null) {
            medicos.remove(medico);
            System.out.println("Médico removido com sucesso!");
        } else {
            System.out.println("Médico não encontrado!");
        }
    }

    private Medico buscarMedico(int registroCRM) {
        for (Medico medico : medicos) {
            if (medico.getRegistroCRM() == registroCRM) {
                return medico;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SistemaMedicos sistema = new SistemaMedicos();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu do Sistema de Médicos:");
            System.out.println("1. Cadastrar médico");
            System.out.println("2. Listar médicos");
            System.out.println("3. Remover médico");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    sistema.cadastrarMedico(entrada);
                    break;
                case 2:
                    sistema.listarMedicos();
                    break;
                case 3:
                    sistema.removerMedico(entrada);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        entrada.close();
    }
}

