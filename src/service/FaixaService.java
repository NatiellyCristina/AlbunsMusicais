package service;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;

import java.util.ArrayList;
import java.util.List;

public class FaixaService implements IFaixaService{
    private List<Faixa> faixas;

    public FaixaService(){
        this.faixas = new ArrayList<>();
    }

    @Override
    public void inserirFaixa(Faixa faixa) {
        this.faixas.add(faixa);
    }

    @Override
    public List<Faixa> listarTodasFaixas() {
        return this.faixas;
    }
}
