import java.util.ArrayList;
import java.util.Scanner;

public class LojinhaSrAbu {
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu da Lojinha do Sr. Abu:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Alterar produto");
            System.out.println("3. Excluir produto");
            System.out.println("4. Realizar venda");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto(entrada);
                    break;
                case 2:
                    alterarProduto(entrada);
                    break;
                case 3:
                    excluirProduto(entrada);
                    break;
                case 4:
                    realizarVenda(entrada);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);

        entrada.close();
    }

    private static void cadastrarProduto(Scanner entrada) {
        System.out.print("Código do produto: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();  // Limpar buffer

        System.out.print("Nome do produto: ");
        String nome = entrada.nextLine();

        System.out.print("Valor unitário: ");
        double valorUnitario = entrada.nextDouble();

        System.out.print("Tipo de unidade (ex: kg, un, etc): ");
        String unidade = entrada.next();

        produtos.add(new Produto(codigo, nome, valorUnitario, unidade));
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void alterarProduto(Scanner entrada) {
        System.out.print("Digite o código do produto que deseja alterar: ");
        int codigo = entrada.nextInt();

        Produto produto = buscarProduto(codigo);
        if (produto != null) {
            entrada.nextLine();  // Limpar buffer
            System.out.print("Novo nome do produto: ");
            String nome = entrada.nextLine();

            System.out.print("Novo valor unitário: ");
            double valorUnitario = entrada.nextDouble();

            System.out.print("Nova unidade: ");
            String unidade = entrada.next();

            produto.setNome(nome);
            produto.setValorUnitario(valorUnitario);
            produto.setUnidade(unidade);

            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void excluirProduto(Scanner entrada) {
        System.out.print("Digite o código do produto que deseja excluir: ");
        int codigo = entrada.nextInt();

        Produto produto = buscarProduto(codigo);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void realizarVenda(Scanner entrada) {
        double totalVenda = 0;
        int codigo;
        double quantidade;

        do {
            System.out.print("Digite o código do produto (ou 0 para finalizar): ");
            codigo = entrada.nextInt();

            if (codigo == 0) {
                break;
            }

            Produto produto = buscarProduto(codigo);
            if (produto != null) {
                System.out.print("Digite a quantidade: ");
                quantidade = entrada.nextDouble();
                totalVenda += produto.getValorUnitario() * quantidade;
                System.out.println("Adicionado: " + produto.getNome() + " - Quantidade: " + quantidade);
            } else {
                System.out.println("Produto não encontrado!");
            }
        } while (codigo != 0);

        if (totalVenda > 0) {
            System.out.println("Total da compra: R$ " + totalVenda);
            definirFormaPagamento(entrada, totalVenda);
        } else {
            System.out.println("Nenhum produto vendido.");
        }
    }

    private static void definirFormaPagamento(Scanner entrada, double totalVenda) {
        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão");
        System.out.println("3. Dinheiro");
        System.out.print("Opção: ");
        int opcaoPagamento = entrada.nextInt();

        switch (opcaoPagamento) {
            case 1:
                System.out.println("Pagamento via Pix.");
                System.out.println("Código Pix: 1234-5678-9012");
                break;
            case 2:
                System.out.println("Pagamento via Cartão.");
                System.out.print("Crédito ou Débito? ");
                String tipoCartao = entrada.next();
                System.out.print("Digite os dados do cartão: ");
                String dadosCartao = entrada.next();  // Simulação dos dados do cartão
                System.out.println("Pagamento realizado com " + tipoCartao);
                break;
            case 3:
                System.out.print("Pagamento em Dinheiro. Digite o valor pago: ");
                double valorPago = entrada.nextDouble();
                if (valorPago >= totalVenda) {
                    double troco = valorPago - totalVenda;
                    System.out.println("Troco: R$ " + troco);
                } else {
                    System.out.println("Valor insuficiente.");
                }
                break;
            default:
                System.out.println("Forma de pagamento inválida.");
        }
    }

    private static Produto buscarProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }
}
