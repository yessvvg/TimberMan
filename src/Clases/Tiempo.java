/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
/**NO TOMAR EN CUENTA YA QUE NO SE PUDO IMPLEMENTAR*/
public class Tiempo extends JLabel {

    Timer t;
    int segundos;
    JButton play;

    public Tiempo() {
        t = new Timer();
        segundos = 0;
        setBounds(50, 50, 100, 100);
        play = new JButton(new ImageIcon(getClass().getResource("/ImagenesJuego/x.png")));//cambiar el icono para reproducir

        play.setBounds(50, 100, 100, 100);
        play.setBorderPainted(true);
        add(play);
        setForeground(Color.BLACK);

        setVisible(true);

        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {
                setText("Tiempo:" + segundos);
                segundos++;
            
                 if(segundos==60){t.cancel();}
            }
           
        };
        t.schedule(tarea, 1000, 1000);

    }

}
