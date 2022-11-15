package AlbunsMusicais.View;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;
import AlbunsMusicais.Model.Genero;
import service.AlbumService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.GenericArrayType;

public class TelaVisualizar extends JFrame{
    AlbumService albumService = new AlbumService();

    Album album = new Album();
    private JPanel mainPanel;
    private JButton btnVoltar;
    JList<Album> listaAlbuns = new JList<>();
    DefaultListModel<Album> model = new DefaultListModel<>();
    private JTextField txtNome;
    private JTextField txtDtLancamento;
    private JTextField txtDuracao;
    private JTextField txtNmFaixa;
    private JTextField txtDrFaixa;
    public TelaVisualizar(){
        configurarTela();

        add(BorderLayout.CENTER, listaAlbuns);

        listaAlbuns.setModel(model);

        /*txtNome.setText(album.getNome());
        txtDtLancamento.setText(album.getData());
        txtDuracao.setText(album.getDuracao());
        //txtGenero.setText((Genero) album.getGenero());
        txtNmFaixa.setText(faixaAlbum.getNome());
        txtDrFaixa.setText(faixaAlbum.getDuracao());*/
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
