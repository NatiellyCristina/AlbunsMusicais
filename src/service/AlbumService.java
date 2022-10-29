package service;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;

import java.util.ArrayList;
import java.util.List;

public class AlbumService implements IAlbumService{
    private List<Album> albuns;

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
    public void alterarAlbum(Album album) {

    }

    @Override
    public void excluirAlbum(Album album) {

    }

    @Override
    public void pesquisarAlbumId(int id) {

    }

    @Override
    public List<Album> listarTodosAlbuns() {
        return this.albuns;
    }
}
