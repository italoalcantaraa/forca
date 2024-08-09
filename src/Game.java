
import java.util.List;
import java.util.Random;

public class Game {
    private int chancesRestantes;
    private boolean venceu;

    public Game() {
        chancesRestantes = 6;
        venceu = false;
    }

    // Sorteia uma palavra de acordo com o tamanho da lista de palavras
    public String[] sortearPalavra(List<Palavra> palavras) {
        Random gerar = new Random();
        int num = Math.abs(gerar.nextInt() % palavras.size());

        String palavra = palavras.get(num).getPalavra();
        String tema = palavras.get(num).getTema();

        String[] palavraTema = { palavra, tema };
        return palavraTema;
    };

    // Exibe a palavra a ser descoberta
    // palavraSorteada[0]: é correspondente a palavra sorteada
    // palavraSorteada[1]: é correspondente ao tema
    public char[] exibirPalavraAnonima(String[] palavra) {
        char[] palavraAnonima = new char[palavra[0].length()];

        for (int i = 0; i < palavra[0].length(); i++) {
            palavraAnonima[i] = '_';
        }

        System.out.println("Tema: " + palavra[1]);
        System.out.println();
        System.out.println(palavraAnonima);
        System.out.println();
        return palavraAnonima;
    }

    public char[] verificaLetraJogada(char letra, String palavra, char[] palavraAnomima) {
        char novapalavra[] = new char[palavra.length()];
        boolean contemPalavra = false;

        // Guarda os caracteres da palavra dentro de uma variável novaPalavra
        for (int i = 0; i < palavra.length(); i++) {
            novapalavra[i] = palavra.charAt(i);
        }

        for (int i = 0; i < novapalavra.length; i++) {
            if (letra == novapalavra[i]) {
                palavraAnomima[i] = letra;
                contemPalavra = true;
            }
            verificaVencedor(palavraAnomima);
        }

        if (!contemPalavra)
            chancesRestantes--;

        return palavraAnomima;
    }

    public void verificaVencedor(char[] palavra) {
        for (int i = 0; i < palavra.length; i++) {
            if (palavra[i] == '_')
                return;
        }

        venceu = true;
    }

    public int getChancesRestantes() {
        return chancesRestantes;
    }

    public boolean getVenceu() {
        return venceu;
    }
}
