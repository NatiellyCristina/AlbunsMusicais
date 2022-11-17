package AlbunsMusicais.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame{
    private JButton btnTelaCadastrar;
    private JPanel mainPanel;

    public TelaPrincipal() {
        configurarTela();
        btnTelaCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastrar().setVisible(true);
            }
        });
    }

    public void configurarTela(){
        setContentPane(mainPanel);
        setTitle("Menu");
        setSize(800, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
    }
}
