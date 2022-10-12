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
    private JTextField txtGenero;

    Album album = new Album();
    Faixa faixaAlbum = new Faixa();

    public TelaCadastrar(){
        setContentPane(mainPanel);
        setTitle("Cadastro");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String data = txtData.getText();
                String duracao = txtDuracao.getText();
                String faixaNome = txtNomeFaixa.getText();
                String faixaDuracao = txtDuracaoFaixa.getText();

                if(nome.isEmpty() || data.isEmpty() || duracao.isEmpty() || faixaNome.isEmpty() || faixaDuracao.isEmpty()){
                    JOptionPane.showMessageDialog(btnCadastrar, "Não é possivel deixar caixas em branco", "Tente novamente", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    album.cadastrarAlbum(album, faixaAlbum, nome, data, duracao, faixaNome, faixaDuracao);
                }
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtData.setText("");
                txtDuracao.setText("");
                txtGenero.setText("");
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
    }

    public static void main(String[] args) {
        TelaCadastrar telaCadastrar = new TelaCadastrar();
    }
}
