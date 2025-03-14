import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutosVista {
    private JTextArea taAutoAzul;
    private JTextArea taAutoRojo;
    private JButton btCarrera;
    private JPanel pPrincipal;

    public AutosVista () {
        btCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taAutoAzul.setText("");
                taAutoRojo.setText("");
                AutoAzul autoAzul = new AutoAzul(taAutoAzul);
                AutoRojo autoRojo = new AutoRojo(taAutoRojo);

                autoAzul.start();
                autoRojo.start();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AutosVista");
        frame.setContentPane(new AutosVista().pPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
    }
}
