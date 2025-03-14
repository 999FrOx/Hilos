import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase que representa la interfaz gráfica para la carrera de autos
public class AutosVista {
    private JTextArea taAutoAzul;  // Área de texto para mostrar el progreso del Auto Azul
    private JTextArea taAutoRojo;  // Área de texto para mostrar el progreso del Auto Rojo
    private JButton btCarrera;     // Botón para iniciar la carrera
    private JPanel pPrincipal;     // Panel principal que contiene los componentes

    // Constructor de la clase donde se define la lógica del botón
    public AutosVista() {
        // Agrega un listener al botón para manejar el evento de clic
        btCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpia los JTextArea antes de comenzar una nueva carrera
                taAutoAzul.setText("");
                taAutoRojo.setText("");

                // Crea instancias de los autos pasándoles sus respectivos JTextArea
                AutoAzul autoAzul = new AutoAzul(taAutoAzul);
                AutoRojo autoRojo = new AutoRojo(taAutoRojo);

                // Inicia ambos hilos para que la carrera comience
                autoAzul.start();
                autoRojo.start();
            }
        });
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        // Crea un nuevo marco (ventana) de la aplicación
        JFrame frame = new JFrame("AutosVista");

        // Establece el panel principal como el contenido de la ventana
        frame.setContentPane(new AutosVista().pPrincipal);

        // Configura la ventana para que se cierre al salir
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajusta el tamaño de la ventana automáticamente
        frame.pack();

        // Hace la ventana visible
        frame.setVisible(true);

        // Establece un tamaño fijo para la ventana
        frame.setSize(500, 400);

        // Centra la ventana en la pantalla
        frame.setLocationRelativeTo(null);
    }
}
