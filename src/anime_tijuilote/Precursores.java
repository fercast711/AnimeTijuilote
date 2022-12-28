package anime_tijuilote;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.PrintWriter;

public class Precursores extends Personas{
    private String Primer_Obra;
    private String Ultima_Obra;
    private String Obra_Famosa;

    public Precursores() {
        super();
        this.Primer_Obra = "";
        this.Ultima_Obra = "";
        this.Obra_Famosa = "";
    }

    public Precursores(String Nombre, char Genero, String Primer_Obra, String Ultima_Obra, String Obra_Famosa) {
        super(Nombre, Genero);
        this.Primer_Obra = Primer_Obra;
        this.Ultima_Obra = Ultima_Obra;
        this.Obra_Famosa = Obra_Famosa;
    }

    public void setPrimer_Obra(String Primer_Obra) {
        this.Primer_Obra = Primer_Obra;
    }

    public void setUltima_Obra(String Ultima_Obra) {
        this.Ultima_Obra = Ultima_Obra;
    }

    public void setObra_Famosa(String Obra_Famosa) {
        this.Obra_Famosa = Obra_Famosa;
    }

    public String getPrimer_Obra() {
        return Primer_Obra;
    }

    public String getUltima_Obra() {
        return Ultima_Obra;
    }

    public String getObra_Famosa() {
        return Obra_Famosa;
    }
    
    public void LeerGUI(int i){
        super.LeerGUI(i);
        Primer_Obra = JOptionPane.showInputDialog("Ingrese la primer obra del precursor #"+(i+1));
        Ultima_Obra = JOptionPane.showInputDialog("Ingrese la ultima obra del precursor #"+(i+1));
        Obra_Famosa = JOptionPane.showInputDialog("Ingrese la obra mas famosa del precursor #"+(i+1));
    }
    public void Guardar(PrintWriter Linea)throws IOException{
        super.Guardar(Linea);
        Linea.printf("%s \t %s \t %s \n ",Primer_Obra,Ultima_Obra,Obra_Famosa);
    }
}
