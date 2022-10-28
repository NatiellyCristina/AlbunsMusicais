package AlbunsMusicais.Model;

import java.util.ArrayList;
import java.util.List;

public class Compositor extends  Pessoa{

    private  int codigo;
    private List<Genero> generos = new ArrayList<Genero>();
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
