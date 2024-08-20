import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        
        Game game = new Game();
 
        ListPalavras listPalavras = new ListPalavras();
        
        listPalavras.adicionarPalavras("Banana", "Fruta");
        listPalavras.adicionarPalavras("Maca", "Fruta");
        listPalavras.adicionarPalavras("Carro", "Veículo");
        listPalavras.adicionarPalavras("Alegria", "Sentimento");
        listPalavras.adicionarPalavras("Moto", "Veículo");
        listPalavras.adicionarPalavras("Rust", "Linguagem de programação");
        listPalavras.adicionarPalavras("JavaScript", "Linguagem de programação");
        listPalavras.adicionarPalavras("Java", "Linguagem de programação");
        listPalavras.adicionarPalavras("C++", "Linguagem de programação");
        listPalavras.adicionarPalavras("Python", "Linguagem de programação");

        // obtem a palavra sorteada
        String[] palavraSorteada = game.sortearPalavra(listPalavras.retornarPalavras());
        // palavraSorteada[0]: é correspondente a palavra sorteada
        // palavraSorteada[1]: é correspondente ao tema

        // Exibe 
        
        // obtem a palavra preenchida com '_'
        char[] palavraAnomina = game.exibirPalavraAnonima(palavraSorteada);

        String resultado;

        while (game.getChancesRestantes() > 0 && game.getVenceu() == false) {
            System.out.printf("Letra: ");
            char letra = ler.next().charAt(0);

            System.out.println("\n* * * * * * * * * * * * *");
            System.out.print(game.verificaLetraJogada(letra, palavraSorteada[0], palavraAnomina));
            System.out.println("    Chances: " + game.getChancesRestantes());
            System.out.println("* * * * * * * * * * * * *");
            
            if(game.getChancesRestantes() == 0 || game.getVenceu() == true) {
                resultado = game.getChancesRestantes()== 0 ? "\nVocê perdeu! ¨_¨" : "\nVocê ganhou! *_*";
                System.out.println(resultado);
            }
        }

        ler.close();

    }
}
