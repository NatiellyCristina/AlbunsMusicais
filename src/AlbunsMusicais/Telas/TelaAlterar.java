package AlbunsMusicais.Telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlterar extends JFrame{
    private JLabel lblAlterar;
    private JPanel mainPanel;
    private JButton btnVoltar;

    public TelaAlterar(){
        setContentPane(mainPanel);
        setTitle("Alterar");
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
        TelaAlterar telaAlterar = new TelaAlterar();
    }
}
