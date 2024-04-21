import com.chiquitos11.veterinaria.controller.ControllerVeterinaria;
import com.chiquitos11.veterinaria.view.Administracion;
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
                
                // declaramos el frame principal donde estará todo
                Veterinaria v = new Veterinaria(); // esto solo es la interfaz
                ControllerVeterinaria c = new ControllerVeterinaria(v); // creamos y asignamos un controlador logico encargado de todo lo relacionado a programacion
                Administracion ad = new Administracion();
                ad.meow();
                

                v.setVisible(true);
                v.setResizable(false);
                v.setLocationRelativeTo(null);
                
                Border bordePersonalizado = BorderFactory.createLineBorder(Color.BLACK, 3);
                v.getRootPane().setBorder(bordePersonalizado);
            }
        });
    }
}
