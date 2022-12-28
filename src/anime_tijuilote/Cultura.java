package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Cultura extends Atributos{
    private String Manga;
    private String Anime;
    private String Juegos;

    public Cultura() {
        super();
        this.Manga = "";
        this.Anime = "";
        this.Juegos = "";
    }

    public Cultura(String Nombre, String Genero,String Manga, String Anime, String Juegos) {
        super(Nombre, Genero);
        this.Manga = Manga;
        this.Anime = Anime;
        this.Juegos = Juegos;
    }

    public void setManga(String Manga) {
        this.Manga = Manga;
    }

    public void setAnime(String Anime) {
        this.Anime = Anime;
    }

    public void setJuegos(String Juegos) {
        this.Juegos = Juegos;
    }

    public String getManga() {
        return Manga;
    }

    public String getAnime() {
        return Anime;
    }

    public String getJuegos() {
        return Juegos;
    }
    
    public void LeerGUI (int i){
        super.LeerGUI(i);
        Manga = JOptionPane.showInputDialog("Ingrese el manga del anime # "+(i+1));
        Anime = JOptionPane.showInputDialog("Ingrese el anime # "+(i+1));
        Juegos = JOptionPane.showInputDialog("Ingrese el videojuego del anime # "+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \t %s \t ",Manga,Anime,Juegos);
    }
    
}
