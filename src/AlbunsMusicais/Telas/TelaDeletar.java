package AlbunsMusicais.Telas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDeletar extends JFrame{
    private JLabel lblDeletar;
    private JPanel mainPanel;
    private JButton btnVoltar;

    public TelaDeletar(){
        configurarTela();
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDeletar telaDeletar = new TelaDeletar();

                telaDeletar.dispose();
                setVisible(false);
            }
        });
    }

    public void configurarTela(){
        setContentPane(mainPanel);
        setTitle("Deletar");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        TelaDeletar telaDeletar = new TelaDeletar();
    }
}
