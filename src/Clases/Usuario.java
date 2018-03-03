package Clases;

import Clases.Jugar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.*;

public class Usuario {

    private JFrame ventana;
    private JTextField usuario;

    private JButton aceptar, cancelar;
    private ImageIcon imagenTimber;
    private JLabel etiqueta2, etiqueta_nombre, imagenTimber2;
    private String nombre;
    public Usuario() {
        
        ventana = new JFrame("Usuario");
        imagenTimber2 = new JLabel();
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
        etiqueta2 = new JLabel();
        etiqueta_nombre = new JLabel();
        usuario = new JTextField("");
        ventana.getComponents();
        initComponents();
       
    }

    public String getNombre() {
        return nombre;
    }

    
    

    /**
     *iniciamos todos los componentes de la creacion del usuario 
     */
    public void initComponents(){
        ventana.setSize(450, 350);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.setVisible(true);
        ventana.setIconImage(new ImageIcon(getClass().getResource("/ImagenesJuego/icono.jpg")).getImage());
        
        imagenTimber = new ImageIcon(getClass().getResource("/ImagenesJuego/Timber-Man.png"));
        imagenTimber2.setIcon(imagenTimber);
        imagenTimber2.setBounds(0, 0, imagenTimber.getIconHeight(), imagenTimber.getIconWidth());
        imagenTimber2.setOpaque(true);
        
        aceptar.setBounds(10, 170, 75, 50);
        ImageIcon acep= new ImageIcon("src/ImagenesJuego/chu.png");
        ImageIcon ac=new ImageIcon(acep.getImage().getScaledInstance(aceptar.getWidth(), aceptar.getHeight(), Image.SCALE_DEFAULT));
        aceptar.setBorder(null);
        aceptar.setContentAreaFilled(false);
        aceptar.setIcon(ac);
        
        cancelar.setBounds(75, 170, 75, 50);
        ImageIcon cancel= new ImageIcon("src/ImagenesJuego/x1.png");
        ImageIcon canx=new ImageIcon(cancel.getImage().getScaledInstance(cancelar.getWidth(), cancelar.getHeight(), Image.SCALE_DEFAULT));
        cancelar.setContentAreaFilled(false);
        cancelar.setBorder(null);
        cancelar.setIcon(canx);
        
        etiqueta2.setBounds(0,15,180,150);
        ImageIcon no= new ImageIcon("src/ImagenesJuego/text.png");
        ImageIcon nomx=new ImageIcon(no.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_DEFAULT));
        etiqueta2.setIcon(nomx);
        
        etiqueta_nombre.setBounds(100, 100, 65, 25);
        
        usuario.setBounds(35, 98, 106, 31);
        usuario.setBorder(null);
        usuario.setBackground(new Color(142,71,17));
        usuario.setFont(new Font("Harrington",Font.BOLD,28));
        usuario.setForeground(Color.WHITE);
        usuario.setVisible(true);

        ventana.add(usuario);
        ventana.add(etiqueta2);
        ventana.add(etiqueta_nombre);
        ventana.add(aceptar);
        ventana.add(cancelar);
        ventana.add(imagenTimber2);
        ventana.setVisible(true);
    }
    /*
    listener para crear una nueva ventana de nuevo juego 
    y guardar datos del usuario en un archivo llamado 
    "archivo_entrada.dat"     
    */
    public void AceptarCancelar() {
        aceptar.addActionListener(new ActionListener() {
            
            String archivo_entrada="archivo_entrada.dat";
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == aceptar) {
                    
                    System.out.println("Aceptar");
                    
                    nombre=usuario.getText();
                    
                            //String puntuacion=puntos
                    try {
                        FileWriter arch=new FileWriter(archivo_entrada,true);
                        BufferedWriter arch2=new BufferedWriter(arch);
                        PrintWriter arch3=new PrintWriter(arch2);
                          
                        arch3.printf("Nombre:"+nombre);
                            //arch3.printf("Puntuacion:"+puntuacion);
                        arch3.close();
                    } catch (Exception e) {System.out.println("No se creo un usuario");
                    }
                    try {
                        
                        Jugar obj= new Jugar(nombre); 
                        
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                   ventana.setVisible(false);
                }

            }
        });
        /*
        listener del boton cancelar para regresar al menu principal 
        sin guardar datos 
        */
        
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent enter) {
                if (enter.getSource() == cancelar) {
                    
                    System.out.println("Cancelar");
                    ventana.setVisible(false);
                }

            }

        });
        /*
        listener para cambiar icono y tamano del boton cancelar
        cuando el mouse salga del area utilizada por el label 
        utilizando el metodo mouseEntered y mouseExited 
        */
                
    cancelar.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
           cancelar.setBounds(75, 165,150, 60);
            ImageIcon cancel= new ImageIcon("src/ImagenesJuego/can1.png");
            ImageIcon canx=new ImageIcon(cancel.getImage().getScaledInstance(cancelar.getWidth(), cancelar.getHeight(), Image.SCALE_DEFAULT));
            cancelar.setContentAreaFilled(false);
            cancelar.setBorder(null);
            cancelar.setIcon(canx);
            cancelar.setOpaque(false);
            cancelar.setText("Cancelar");
            cancelar.setForeground(Color.WHITE);
            cancelar.setFont(new Font("Harrington",Font.BOLD,28));
            cancelar.setHorizontalTextPosition(SwingConstants.CENTER);
            cancelar.setVerticalTextPosition(SwingConstants.CENTER);
        }
        /*
        listener para cambiar icono y tamano del boton cancelar
        cuando el mouse salga del area utilizada por el label 
        utilizando el metodo mouseExited. 
        */
        public void mouseExited(MouseEvent e){
            
            cancelar.setBounds(75, 170, 75, 50);
            ImageIcon cancel= new ImageIcon("src/ImagenesJuego/x1.png");
            ImageIcon canx=new ImageIcon(cancel.getImage().getScaledInstance(cancelar.getWidth(), cancelar.getHeight(), Image.SCALE_DEFAULT));
            cancelar.setContentAreaFilled(false);
            cancelar.setBorder(null);
            cancelar.setIcon(canx);
            cancelar.setText("");
        }
        });
        /*
        listener para cambiar icono y tamano del boton aceptar
        cuando el mouse entre en el area utilizada por el label 
        utilizando el metodo mouseEntered 
        */
        aceptar.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                aceptar.setBounds(10, 165,150, 60);
                ImageIcon cancel= new ImageIcon("src/ImagenesJuego/can1.png");
                ImageIcon canx=new ImageIcon(cancel.getImage().getScaledInstance(aceptar.getWidth(), aceptar.getHeight(), Image.SCALE_DEFAULT));
                aceptar.setContentAreaFilled(false);
                aceptar.setBorder(null);
                aceptar.setIcon(canx);
                aceptar.setOpaque(false);
                aceptar.setText("Aceptar");
                aceptar.setForeground(Color.WHITE);
                aceptar.setFont(new Font("Harrington",Font.BOLD,28));
                aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
                aceptar.setVerticalTextPosition(SwingConstants.CENTER);
        }
        /*
        listener para cambiar icono y tamano del boton aceptar
        cuando el mouse salga del area utilizada por el label 
        utilizando el metodo mouseExited. 
        */
        public void mouseExited(MouseEvent e){
            
            aceptar.setBounds(10, 170, 75, 50);
            ImageIcon cancel= new ImageIcon("src/ImagenesJuego/chu.png");
            ImageIcon canx=new ImageIcon(cancel.getImage().getScaledInstance(aceptar.getWidth(), aceptar.getHeight(), Image.SCALE_DEFAULT));
            aceptar.setContentAreaFilled(false);
            aceptar.setBorder(null);
            aceptar.setIcon(canx);
            aceptar.setText("");
        }
        });
    }
    

}
