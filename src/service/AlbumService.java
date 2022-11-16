package service;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;
import AlbunsMusicais.Model.Genero;

import java.util.ArrayList;
import java.util.List;

public class AlbumService implements IAlbumService{
    public List<Album> albuns;

    private int idAux = 0;

    public AlbumService(){
        this.albuns = new ArrayList<>();
    }

    @Override
    public void inserirAlbum(Album album){
        album.setId(idAux);
        this.albuns.add(album);
        idAux++;
    }

    @Override
    public void alterarAlbum(String nome, String data, String duracao, Genero genero, int posicao) {
        this.albuns.get(posicao).getId();
        this.albuns.get(posicao).setNome(nome);
        this.albuns.get(posicao).setData(data);
        this.albuns.get(posicao).setDuracao(duracao);
        this.albuns.get(posicao).setGenero(genero);
    }

    @Override
    public void excluirAlbum(int posicao) {
        for(int i = 0; i < albuns.size(); i++){
            this.albuns.get(posicao).setId(idAux);
        }
        --idAux;

        this.albuns.remove(posicao);
    }

    @Override
    public Album pesquisarAlbumId(int id) {
        return this.albuns.get(id);
    }

    @Override
    public List<Album> listarTodosAlbuns() {
        return this.albuns;
    }
}
