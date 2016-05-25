/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author MiguelAngel
 */
public class Carro extends JPanel implements ActionListener{

    private int delay;
    private int x;
    private int dx;
    public Rectangle cuadrado;
    private Rectangle caja;
    protected Timer timer;

    public void actionPerformed(ActionEvent e) {
            mover();
            repaint();
        }
    public Carro() {
        this.delay = 5;
        this.x = 0;
        this.dx = 2;
        this.timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(20 + this.x+dx, 110, 50, 50);
        g.setColor(Color.blue);
        g.fillOval(90 + this.x, 110, 50, 50);
        g.setColor(Color.yellow);
        g.fillRect(10 + this.x, 60, 150, 50);
        Polygon poligono = new Polygon();
        poligono.addPoint(30 + this.x, 60);
        poligono.addPoint(60 + this.x, 30);
        poligono.addPoint(110 + this.x, 30);
        poligono.addPoint(140 + this.x, 60);
        g.drawPolygon(poligono);
        g.setColor(Color.GREEN);
        g.fillPolygon(poligono);
        g.drawRect(10 + this.x, 10, 150, 150);
        g.drawRect(1, 1, 1098, 598);
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    

    public void mover() {
        if(x == 950){
            x=0;
        }
        x += dx;
    }

    public void suspend() {
        timer.stop();
    }

    public void resume() {
        timer.start();
    }

    public void reiniciar() {
        timer.restart();
    }

    public Rectangle ObtenerRectangulo1() {
        cuadrado = new Rectangle(10 + x, 10, 150, 150);
        return cuadrado;

    }

    public Rectangle ubicacion() {
        caja = new Rectangle(1, 1, 1098, 598);
        return caja;
    }

    public void choque() {
        if (cuadrado.intersects(caja)) {
            reiniciar();

        }
    }

    public void setDelay(int delay) {
        timer.setDelay(delay);
        timer.stop();
        timer.start();
    }
}
