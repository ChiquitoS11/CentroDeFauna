import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColisionJPanel extends JFrame {
    private JPanel panel1;
    private JPanel panel2;
    private JPanel personaje;
    
    private int personajeX = 50; // Posición inicial del personaje en el eje X
    private int personajeY = 50; // Posición inicial del personaje en el eje Y
    private int personajeWidth = 50; // Ancho del personaje
    private int personajeHeight = 50; // Alto del personaje

    public ColisionJPanel() {
        setTitle("Ejemplo de Colisión de JPanel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los JPanel
        panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setBounds(100, 100, 200, 100);

        panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setBounds(300, 200, 150, 150);

        // Crear el JPanel del personaje
        personaje = new JPanel();
        personaje.setBackground(Color.GREEN);
        personaje.setBounds(personajeX, personajeY, personajeWidth, personajeHeight);

        // Agregar los JPanel al JFrame
        setLayout(null);
        add(panel1);
        add(panel2);
        add(personaje);

        // Agregar el KeyListener para controlar el movimiento del personaje
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    personajeX -= 5;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    personajeX += 5;
                } else if (keyCode == KeyEvent.VK_UP) {
                    personajeY -= 5;
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    personajeY += 5;
                }

                // Comprobar colisión con los JPanel
                if (personaje.getBounds().intersects(panel1.getBounds()) ||
                        personaje.getBounds().intersects(panel2.getBounds())) {
                    // Si hay colisión, revertir el movimiento
                    personajeX = Math.min(Math.max(personajeX, 0), getWidth() - personajeWidth);
                    personajeY = Math.min(Math.max(personajeY, 0), getHeight() - personajeHeight);
                }

                // Actualizar la posición del personaje
                personaje.setBounds(personajeX, personajeY, personajeWidth, personajeHeight);
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ColisionJPanel();
    }
}
