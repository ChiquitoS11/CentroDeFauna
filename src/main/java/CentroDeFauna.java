import com.chiquitos11.veterinaria.controller.ControllerVeterinaria;
import com.chiquitos11.veterinaria.view.Veterinaria;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author ChiquitoS11
 */
public class CentroDeFauna {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Veterinaria v = new Veterinaria();
                ControllerVeterinaria c = new ControllerVeterinaria(v);
                

                v.setVisible(true);
                v.setResizable(false);
                v.setLocationRelativeTo(null);
                
                Border bordePersonalizado = BorderFactory.createLineBorder(Color.BLACK, 3);
                v.getRootPane().setBorder(bordePersonalizado);
            }
        });
    }
}
