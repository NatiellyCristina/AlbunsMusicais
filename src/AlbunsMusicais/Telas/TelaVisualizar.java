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

    public TelaVisualizar(){
        configurarTela();
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
