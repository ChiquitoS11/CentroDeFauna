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
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;
import java.time.LocalDate;
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
    
    final ActionListener bajaBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.bajaJPANEL);
                
                
                
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
    
    //
    //
    // ALTAJPANEL --------------------------------------------------------------
    //
    //
    
    final ActionListener regresarMenuBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.inicioJPANEL);
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
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
        ad.regresarBTN_ALTA.addActionListener(regresarMenuBTNaction);
        ad.especieJCB.addActionListener(especieJCBaction);
        ad.enviarBTN_ALTA.addActionListener(enviarBTNaltaaction);
        
    }
    
    public void reiniciarAlta(){
        ad.dniTEXTFIELD.setText("");
        ad.nombreTEXTFIELD.setText("");
        ad.pesoJSPINNER_ALTA.setValue(0.0);
    }
    
}
