package AlbunsMusicais.Model;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Album {
    private int id;
    private String nome;
    private String data;
    private String duracao;
    private Genero genero;
    private Gravadora gravadora;
    private List<Faixa> faixas = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }
    public List<Faixa> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<Faixa> faixas) {
        this.faixas = faixas;
    }

   /* public Album cadastrarAlbum(Album album, Faixa faixaAlbum, String nome, String data, String duracao, Genero genero, String faixaNome, String faixaDuracao){
        album.setNome(nome);
        album.setData(data);
        album.setDuracao(duracao);
        album.setGenero(genero);
        faixaAlbum.setNome(faixaNome);
        faixaAlbum.setDuracao(faixaDuracao);

        System.out.println("Cadastro Realizado!!");

        this.albuns.add(album);

        return album;
    }*/
    public void adicionarFaixas(Faixa faixa){
        this.faixas.add(faixa);
    }
    public List<Faixa> retornaFaixasAlbum(){
        //Alterar para que retorne apenas as faixas dos albuns passado como parametro
        return this.faixas;
    }

    public static Album visualizarAlbum(Album album, Faixa faixaAlbum){

        System.out.println("Id: " + album.getId());
        System.out.println("nome: " + album.getNome());
        System.out.println("data: " + album.getData());
        System.out.println("duração: " + album.getDuracao());
        System.out.println("Genero: " + album.getGenero().getDescricao());
        System.out.println("nome fiaxa: " + faixaAlbum.getNome());
        System.out.println("duração faixa: " + faixaAlbum.getDuracao());

        //Retorna as faixas do album
        /*List<Faixa> faixasThriller = album.retornaFaixasAlbum();
        System.out.println("Faixas:");
        for(Faixa faixa :  faixasThriller) {
            System.out.println("Musica:" + faixa.getNome());
        }*/
        return album;
    }

    /*public List<Album> listarTodosAlbuns(){
        //for(Album cont : )
        return this.albuns;
    }*/

    @Override
    public String toString() {
        return "Album{" +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", duracao='" + duracao + '\'' +
                ", genero=" + genero +
                ", gravadora=" + gravadora +
                ", faixas=" + faixas +
                '}';
    }
}
