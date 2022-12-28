package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Personaje extends Diseño{
    private String Personaje;
    private char Gen;
    private String Personalidad;

    public Personaje() {
        super();
        this.Personaje = "";
        this.Gen = ' ';
        this.Personalidad = "";
    }

    public Personaje(String Nombre, String Genero,String Casa_Animacion, String Personaje, char Gen, String Personalidad ) {
        super(Nombre, Genero, Casa_Animacion);
        this.Personaje = Personaje;
        this.Gen = Gen;
        this.Personalidad = Personalidad;
    }

    public void setPersonaje(String Personaje) {
        this.Personaje = Personaje;
    }

    public void setGen(char Gen) {
        this.Gen = Gen;
    }

    public void setPersonalidad(String Personalidad) {
        this.Personalidad = Personalidad;
    }

    public String getPersonaje() {
        return Personaje;
    }

    public char getGen() {
        return Gen;
    }

    public String getPersonalidad() {
        return Personalidad;
    }

    

    public void LeerGUI (int i){
        super.LeerGUI(i);
        Personaje = JOptionPane.showInputDialog("Ingrese el nombre del personaje del anime #"+(i+1));
        try{
        Gen = JOptionPane.showInputDialog("Ingrese el genero del personaje del anime #"+(i+1)).charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Gen = ' ';
        }catch(java.lang.NullPointerException e){
            Gen = ' ';
        }
        Personalidad = JOptionPane.showInputDialog("Ingrese la personalidad del personaje del anime #"+(i+1));
    }
    
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \t %s \n",Personaje,Gen,Personalidad);
    }
}
