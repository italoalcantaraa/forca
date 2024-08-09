import java.util.ArrayList;
import java.util.List;

public class ListPalavras {

    private List<Palavra> palavrasList;

    public ListPalavras() {
        palavrasList = new ArrayList<>();
    }

    // Adicionar palavras
    public void adicionarPalavras(String palavra, String tema) {
        palavrasList.add(new Palavra(palavra, tema));

        Game games = new Game();
        games.sortearPalavra(palavrasList);
    }

    // Consulta de palavras
    public void consultarPalavras(String palavra) {
        if (palavrasList.isEmpty())
            return;

        palavrasList.stream()
                .filter(p -> palavra == p.getPalavra())
                .forEach(System.out::print);
    }

    // Exbibe todas as palavras
    public List<Palavra> retornarPalavras() {
        return palavrasList;
    }

    // Remover palavra
    public void removerPalavra(String palavra) {
        if (palavrasList.isEmpty())
            return;

        palavrasList.removeAll(
                palavrasList.stream()
                        .filter(p -> palavra == p.getPalavra())
                        .toList());
    }
}
