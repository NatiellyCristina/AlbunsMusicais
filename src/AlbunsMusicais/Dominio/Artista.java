package AlbunsMusicais.Dominio;

import java.util.ArrayList;
import java.util.List;

public class Artista extends Pessoa {

    private  int codigo;
    private List<Genero> generos = new ArrayList<>();


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}
