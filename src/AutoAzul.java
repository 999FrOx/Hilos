import java.util.Random;
import javax.swing.*;

// Clase que representa un auto azul que se mueve en un hilo separado
class AutoAzul extends Thread {
    // Objeto para referenciar al JTextArea donde se mostrará el avance
    private JTextArea textArea;

    // Constructor que recibe el JTextArea como parámetro
    public AutoAzul(JTextArea textArea) {
        this.textArea = textArea;
    }

    // Variable que almacena la distancia recorrida por el auto
    private int distancia = 0;
    // Distancia total necesaria para llegar a la meta
    private static final int META = 100;

    // Método run() que ejecuta el comportamiento del hilo
    public void run() {
        Random rand = new Random(); // Objeto para generar números aleatorios

        // Bucle que se ejecuta hasta que el auto alcance la meta
        while (distancia < META) {
            int avance = rand.nextInt(10) + 1; // Genera un avance aleatorio entre 1 y 10 metros
            distancia += avance; // Suma el avance a la distancia recorrida

            // Muestra el avance en el JTextArea
            textArea.append("🚗 El bocho tuneado avanzó " + avance + " metros. Total: " + distancia + "\n");

            try {
                // Pausa el hilo por un tiempo aleatorio entre 0.5 y 1 segundo
                Thread.sleep(rand.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manejo de la excepción en caso de interrupción del hilo
            }
        }

        // Mensaje final cuando el auto alcanza la meta
        textArea.append("🚩🚗 El bocho llegó a la meta!");
    }
}
