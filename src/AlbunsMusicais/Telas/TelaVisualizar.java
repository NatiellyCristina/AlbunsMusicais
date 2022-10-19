package AlbunsMusicais.Telas;

import AlbunsMusicais.Dominio.Album;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVisualizar extends JFrame{
    private JPanel mainPanel;
    private JButton btnVoltar;
    private JTextField txtNome;
    private JTextField txtDtNasc;
    private JTextField txtDuracao;

    Album album = new Album();

    public TelaVisualizar(){
        setContentPane(mainPanel);
        setTitle("Visualizar");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        TelaVisualizar telaVisualizar = new TelaVisualizar();
    }
}
