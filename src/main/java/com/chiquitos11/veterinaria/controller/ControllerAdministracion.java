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
                ad.estadoSubidaLABEL.setText("");
                
                
                
                ad.altaIMG.imgToContainer(ad.monitaChinaLABELalta);
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
                           JOptionPane.showMessageDialog(null, "ERROR DE SINTAXIS");
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
                           JOptionPane.showMessageDialog(null, "ERROR DE SINTAXIS");
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
                reiniciarAlta();
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
                ad.veterinarioJTEXT_BAJA.setEnabled(false);
                ad.veterinarioJTEXT_BAJA.setText("");
                
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
                ad.veterinarioJTEXT_BAJA.setEnabled(true);
                
                System.out.println(((String)ad.animalActualJCB_BAJA.getSelectedItem()).toLowerCase());
                tipoAnimalElegido_BAJA = ((String)ad.animalActualJCB_BAJA.getSelectedItem()).toLowerCase();
                
                
                try {
                    ResultSet rs = db.obtenerListadoModificado(tipoAnimalElegido_BAJA);
                    
                    
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
                String veterinario = ad.veterinarioJTEXT_BAJA.getText();
                if (veterinario.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "El nombre del veterinario no puede estar vacío.");
                    return;
                }
                System.out.println(veterinario);
                
                try {
                    ad.estadoBorradoLABEL_BAJA.setText("ERROR DE ELIMINACION.");
                    db.darBaja(bajaADar, tipoAnimalElegido_BAJA, veterinario);
                    ad.estadoBorradoLABEL_BAJA.setText("DATOS ELIMINADOS EXITOSAMENTE.");
                } catch (CommunicationsException ex) {
                    JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos... Encienda el XAMPP");
                } catch (SQLSyntaxErrorException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR DE SINTAXIS");
                    System.out.println("Error: " + ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error desconocido, intentelo más tarde.");
                    System.out.println("Error: " + ex.getMessage());
                    System.out.println("Excepcion: " + ex.toString());
                }
                
                
                ActionEvent evento = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "");

                retrocederBTN_BAJAaction.actionPerformed(evento);
                
                ad.veterinarioJTEXT_BAJA.setText("");
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    //
    //
    // LIBERACIONJPANEL --------------------------------------------------------------
    //
    //

    final ActionListener liberacionBTNaction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ad.menuJPANEL.removeAll();
            ad.menuJPANEL.add(ad.liberacionJPANEL);
            ad.animalActualJCB_LIBERACION.removeAllItems();
            ad.revalidate(); 
            ad.repaint();

            for (TipoAnimal tipoAni : TipoAnimal.values()) {
                ad.animalActualJCB_LIBERACION.addItem(tipoAni.toString());
            }

            ad.liberacionIMG.imgToContainer(ad.monitaChinaLABEL_LIBERACION);
        }
    };
    
    final ActionListener retrocederBTN_LIBERACIONaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.animalActualJCB_LIBERACION.removeAllItems();
                
                ad.avanzarBTN_LIBERACION.setEnabled(true);
                ad.retrocederBTN_LIBERACION.setEnabled(false);
                ad.darLiberacionBTN_LIBERACION.setEnabled(false);
                ad.veterinarioJTEXT_LIBERACION.setEnabled(false);
                ad.veterinarioJTEXT_LIBERACION.setText("");
                
                for (TipoAnimal tipoAni : TipoAnimal.values()) {
                    ad.animalActualJCB_LIBERACION.addItem(tipoAni.toString());
                }
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    String tipoAnimalElegido_LIBERACION = "";
    final ActionListener avanzarBTN_LIBERACIONaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                ad.avanzarBTN_LIBERACION.setEnabled(false);
                ad.retrocederBTN_LIBERACION.setEnabled(true);
                ad.darLiberacionBTN_LIBERACION.setEnabled(true);
                ad.veterinarioJTEXT_LIBERACION.setEnabled(true);
                
                System.out.println(((String)ad.animalActualJCB_LIBERACION.getSelectedItem()).toLowerCase());
                tipoAnimalElegido_LIBERACION = ((String)ad.animalActualJCB_LIBERACION.getSelectedItem()).toLowerCase();
                
                
                try {
                    ResultSet rs = db.obtenerListadoModificado(tipoAnimalElegido_LIBERACION);
                    
                    
                    ad.animalActualJCB_LIBERACION.removeAllItems(); // SACADA DE *****, COMO LO MUEVAS DE AQUI SE ROMPE EL PROGRAMA xd
                    
                    
                    while (rs.next()) {
                        ad.animalActualJCB_LIBERACION.addItem(rs.getString("dni") + ", " + rs.getString("nombre"));
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    final ActionListener darLiberacionBTN_LIBERACIONaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String liberacionStr = (String)ad.animalActualJCB_LIBERACION.getSelectedItem();
                int indiceComa = liberacionStr.indexOf(",");
                String liberacionADar = liberacionStr.substring(0, indiceComa);
                String veterinario = ad.veterinarioJTEXT_LIBERACION.getText();
                if (veterinario.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "El nombre del veterinario no puede estar vacío.");
                    return;
                }
                System.out.println(veterinario);
                
                try {
                    ad.estadoLiberacionLABEL_LIBERACION.setText("ERROR DE LIBERACION.");
                    db.darLiberacion(liberacionADar, tipoAnimalElegido_LIBERACION, veterinario);
                    ad.estadoLiberacionLABEL_LIBERACION.setText("ANIMAL DADO EN LIBERTAD CORRECTAMENTE.");
                } catch (CommunicationsException ex) {
                    JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos... Encienda el XAMPP");
                } catch (SQLSyntaxErrorException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR DE SINTAXIS");
                    System.out.println("Error: " + ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error desconocido, intentelo más tarde.");
                    System.out.println("Error: " + ex.getMessage());
                    System.out.println("Excepcion: " + ex.toString());
                }
                
                
                ActionEvent evento = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "");

                retrocederBTN_LIBERACIONaction.actionPerformed(evento);
                
                ad.veterinarioJTEXT_LIBERACION.setText("");
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    //
    //
    // TRATAMIENTOJPANEL --------------------------------------------------------------
    //
    //
    
    final ActionListener tratamientoBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.tratamientoJPANEL);
                ad.animalActualJCB_TRATAMIENTO.removeAllItems();
                ad.revalidate(); 
                ad.repaint(); 

                for (TipoAnimal tipoAni : TipoAnimal.values()) {
                    ad.animalActualJCB_TRATAMIENTO.addItem(tipoAni.toString());
                }

                ad.tratamientoIMG.imgToContainer(ad.monitaChinaLABEL_TRATAMIENTO);
            }
    };
    
    final ActionListener retrocederBTN_TRATAMIENTOaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.animalActualJCB_TRATAMIENTO.removeAllItems();
                
                ad.avanzarBTN_TRATAMIENTO.setEnabled(true);
                ad.retrocederBTN_TRATAMIENTO.setEnabled(false);
                ad.darTratamientoBTN_TRATAMIENTO.setEnabled(false);
                ad.veterinarioJTEXT_TRATAMIENTO.setEnabled(false);
                ad.veterinarioJTEXT_TRATAMIENTO.setText("");
                ad.tratamientoJTEXT_TRATAMIENTO.setEnabled(false);
                ad.tratamientoJTEXT_TRATAMIENTO.setText("");
                
                for (TipoAnimal tipoAni : TipoAnimal.values()) {
                    ad.animalActualJCB_TRATAMIENTO.addItem(tipoAni.toString());
                }
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    String tipoAnimalElegido_TRATAMIENTO = "";
    final ActionListener avanzarBTN_TRATAMIENTOaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                ad.avanzarBTN_TRATAMIENTO.setEnabled(false);
                ad.retrocederBTN_TRATAMIENTO.setEnabled(true);
                ad.darTratamientoBTN_TRATAMIENTO.setEnabled(true);
                ad.veterinarioJTEXT_TRATAMIENTO.setEnabled(true);
                ad.tratamientoJTEXT_TRATAMIENTO.setEnabled(true);
                
                System.out.println(((String)ad.animalActualJCB_TRATAMIENTO.getSelectedItem()).toLowerCase());
                tipoAnimalElegido_TRATAMIENTO = ((String)ad.animalActualJCB_TRATAMIENTO.getSelectedItem()).toLowerCase();
                
                
                try {
                    ResultSet rs = db.obtenerListadoModificado(tipoAnimalElegido_TRATAMIENTO);
                    
                    
                    ad.animalActualJCB_TRATAMIENTO.removeAllItems(); // SACADA DE *****, COMO LO MUEVAS DE AQUI SE ROMPE EL PROGRAMA xd
                    
                    
                    while (rs.next()) {
                        ad.animalActualJCB_TRATAMIENTO.addItem(rs.getString("dni") + ", " + rs.getString("nombre"));
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerAdministracion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    final ActionListener darTratamientoBTN_TRATAMIENTOaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String tratamientoStr = (String)ad.animalActualJCB_TRATAMIENTO.getSelectedItem();
                int indiceComa = tratamientoStr.indexOf(",");
                String tratamientoADar = tratamientoStr.substring(0, indiceComa);
                String veterinario = ad.veterinarioJTEXT_TRATAMIENTO.getText();
                
                String tratamiento = ad.tratamientoJTEXT_TRATAMIENTO.getText();
                
                if (veterinario.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "El nombre del veterinario no puede estar vacío.");
                    return;
                }
                if (tratamiento.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(null, "El tratamiento no puede estar vacío.");
                    return;
                }
                System.out.println(veterinario);
                
                try {
                    ad.estadoTratamientoLABEL_TRATAMIENTO.setText("ERROR DE TRATAMIENTO.");
                    db.darTratamiento(tratamientoADar, tipoAnimalElegido_TRATAMIENTO, veterinario, tratamiento);
                    ad.estadoTratamientoLABEL_TRATAMIENTO.setText("TRATAMIENTO DADO CORRECTAMENTE.");
                } catch (CommunicationsException ex) {
                    JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos... Encienda el XAMPP");
                } catch (SQLSyntaxErrorException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR DE SINTAXIS");
                    System.out.println("Error: " + ex.getMessage());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error desconocido, intentelo más tarde.");
                    System.out.println("Error: " + ex.getMessage());
                    System.out.println("Excepcion: " + ex.toString());
                }
                
                
                ActionEvent evento = new ActionEvent(new Object(), ActionEvent.ACTION_PERFORMED, "");

                retrocederBTN_TRATAMIENTOaction.actionPerformed(evento);
                
                ad.veterinarioJTEXT_TRATAMIENTO.setText("");
                ad.tratamientoJTEXT_TRATAMIENTO.setText("");
                ad.revalidate(); 
                ad.repaint(); 
            }
    };
    
    
    
    //
    //
    // LISTADOJPANEL --------------------------------------------------------------
    //
    //
    
    final ActionListener listadoBTNaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ad.menuJPANEL.removeAll();
                ad.menuJPANEL.add(ad.listadoJPANEL);
                ad.animalActualJCB_LISTADO.removeAllItems();
                ad.revalidate();
                ad.repaint();

                for (TipoAnimal tipoAni : TipoAnimal.values()) {
                    ad.animalActualJCB_LISTADO.addItem(tipoAni.toString());
                }

                ad.listadoIMG.imgToContainer(ad.monitaChinaLABEL_LISTADO);
            }
    };
    
    final ActionListener darListadoBTN_LISTADOaction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("entroLISTADO");
                try {
                    String animalActual = ((String)ad.animalActualJCB_LISTADO.getSelectedItem()).toLowerCase();
                    ResultSet rs = db.obtenerListadoPorAnimal(animalActual);
                    
                    
                    ad.listadoJTEXT_LISTADO.setText(""); // SACADA DE *****, COMO LO MUEVAS DE AQUI SE ROMPE EL PROGRAMA xd
                    
                    StringBuilder todo = new StringBuilder();
                    while (rs.next()) {
                        todo.append("\n\nDNI: ").append(rs.getString("dni"))
                                .append("\nNombre: ").append(rs.getString("nombre"))
                                .append("\nTratamiento: ").append(rs.getString("tratamiento"))
                                .append("\nFecha de Entrada: ").append(rs.getDate("fechaEntrada"))
                                .append("\nTipo de Animal: ").append(rs.getString("tipoAnimal"))
                                .append("\nPeso: ").append(rs.getDouble("peso"))
                                .append("\nGravedad: ").append(rs.getString("gravedad"))
                                .append("\nFecha de Salida: ").append(rs.getDate("fechaSalida"))
                                .append("\nMotivo de Salida: ").append(rs.getString("motivoSalida"))
                                .append("\nVeterinario: ").append(rs.getString("veterinario"));
                        switch (animalActual) {
                            case "ave":
                                todo.append("\nCaza Furtiva? ").append(rs.getBoolean("cazaFurtiva"));
                                break;
                                
                            case "mamifero":
                                todo.append("\nAtropello? ").append(rs.getBoolean("atropello"));
                                break;
                                
                            case "reptil":
                                todo.append("\nInfeccion Bacteriana? ").append(rs.getBoolean("infeccionBacteriana"));
                                break;
                        }
                    }
                    ad.listadoJTEXT_LISTADO.setText(todo.toString());
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error desconocido, intentelo más tarde.");
                    System.out.println("Error: " + ex.getMessage());
                    System.out.println("Excepcion: " + ex.toString());
                }
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
        
        // LIBERACIONJPANEL
        ad.retrocederBTN_LIBERACION.addActionListener(retrocederBTN_LIBERACIONaction);
        ad.avanzarBTN_LIBERACION.addActionListener(avanzarBTN_LIBERACIONaction);
        ad.darLiberacionBTN_LIBERACION.addActionListener(darLiberacionBTN_LIBERACIONaction);
        ad.regresarMenuBTN_LIBERACION.addActionListener(regresarMenuBTNaction);
        
        // TRATAMIENTOJPANEL
        ad.retrocederBTN_TRATAMIENTO.addActionListener(retrocederBTN_TRATAMIENTOaction);
        ad.avanzarBTN_TRATAMIENTO.addActionListener(avanzarBTN_TRATAMIENTOaction);
        ad.darTratamientoBTN_TRATAMIENTO.addActionListener(darTratamientoBTN_TRATAMIENTOaction);
        ad.regresarMenuBTN_TRATAMIENTO.addActionListener(regresarMenuBTNaction);
        
        // TRATAMIENTOJPANEL
        ad.darListadoBTN_LISTADO.addActionListener(darListadoBTN_LISTADOaction);
        ad.regresarMenuBTN_LISTADO.addActionListener(regresarMenuBTNaction);
    }
    
    public void reiniciarAlta(){
        ad.dniTEXTFIELD.setText("");
        ad.nombreTEXTFIELD.setText("");
        ad.pesoJSPINNER_ALTA.setValue(0.0);
    }
    
    public void reiniciarJCBBaja(){
        
    }
    
    
}
