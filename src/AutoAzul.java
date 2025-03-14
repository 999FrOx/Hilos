import java.util.Random;
import javax.swing.*;

class AutoAzul extends Thread {
    //Objeto para referenciar al textarea
    private JTextArea textArea;
    public AutoAzul (JTextArea textArea) {
        this.textArea = textArea;
    }
    private int distancia = 0;
    private static final int META = 100;

    public void run() {
        Random rand = new Random();
        while (distancia < META) {
            int avance = rand.nextInt(10) + 1; // Avance aleatorio entre 1 y 10
            distancia += avance;
            textArea.append("🚗 El bocho tuneado avanzó " + avance + " metros. Total: " + distancia + "\n") ;
            try {
                Thread.sleep(rand.nextInt(500) + 500); // Espera entre 0.5 y 1 seg
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        textArea.append("🚩🚗 El bocho ganó!!!");
    }
}