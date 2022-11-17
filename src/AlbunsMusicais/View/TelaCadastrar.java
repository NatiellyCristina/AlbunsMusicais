package AlbunsMusicais.View;

import AlbunsMusicais.Model.Album;
import AlbunsMusicais.Model.Faixa;
import AlbunsMusicais.Model.Genero;
import service.AlbumService;
import service.FaixaService;
import service.IAlbumService;
import service.IFaixaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Iterator;

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
    private JLabel lblNome;
    private JLabel lblAno;
    private JLabel lblDuracao;
    private JLabel lblGenero;
    private JButton btnVisualizar;
    private JComboBox cbGenero;
    private JFormattedTextField txtAno;
    {
        try {
            new JFormattedTextField(mascaras.mascaraData(txtAno));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private JTable tblAlbuns;
    private JButton btnExcluir;
    private JButton btnAtualizar;
    private JLabel lblId;
    private JTextField txtPesquisarId;
    private JButton btnPesquisar;
    private JLabel lblContAlbuns;
    private JCheckBox chbHabilitar;

    IAlbumService IAS = getAlbumService();

    public TelaCadastrar() {
        configTela();

        criarTabela();


        adicionarGenero();

        cbGenero.setSelectedIndex(-1);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Album album = getAlbum();

                IAS.inserirAlbum(album);

                txtNome.setText("");
                txtAno.setText("");
                txtDuracao.setText("");
                cbGenero.setSelectedIndex(-1);
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtAno.setText("");
                txtDuracao.setText("");
                cbGenero.setSelectedIndex(-1);
            }
        });

        btnVisualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel) tblAlbuns.getModel();
                modelo.setNumRows(0);

                for(Album albumCont : IAS.listarTodosAlbuns()){
                    modelo.addRow(new Object[]{
                            albumCont.getId(), albumCont.getNome(), albumCont.getData(), albumCont.getDuracao(), albumCont.getGenero()
                    });
                }

                lblContAlbuns.setText(String.valueOf(tblAlbuns.getRowCount()));
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int posicao = tblAlbuns.getSelectedRow();

                int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o Album?");

                if(opcao == JOptionPane.YES_OPTION){
                    IAS.excluirAlbum(posicao);
                }

                DefaultTableModel modelo = (DefaultTableModel) tblAlbuns.getModel();
                modelo.setNumRows(0);

                for(Album albumCont : IAS.listarTodosAlbuns()){
                    modelo.addRow(new Object[]{
                            albumCont.getId(), albumCont.getNome(), albumCont.getData(), albumCont.getDuracao(), albumCont.getGenero()
                    });
                }

                lblContAlbuns.setText(String.valueOf(tblAlbuns.getRowCount()));
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int posicao = tblAlbuns.getSelectedRow();

                DefaultTableModel modelo = (DefaultTableModel) tblAlbuns.getModel();
                modelo.setNumRows(0);

                String nome = txtNome.getText();
                String data = txtAno.getText();
                String duracao = txtDuracao.getText();
                Genero genero = (Genero) cbGenero.getSelectedItem();

                int opcao = JOptionPane.showConfirmDialog(null, "Deseja mesmo Alterar?");

                if(opcao == JOptionPane.YES_OPTION){
                    IAS.alterarAlbum(nome, data, duracao, genero, posicao);
                }

                for(Album albumCont : IAS.listarTodosAlbuns()){
                    modelo.addRow(new Object[]{
                            albumCont.getId(), albumCont.getNome(), albumCont.getData(), albumCont.getDuracao(), albumCont.getGenero()
                    });
                }
            }
        });

        tblAlbuns.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                preencherCampos();
            }
        });
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtPesquisarId.getText());

                DefaultTableModel modelo = (DefaultTableModel) tblAlbuns.getModel();
                modelo.setNumRows(0);

                Album albumCont = IAS.pesquisarAlbumId(id);
                modelo.addRow(new Object[]{
                        albumCont.getId(), albumCont.getNome(), albumCont.getData(), albumCont.getDuracao(), albumCont.getGenero()
                });
            }
        });
        chbHabilitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chbHabilitar.isSelected()){
                    txtPesquisarId.setEnabled(true);
                    btnPesquisar.setEnabled(true);
                }
                else {
                    txtPesquisarId.setEnabled(false);
                    btnPesquisar.setEnabled(false);
                }
            }
        });
    }



    private void preencherCampos(){
        int posicao = tblAlbuns.getSelectedRow();

        txtNome.setText(tblAlbuns.getModel().getValueAt(posicao, 1).toString());
        txtAno.setText(tblAlbuns.getModel().getValueAt(posicao, 2).toString());
        txtDuracao.setText(tblAlbuns.getModel().getValueAt(posicao, 3).toString());
    }

    public Album getAlbum(){

        Album album = new Album();

        String nome = txtNome.getText();
        String data = txtAno.getText();
        String duracao = txtDuracao.getText();
        Genero genero = (Genero) cbGenero.getSelectedItem();

        if (nome.isEmpty() || data.isEmpty() || duracao.isEmpty()) {
            JOptionPane.showMessageDialog(btnCadastrar, "Não é possivel deixar caixas em branco", "Tente novamente", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        else{
            album.setNome(nome);
            album.setData(data);
            album.setDuracao(duracao);
            album.setGenero(genero);

            JOptionPane.showMessageDialog(btnCadastrar, "Cadastro Realizado com sucesso!!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            return album;
        }
    }

    private void criarTabela(){
        tblAlbuns.setModel(new DefaultTableModel(
                null,
                new String[]{"Id", "Nome", "Data", "Duração", "Genero"}
        ));
    }

    public static IAlbumService getAlbumService(){
        return new AlbumService();
    }

    public void configTela() {
        setContentPane(mainPanel);
        setTitle("Cadastro");
        setSize(800, 800);
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
