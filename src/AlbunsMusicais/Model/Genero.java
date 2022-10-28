package AlbunsMusicais.Model;

public class Genero {
    private  int Codigo;
    private  String Descricao;

    public int getCodigo() {
        return Codigo;
    }
    public void setCodigo(int codigo) {
        Codigo = codigo;
    }
    public String getDescricao() {

        return Descricao;
    }
    public void setDescricao(String descricao) {

        String pop = "pop";
        String rock = "rock";
        String eletronica = "eletronica";

        this.Descricao = descricao;
    }

    @Override
    public String toString(){
        return this.Descricao;
    }


}
