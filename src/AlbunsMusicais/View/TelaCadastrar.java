package AlbunsMusicais.View;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;
import AlbunsMusicais.Model.Genero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaCadastrar extends JFrame {
    Mascaras mascaras = new Mascaras();
    private JTextField txtNome;
    private JFormattedTextField txtDuracao;
    {
        try {
            new JFormattedTextField(mascaras.mascaraDuracao(txtDuracao));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private JButton btnCadastrar;
    private JButton btnLimpar;
    private JPanel mainPanel;
    private JTextField txtNomeFaixa;
    private JLabel lblNome;
    private JLabel lblAno;
    private JLabel lblDuracao;
    private JLabel lblGenero;
    private JLabel lblFaixa;
    private JFormattedTextField txtDuracaoFaixa;
    {
        try {
            new JFormattedTextField(mascaras.mascaraDuracao(txtDuracaoFaixa));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    private JButton btnVisualizar;
    private JComboBox cbGenero;
    private JButton btnVoltar;
    private JFormattedTextField txtAno;
    {
        try {
            new JFormattedTextField(mascaras.mascaraData(txtAno));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    Album album = new Album();
    Faixa faixaAlbum = new Faixa();
    public TelaCadastrar() {
        configTela();

        adicionarGenero();

        cbGenero.setSelectedIndex(-1);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String data = txtAno.getText();
                String duracao = txtDuracao.getText();
                Genero genero = (Genero) cbGenero.getSelectedItem();
                String faixaNome = txtNomeFaixa.getText();
                String faixaDuracao = txtDuracaoFaixa.getText();

                if (nome.isEmpty() || data.isEmpty() || duracao.isEmpty() || faixaNome.isEmpty() || faixaDuracao.isEmpty()) {
                    JOptionPane.showMessageDialog(btnCadastrar, "Não é possivel deixar caixas em branco", "Tente novamente", JOptionPane.ERROR_MESSAGE);
                    return ;
                }else{
                    album.cadastrarAlbum(album, faixaAlbum, nome, data, duracao, genero, faixaNome, faixaDuracao);
                    JOptionPane.showMessageDialog(btnCadastrar, "Cadastro realizado com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtAno.setText("");
                txtDuracao.setText("");
                cbGenero.setSelectedIndex(-1);
                txtNomeFaixa.setText("");
                txtDuracaoFaixa.setText("");
            }
        });
        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrar telaCadastrar = new TelaCadastrar();
                new TelaVisualizar().setVisible(true);

                telaCadastrar.dispose();
                setVisible(false);

                album.visualizarAlbum(album, faixaAlbum);
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrar telaCadastrar = new TelaCadastrar();

                telaCadastrar.dispose();
                setVisible(false);
            }
        });
    }

    public void configTela() {
        setContentPane(mainPanel);
        setTitle("Cadastro");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void adicionarGenero() {
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
