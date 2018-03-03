package Clases;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class Jugar extends JPanel {

    /**se crean los atributos de la clase y atributos auxiliares para usos en la clase*/
    private JFrame ventana;

    private ImageIcon fondo;
    private JLabel f;
    private JLabel uno, dos, tres, cuatro, cinco, seis, siete, ocho,ax1,ax2;
    private JLabel l1, etiqueta,etip,con;
    
    AudioClip hacha,gameo,pun;



    int aux1 = 1;
    int z,ff,cont=0,puntos=0;
    int aux2 = 2;
    int auxAXE = 3;
    int aux4 = 4;
    int aux5 = 5;
    private String nombre;

    /**se inicializan los atributos de la clase*/
    public Jugar(String nombre) throws InterruptedException {
        this.nombre=nombre;
        ventana = new JFrame("Timber-Man");
        dos = new JLabel();
        tres = new JLabel();
        cuatro = new JLabel();
        cinco = new JLabel();
        seis = new JLabel();
        siete = new JLabel();
        ocho = new JLabel();
        ax1 = new JLabel();
        ax2 = new JLabel();
        etiqueta=new JLabel();
        etip=new JLabel();
        con=new JLabel();
        ventana.setSize(800, 800);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);

             /**se inicializan la carga de imagenes de cada uno de los objetos de la clase*/
        ventana.setIconImage(new ImageIcon(getClass().getResource("/ImagenesJuego/icono.jpg")).getImage());

        fondo = new ImageIcon(ventana.getClass().getResource("/ImagenesJuego/xx.jpg"));

        ImageIcon fondox = new ImageIcon(fondo.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));

        f = new JLabel();

        f.setIcon(fondox);
        
            /**se generan los sonidos para la clase*/
            hacha= java.applet.Applet.newAudioClip(ventana.getClass().getResource("/Sonido/laser.wav"));
        pun= java.applet.Applet.newAudioClip(ventana.getClass().getResource("/Sonido/0x0C.wav"));
        gameo= java.applet.Applet.newAudioClip(ventana.getClass().getResource("/Sonido/game_over.wav"));
        
        
        
        
        
        
        etiqueta.setBounds(10, 20, 100, 100);
        ImageIcon fdfg= new ImageIcon("src/ImagenesJuego/can1.png");
        ImageIcon etiq = new ImageIcon(fdfg.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT));
        
        etiqueta.setHorizontalTextPosition(SwingConstants.CENTER);
        etiqueta.setFont(new Font("Harrington", Font.BOLD, 24));
        etiqueta.setForeground(Color.WHITE);
        
        etiqueta.setText(nombre);
        etiqueta.setIcon(etiq);
        etiqueta.setOpaque(false);
        etiqueta.setVisible(true);
        etip.setBounds(10, 120, 100, 100);
        ImageIcon et= new ImageIcon("src/ImagenesJuego/can1.png");
        ImageIcon etipe = new ImageIcon(et.getImage().getScaledInstance(etip.getWidth(), etip.getHeight(), Image.SCALE_DEFAULT));
        etip.setHorizontalTextPosition(SwingConstants.CENTER);
        etip.setFont(new Font("Harrington", Font.BOLD, 24));
        etip.setForeground(Color.WHITE);
        etip.setOpaque(false);
        etip.setIcon(etipe);
        etip.setVisible(true);
        con.setBounds(10, 220, 100, 100);
        ImageIcon c= new ImageIcon("src/ImagenesJuego/can1.png");
        ImageIcon co = new ImageIcon(c.getImage().getScaledInstance(con.getWidth(), con.getHeight(), Image.SCALE_DEFAULT));
        con.setHorizontalTextPosition(SwingConstants.CENTER);
        con.setFont(new Font("Harrington", Font.BOLD, 24));
        con.setForeground(Color.WHITE);
        con.setOpaque(false);
        con.setIcon(co);
        con.setVisible(true);
        uno = new JLabel(new ImageIcon(getClass().getResource("/Tronco/0.png")));

        uno.setBounds(293, 686, 190, 100);
            
        /**se llama al metodo cargarI para hacer la carga de los troncos*/
        cargarI(dos, 1, 588);
        cargarI(tres, 1, 490);
        cargarI(cuatro, 1, 392);
        z=Al(1);
        cargarI(cinco, z, 294);
        z=Al(z);
        cargarI(seis, z, 196);
        z=Al(z);
        cargarI(siete, z, 98);
        z=Al(z);
        cargarI(ocho, z, 0);

        
        l1 = new JLabel();
        l1.setBounds(100, 490, 206, 191);
        cargarImagenes(l1, 2);
        l1.setVisible(true);
        l1.setFocusable(true);
      
        ax1.setVisible(false);
        ax2.setOpaque(false);
        ax1.setOpaque(false);
        ax2.setVisible(false);
        
          /**se añaden los objetos a la ventana*/
        ventana.add(etiqueta);
        ventana.add(etip);
        ventana.add(con);
        ventana.add(l1);
        ventana.add(uno);
        ventana.add(dos);
        ventana.add(tres);
        ventana.add(cuatro);
        ventana.add(cinco);
        ventana.add(seis);
        ventana.add(siete);
        ventana.add(ocho);
        ventana.add(ax1);
        ventana.add(ax2);
        ventana.add(f);

   
   cont=0;
   /**  se invoca al metodo para mover el personaje*/
        personajeMov();

    }

    
/**aqui se crean las imagenes para el personaje y se llamaran en el metodo personajeMov(); */
    public void cargarImagenes(JLabel l, int i) {
        
            ImageIcon img = new ImageIcon("src/Personaje/"+i+".png");
            ImageIcon icono= new ImageIcon(img.getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT));
            l.setIcon(img);
        
    }
/**se crea el metodo colision para validar el arbol*/
    public void colision(boolean ban,int x) {
        if(ban==true){
        if(x==100){
            /**sonidos del hacha*/
            hacha.stop();
            hacha.play();
            
            int j=Integer.parseInt(dos.getText());
            cargarI(ax1, j, 588);
            ax1.move(ax1.getX()+50, ax1.getY());
            ax1.setOpaque(true);
            cargarImagenes(l1, 3);
            
            dos.setVisible(false);
             /**sonidos del juego*/
            gameo.play();
            
            
            ax1.setVisible(true);
            f.add(ax1);
            cont++;
            puntos+=10;
            /**sonidos de puntos*/
            pun.play();


            
            etip.setText(String.valueOf(puntos));
            con.setText(String.valueOf(cont));
            j=Integer.parseInt(tres.getText());
            cargarI(dos, j, 588);
            ax1.setVisible(false);
            dos.setVisible(true);
            j=Integer.parseInt(cuatro.getText());
            cargarI(tres, j, 490);
            tres.setVisible(true);
            if(l1.getBounds().intersects(tres.getBounds()) ||l1.getBounds().intersects(dos.getBounds())){
                ventana.setVisible(false);
            }
            j=Integer.parseInt(cinco.getText());
            cargarI(cuatro, j, 392);
            cuatro.setVisible(true);
            j=Integer.parseInt(seis.getText());
            cargarI(cinco, j, 294);
            cinco.setVisible(true);
            j=Integer.parseInt(siete.getText());
            cargarI(seis, j, 196);
            seis.setVisible(true);
            j=Integer.parseInt(ocho.getText());
            cargarI(siete, j, 98);
            siete.setVisible(true);
            cargarI(ax1,1, 0);
            dos.setVisible(true);
            cargarImagenes(l1, 2);
        }    
        if(x==450){
             /**sonidos del hacha*/
            hacha.stop();
            hacha.play();
            
            int j=Integer.parseInt(dos.getText());
            cargarI(ax1, j, 588);
            ax1.move(ax1.getX()-50, ax1.getY());
            ax1.setOpaque(true);
            cargarImagenes(l1, 1);
            
            
            dos.setVisible(false);
                  /**sonidos del juego*/
               gameo.play();
               
               
            ax1.setVisible(true);
            f.add(ax1);
            cont++;
            puntos+=10;
              /**sonidos de puntos*/
            pun.play();
            
            etip.setText(String.valueOf(puntos));
            con.setText(String.valueOf(cont));
            j=Integer.parseInt(tres.getText());
            cargarI(dos, j, 588);
            ax1.setVisible(false);
            dos.setVisible(true);
            j=Integer.parseInt(cuatro.getText());
            cargarI(tres, j, 490);
            tres.setVisible(true);
            if(l1.getBounds().intersects(tres.getBounds()) ||l1.getBounds().intersects(dos.getBounds())){
                ventana.setVisible(false);
            }
            j=Integer.parseInt(cinco.getText());
            cargarI(cuatro, j, 392);
            cuatro.setVisible(true);
            j=Integer.parseInt(seis.getText());
            cargarI(cinco, j, 294);
            cinco.setVisible(true);
            j=Integer.parseInt(siete.getText());
            cargarI(seis, j, 196);
            seis.setVisible(true);
            j=Integer.parseInt(ocho.getText());
            cargarI(siete, Al(j), 98);
            siete.setVisible(true);
            cargarI(ax1,Al(j), 0);
            dos.setVisible(true);
            cargarImagenes(l1, 1);
        }    
            ban=false;
        }
    }
/**se generan aleatoriamente los troncos por partes del arbol es decir cada pieza del arbol esta separada por tronco*/
    public int Al(int z) {
        
        ff=(int) (Math.random() * 3 + 1);
        
        if(ff==2 && z==1){
            ff=2;
        }
        if(ff==3 && z==1){
            ff=3;
        }
        if(ff!=1 && z==1){
          ff=ff;
        }
        
        return ff;
        
    }
    
/**se crea al metodo cargarI para hacer la carga de los troncos*/
    public void cargarI(JLabel l, int i, int y) {
        ImageIcon img = new ImageIcon("src/Tronco/" + i + ".png");
        if (i == 1) {
            l.setBounds(349, y, 82, 100);
            l.setOpaque(false);
            l.setText("1");
        }
        if (i == 2) {
            l.setBounds(349, y, 316, 100);
            l.setOpaque(false);
            l.setText("2");
        }
        if (i == 3) {
            l.setBounds(103, y, 329, 100);
            l.setOpaque(false);
            l.setText("3");
        }
        l.setIcon(img);
    }
/**se crea al metodo personajeMov(); para hacer la carga de los troncos*/
    public void personajeMov() {

        l1.addKeyListener(new KeyListener() {
        int zkey;
        
            @Override
            public void keyPressed(KeyEvent ke) {
                

                if (ke.getKeyCode() == ke.VK_LEFT){
                    cargarImagenes(l1, 2);
                    if(l1.getX()>100){
                        l1.move(l1.getX()-350, l1.getY());
                    }
                    if(zkey==ke.getKeyCode()){
                        colision(true,100);
                        
                    }
                }

                if (ke.getKeyCode() == ke.VK_RIGHT){
                    cargarImagenes(l1, 5);
                    if(l1.getX()<450){
                        l1.move(l1.getX()+350, l1.getY());
                    }
                    if(zkey==ke.getKeyCode()){
                        colision(true,450);
                        
                    }
                }
                zkey=ke.getKeyCode();
            }

            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
    }
}
