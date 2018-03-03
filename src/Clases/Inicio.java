package Clases;

import Implementacion.ObjetosVentana;
import java.awt.Image;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Inicio implements Runnable {
/**atributs de la clase inicio, aqui en esta clase se genera una ventana de introduccion*/
    private JFrame f;
    private Window w;
    private ImageIcon madera;
    private JLabel fondo,l1, l2, l3, l4, l5, l6, l7, l8, l9;
    int x = 50, dx = 20;
    int y = -1, dy = 20;

    Thread t;
/**constructor por defecto inicializando sus atributos y componentes*/
    public Inicio() {
        this.f = new JFrame();
        this.w = new Window(f);
        this.fondo= new JLabel();
        this.l1 = new JLabel();
        this.l2 = new JLabel();
        this.l3 = new JLabel();
        this.l4 = new JLabel();
        this.l5 = new JLabel();
        this.l6 = new JLabel();
        this.l7 = new JLabel();
        this.l8 = new JLabel();
        this.l9 = new JLabel();
        initComponents();
    }
    
    /**se inicializan los componentes*/
    public void initComponents(){
            
            w.setLayout(null);
            w.setBounds(100, 100, 800, 800);
            w.setLocationRelativeTo(null);
            
            madera = new ImageIcon(getClass().getResource("/Imagenes/madera.png"));
            ImageIcon md=new ImageIcon(madera.getImage().getScaledInstance(w.getWidth(), w.getHeight(), Image.SCALE_DEFAULT));
            fondo.setIcon(md);
            fondo.setBounds(0, 0, 800, 800);
            
            w.add(fondo);
            l1.setBounds(0, y, 80, 80);
            l2.setBounds(80, y, 80,80);
            l3.setBounds(160, y, 80, 80);
            l4.setBounds(240, y, 80, 80);
            l5.setBounds(320, y, 80, 80);
            l6.setBounds(400, y, 80, 80);
            l7.setBounds(560, y, 80, 80);
            l8.setBounds(640, y, 80, 80);
            l9.setBounds(720, y, 80, 80);
            
            /**se invoca al metodo cargar imagen para cada una de las letras que se van arrastrando hacia abajo*/
            cargarimagen(l1, 0);
            l1.setOpaque(false);
            cargarimagen(l2, 1);
            l2.setOpaque(false);
            cargarimagen(l3, 2);
            l3.setOpaque(false);
            cargarimagen(l4, 3);
            l4.setOpaque(false);
            cargarimagen(l5, 4);
            l5.setOpaque(false);
            cargarimagen(l6, 5);
            l6.setOpaque(false);
            cargarimagen(l7, 2);
            l7.setOpaque(false);
            cargarimagen(l8, 7);
            l8.setOpaque(false);
            cargarimagen(l9, 8);
            l9.setOpaque(false);
            w.setVisible(true);
           
    }
    
    /**invocamos un metodo para la animacion de las letras llamado run y que invoca al metodo mover de cada uno de los 
     labels*/
    @Override
    public void run() {
        try {
            mover(l1, 0);
            mover(l2, 80);
            mover(l3, 160);
            mover(l4, 240);
            mover(l5, 320);
            mover(l6, 400);
            mover(l7, 560);
            mover(l8, 640);
            mover(l9, 720);
            
            t.sleep(1000);
            
            w.setVisible(true);
        } catch (InterruptedException ex) {
           
        }

        w.setVisible(false);
     /**hacemos llamado a un objeto de la clase ObjetosVentana donde llamara a la ventana principal que es el menu*/
        ObjetosVentana o = new ObjetosVentana();
   
        
    }

    /**se mueve cada una de las letras hacia abajo durante una fraccion de tiempo determinado*/
    public void mover(JLabel l, int x) throws InterruptedException {
        int y = -1;
        //
        do {
            
            fondo.add(l);
            l.move(x, y);
            t.sleep(30);
            y += dy;

        } while (y <= 250);
        
    }

    /**se crea el metodo cargar Imagen para cargar las letra*/
    public void cargarimagen(JLabel l, int i) {

        ImageIcon img = new ImageIcon("src/Imagenes/" + i + ".png");
        ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
        l.setIcon(icon);
        
    }
}
