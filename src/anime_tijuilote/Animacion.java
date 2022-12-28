package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Animacion extends Diseño{
    private String Animadores;
    private String Tipo;

    public Animacion() {
        super();
        this.Animadores = "";
        this.Tipo = "";
    }

    public Animacion(String Nombre, String Genero, String Casa_Animacion, String Animadores, String Tipo ) {
        super(Nombre, Genero, Casa_Animacion);
        this.Animadores = Animadores;
        this.Tipo = Tipo;
    }

    public void setAnimadores(String Animadores) {
        this.Animadores = Animadores;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getAnimadores() {
        return Animadores;
    }

    public String getTipo() {
        return Tipo;
    }

    public void LeerGUI (int i){
        super.LeerGUI(i);
        Animadores = JOptionPane.showInputDialog("Ingrese los animadores del anime # "+(i+1));
        Tipo = JOptionPane.showInputDialog("Ingrese el tipo de animacion del anime # "+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \n",Animadores,Tipo);
    }
}
    

