package Clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class Instrucciones extends JFrame{
    
    /**se crean los atributos del la clase que hereda de un JFrame de manera 
     * anonima sin necesidad de crear el objeto*/
    private JWindow w1;
    private JTextArea ti,t2;
    private JButton volver;
    private JLabel fon;
    private String msj="Si crees que talar árboles sin que una"+"\n"
                        +"rama acabe contigo es una tarea fácil entonces"+"\n"
                        +"no has probado Timberman,el juego en el que"+"\n"
                        +"nos enfundaremos en una camisa de cuadros "+"\n"
                        +"de leñador,cogeremos un hacha bien afilada "+"\n"
                        +"e intentaremos batir el récord."+"\n"
                        +"El mecanismo es tan sencillo como cualquier"+"\n"
                        +"otro juego casual Arcade: cada vez que pulsemos"+"\n"
                        +"una tecla, realizaremos un corte sobre el árbol."+"\n"
                        +"Cuando veamos una rama caer sobre nosotros, "+"\n"
                        +"tendremos que cambiar el lado del tronco en el "+"\n"
                        +"que estamos, esto lo hacemos con las teclas "+"\n"
                        +"de flechas(izquierda o derecha)."+"\n";
    
    int y=501,dy=30;
    Thread t;
    
    /**se crea un constructor por defecto para la inicializacion de los atributos de la clase*/
    public Instrucciones() {
        this.w1 = new JWindow() ;
        this.fon= new JLabel();
        this.ti = new JTextArea(msj,600,500);
        this.t2 = new JTextArea();
        this.volver= new JButton();
        
    }
    
     /**se crea un metodo para la inicializacion de los atributos de la clase*/
    public void inicializar(){
        w1.setLayout(null);
        w1.setBounds(120, 10, 800, 800);
        w1.getComponents();
        
        fon.setBounds(0, 0, 800, 800);
        ImageIcon gh=new ImageIcon("src/Imagenes/madera.png");
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
        
        
        ti.setBounds(100,50, 600, 750);
        ti.setBorder(null);
        ti.setFont(new Font("Harrington",Font.BOLD,28));
        ti.setForeground(Color.WHITE);
        ti.setOpaque(false);
        /**se añaden los objetos a la ventana, es decir aqui en esta seccion usamos una window para mostrar las instrucciones*/
        fon.add(ti);
        fon.add(volver);
        w1.add(fon);
        w1.setVisible(true);
        volver.addMouseListener(new ManejaButton());
        
    }
    /**se crea un metodo para el boton que regresara a la pantalla principal del programa*/
    public class ManejaButton extends MouseAdapter
    {
        public void mousePressed(MouseEvent e){
            if(e.getSource()==volver){
                w1.setVisible(false);
            }
        }
    }
    
}
