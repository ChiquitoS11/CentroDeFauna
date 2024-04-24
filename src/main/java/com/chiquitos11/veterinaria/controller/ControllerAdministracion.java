package com.chiquitos11.veterinaria.controller;

import com.chiquitos11.veterinaria.enums.Gravedad;
import com.chiquitos11.veterinaria.enums.TipoAnimal;
import com.chiquitos11.veterinaria.model.Ave;
import com.chiquitos11.veterinaria.model.Mamifero;
import com.chiquitos11.veterinaria.model.Reptil;
import com.chiquitos11.veterinaria.view.Administracion;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ChiquitoS11
 */
public class ControllerAdministracion {
    private Administracion ad;
    private ControllerBBDD db;
    
    
    final ActionListener altaBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.altaJPANEL);
                ad.revalidate(); 
                ad.repaint(); 
                
                ad.altaIMG.imgToContainer(ad.monitaChinaLABELalta);
            }
    };
    
    final ActionListener tratamientoBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.tratamientoJPANEL);
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    final ActionListener listadoBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.listadoJPANEL);
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };

    
    final ActionListener liberacionBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.liberacionJPANEL);
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    final ActionListener salirBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.dispose();
            }
    };
    
    final ActionListener regresarMenuBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.inicioJPANEL);
                 
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    //
    //
    // ALTAJPANEL --------------------------------------------------------------
    //
    //
    

    
    final ActionListener especieJCBaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ad.especieJCB.getSelectedItem() == TipoAnimal.Ave) {
                    ad.motivoLesionLABEL.setText("Caza Furtiva ?");
                }
                if (ad.especieJCB.getSelectedItem() == TipoAnimal.Mamifero) {
                    ad.motivoLesionLABEL.setText("Atropello ?");
                }
                if (ad.especieJCB.getSelectedItem() == TipoAnimal.Reptil) {
                    ad.motivoLesionLABEL.setText("Infección bacteriana ?");
                }
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    final ActionListener enviarBTNaltaaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (ad.dniTEXTFIELD.getText().isBlank()) {
                    System.out.println("DNI vacio en el panel de alta");
                    reiniciarAlta();
                    ad.estadoSubidaLABEL.setText("ERROR EN LA CARGA DE DATOS.");
                    return;
                }
                if (ad.dniTEXTFIELD.getText().isBlank()) {
                    System.out.println("Nombre vacio en el panel de alta");
                    reiniciarAlta();
                    ad.estadoSubidaLABEL.setText("ERROR EN LA CARGA DE DATOS.");
                    return;
                }
                if (0.1 > (double)ad.pesoJSPINNER_ALTA.getValue()) {
                    System.out.println("Peso vacio");
                    reiniciarAlta();
                    ad.estadoSubidaLABEL.setText("ERROR EN LA CARGA DE DATOS.");
                    return;
                }
                
                
                switch (ad.especieJCB.getSelectedItem().toString()) {
                    case "Ave":
                        try {
                            ad.estadoSubidaLABEL.setText("ERROR EN LA CARGA DE DATOS.");
                            db.darAlta(new Ave(ad.dniTEXTFIELD.getText(), 
                                    ad.nombreTEXTFIELD.getText(),
                                    LocalDate.now(), 
                                    (TipoAnimal)ad.especieJCB.getSelectedItem(), 
                                    (double)ad.pesoJSPINNER_ALTA.getValue(), 
                                    (Gravedad)ad.gravedadJCB.getSelectedItem(),
                                    ad.motivoLesionJCHECK_ALTA.isSelected()));
                            
                        // db.darAlta(new Reptil()); // ASI PASARE LOS DATOS DE LA LOGICA A LA ddbb
                        } catch (CommunicationsException ex) {
                           JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos... Encienda el XAMPP");
                        } catch (SQLIntegrityConstraintViolationException ex) {
                           JOptionPane.showMessageDialog(null, "Un animal ya ha sido registrado con ese DNI, verifique los datos.");
                        } catch (SQLSyntaxErrorException ex) {
                           JOptionPane.showMessageDialog(null, "No se creo la base ded datos con el nombre 'veterinaria'");
                        } catch (SQLException ex) {
                           JOptionPane.showMessageDialog(null, "Error desconocido, intentelo más tarde.");
                           System.out.println("Error: " + ex.getMessage());
                           System.out.println("Excepcion: " + ex.toString());
                        }
                        break;
                        
                    case "Mamifero":
                        try {
                            db.darAlta(new Mamifero(ad.dniTEXTFIELD.getText(), 
                                    ad.nombreTEXTFIELD.getText(),
                                    LocalDate.now(), 
                                    (TipoAnimal)ad.especieJCB.getSelectedItem(), 
                                    (double)ad.pesoJSPINNER_ALTA.getValue(), 
                                    (Gravedad)ad.gravedadJCB.getSelectedItem(),
                                    ad.motivoLesionJCHECK_ALTA.isSelected()));
                        // db.darAlta(new Reptil()); // ASI PASARE LOS DATOS DE LA LOGICA A LA ddbb
                        } catch (CommunicationsException ex) {
                           JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos... Encienda el XAMPP");
                        } catch (SQLIntegrityConstraintViolationException ex) {
                           JOptionPane.showMessageDialog(null, "Un animal ya ha sido registrado con ese DNI, verifique los datos.");
                        } catch (SQLSyntaxErrorException ex) {
                           JOptionPane.showMessageDialog(null, "No se creo la base ded datos con el nombre 'veterinaria'");
                        } catch (SQLException ex) {
                           JOptionPane.showMessageDialog(null, "Error desconocido, intentelo más tarde.");
                           System.out.println("Error: " + ex.getMessage());
                           System.out.println("Excepcion: " + ex.toString());
                        }
                        break;
                        
                    case "Reptil":
                        try {
                            db.darAlta(new Reptil(ad.dniTEXTFIELD.getText(), 
                                    ad.nombreTEXTFIELD.getText(),
                                    LocalDate.now(), 
                                    (TipoAnimal)ad.especieJCB.getSelectedItem(), 
                                    (double)ad.pesoJSPINNER_ALTA.getValue(), 
                                    (Gravedad)ad.gravedadJCB.getSelectedItem(),
                                    ad.motivoLesionJCHECK_ALTA.isSelected()));
                        // db.darAlta(new Reptil()); // ASI PASARE LOS DATOS DE LA LOGICA A LA ddbb
                        } catch (CommunicationsException ex) {
                           JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos... Encienda el XAMPP");
                        } catch (SQLIntegrityConstraintViolationException ex) {
                           JOptionPane.showMessageDialog(null, "Un animal ya ha sido registrado con ese DNI, verifique los datos.");
                        } catch (SQLSyntaxErrorException ex) {
                           JOptionPane.showMessageDialog(null, "ERROR DE SINTAXIS");
                        } catch (SQLException ex) {
                           JOptionPane.showMessageDialog(null, "Error desconocido, intentelo más tarde.");
                           System.out.println("Error: " + ex.getMessage());
                           System.out.println("Excepcion: " + ex.toString());
                        }
                        break;
                }
                ad.estadoSubidaLABEL.setText("DATOS CARGADOS EXITOSAMENTE.");
                
            }
    };
    
    //
    //
    // BAJAJPANEL --------------------------------------------------------------
    //
    //
    
    
    final ActionListener bajaBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.bajaJPANEL);
                ad.animalActualJCB_BAJA.removeAllItems();
                ad.revalidate(); 
                ad.repaint();

                
                for (TipoAnimal tipoAni : TipoAnimal.values()) {
                    ad.animalActualJCB_BAJA.addItem(tipoAni.toString());
                }
                
                ad.bajaIMG.imgToContainer(ad.monitaChinaLABEL_BAJA);
                
            }
    };
    
    
    final ActionListener retrocederBTN_BAJAaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.animalActualJCB_BAJA.removeAllItems();
                
                ad.avanzarBTN_BAJA.setEnabled(true);
                ad.retrocederBTN_BAJA.setEnabled(false);
                ad.darBajaBTN_BAJA.setEnabled(false);
                
                for (TipoAnimal tipoAni : TipoAnimal.values()) {
                    ad.animalActualJCB_BAJA.addItem(tipoAni.toString());
                }
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    String tipoAnimalElegido_BAJA = "";
    final ActionListener avanzarBTN_BAJAaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                ad.avanzarBTN_BAJA.setEnabled(false);
                ad.retrocederBTN_BAJA.setEnabled(true);
                ad.darBajaBTN_BAJA.setEnabled(true);
                
                System.out.println(((String)ad.animalActualJCB_BAJA.getSelectedItem()).toLowerCase());
                tipoAnimalElegido_BAJA = ((String)ad.animalActualJCB_BAJA.getSelectedItem()).toLowerCase();
                
                
                try {
                    ResultSet rs = db.obtenerListado(tipoAnimalElegido_BAJA);
                    
                    
                    ad.animalActualJCB_BAJA.removeAllItems(); // SACADA DE *****, COMO LO MUEVAS DE AQUI SE ROMPE EL PROGRAMA xd
                    
                    
                    while (rs.next()) {
                        ad.animalActualJCB_BAJA.addItem(rs.getString("dni") + ", " + rs.getString("nombre"));
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
            final ActionListener bajaBTN_BAJAaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String bajaStr = (String)ad.animalActualJCB_BAJA.getSelectedItem();
                int indiceComa = bajaStr.indexOf(",");
                String bajaADar = bajaStr.substring(0, indiceComa);

                try {
                    db.darBaja(bajaADar, tipoAnimalElegido_BAJA);
                    ad.estadoBorradoLABEL_BAJA.setText("DATOS ELIMINADOS EXITOSAMENTE.");
                } catch (SQLException ex) {
                    ad.estadoBorradoLABEL_BAJA.setText("ERROR EN LA ELIMINACIÓN DE DATOS.");
                    Logger.getLogger(ControllerAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                ActionEvent evento = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "");

                retrocederBTN_BAJAaction.actionPerformed(evento);
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
            
            
    public ControllerAdministracion(Administracion ad) {
        this.ad = ad;
        db = new ControllerBBDD();
        
        
        ad.altaBTN.addActionListener(altaBTNaction);
        ad.tratamientoBTN.addActionListener(tratamientoBTNaction);
        ad.listadoBTN.addActionListener(listadoBTNaction);
        ad.bajaBTN.addActionListener(bajaBTNaction);
        ad.liberacionBTN.addActionListener(liberacionBTNaction);
        ad.salirBTN.addActionListener(salirBTNaction);
    
        
        // ALTAJPANEL
        ad.regresarMenuBTN_ALTA.addActionListener(regresarMenuBTNaction);
        ad.especieJCB.addActionListener(especieJCBaction);
        ad.enviarBTN_ALTA.addActionListener(enviarBTNaltaaction);
        
        // BAJAJPANEL
        ad.retrocederBTN_BAJA.addActionListener(retrocederBTN_BAJAaction);
        ad.avanzarBTN_BAJA.addActionListener(avanzarBTN_BAJAaction);
        ad.darBajaBTN_BAJA.addActionListener(bajaBTN_BAJAaction);
        ad.regresarMenuBTN_BAJA.addActionListener(regresarMenuBTNaction);
    }
    
    public void reiniciarAlta(){
        ad.dniTEXTFIELD.setText("");
        ad.nombreTEXTFIELD.setText("");
        ad.pesoJSPINNER_ALTA.setValue(0.0);
    }
    
    public void reiniciarJCBBaja(){
        
    }
    
    
}
