/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JWindow;

/**
 *
 * @author Yess
 */
public class Creditos extends JFrame{
    /**atributos de la clase*/
    private JWindow w1;
    private JTextArea ti,t2;
    private JButton volver;
    private JLabel fon;
    private int y=750;
    private String msj="Realizado Por:"+"\n"
            + "~Yessika Vargas"+"\n"
            + "C.I.: V-19353702"+"\n"
            + "~Sammy Castro "+"\n"
            + "C.I.: V-20061840"+"\n"
            + "Intensivo 2018";
    Thread t;
    /**constructor por defecto con sus atributos inicializados */
    public Creditos(){
        this.w1 = new JWindow() ;
        this.fon= new JLabel();
        this.ti = new JTextArea(msj,600,500);
        this.t2 = new JTextArea();
        this.volver= new JButton();
        
    } 
    /**metodo para inicializar los atributos de la clase con sus respectivas imagenes*/
    public void inicializar(){
        w1.setLayout(null);
        w1.setBounds(110, 10, 800, 800);
        w1.getComponents();
        
        fon.setBounds(0, 0, 800, 800);
        ImageIcon gh=new ImageIcon("src/Imagenes/jum.jpg");
        ImageIcon icon= new ImageIcon(gh.getImage().getScaledInstance(w1.getWidth(), w1.getHeight(),Image.SCALE_DEFAULT));
        fon.setIcon(icon);
        fon.setOpaque(false);
        
        volver.setBounds(10, 20, 50, 50);
        ImageIcon imgg = new ImageIcon("src/ImagenesJuego/atras.png");
        ImageIcon icono= new ImageIcon(imgg.getImage().getScaledInstance(volver.getWidth(), volver.getHeight(),Image.SCALE_DEFAULT));
        volver.setBorder(null);
        volver.setContentAreaFilled(false);
        volver.setIcon(icono);
        
        
        volver.setBackground(Color.red);
        volver.setVisible(true);
        
        
        ti.setBounds(50,150, 600, 750);
        ti.setBorder(null);
        ti.setFont(new Font("Harrington",Font.BOLD,36));
        ti.setForeground(Color.CYAN);
        ti.setOpaque(false);
        fon.add(ti);
        fon.add(volver);
        w1.add(fon);
        
        w1.setVisible(true);
        /**se crea un metodo escuchador para el boton de volver al menu anterior*/
        volver.addMouseListener(new ManejaButton());
        
    }
   /**se crea un boton para volver al menu anterior*/
    public class ManejaButton extends MouseAdapter
    {
        public void mousePressed(MouseEvent e){
            if(e.getSource()==volver){
                w1.setVisible(false);
            }
        }
    }
    
}
