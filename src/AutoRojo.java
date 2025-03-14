import java.util.Random;
import javax.swing.*;

// Clase que representa un auto rojo que se mueve en un hilo separado
class AutoRojo extends Thread {
    private JTextArea textArea; // Objeto JTextArea para mostrar el progreso en la interfaz gráfica

    // Constructor que recibe el JTextArea como parámetro
    public AutoRojo(JTextArea textArea) {
        this.textArea = textArea;
    }

    private int distancia = 0; // Distancia recorrida por el auto
    private static final int META = 100; // Distancia total para llegar a la meta

    // Método run() que ejecuta la lógica del hilo
    public void run() {
        Random rand = new Random(); // Objeto para generar valores aleatorios

        // Mientras el auto no haya alcanzado la meta
        while (distancia < META) {
            int avance = rand.nextInt(10) + 1; // Genera un avance aleatorio entre 1 y 10 metros
            distancia += avance; // Suma el avance a la distancia total

            // Muestra el progreso en el JTextArea
            textArea.append("🏎️  El Bugatti avanzó " + avance + " metros. Total: " + distancia + "\n");

            try {
                // Pausa el hilo por un tiempo aleatorio entre 0.5 y 1 segundo
                Thread.sleep(rand.nextInt(500) + 500);
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manejo de la excepción en caso de interrupción del hilo
            }
        }

        // Mensaje final cuando el auto alcanza la meta
        textArea.append("🚩🏎️ El Bugatti ha llegado a la meta!");
    }
}
