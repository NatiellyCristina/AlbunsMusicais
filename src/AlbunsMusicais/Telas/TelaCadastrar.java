package AlbunsMusicais.Telas;

import AlbunsMusicais.Dominio.Album;
import AlbunsMusicais.Dominio.Faixa;
import AlbunsMusicais.Dominio.Genero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrar extends JFrame{
    private JTextField txtNome;
    private JTextField txtData;
    private JTextField txtDuracao;
    private JButton btnCadastrar;
    private JButton btnLimpar;
    private JPanel mainPanel;
    private JTextField txtNomeFaixa;
    private JLabel lblFaixa;
    private JTextField txtDuracaoFaixa;
    private JButton btnVisualizar;
    private JComboBox cbGenero;
    private JButton btnVoltar;
    private JTextField txtGenero;

    //JComboBox<Genero> combo = new JComboBox<Genero>();

    Album album = new Album();
    Faixa faixaAlbum = new Faixa();

    public TelaCadastrar(){
        configTela();

        adicionarGenero();

        cbGenero.setSelectedIndex(-1);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String data = txtData.getText();
                String duracao = txtDuracao.getText();
                Genero genero = (Genero) cbGenero.getSelectedItem();
                String faixaNome = txtNomeFaixa.getText();
                String faixaDuracao = txtDuracaoFaixa.getText();

                if(nome.isEmpty() || data.isEmpty() || duracao.isEmpty() || faixaNome.isEmpty() || faixaDuracao.isEmpty()){
                    JOptionPane.showMessageDialog(btnCadastrar, "Não é possivel deixar caixas em branco", "Tente novamente", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    album.cadastrarAlbum(album, faixaAlbum, nome, data, duracao, genero, faixaNome, faixaDuracao);
                }
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtData.setText("");
                txtDuracao.setText("");
                cbGenero.setSelectedIndex(-1);
                txtNomeFaixa.setText("");
                txtDuracaoFaixa.setText("");
            }
        });
        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                album.visualizarAlbum(album, faixaAlbum);
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    public void configTela(){
        setContentPane(mainPanel);
        setTitle("Cadastro");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void adicionarGenero(){
        Genero genero = new Genero();
        Genero genero2 = new Genero();
        Genero genero3 = new Genero();

        genero.setCodigo(1);
        genero.setDescricao("Pop");

        genero2.setCodigo(2);
        genero2.setDescricao("Rock");

        genero3.setCodigo(3);
        genero3.setDescricao("Eletronica");

        cbGenero.addItem(genero);
        cbGenero.addItem(genero2);
        cbGenero.addItem(genero3);
    }

    public static void main(String[] args) {
        TelaCadastrar telaCadastrar = new TelaCadastrar();
    }
}
