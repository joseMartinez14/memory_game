/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jams.GameModel;

import java.io.IOException;
import java.util.Observable;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Andrés
 */
public class Model extends Observable {

    private Casilla casillas[][];
    private Casilla primeraCasilla;
    private Casilla segundaCasilla;
    private int filas, columnas;

    public Model() throws IOException {
        casillas = new Casilla[4][5];
        filas = 4;
        columnas = 5;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                casillas[i][j] = new Casilla();
            }
        }
        primeraCasilla = null;
        segundaCasilla = null;
    }

    public void shuffle() {
        int numeros = 1, cant = 0;
        Random aleatorio = new Random(System.currentTimeMillis());
        int numeroRandomFil, numeroRandomCol;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                do {
                    numeroRandomFil = aleatorio.nextInt(4);
                    numeroRandomCol = aleatorio.nextInt(5);
                } while (casillas[numeroRandomFil][numeroRandomCol].getId().length() <= 3);
                casillas[numeroRandomFil][numeroRandomCol].setId(Integer.toString(numeros));
                if (cant % 2 == 1)
                    numeros++;
                cant++;
            }
        }
    }

    public void intento(Casilla intento) {
        if (primeraCasilla == null) {
            primeraCasilla = intento;
            intento.setEncontrado(true);
            return;
        } else {
            if (segundaCasilla == null && primeraCasilla != intento) {
                segundaCasilla = intento;
                intento.setEncontrado(true);
                return;
            }
        }
        if (primeraCasilla.getId() == null ? segundaCasilla.getId() != null
                : !primeraCasilla.getId().equals(segundaCasilla.getId())) {
            primeraCasilla.setEncontrado(false);
            segundaCasilla.setEncontrado(false);
            primeraCasilla = null;
            segundaCasilla = null;
        } else {
            primeraCasilla = null;
            segundaCasilla = null;
        }
    }

    public boolean ganar() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].isEncontrado())
                    return false;
            }
        }
        return true;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public Casilla getPrimeraCasilla() {
        return primeraCasilla;
    }

    public Casilla getSegundaCasilla() {
        return segundaCasilla;
    }

    public Casilla getCasilla(int i, int j) {
        return casillas[i][j];
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

}
