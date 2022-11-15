package service;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;

import java.util.List;

public interface IFaixaService {

    public void inserirFaixa(Faixa faixa);
    public List<Faixa> listarTodasFaixas();
}
