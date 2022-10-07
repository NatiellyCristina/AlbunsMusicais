package AlbunsMusicais.Dominio;

import java.util.*;

public class Album {

    private String nome;
    private Date data;
    private String duracao;
    private Genero genero;
    private Gravadora gravadora;
    private List<Faixa> faixas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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


    public void adicionarFaixas(Faixa faixa){
        this.faixas.add(faixa);
    }
    public List<Faixa> retornaFaixasAlbum(){
        //Alterar para que retorne apenas as faixas dos albuns passado como parametro
        faixas.stream().count();
        return this.faixas;
    }


}
