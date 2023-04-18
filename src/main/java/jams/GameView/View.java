/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jams.GameView;

import jams.GameController.Controller;
import jams.GameModel.Model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andrés
 */
public class View extends JFrame implements Observer {
    Model model;
    Controller controller;
    // private JPanel panel;
    BufferedImage Arya;
    BufferedImage Cercei;
    BufferedImage Daenarys;
    BufferedImage Drogon;
    BufferedImage Jaime;
    BufferedImage Jon;
    BufferedImage Jorah;
    BufferedImage Margaery;
    BufferedImage Melisandre;
    BufferedImage Tyrion;

    public View() throws IOException {

        Arya = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Arya.jpg"));
        Cercei = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Cercei.jpg"));
        Daenarys = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Daenarys.jpg"));
        Drogon = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Drogon.jpg"));
        Jaime = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Jaime.jpg"));
        Jon = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Jon.jpg"));
        Jorah = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Jorah.jpg"));
        Margaery = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Margaery.jpg"));
        Melisandre = ImageIO
                .read(new File("src\\main\\java\\jams\\GameView\\Melisandre.jpg"));
        Tyrion = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Tyrion.jpg"));

        setSize(800, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inicializar() {
        this.setLayout(new GridLayout(4, 5));
        for (int i = 0; i < model.getFilas(); i++) {
            for (int j = 0; j < model.getColumnas(); j++) {
                model.getCasilla(i, j).setBorder(BorderFactory.createLineBorder(Color.blue));
                model.getCasilla(i, j).addMouseListener(this.controller);
                this.add(model.getCasilla(i, j));
            }
        }
    }

    public void agregarImagen() {
        for (int i = 0; i < model.getFilas(); i++) {
            for (int j = 0; j < model.getColumnas(); j++) {
                model.getCasilla(i, j).setPersonaje(elegir(model.getCasilla(i, j).getId()));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < model.getFilas(); i++) {
            for (int j = 0; j < model.getColumnas(); j++) {
                g.drawImage(model.getCasilla(i, j).getPersonaje(), model.getCasilla(i, j).getX() + 12,
                        model.getCasilla(i, j).getY() + 30, null);
            }
        }

    }

    public BufferedImage elegir(String id) {
        if ("1".equals(id))
            return Arya;
        if ("2".equals(id))
            return Cercei;
        if ("3".equals(id))
            return Daenarys;
        if ("4".equals(id))
            return Drogon;
        if ("5".equals(id))
            return Jaime;
        if ("6".equals(id))
            return Jon;
        if ("7".equals(id))
            return Jorah;
        if ("8".equals(id))
            return Margaery;
        if ("9".equals(id))
            return Melisandre;
        if ("10".equals(id))
            return Tyrion;
        return null;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
        this.getContentPane().addMouseListener(controller);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

}
