/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jams.GameModel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Andrés
 */
public class Casilla extends JPanel {
    private boolean encontrado;
    private String id;
    BufferedImage personaje;
    BufferedImage Logo;

    public Casilla() throws IOException {
        this.encontrado = false;
        this.id = "Not set";
        Logo = ImageIO.read(new File("src\\main\\java\\jams\\GameView\\Logo.jpg"));
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BufferedImage getPersonaje() {
        if (encontrado)
            return personaje;
        else
            return Logo;
    }

    public void setPersonaje(BufferedImage personaje) {
        this.personaje = personaje;
    }

}
