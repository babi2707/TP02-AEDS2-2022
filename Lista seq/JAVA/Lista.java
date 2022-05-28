
/****************************************
 * 
 * @author Barbara Luciano Araujo
 * Matricula: 748190
 * TP02 - Questão 5 - Lista Sequencial em Java
 * 
****************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

class List {

    // ---------- atributos ----------

    private Filme[] filme;
    private int n;

    // -------------------------------

    // ---------- construtores ----------

    public List() {
        this(6);
    }

    public List(int tamanho) {
        filme = new Filme[tamanho];
        n = 0;
    }

    // ----------------------------------

    // ---------- inserir na primeira posição ----------

    public void insertInicio(Filme x) throws Exception {

        // ----- validar inserção -----

        if (n >= filme.length) {
            throw new Exception("Erro ao inserir");
        }

        // ----------------------------

        // ----- levar elementos para o final -----

        for (int i = n; i > 0; i--) {
            filme[i] = filme[i - 1];
        }

        // ----------------------------------------

        filme[0] = x;
        n++;

    }

    // -------------------------------------------------

    // ---------- inserir na última posição ----------

    public void insertFim(Filme x) throws Exception {

        // ----- validar inserção -----

        if (n >= filme.length) {
            throw new Exception("Erro ao inserir");
        }

        // ----------------------------

        filme[n] = x;
        n++;

    }

    // -------------------------------------------------

    // ---------- inserir em determinada posição ----------

    public void insertPos(Filme x, int pos) throws Exception {

        // ----- validar inserção -----

        if (n >= filme.length || pos < 0 || pos > n) {
            throw new Exception("Erro ao inserir");
        }

        // ----------------------------

        // ----- levar elementos para o final -----

        for (int i = n; i > pos; i--) {
            filme[i] = filme[i - 1];
        }

        // ----------------------------------------

        filme[pos] = x;
        n++;

    }

    // -------------------------------------------------

    // ---------- remover na primeira posição ----------

    public Filme removeInicio() throws Exception {

        // ----- validar remoção -----

        if (n == 0) {
            throw new Exception("Erro ao remover");
        }

        // ----------------------------

        Filme resp = filme[0];
        n--;

        // ----- levar elementos para o início -----

        for (int i = 0; i < n; i++) {
            filme[i] = filme[i + 1];
        }

        // ----------------------------------------

        return resp;

    }

    // -------------------------------------------------

    // ---------- remover na última posição ----------

    public Filme removeFim() throws Exception {

        // ----- validar remoção -----

        if (n == 0) {
            throw new Exception("Erro ao remover");
        }

        // ----------------------------

        Filme resp = filme[--n];

        return resp;

    }

    // -------------------------------------------------

    // ---------- remover em determinada posição ----------

    public Filme removePos(int pos) throws Exception {

        // ----- validar remoção -----

        if (n == 0 || pos < 0 || pos >= n) {
            throw new Exception("Erro ao remover");
        }

        // ----------------------------

        Filme resp = filme[pos];
        n--;

        // ----- levar elementos para o início -----

        for (int i = pos; i < n; i++) {
            filme[i] = filme[i + 1];
        }

        // ----------------------------------------

        return resp;

    }

    // -------------------------------------------------

    // ---------- mostrar elementos ----------

    public void show() {

        for (int i = 0; i < n; i++) {
            MyIO.print("[" + i + "]" + " ");
            filme[i].print();
        }
    }

    // ---------------------------------------

}

class Filme {

    // ------------------------- atributos -------------------------

    private String Nome;
    private String Titulo_Original;
    private Date Data_de_Lancamento;
    private int Duracao;
    private String Genero;
    private String Idioma_Original;
    private String Situacao;
    private float Orcamento;
    private ArrayList<String> Key_Words;

    // ------------------------------------------------------------

    // ----------------------- construtores -----------------------

    public Filme() {

        Nome = "";
        // Titulo_Original = "";
        // Duracao = 0;
        // Genero = "";
        // Idioma_Original = "";
        // Situacao = "";
        // Orcamento = 0;
        // Key_Words = new ArrayList<String>();

    }

    public Filme(String Nome, String Titulo_Original, Date Data_de_Lancamento, int Duracao, String Genero,
            String Idioma_Original, String Situacao, Float Orcamento, ArrayList<String> Key_Words) {

        setNome(Nome);
        // setTitulo_Original(Titulo_Original);
        // setData_de_Lancamento(Data_de_Lancamento);
        // setDuracao(Duracao);
        // setGenero(Genero);
        // setIdioma_Original(Idioma_Original);
        // setSituacao(Situacao);
        // setOrcamento(Orcamento);
        // setKey_Words(Key_Words);

    }

    // ------------------------------------------------------------

    // ------------------------- gets/sets ------------------------

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTitulo_Original() {
        return Titulo_Original;
    }

    public void setTitulo_Original(String Titulo_Original) {
        this.Titulo_Original = Titulo_Original;
    }

    public Date getData_de_Lancamento() {
        return Data_de_Lancamento;
    }

    public void setData_de_Lancamento(Date Data_de_Lancamento) {
        this.Data_de_Lancamento = Data_de_Lancamento;
    }

    public int getDuracao() {
        return Duracao;
    }

    public void setDuracao(int Duracao) {
        this.Duracao = Duracao;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getIdioma_Original() {
        return Idioma_Original;
    }

    public void setIdioma_Original(String Idioma_Original) {
        this.Idioma_Original = Idioma_Original;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public float getOrcamento() {
        return Orcamento;
    }

    public void setOrcamento(float Orcamento) {
        this.Orcamento = Orcamento;
    }

    public ArrayList<String> getKey_Words() {
        return Key_Words;
    }

    public void setKey_Words(ArrayList<String> Key_Words) {
        this.Key_Words = Key_Words;
    }

    // ------------------------------------------------------------

    // ------------------------ remover tags ----------------------

    public String removeTags(String linha) {

        String resp = "";

        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == '<') {
                while (linha.charAt(i) != '>')
                    i++;
            } else {
                resp += linha.charAt(i);
            }
        }

        return resp;
    }

    // ------------------------------------------------------------

    // ------------------------ remover parenteses ----------------------

    public static String removeBrackets(String s) {

        String resp = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                while (s.charAt(i) != ')')
                    i++;
            } else {
                resp += s.charAt(i);
            }
        }

        return resp;
    }

    // ------------------------------------------------------------

    // -------------------------- imprimir ------------------------

    public void print() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        MyIO.println(getNome() + getTitulo_Original() + " " + sdf.format(getData_de_Lancamento()) + " "
                + getDuracao() + " " + getGenero() + " " + getIdioma_Original() + " " + getSituacao() + " "
                + getOrcamento() + " " + getKey_Words());

    }

    // ------------------------------------------------------------

    // -------------------------- leitura ------------------------

    // ----- Nome -----
    public void readNome(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        try {
            String linha = readArq.readLine();

            while (!linha.contains("h2 class")) {
                linha = readArq.readLine();
            }

            linha = readArq.readLine().trim();
            setNome(removeTags(linha));

        } catch (IOException except) {
            except.printStackTrace();
        }

        arq.close();

    }

    // ----------------

    // ----- Titulo original -----
    public void readTitulo(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        String linha = readArq.readLine();

        try {

            while (!linha.contains("Título original")) {

                linha = readArq.readLine();
            }

            this.setTitulo_Original(removeTags(linha.replace("Título original", "").trim()));

        } catch (NullPointerException npe) {
            this.setTitulo_Original(" " + getNome());
        }

        arq.close();

    }

    // ---------------------------

    // ----- Data -----
    public void readData(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        String linha = readArq.readLine();

        try {
            while (!linha.contains("class=\"release\"")) {
                linha = readArq.readLine();
            }

            linha = readArq.readLine().trim();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            try {
                Date date = format.parse(removeTags(removeBrackets(linha)));
                this.setData_de_Lancamento(date);
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }

        } catch (IOException except) {
            except.printStackTrace();
        }

        arq.close();

    }

    // ----------------

    // ----- Duração -----
    public void readDuracao(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        String linha = readArq.readLine();

        try {

            int hrs = 0, min = 0;

            while (!linha.contains("runtime")) {
                linha = readArq.readLine();
            }

            linha = readArq.readLine();
            linha = readArq.readLine().replace(" ", "").trim();

            if (linha.contains("h")) {
                hrs = Integer.parseInt(linha.substring(0, linha.indexOf("h")));
                min = Integer.parseInt(linha.substring((linha.indexOf("h") + 1), (linha.indexOf("m"))));
            } else {
                min = Integer.parseInt(linha.replace(" ", "").substring(0, linha.indexOf("m")).trim());
            }

            int Duration = min + (hrs * 60);

            this.setDuracao(Duration);

        } catch (StringIndexOutOfBoundsException except) {
            this.setDuracao(2);
        }

        arq.close();

    }
    // -------------------

    // ----- Genero -----
    public void readGenero(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        String linha = readArq.readLine();

        try {
            while (!linha.contains("genres")) {
                linha = readArq.readLine();
            }

            linha = readArq.readLine().trim();
            linha = readArq.readLine().trim();

            this.setGenero(removeTags(linha).replace("&nbsp;", ""));

        } catch (IOException except) {
            except.printStackTrace();
        }

        arq.close();
    }

    // ------------------

    // ----- Idioma original -----
    public void readIdioma(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        String linha = readArq.readLine();

        try {
            while (!linha.contains("Idioma original")) {
                linha = readArq.readLine();
            }

            this.setIdioma_Original(removeTags(linha).trim().replace("Idioma original ", ""));

        } catch (IOException except) {
            except.printStackTrace();
        }

        arq.close();

    }

    // ---------------------------

    // ----- Situação -----
    public void readSituacao(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        String linha = readArq.readLine();

        try {
            while (!linha.contains("<bdi>Situação")) {
                linha = readArq.readLine();
            }

            this.setSituacao(removeTags(linha).trim().replace("Situação ", ""));
        } catch (IOException except) {
            except.printStackTrace();
        }

        arq.close();
    }

    // ---------------------------

    // ----- Orçamento -----
    public void readOrcamento(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        String linha = readArq.readLine();

        while (!linha.contains("<p><strong><bdi>Orçamento")) {
            linha = readArq.readLine();
        }

        linha = linha.trim();
        linha = removeTags(linha);
        linha = linha.replace("Orçamento", "");
        linha = linha.substring(1);
        linha = linha.replace("$", "");

        if (linha.length() == 1) {
            linha = "0";
        } else {
            linha = linha.replace(",", "");
        }

        float budget = Float.parseFloat(linha);
        this.setOrcamento(budget);

        arq.close();

    }

    // -------------------

    // ----- Palavras-chave -----
    public void readKey(String arquivo) throws Exception {

        String folder = "./tmp/filmes/";
        FileReader arq = new FileReader(folder + arquivo);
        BufferedReader readArq = new BufferedReader(arq);

        this.Key_Words = new ArrayList<String>();

        String linha = readArq.readLine();

        try {
            while (!linha.contains("Palavras-chave")) {
                linha = readArq.readLine();
            }

            linha = readArq.readLine();

            while (!linha.contains("</ul>")) {
                if (linha.contains("/keyword/")) {
                    linha = removeTags(linha);
                    this.Key_Words.add(removeTags(linha).trim());
                }

                linha = readArq.readLine();

            }

        } catch (IOException except) {
            except.printStackTrace();
        }

        arq.close();

    }

    // ---------------------------

    // ------------------------------------------------------------
}

public class Lista {

    // --------------------------- is FIM -------------------------

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' &&
                s.charAt(2) == 'M');
    }

    // ------------------------------------------------------------

    public static void main(String args[]) throws Exception {

        MyIO.setCharset("UTF-8");

        // ----- inicialização das variáveis -----
        String[] s = new String[10000];
        String[] s2 = new String[10000];
        int qtd = 0, qtd2 = 0, n;
        // ----------------------------------------

        // ---------- repetição do while para ler todas as linhas da entrada até chegar
        // na palavra FIM ----------

        do {
            s[qtd] = MyIO.readLine();
        } while (isFim(s[qtd++]) == false);

        // ------------------------------------------------------------------------------------------------------

        qtd--; // diminuir a quantidade de elementos da string em cada linha lida

        Filme entradas[] = new Filme[qtd]; // criar um vetor da classe
        List movie = new List(10000); // criar uma lista da classe List

        // ---------------- for loop para chamar a função que lê o arquivo
        // -----------------
        for (int i = 0; i < qtd; i++) {
            entradas[i] = new Filme();
            entradas[i].readNome(s[i]);
            entradas[i].readTitulo(s[i]);
            entradas[i].readData(s[i]);
            entradas[i].readDuracao(s[i]);
            entradas[i].readGenero(s[i]);
            entradas[i].readIdioma(s[i]);
            entradas[i].readSituacao(s[i]);
            entradas[i].readOrcamento(s[i]);
            entradas[i].readKey(s[i]);

            movie.insertFim(entradas[i]); // inserir a entrada no final da lista
        }
        // ---------------------------------------------------------------------------------

        qtd2 = qtd + 2; // contador para pegar a segunda parte do arquivo

        s2[qtd2] = MyIO.readLine(); // ler a primeira linha da segunda parte
        n = Integer.parseInt(s2[qtd2]); // primeira linha é a qtd de objetos a serem inseridos/removidos

        // ---------------- for loop para ler as linhas do arquivo ----------------
        for (int i = 0; i < n; i++) {

            s2[i] = MyIO.readLine();
        }

        // ------------------------------------------------------------------------

        // ---------------- for loop para fazer as inserções e remoções
        // -----------------
        for (int i = 0; i < n; i++) {

            String linha = s2[i].substring(0, 2);
            String x[] = new String[10000];
            int pos = 0;

            // ----- inserir em determinada posição -----
            if (linha.compareTo("I*") == 0) {

                pos = Integer.parseInt(s2[i].substring(3, 5)); // guarda o valor da posição de inserção
                x[i] = s2[i].substring(6); // guarda a string a ser inserida
            }
            // ------------------------------------------

            // ----- remover em determinada posição -----
            else if (linha.compareTo("R*") == 0) {

                pos = Integer.parseInt(s2[i].substring(3)); // guarda o valor da posição de remoção
            }
            // ------------------------------------------

            // ----- inserir -----
            else if (linha.compareTo("II") == 0 || linha.compareTo("IF") == 0) {

                x[i] = s2[i].substring(3); // guarda a string a ser inserida
            }
            // --------------------

            // ----- inserir inicio -----

            if (linha.compareTo("II") == 0) {

                Filme filminho = new Filme(); // criar lista de filmes

                // ----- ler o arquivo -----
                filminho.readNome(x[i]);
                filminho.readTitulo(x[i]);
                filminho.readData(x[i]);
                filminho.readDuracao(x[i]);
                filminho.readGenero(x[i]);
                filminho.readIdioma(x[i]);
                filminho.readSituacao(x[i]);
                filminho.readOrcamento(x[i]);
                filminho.readKey(x[i]);
                // -------------------------

                // ----- inserir -----
                movie.insertInicio(filminho);
                // -------------------

            }

            // --------------------------

            // ----- inserir final -----

            else if (linha.compareTo("IF") == 0) {

                Filme filminho = new Filme(); // criar lista de filmes

                // ----- ler o arquivo -----
                filminho.readNome(x[i]);
                filminho.readTitulo(x[i]);
                filminho.readData(x[i]);
                filminho.readDuracao(x[i]);
                filminho.readGenero(x[i]);
                filminho.readIdioma(x[i]);
                filminho.readSituacao(x[i]);
                filminho.readOrcamento(x[i]);
                filminho.readKey(x[i]);
                // -------------------------

                // ----- inserir -----
                movie.insertFim(filminho);
                // -------------------

            }

            // --------------------------

            // ----- inserir em determinada posição -----

            else if (linha.compareTo("I*") == 0) {

                Filme filminho = new Filme(); // criar lista de filmes

                // ----- ler o arquivo -----
                filminho.readNome(x[i]);
                filminho.readTitulo(x[i]);
                filminho.readData(x[i]);
                filminho.readDuracao(x[i]);
                filminho.readGenero(x[i]);
                filminho.readIdioma(x[i]);
                filminho.readSituacao(x[i]);
                filminho.readOrcamento(x[i]);
                filminho.readKey(x[i]);
                // -------------------------

                // ----- inserir -----
                movie.insertPos(filminho, pos);
                // -------------------

            }

            // --------------------------

            // ----- remover inicio -----

            else if (linha.compareTo("RI") == 0) {

                MyIO.println("(R) " + movie.removeInicio().getNome());

            }

            // --------------------------

            // ----- remover final -----

            else if (linha.compareTo("RF") == 0) {

                MyIO.println("(R) " + movie.removeFim().getNome());

            }

            // --------------------------

            // ----- remover em determinada posição -----

            else if (linha.compareTo("R*") == 0) {

                MyIO.println("(R) " + movie.removePos(pos).getNome());

            }

            // ------------------------------------------

        }

        // -----------------------------------------------------------------------------

        movie.show();

    }
}