public class Palavra {
    private String palavra;
    private String tema;

    public Palavra(String palavra, String tema) {
        this.palavra = palavra.toLowerCase();
        this.tema = tema.toLowerCase();
    }

    public String getPalavra() {
        return palavra;
    }

    public String getTema() {
        return tema;
    }

    @Override
    public String toString() {
        String informacoes = String.format("Palavra: %s, Tema: %s", palavra, tema);
        return informacoes;
    }
}