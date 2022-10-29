package AlbunsMusicais.View;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;
import AlbunsMusicais.Model.Genero;
import service.AlbumService;
import service.IAlbumService;

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

    private int idAux = 0;
    public TelaCadastrar() {
        configTela();

        adicionarGenero();

        cbGenero.setSelectedIndex(-1);

        IAlbumService IAS = getAlbumService();

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Album album = getAlbum();

                IAS.inserirAlbum(album);

                /*if (nome.isEmpty() || data.isEmpty() || duracao.isEmpty() || faixaNome.isEmpty() || faixaDuracao.isEmpty()) {
                    JOptionPane.showMessageDialog(btnCadastrar, "Não é possivel deixar caixas em branco", "Tente novamente", JOptionPane.ERROR_MESSAGE);
                    return ;
                }else{
                    album.cadastrarAlbum(album, faixaAlbum, nome, data, duracao, genero, faixaNome, faixaDuracao);
                    JOptionPane.showMessageDialog(btnCadastrar, "Cadastro realizado com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }*/
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
                /*TelaCadastrar telaCadastrar = new TelaCadastrar();
                new TelaVisualizar().setVisible(true);

                telaCadastrar.dispose();
                setVisible(false);*/

                String resposta = "";

                for(Album albumCont : IAS.listarTodosAlbuns()){
                    System.out.println("Id: " + albumCont.getId());
                    System.out.println("nome: " + albumCont.getNome());
                    System.out.println("data: " + albumCont.getData());
                    System.out.println("duração: " + albumCont.getDuracao());
                    System.out.println("Genero: " + albumCont.getGenero().getDescricao());
                    System.out.println("nome fiaxa: " + albumCont.getNome());
                    System.out.println("duração faixa: " + albumCont.getDuracao());
                }

                //album.listarTodosAlbuns();
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

    public Album getAlbum(){
        Album album = new Album();
        Faixa faixa = new Faixa();

        String nome = txtNome.getText();
        String data = txtAno.getText();
        String duracao = txtDuracao.getText();
        Genero genero = (Genero) cbGenero.getSelectedItem();
        String faixaNome = txtNomeFaixa.getText();
        String faixaDuracao = txtDuracaoFaixa.getText();

        if (nome.isEmpty() || data.isEmpty() || duracao.isEmpty() || faixaNome.isEmpty() || faixaDuracao.isEmpty()) {
            JOptionPane.showMessageDialog(btnCadastrar, "Não é possivel deixar caixas em branco", "Tente novamente", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        else{
            album.setNome(nome);
            album.setData(data);
            album.setDuracao(duracao);
            album.setGenero(genero);
            faixa.setNome(faixaNome);
            faixa.setDuracao(faixaDuracao);

            JOptionPane.showMessageDialog(btnCadastrar, "Cadastro Realizado com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            return album;
        }
    }


    public static IAlbumService getAlbumService(){
        return new AlbumService();
    }

    public static void main(String[] args) {
        TelaCadastrar telaCadastrar = new TelaCadastrar();
    }
}
