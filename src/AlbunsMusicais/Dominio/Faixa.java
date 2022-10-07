package AlbunsMusicais.Dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Faixa {

    private String nome;
    private Album album;
    private  String duracao;
    private Genero genero;

    private List<Artista> artistas = new ArrayList<Artista>();

    private List<Compositor> compositores = new ArrayList<Compositor>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
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

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public List<Compositor> getCompositores() {
        return compositores;
    }

    public void setCompositores(List<Compositor> compositores) {
        this.compositores = compositores;
    }

}
