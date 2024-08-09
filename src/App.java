import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        ListPalavras listPalavras = new ListPalavras();
        listPalavras.adicionarPalavras("Banana", "Fruta");
        listPalavras.adicionarPalavras("Maca", "Fruta");
        listPalavras.adicionarPalavras("Carro", "Veículo");
        listPalavras.adicionarPalavras("Alegria", "Sentimento");

        Game game = new Game();

        // obtem a palavra sorteada
        String[] palavraSorteada = game.sortearPalavra(listPalavras.retornarPalavras());
        // palavraSorteada[0]: é correspondente a palavra sorteada
        // palavraSorteada[1]: é correspondente ao tema

        // obtem a palavra preenchida com '_'
        char[] palavraAnomina = game.exibirPalavraAnonima(palavraSorteada);

        String resultado;

        while (Game.chancesRestantes > 0 && Game.venceu == false) {
            char letra = ler.next().charAt(0);
            System.out.println();
            System.out.println(game.verificaLetraJogada(letra, palavraSorteada[0], palavraAnomina));
            System.out.println(Game.getChancesRestantes());
            
            if(Game.chancesRestantes == 0 || Game.venceu == true) {
                resultado = Game.chancesRestantes == 0 ? "Você perdeu!" : "Você ganhou!";
                System.out.println(resultado);
            }
        }

    }
}
