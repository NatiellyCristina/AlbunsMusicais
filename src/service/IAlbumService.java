package service;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;

import java.util.List;

public interface IAlbumService {
    public void inserirAlbum(Album album);

    public void alterarAlbum(Album album);

    public void excluirAlbum(int album);

    public void pesquisarAlbumId(int id);

    public List<Album> listarTodosAlbuns();
}
