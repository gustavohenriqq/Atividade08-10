public class Produto {
    private int codigo;
    private String nome;
    private double valorUnitario;
    private String unidade;

    public Produto(int codigo, String nome, double valorUnitario, String unidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.unidade = unidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Valor: R$ " + valorUnitario + ", Unidade: " + unidade;
    }
}