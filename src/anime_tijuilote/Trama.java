package anime_tijuilote;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class Trama extends Atributos{
    private String Sinopsis;

    public Trama() {
        super();
        this.Sinopsis = "";
    }

    public Trama(String Nombre, String Genero,String Sinopsis) {
        super(Nombre, Genero);
        this.Sinopsis = Sinopsis;
    }
    
    //void

    public void setSinopsis(String Sinopsis) {
        this.Sinopsis = Sinopsis;
    }
    
    //funciones

    public String getSinopsis() {
        return Sinopsis;
    }
    
    
    public void LeerGUI (int i){
        super.LeerGUI(i);
        Sinopsis = JOptionPane.showInputDialog("Ingrese el sinopsis del anime # "+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \n",Sinopsis);
    }
}
