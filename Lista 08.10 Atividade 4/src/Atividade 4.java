
class Atividade4 {
    public static void main(String[] args) {

        double soma = 0;
        int numerador = 1000;
        int sinal = 1;

        for (int denominador = 1; denominador <= 50; denominador++) {
            soma += sinal * (double) numerador / denominador;
            numerador -= 3;
            sinal *= -1;
        }

        System.out.println("A soma dos 50 primeiros termos da série é: " + soma);
    }
}