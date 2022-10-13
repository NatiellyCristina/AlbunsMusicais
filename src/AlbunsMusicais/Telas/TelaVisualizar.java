package AlbunsMusicais.Telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVisualizar extends JFrame{
    private JLabel lblVisualizar;
    private JPanel mainPanel;
    private JButton btnVoltar;

    public TelaVisualizar(){
        setContentPane(mainPanel);
        setTitle("Cadastro");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
