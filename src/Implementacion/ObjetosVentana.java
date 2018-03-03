package Implementacion;
import Clases.Creditos;
import Clases.Instrucciones;
import Clases.Usuario;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import javax.swing.*;

public class ObjetosVentana {
/**atributos de la clase objetos ventana*/
    private JFrame ventana;
    private JButton b1, b2, b3, b4;
    private JLabel f;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;

    /**Constructor por defecto inicializando cada uno de los atributos de la clase*/
    public ObjetosVentana() {
        ventana = new JFrame("TimberMan");
        ventana.setBounds(100, 100, 800, 700);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
      
        ventana.setResizable(false);
        f = new JLabel();
        this.l1 = new JLabel();
        this.l2 = new JLabel();
        this.l3 = new JLabel();
        this.l4 = new JLabel();
        this.l5 = new JLabel();
        this.l6 = new JLabel();
        this.l7 = new JLabel();
        this.l8 = new JLabel();
        this.l9 = new JLabel();
        f.setBounds(0, 0, 800, 700);
        
        
        ventana.setIconImage(new ImageIcon(getClass().getResource("/ImagenesJuego/icono.jpg")).getImage());
        ImageIcon fondo = new ImageIcon("src/ImagenesJuego/jeje.jpg");
        ImageIcon fondox = new ImageIcon(fondo.getImage().getScaledInstance(f.getWidth(), f.getHeight(),Image.SCALE_DEFAULT));
        
        f.setIcon(fondox);
        f.setVisible(true);
        //f.setOpaque(false);
        

        l1.setBounds(220, 250, 60, 60);
        l2.setBounds(280, 250, 60,60);
        l3.setBounds(340, 250, 60, 60);
        l4.setBounds(400, 250, 60, 60);
        l5.setBounds(460, 250, 60, 60);
        l6.setBounds(520, 250, 60, 60);
        l7.setBounds(310, 350, 60, 60);
        l8.setBounds(370, 350, 60, 60);
        l9.setBounds(430, 350, 60, 60);
        
        /**se invoca al metodo cargar imagen para el menu principal y se le da
         memoria a todos los botones con sus respectivos iconos*/
        
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
        b1 = new JButton("Nuevo Juego");
        b1.setBounds(365, 410, 60, 60);
        ImageIcon ng=new ImageIcon("src/ImagenesJuego/play.png");
        ImageIcon newga=new ImageIcon(ng.getImage().getScaledInstance(b1.getWidth(), b1.getHeight(), Image.SCALE_DEFAULT));
        b1.setContentAreaFilled(false);
        b1.setBorder(null);
        b1.setIcon(newga);
        b2 = new JButton("Instrucciones");
        b2.setBounds(365, 470, 60, 60);
        ImageIcon ins=new ImageIcon("src/ImagenesJuego/inf.png");
        ImageIcon in=new ImageIcon(ins.getImage().getScaledInstance(b2.getWidth(), b2.getHeight(), Image.SCALE_DEFAULT));
        b2.setContentAreaFilled(false);
        b2.setBorder(null);
        b2.setIcon(in);
        b3 = new JButton("Creditos");
        b3.setBounds(365, 530, 60, 60);
        ImageIcon cre=new ImageIcon("src/ImagenesJuego/jijiji.png");
        ImageIcon cr=new ImageIcon(cre.getImage().getScaledInstance(b3.getWidth(), b3.getHeight(), Image.SCALE_DEFAULT));
        b3.setContentAreaFilled(false);
        b3.setBorder(null);
        b3.setIcon(cr);
        b4 = new JButton("Salir");
        b4.setBounds(365, 590, 60, 60);
        ImageIcon sal=new ImageIcon("src/ImagenesJuego/x.png");
        ImageIcon sa=new ImageIcon(sal.getImage().getScaledInstance(b4.getWidth(), b4.getHeight(), Image.SCALE_DEFAULT));
        b4.setContentAreaFilled(false);
        b4.setBorder(null);
        b4.setIcon(sa);
        /**se agregan todos los objetos a la ventana*/
        ventana.add(b1);
        ventana.add(b2);
        ventana.add(b3);
        ventana.add(b4);
       
        ventana.add(l1);
        ventana.add(l2);
        ventana.add(l3);
        ventana.add(l4);
        ventana.add(l5);
        ventana.add(l6);
        ventana.add(l7);
        ventana.add(l8);
        ventana.add(l9);
        ventana.add(f);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**se agregan escuchadores a cada uno de los botones y se les da memoria
         */
        b1.addMouseListener(new ManejaButton());
        b2.addMouseListener(new ManejaButton());
        b3.addMouseListener(new ManejaButton());
        b4.addMouseListener(new ManejaButton());
    }
    
    /**se crea un metodo ManejaButton que fue llamado arriba en el constructor para 
     cada uno de los botones y en cada boton se llama a un objeto de la clase a invocar,
     es decir en el boton uno se llama al objetoUsuario, en el boton2 se llama la ventana de instrucciones
     en el boton3 se inicializan los creditos y en el boton cuatro se sale del programa*/
    public class ManejaButton extends MouseAdapter
    {
    
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == b1) {
                    Usuario obj = new Usuario();
                    obj.AceptarCancelar();

                }
                if (e.getSource() == b2) {
                    Instrucciones i=new Instrucciones();
                    i.inicializar();
                }
                if (e.getSource() == b3) {
                    Creditos c=new Creditos();
                    c.inicializar();
                   
                }
         
                if (e.getSource() == b4) {
                    System.exit(0);
                }
            }
        
    }
    
    /**aqui se cargan las imagenes para el menu*/
    public void cargarimagen(JLabel l, int i) {

        ImageIcon img = new ImageIcon("src/Imagenes/" + i + ".png");
        ImageIcon icon = new ImageIcon(img.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
        l.setIcon(icon);
        
    }
}