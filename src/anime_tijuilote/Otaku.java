package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Otaku extends Cultura{
    private int Mangas_Vendidos;
    private String Popularidad;
    private int Vidoejuegos_Vendidos;

    public Otaku() {
        super();
        this.Mangas_Vendidos = 0;
        this.Popularidad = "";
        this.Vidoejuegos_Vendidos = 0;
    }

    public Otaku( String Nombre, String Genero, String Manga, String Anime, String Juegos,int Mangas_Vendidos, String Popularidad, int Vidoejuegos_Vendidos) {
        super(Nombre, Genero, Manga, Anime, Juegos);
        this.Mangas_Vendidos = Mangas_Vendidos;
        this.Popularidad = Popularidad;
        this.Vidoejuegos_Vendidos = Vidoejuegos_Vendidos;
    }

    public void setMangas_Vendidos(int Mangas_Vendidos) {
        this.Mangas_Vendidos = Mangas_Vendidos;
    }

    public void setPopularidad(String Popularidad) {
        this.Popularidad = Popularidad;
    }

    public void setVidoejuegos_Vendidos(int Vidoejuegos_Vendidos) {
        this.Vidoejuegos_Vendidos = Vidoejuegos_Vendidos;
    }

    public int getMangas_Vendidos() {
        return Mangas_Vendidos;
    }

    public String getPopularidad() {
        return Popularidad;
    }

    public int getVidoejuegos_Vendidos() {
        return Vidoejuegos_Vendidos;
    }
    
    public void LeerGUI (int i){
        super.LeerGUI(i);
        try{
        Mangas_Vendidos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los mangas vendidos del anime # "+(i+1)));
        }catch(java.lang.NumberFormatException e){
           Mangas_Vendidos = 0;
        }
        Popularidad = JOptionPane.showInputDialog("Ingrese el personaje mas popular del anime # "+(i+1));
        try{
        Vidoejuegos_Vendidos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los videojuegos vendidos del anime # "+(i+1)));
        }catch(java.lang.NumberFormatException e){
        Vidoejuegos_Vendidos = 0;
        }
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \t %s \n ",Mangas_Vendidos,Popularidad,Vidoejuegos_Vendidos);
    }
}
