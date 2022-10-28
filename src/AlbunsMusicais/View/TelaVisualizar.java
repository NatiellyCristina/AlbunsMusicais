package AlbunsMusicais.View;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;
import AlbunsMusicais.Model.Genero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVisualizar extends JFrame{
    private JPanel mainPanel;
    private JButton btnVoltar;
    private JTextField txtNome;
    private JTextField txtDtLancamento;
    private JTextField txtDuracao;
    private JTextField txtGenero;
    private JTextField txtNmFaixa;
    private JTextField txtDrFaixa;

    Album album = new Album();

    Faixa faixaAlbum= new Faixa();

    public TelaVisualizar(){
        configurarTela();

        txtNome.setText(album.getNome());
        txtDtLancamento.setText(album.getData());
        txtDuracao.setText(album.getDuracao());
        //txtGenero.setText((Genero) album.getGenero());
        txtNmFaixa.setText(faixaAlbum.getNome());
        txtDrFaixa.setText(faixaAlbum.getDuracao());
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaVisualizar telaVisualizar = new TelaVisualizar();

                telaVisualizar.dispose();
                setVisible(false);
            }
        });
    }
    public void configurarTela(){
        setContentPane(mainPanel);
        setTitle("Visualizar");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        TelaVisualizar telaVisualizar = new TelaVisualizar();
    }
}
