/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jams.GameController;

import jams.GameModel.Casilla;
import jams.GameModel.Model;
import jams.GameView.View;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Andrés
 */
public class Controller extends MouseAdapter {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        model.addObserver(view);
        for (int i = 0; i < model.getFilas(); i++) {
            for (int j = 0; j < model.getColumnas(); j++) {
                model.getCasilla(i, j).addMouseListener(this);
            }
        }
    }

    public void IniciarPartida() {
        view.inicializar();
        model.shuffle();
        view.agregarImagen();
        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Casilla temp = (Casilla) e.getSource();
        model.intento(temp);
        view.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
