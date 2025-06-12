import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArvoreAVL avl = new ArvoreAVL();
        Map<String, Show> map = new TreeMap<>();
        List<Show> shows = lerShowsDoCSV("src/netflix_data.csv");
        PrintWriter log = new PrintWriter("log.txt");

        long inicio = System.nanoTime();
        for (Show show : shows) avl.inserir(show);
        long fim = System.nanoTime();
        long tempoInsercaoAVL = (fim - inicio) / 1_000_000;
        log.println("Tempo de inserção AVL: " + tempoInsercaoAVL + " ms");

        inicio = System.nanoTime();
        for (Show show : shows) map.put(show.getShowId(), show);
        fim = System.nanoTime();
        long tempoInsercaoTreeMap = (fim - inicio) / 1_000_000;
        log.println("Tempo de inserção TreeMap: " + tempoInsercaoTreeMap + " ms");

        Random rand = new Random();
        int n = shows.size();
        int numBuscas = 1000;
        inicio = System.nanoTime();
        for (int i = 0; i < numBuscas; i++) {
            String id = shows.get(rand.nextInt(n)).getShowId();
            avl.buscar(id);
        }
        fim = System.nanoTime();
        long tempoBuscaAVL = (fim - inicio) / 1_000_000;
        log.println("Tempo de " + numBuscas + " buscas AVL: " + tempoBuscaAVL + " ms");

        inicio = System.nanoTime();
        for (int i = 0; i < numBuscas; i++) {
            String id = shows.get(rand.nextInt(n)).getShowId();
            map.get(id);
        }
        fim = System.nanoTime();
        long tempoBuscaTreeMap = (fim - inicio) / 1_000_000;
        log.println("Tempo de " + numBuscas + " buscas TreeMap: " + tempoBuscaTreeMap + " ms");

        List<String> idsParaRemover = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            idsParaRemover.add(shows.get(rand.nextInt(n)).getShowId());
        }
        inicio = System.nanoTime();
        for (String id : idsParaRemover) {
            avl.remover(id);
        }
        fim = System.nanoTime();
        long tempoRemocaoAVL = (fim - inicio) / 1_000_000;
        log.println("Tempo de 1000 remoções AVL: " + tempoRemocaoAVL + " ms");

        inicio = System.nanoTime();
        for (String id : idsParaRemover) {
            map.remove(id);
        }
        fim = System.nanoTime();
        long tempoRemocaoTreeMap = (fim - inicio) / 1_000_000;
        log.println("Tempo de 1000 remoções TreeMap: " + tempoRemocaoTreeMap + " ms");

        log.close();
        System.out.println("Resultados gravados em log.txt");
    }

    public static List<Show> lerShowsDoCSV(String caminho) throws IOException {
        List<Show> shows = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(caminho));
        String linha = br.readLine(); // pula o cabeçalho

        while ((linha = br.readLine()) != null) {
            String[] campos = parseCSVLine(linha);
            if (campos.length < 12) continue;

            try {
                String showId = campos[0];
                String type = campos[1];
                String title = campos[2];
                String director = campos[3];
                String cast = campos[4];
                String country = campos[5];
                String dateAdded = campos[6];
                int releaseYear = Integer.parseInt(campos[7]);
                String rating = campos[8];
                String duration = campos[9];
                String listedIn = campos[10];
                String description = campos[11];

                Show show = new Show(showId, type, title, director, cast, country,
                        dateAdded, releaseYear, rating, duration, listedIn, description);
                shows.add(show);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao processar linha: " + linha);
            }
        }
        br.close();
        return shows;
    }

    public static String[] parseCSVLine(String line) {
        List<String> campos = new ArrayList<>();
        StringBuilder campo = new StringBuilder();
        boolean dentroDeAspas = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                dentroDeAspas = !dentroDeAspas;
            } else if (c == ',' && !dentroDeAspas) {
                campos.add(campo.toString().trim());
                campo = new StringBuilder();
            } else {
                campo.append(c);
            }
        }
        campos.add(campo.toString().trim());
        return campos.toArray(new String[0]);
    }
}