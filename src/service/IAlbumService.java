package service;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;
import AlbunsMusicais.Model.Genero;

import java.util.List;

public interface IAlbumService {
    public void inserirAlbum(Album album);

    public void alterarAlbum(String nome, String data, String duracao, Genero genero, int posicao);

    public void excluirAlbum(int posicao);

    public Album pesquisarAlbumId(int id);

    public List<Album> listarTodosAlbuns();
}
