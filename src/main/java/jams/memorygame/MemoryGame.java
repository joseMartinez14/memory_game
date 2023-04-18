package jams.memorygame;

import jams.GameController.Controller;
import jams.GameModel.Model;
import jams.GameView.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Hello world!
 *
 */
public class MemoryGame {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        Thread t1 = new Thread() {
            public void run() {
                try {
                    playMusic();
                } catch (IOException ex) {
                    Logger.getLogger(MemoryGame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JavaLayerException ex) {
                    Logger.getLogger(MemoryGame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t1.start();
        View view = new View();
        Model m1 = new Model();
        Controller controller = new Controller(m1, view);
        view.setVisible(true);
        controller.IniciarPartida();
    }

    public static void playMusic() throws FileNotFoundException, IOException, JavaLayerException {
        FileInputStream fileInputStream = new FileInputStream(
                "src\\main\\java\\jams\\memorygame\\GOT Song2.mp3");
        Player player = new Player(fileInputStream);
        player.play();
    }
}
