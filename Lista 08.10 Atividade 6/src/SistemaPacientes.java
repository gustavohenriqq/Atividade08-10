import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPacientes {
    private ArrayList<Paciente> pacientes;

    public SistemaPacientes() {
        pacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Scanner entrada) {
        System.out.print("ID do paciente: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nome do paciente: ");
        String nome = entrada.nextLine();

        System.out.print("Idade do paciente: ");
        int idade = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Endereço do paciente: ");
        String endereco = entrada.nextLine();

        pacientes.add(new Paciente(id, nome, idade, endereco));
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            System.out.println("Lista de Pacientes:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }

    public void removerPaciente(Scanner entrada) {
        System.out.print("Digite o ID do paciente a ser removido: ");
        int id = entrada.nextInt();

        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    private Paciente buscarPaciente(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SistemaPacientes sistema = new SistemaPacientes();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu do Sistema de Pacientes:");
            System.out.println("1. Cadastrar paciente");
            System.out.println("2. Listar pacientes");
            System.out.println("3. Remover paciente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    sistema.cadastrarPaciente(entrada);
                    break;
                case 2:
                    sistema.listarPacientes();
                    break;
                case 3:
                    sistema.removerPaciente(entrada);
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
