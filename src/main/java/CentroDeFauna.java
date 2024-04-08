import com.chiquitos11.veterinaria.controller.ControllerVeterinaria;
import com.chiquitos11.veterinaria.view.Veterinaria;
import javax.swing.SwingUtilities;

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
                v.setResizable(true);
                v.setLocationRelativeTo(null);
            }
        });
    }
}
