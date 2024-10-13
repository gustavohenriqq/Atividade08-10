public class Medico {
    private int registroCRM;
    private String nome;
    private String especialidade;

    public Medico(int registroCRM, String nome, String especialidade) {
        this.registroCRM = registroCRM;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getRegistroCRM() {
        return registroCRM;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return "CRM: " + registroCRM + ", Nome: " + nome + ", Especialidade: " + especialidade;
    }
}

