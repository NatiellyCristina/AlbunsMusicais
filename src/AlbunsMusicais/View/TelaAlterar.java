package AlbunsMusicais.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlterar extends JFrame{
    private JLabel lblAlterar;
    private JPanel mainPanel;
    private JButton btnVoltar;

    public TelaAlterar(){
        configurarTela();
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAlterar telaAlterar = new TelaAlterar();

                telaAlterar.dispose();
                setVisible(false);
            }
        });
    }

    public void configurarTela(){
        setContentPane(mainPanel);
        setTitle("Alterar");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        TelaAlterar telaAlterar = new TelaAlterar();
    }
}
