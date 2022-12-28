
package anime_tijuilote;
import java.io.FileReader;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
/*
Created!
You have successfully created a new database. The details are below.

Username: I66eN9EkOA

Database name: I66eN9EkOA

Password: eryxH5VrAn

Server: remotemysql.com

Port: 3306

These are the username and password to log in to your database and phpMyAdmin

Make sure you keep your password secure. Ensure you keep back ups of your database in case it gets deleted.
*/
public class GUI extends javax.swing.JFrame {
    ButtonGroup Menu = new ButtonGroup();
    ButtonGroup SubMenu = new ButtonGroup();
    DefaultTableModel Modelo;
    char OpMenu, OpSubM;
    
    Programa P = new Programa();
    Anime Arreglo[] = {};
    
    Connection Con;
    Statement Pila;
    ResultSet Resul;
    String  Consulta;
    
    FileReader Archivo, Archivo2, Archivo3, Archivo4, Archivo5,Archivo6, Archivo7,Archivo8,
            Archivo9, Archivo10, Archivo11;
    Scanner Datos;
    Iterator Mover;
    
    Anime A;
    
    char Leer;
    char Op;
    EleccionGUI G = new EleccionGUI();
    public GUI(char Op) {
        this.Op = Op;
        initComponents();
        Menu.add(jRB_Mostrar);
        Menu.add(jRB_Registrar);
        Menu.add(jRB_Guardar);
        Menu.add(jRB_Eliminar);
        Menu.add(jRB_Modificar);
        
        SubMenu.add(jRB_Trama);
        SubMenu.add(jRB_Otaku);
        SubMenu.add(jRB_Animacion);
        SubMenu.add(jRB_Personaje);
        SubMenu.add(jRB_Audio);
        SubMenu.add(jRB_Guion);
        SubMenu.add(jRB_Ingresos);
        SubMenu.add(jRB_Egresos);
        SubMenu.add(jRB_Series);
        SubMenu.add(jRB_Peliculas);
        SubMenu.add(jRB_Ovas);
        SubMenu.add(jRB_Directores);
        SubMenu.add(jRB_Precursores);
        SubMenu.add(jRB_Login);
        Bloquear(false);
        
        Leer = Op;
        //System.out.println(Leer);
        
        switch(Leer){
            case '1':
                 Seleccionar();
                break;
            case '2': 
                Exportar();
                break;
            default:
                throw new AssertionError();
        }
        
        
    }

    public void setLeer(char Leer) {
        this.Leer = Leer;
    }

    public char getLeer() {
        return Leer;
    }
    
    public void Bloquear(boolean Accion){
        this.jRB_Eliminar.setEnabled(Accion);
        this.jRB_Modificar.setEnabled(Accion);
        
        if( (Accion && OpMenu >= 'A' && OpMenu <= 'C') || !Accion ){
            this.jRB_Trama.setEnabled(Accion);
            this.jRB_Otaku.setEnabled(Accion);
            this.jRB_Animacion.setEnabled(Accion);
            this.jRB_Personaje.setEnabled(Accion);
            this.jRB_Audio.setEnabled(Accion);
            this.jRB_Guion.setEnabled(Accion);
            this.jRB_Ingresos.setEnabled(Accion);
            this.jRB_Egresos.setEnabled(Accion);
            this.jRB_Series.setEnabled(Accion);
            this.jRB_Peliculas.setEnabled(Accion);
            this.jRB_Ovas.setEnabled(Accion);
            this.jRB_Directores.setEnabled(Accion);
            this.jRB_Precursores.setEnabled(Accion);
            this.jRB_Login.setEnabled(Accion);
        }
        
        if( (Accion && OpMenu=='B') || !Accion ){
            this.jTF_Cant.setEnabled(Accion);
        }else{
            this.jTF_Cant.setEnabled(false);
        }
        
        if( (Accion && OpMenu >= 'D' && OpMenu <= 'E') || !Accion ){
            this.jTF_Pos.setEnabled(Accion);
        }else{
            this.jTF_Pos.setEnabled(false);
        }
        
        if( (Accion && OpSubM >= 'a' && OpSubM <= 'c') || !Accion ){
            this.jBtn_Aceptar.setEnabled(Accion);
        }
    }
    void Exportar(){
        try{
            Archivo6 = new FileReader("Trama.xls");
                    Datos = new Scanner(Archivo6);                    
                    Mover = Datos;
                    
                        A = new Trama(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Trama(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo6.close();
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        /*try{
            Archivo7 = new FileReader("Otaku.xls");
                    Datos = new Scanner(Archivo7);                    
                    Mover = Datos;
                    //System.out.println(String.valueOf(Mover.next())+"\t"+ String.valueOf(Mover.next())+"\t"+String.valueOf(Mover.next())+"\t"+String.valueOf(Mover.next())+"\t"+String.valueOf(Mover.next())+"\t"+Integer.parseInt(String.valueOf(Mover.next()))+"\t"+String.valueOf(Mover.next())+"\t"+Integer.parseInt(String.valueOf(Mover.next())) );
                        A = new Otaku(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()),Integer.parseInt(String.valueOf(Mover.next())), String.valueOf(Mover.next()),Integer.parseInt(String.valueOf(Mover.next())) );
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Otaku(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()),Integer.parseInt(String.valueOf(Mover.next())), String.valueOf(Mover.next()),Integer.parseInt(String.valueOf(Mover.next())) );
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo7.close();
        //}catch (java.lang.NumberFormatException e){
            
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }*/
        
        try{
                    Archivo = new FileReader("Animacion.xls");
                    Datos = new Scanner(Archivo);                    
                    Mover = Datos;
                    
                        A = new Animacion(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Animacion(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo.close();
                    
                    
                }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        try{
            
            Archivo3 = new FileReader("Personaje.xls");
                    Datos = new Scanner(Archivo3);                    
                    Mover = Datos;
                    
                        A = new Personaje(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()).charAt(0),String.valueOf(Mover.next()));
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Personaje(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()).charAt(0),String.valueOf(Mover.next()));
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo3.close();
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        try{
            Archivo4 = new FileReader("Audio.xls");
                    Datos = new Scanner(Archivo4);                    
                    Mover = Datos;
                    
                        A = new Audio(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()),String.valueOf(Mover.next()) );
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Audio(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()),String.valueOf(Mover.next()) );
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo4.close();
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        try{
            Archivo5 = new FileReader("Guion.xls");
                    Datos = new Scanner(Archivo5);                    
                    Mover = Datos;
                    
                        A = new Guion(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()) );
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Guion(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()) );
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo5.close();
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        try{
            Archivo11 = new FileReader("Peliculas.xls");
                    Datos = new Scanner(Archivo11);                    
                    Mover = Datos;
                    
                        A = new Peliculas(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Peliculas(String.valueOf(Mover.next()), String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo11.close();
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        /*try{
            Archivo8 = new FileReader("Ingresos.xls");
                    Datos = new Scanner(Archivo8);                    
                    Mover = Datos;
                    
                        A = new Ingresos(String.valueOf(Mover.next()).toCharArray(), String.valueOf(Mover.next()), Float.parseFloat(String.valueOf(Mover.next())) );
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Ingresos(String.valueOf(Mover.next()).toCharArray(), String.valueOf(Mover.next()), Float.parseFloat(String.valueOf(Mover.next())) );
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo8.close();
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }*/
        try{
           Archivo9 = new FileReader("Directores.xls");
                    Datos = new Scanner(Archivo9);                    
                    Mover = Datos;
                    
                        A = new Directores(String.valueOf(Mover.next()), String.valueOf(Mover.next()).charAt(0), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()) );
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Directores(String.valueOf(Mover.next()), String.valueOf(Mover.next()).charAt(0), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()) );
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo9.close(); 
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        try{
           Archivo10 = new FileReader("Precursores.xls");
                    Datos = new Scanner(Archivo10);                    
                    Mover = Datos;
                    
                        A = new Precursores(String.valueOf(Mover.next()), String.valueOf(Mover.next()).charAt(0), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()) );
                    for (int i=0; Mover.hasNext();i++) {                       
                        A = new Precursores(String.valueOf(Mover.next()), String.valueOf(Mover.next()).charAt(0), String.valueOf(Mover.next()), String.valueOf(Mover.next()),String.valueOf(Mover.next()) );
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    Archivo10.close(); 
        }catch (java.util.NoSuchElementException e){
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
        try{
            Archivo2 = new FileReader("Usuarios.xls");
                    Datos = new Scanner(Archivo2);
                    
                    Mover = Datos;
                    
                        A = new Login(String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                        //System.out.println(String.valueOf(Mover.next())+"\t"+String.valueOf(Mover.next())+"\t"+String.valueOf(Mover.next() ));
                    for (int i=0; Mover.hasNext();i++) {
                        //System.out.println(String.valueOf(Mover.next())+"\t"+String.valueOf(Mover.next())+"\t"+String.valueOf(Mover.next() ));
                        A = new Login(String.valueOf(Mover.next()), String.valueOf(Mover.next()));
                        //A.ImprimirCLI(i);
                        Arreglo = P.Registrar(Arreglo, A);
                    }
                    
                    Archivo2.close();
        }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null, "NO fue posible Abrir el Archivo!!!\nFavor vuelva a Intentarlo más Tarde!!!");
                }
    }
    public void MostrarGUI(){
        switch(OpSubM){
            case 'a':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Sinopsis"});
                break;
            case 'b':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Mangas","Anime","Videojuegos","Mangas Vendidos","Personaje Popular","Videojuegos Vendidos"});
                break;
            case 'c':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Casa de Animacion","Animadores","Tipo de Animacion"});
                break;
            case 'd':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Casa de Animacion","Personaje","Genero","Personalidad"});
                break;
            case 'e':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Casa de Animacion","Actor de Voz","Banda de Opening","Banda de Ending"});
                break;
            case 'f':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Casa de Animacion","Mangaka"});
                break;
            case 'g':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Numero de Reporte","Fecha","Cantidad de Ingresos"});
                break;
            case 'h':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Numero de Reporte","Fecha","Cantidad de Egresos"});
                break;
            case 'i':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Titulos","Fecha de Estreno","Numero de Capitulos","Numero de Temporadas"});
                break;
            case 'j':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Titulos","Fecha de Estreno","Duracion"});
                break;
            case 'k':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Titulos","Fecha de Estreno","Numero de Ovas","Numero de Capitulos"});
                break;
            case 'l':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Primer Obra","Ultima Obra","Obra mas famosa"});
                break;
            case 'm':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Nombre","Genero","Primer Obra","Ultima Obra","Obra mas famosa"});
                break;
            case 'n':
                Modelo = new DefaultTableModel(new String [][] { },new String [] {"Posicion","Usuario","Contraseña"});
                break;
        }
        jTB_Mostrar.setModel(Modelo);
        for (int i = 0; i < Arreglo.length; i++) {
            if(OpSubM == 'a' && Arreglo[i] instanceof Trama){
                Object Linea[] = {i, ((Atributos)Arreglo[i]).getNombre(), 
                    ((Atributos)Arreglo[i]).getGenero(), ((Trama)Arreglo[i]).getSinopsis()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'b' && Arreglo[i] instanceof Otaku){
                Object Linea[] = {i, ((Atributos)Arreglo[i]).getNombre(), 
                    ((Atributos)Arreglo[i]).getGenero(), ((Otaku)Arreglo[i]).getManga(), ((Otaku)Arreglo[i]).getAnime(), ((Otaku)Arreglo[i]).getJuegos(),
                ((Otaku)Arreglo[i]).getMangas_Vendidos(),((Otaku)Arreglo[i]).getPopularidad(),((Otaku)Arreglo[i]).getVidoejuegos_Vendidos()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'c' && Arreglo[i] instanceof Animacion){
                Object Linea[] = {i, ((Atributos)Arreglo[i]).getNombre(), 
                    ((Atributos)Arreglo[i]).getGenero(), ((Diseño)Arreglo[i]).getCasa_Animacion(), ((Animacion)Arreglo[i]).getAnimadores(), 
                    ((Animacion)Arreglo[i]).getTipo()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'd' && Arreglo[i] instanceof Personaje){
                Object Linea[] = {i, ((Atributos)Arreglo[i]).getNombre(), 
                    ((Atributos)Arreglo[i]).getGenero(), ((Diseño)Arreglo[i]).getCasa_Animacion(), ((Personaje)Arreglo[i]).getPersonaje(), 
                    ((Personaje)Arreglo[i]).getGen(),((Personaje)Arreglo[i]).getPersonalidad()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'e' && Arreglo[i] instanceof Audio){
                Object Linea[] = {i, ((Atributos)Arreglo[i]).getNombre(), 
                    ((Atributos)Arreglo[i]).getGenero(), ((Diseño)Arreglo[i]).getCasa_Animacion(), ((Audio)Arreglo[i]).getActor(), 
                    ((Audio)Arreglo[i]).getOp(),((Audio)Arreglo[i]).getEnd()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'f' && Arreglo[i] instanceof Guion){
                Object Linea[] = {i, ((Atributos)Arreglo[i]).getNombre(), 
                    ((Atributos)Arreglo[i]).getGenero(), ((Diseño)Arreglo[i]).getCasa_Animacion(), ((Guion)Arreglo[i]).getMangaka()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'g' && Arreglo[i] instanceof Ingresos){
                Object Linea[] = {i, String.valueOf(((Registro_Reportes)Arreglo[i]).getNumero()), 
                    ((Registro_Reportes)Arreglo[i]).getFecha(), ((Ingresos)Arreglo[i]).getCant()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'h' && Arreglo[i] instanceof Egresos){
                Object Linea[] = {i, String.valueOf(((Registro_Reportes)Arreglo[i]).getNumero()), 
                    ((Registro_Reportes)Arreglo[i]).getFecha(), ((Egresos)Arreglo[i]).getCant()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'i' && Arreglo[i] instanceof Series){
                Object Linea[] = {i, ((Formatos)Arreglo[i]).getTitulo(), 
                    ((Formatos)Arreglo[i]).getFecha(), ((Series)Arreglo[i]).getCaps(), ((Series)Arreglo[i]).getTemp()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'j' && Arreglo[i] instanceof Peliculas){
                Object Linea[] = {i, ((Formatos)Arreglo[i]).getTitulo(), 
                    ((Formatos)Arreglo[i]).getFecha(), ((Peliculas)Arreglo[i]).getDuracion()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'k' && Arreglo[i] instanceof Ovas){
                Object Linea[] = {i, ((Formatos)Arreglo[i]).getTitulo(), 
                    ((Formatos)Arreglo[i]).getFecha(), ((Ovas)Arreglo[i]).getNumero_Ova(), ((Ovas)Arreglo[i]).getCaps()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'l' && Arreglo[i] instanceof Directores){
                Object Linea[] = {i, ((Personas)Arreglo[i]).getNombre(), 
                    ((Personas)Arreglo[i]).getGenero(), ((Directores)Arreglo[i]).getPrimer_Obra(), ((Directores)Arreglo[i]).getUltima_Obra(),
                    ((Directores)Arreglo[i]).getObra_Famosa()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'm' && Arreglo[i] instanceof Precursores){
                Object Linea[] = {i, ((Personas)Arreglo[i]).getNombre(), 
                    ((Personas)Arreglo[i]).getGenero(), ((Precursores)Arreglo[i]).getPrimer_Obra(), ((Precursores)Arreglo[i]).getUltima_Obra(),
                    ((Precursores)Arreglo[i]).getObra_Famosa()};
                Modelo.addRow(Linea);
            }else if(OpSubM == 'n' && Arreglo[i] instanceof Login){
                Object Linea[] = {i, ((Login)Arreglo[i]).getUser(), 
                    ((Login)Arreglo[i]).getPassword()};
                Modelo.addRow(Linea);
            }
        }
    }
    void Seleccionar(){
        Con = P.Conec(Con);
        if(Con != null){
            try{
                Pila = Con.createStatement();
                Consulta = "select *from Trama;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Trama(Resul.getString("nombre"),
                    Resul.getString("genero"),
                    Resul.getString("sinopsis")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Otaku;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Otaku(Resul.getString("nombre"),
                    Resul.getString("genero"),
                    Resul.getString("manga"),
                    Resul.getString("anime"),
                    Resul.getString("videosjuegos"),
                    Resul.getInt("mangas_vendidos"),
                    Resul.getString("persona_popular"),
                    Resul.getInt("videosjuegos_vendidos")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Animacion;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Animacion(Resul.getString("nombre"),
                    Resul.getString("genero"),
                    Resul.getString("casa_animacion"),
                    Resul.getString("Animadores"),
                    Resul.getString("tipo_animacion")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Personaje;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Personaje(Resul.getString("nombre"),
                    Resul.getString("genero"),
                    Resul.getString("casa_animacion"),
                    Resul.getString("personaje"),
                    Resul.getString("sexo").charAt(0),
                    Resul.getString("personalidad")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Audio;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Audio(Resul.getString("nombre"),
                    Resul.getString("genero"),
                    Resul.getString("casa_animacion"),
                    Resul.getString("actor_voz"),
                    Resul.getString("banda_opening"),
                    Resul.getString("banda_ending")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Guion;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Guion(Resul.getString("nombre"),
                    Resul.getString("genero"),
                    Resul.getString("casa_animacion"),
                    Resul.getString("mangaka")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Total_Ingresos;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Ingresos(Resul.getString("numero_reporte").toCharArray(),
                    Resul.getString("fecha"),
                    Resul.getFloat("cantidad_ingreso")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Total_Egresos;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Egresos(Resul.getString("numero_reporte").toCharArray(),
                    Resul.getString("fecha"),
                    Resul.getFloat("cantidad_egreso")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Series;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Series(Resul.getString("titulo"),
                    Resul.getString("fecha_estreno"),
                    Resul.getInt("numero_capitulo"),
                    Resul.getInt("numero_temporadas")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Peliculas;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Peliculas(Resul.getString("titulo"),
                    Resul.getString("fecha_estreno"),
                    Resul.getString("duracion")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Ovas;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Ovas(Resul.getString("titulo"),
                    Resul.getString("fecha"),
                    Resul.getInt("numero_ova"),
                    Resul.getInt("numero_capitulos")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Directores;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Directores(Resul.getString("nombre"),
                    Resul.getString("genero").charAt(0),
                    Resul.getString("primer_obra"),
                    Resul.getString("ultima_obra"),
                    Resul.getString("obra_famosa")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from Precursores;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Precursores(Resul.getString("nombre"),
                    Resul.getString("genero").charAt(0),
                    Resul.getString("primer_obra"),
                    Resul.getString("ultima_obra"),
                    Resul.getString("obra_famosa")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
                Consulta = "select *from USUARIO;";
                Resul = Pila.executeQuery(Consulta);
                
                for(; Resul.next();){
                    A = new Login(Resul.getString("n_usuario"),
                    Resul.getString("pass")
                    );
                    Arreglo = P.Registrar(Arreglo, A);
                }
            }catch(java.sql.SQLException e){
                JOptionPane.showMessageDialog(null, "NO fue posible realizar dicha seleccion");
            }finally{
                P.DesConecta(Con);
            }
        }
    }
    void Insertar(int Cant){
        Con = P.Conec(Con);
        if( Con != null && Cant > 0 ){
            try {
                Pila = Con.createStatement();
                for (int i = Arreglo.length-Cant; i < Arreglo.length; i++) {
                    if(OpSubM=='a' && Arreglo[i] instanceof Trama){
                        Consulta = "insert into Trama(nombre, genero, sinopsis)values('"+
                                ((Trama)Arreglo[i]).getNombre()+"','"+
                                ((Trama)Arreglo[i]).getGenero()+"','"+
                                ((Trama)Arreglo[i]).getSinopsis()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='b' && Arreglo[i] instanceof Otaku){
                         Consulta = "insert into Otaku(nombre, genero, manga, anime, videosjuegos, mangas_vendidos, persona_popular, videosjuegos_vendidos)values('"+
                                ((Otaku)Arreglo[i]).getNombre()+"','"+
                                ((Otaku)Arreglo[i]).getGenero()+"','"+
                                ((Otaku)Arreglo[i]).getManga()+"','"+
                                ((Otaku)Arreglo[i]).getAnime()+"','"+
                                ((Otaku)Arreglo[i]).getJuegos()+"','"+
                                ((Otaku)Arreglo[i]).getMangas_Vendidos()+"','"+
                                ((Otaku)Arreglo[i]).getPopularidad()+"','"+
                                ((Otaku)Arreglo[i]).getVidoejuegos_Vendidos()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='c' && Arreglo[i] instanceof Animacion){
                        Consulta = "insert into Animacion(nombre, genero, casa_animacion, animadores, tipo_animacion)values('"+
                                ((Animacion)Arreglo[i]).getNombre()+"','"+
                                ((Animacion)Arreglo[i]).getGenero()+"','"+
                                ((Animacion)Arreglo[i]).getCasa_Animacion()+"','"+
                                ((Animacion)Arreglo[i]).getAnimadores()+"','"+
                                ((Animacion)Arreglo[i]).getTipo()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='d' && Arreglo[i] instanceof Personaje){
                        Consulta = "insert into Personaje(nombre, genero, casa_animacion, personaje, sexo, personalidad)values('"+
                                ((Personaje)Arreglo[i]).getNombre()+"','"+
                                ((Personaje)Arreglo[i]).getGenero()+"','"+
                                ((Personaje)Arreglo[i]).getCasa_Animacion()+"','"+
                                ((Personaje)Arreglo[i]).getPersonaje()+"','"+
                                ((Personaje)Arreglo[i]).getGen()+"','"+
                                ((Personaje)Arreglo[i]).getPersonalidad()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='e' && Arreglo[i] instanceof Audio){
                        Consulta = "insert into Audio(nombre, genero, casa_animacion, actor_voz, banda_opening, banda_ending)values('"+
                                ((Audio)Arreglo[i]).getNombre()+"','"+
                                ((Audio)Arreglo[i]).getGenero()+"','"+
                                ((Audio)Arreglo[i]).getCasa_Animacion()+"','"+
                                ((Audio)Arreglo[i]).getActor()+"','"+
                                ((Audio)Arreglo[i]).getOp()+"','"+
                                ((Audio)Arreglo[i]).getEnd()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='f' && Arreglo[i] instanceof Guion){
                        Consulta = "insert into Guion(nombre, genero, casa_animacion, mangaka)values('"+
                                ((Guion)Arreglo[i]).getNombre()+"','"+
                                ((Guion)Arreglo[i]).getGenero()+"','"+
                                ((Guion)Arreglo[i]).getCasa_Animacion()+"','"+
                                ((Guion)Arreglo[i]).getMangaka()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='g' && Arreglo[i] instanceof Ingresos){
                        Consulta = "insert into Total_Ingresos(numero_reporte, fecha, cantidad_ingreso)values('"+
                                String.valueOf(((Ingresos)Arreglo[i]).getNumero())+"','"+
                                ((Ingresos)Arreglo[i]).getFecha()+"','"+
                                ((Ingresos)Arreglo[i]).getCant()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='h' && Arreglo[i] instanceof Egresos){
                        Consulta = "insert into Total_Egresos(numero_reporte, fecha, cantidad_egreso)values('"+
                                String.valueOf(((Egresos)Arreglo[i]).getNumero())+"','"+
                                ((Egresos)Arreglo[i]).getFecha()+"','"+
                                ((Egresos)Arreglo[i]).getCant()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='i' && Arreglo[i] instanceof Series){
                        Consulta = "insert into Series(titulo, fecha_estreno, numero_capitulo, numero_temporadas)values('"+
                                ((Series)Arreglo[i]).getTitulo()+"','"+
                                ((Series)Arreglo[i]).getFecha()+"','"+
                                ((Series)Arreglo[i]).getCaps()+"','"+
                                ((Series)Arreglo[i]).getTemp()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='j' && Arreglo[i] instanceof Peliculas){
                        Consulta = "insert into Peliculas(titulo, fecha_estreno, duracion)values('"+
                                ((Peliculas)Arreglo[i]).getTitulo()+"','"+
                                ((Peliculas)Arreglo[i]).getFecha()+"','"+
                                ((Peliculas)Arreglo[i]).getDuracion()+"');";
                        
                        Pila.execute(Consulta);
                    }else if(OpSubM=='k' && Arreglo[i] instanceof Ovas){
                        Consulta = "insert into Ovas(titulo, fecha, numero_ova, numero_capitulos)values('"+
                                ((Ovas)Arreglo[i]).getTitulo()+"','"+
                                ((Ovas)Arreglo[i]).getFecha()+"','"+
                                ((Ovas)Arreglo[i]).getNumero_Ova()+"','"+
                                ((Ovas)Arreglo[i]).getCaps()+"');";
                        Pila.execute(Consulta);
                    }else if(OpSubM=='l' && Arreglo[i] instanceof Directores){
                        Consulta = "insert into Directores(nombre, genero, primer_obra, ultima_obra, obra_famosa)values('"+
                                ((Directores)Arreglo[i]).getNombre()+"','"+
                                ((Directores)Arreglo[i]).getGenero()+"','"+
                                ((Directores)Arreglo[i]).getPrimer_Obra()+"','"+
                                ((Directores)Arreglo[i]).getUltima_Obra()+"','"+
                                ((Directores)Arreglo[i]).getObra_Famosa()+"');";
                        Pila.execute(Consulta);
                    }else if(OpSubM=='m' && Arreglo[i] instanceof Precursores){
                        Consulta = "insert into Precursores(nombre, genero, primer_obra, ultima_obra, obra_famosa)values('"+
                                ((Precursores)Arreglo[i]).getNombre()+"','"+
                                ((Precursores)Arreglo[i]).getGenero()+"','"+
                                ((Precursores)Arreglo[i]).getPrimer_Obra()+"','"+
                                ((Precursores)Arreglo[i]).getUltima_Obra()+"','"+
                                ((Precursores)Arreglo[i]).getObra_Famosa()+"');";
                        Pila.execute(Consulta);
                    }else if(OpSubM=='n' && Arreglo[i] instanceof Login){
                        Consulta = "insert into USUARIO(n_usuario, pass)values('"+
                                ((Login)Arreglo[i]).getUser()+"','"+
                                ((Login)Arreglo[i]).getPassword()+"');";
                        Pila.execute(Consulta);
                    }
                }
            } catch (java.sql.SQLException e) {
                JOptionPane.showMessageDialog(null,"NO fue posible realizar la Inserción en la Base de Datos!!!\nFavor Vuelva a Intentarlo!!!");
            } finally{
                P.DesConecta(Con);
            }
        }
    }
    public int ValidarInt(String Leer){
        int Cant;
        
        try {
            Cant = Integer.parseInt(Leer);
        } catch (java.lang.NumberFormatException e) {
            Cant = 0;
        }
        
        if( Cant<0 ){
            Cant = 0;
            JOptionPane.showMessageDialog(null, "NO debe ingresar un número negativo!!!\nFavor vuelva a Intentarlo!!!");
        }
        
        return Cant;
    }
    void EliminarBD(Anime Linea){
        Con = P.Conec(Con);
        if (Con != null){
            try{
            Pila = Con.createStatement();
            if(Linea instanceof Trama){
            Consulta ="delete from Trama where nombre = +'"+((Trama)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Otaku){
            Consulta ="delete from Otaku where nombre = +'"+((Otaku)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Animacion){
            Consulta ="delete from Animacion where nombre = +'"+((Animacion)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Personaje){
            Consulta ="delete from Personaje where nombre = +'"+((Personaje)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Audio){
            Consulta ="delete from Audio where nombre = +'"+((Audio)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Guion){
            Consulta ="delete from Guion where nombre = +'"+((Guion)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Ingresos){
            Consulta ="delete from Total_Ingresos where numero_reporte = +'"+String.valueOf(((Ingresos)Linea).getNumero())+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Egresos){
            Consulta ="delete from Total_Egresos where numero_reporte = +'"+String.valueOf(((Egresos)Linea).getNumero())+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Series){
            Consulta ="delete from Series where titulo = +'"+((Series)Linea).getTitulo()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Peliculas){
            Consulta ="delete from Peliculas where titulo = +'"+((Peliculas)Linea).getTitulo()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Ovas){
            Consulta ="delete from Ovas where titulo = +'"+((Ovas)Linea).getTitulo()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Directores){
            Consulta ="delete from Directores where nombre = +'"+((Directores)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Precursores){
            Consulta ="delete from Precursores where nombre = +'"+((Precursores)Linea).getNombre()+"';";
            Pila.execute(Consulta);
            }else if(Linea instanceof Login){
            Consulta ="delete from USUARIO where n_usuario = +'"+((Login)Linea).getUser()+"';";
            Pila.execute(Consulta);
            }
            }catch(java.sql.SQLException e){
                JOptionPane.showMessageDialog(null,"NO fue posible realizar la Eliminacion "+((Trama)Linea).getNombre()+" de la Base de Datos!!!\n"
                        + "Favor Vuelva a Intentarlo!!!");
            }finally{
                P.DesConecta(Con);
            }
        }
    }
    void ModificarBD(Anime Antes, Anime Despues){
        Con = P.Conec(Con);
        if( Con!=null ){
            try{
                Pila = Con.createStatement();
                if(Antes instanceof Trama){
                    Consulta = "update Trama set nombre='"+((Trama)Despues).getNombre()+"', genero = '"+((Trama)Despues).getGenero()+"', sinopsis = '"+((Trama)Despues).getSinopsis()+"' where nombre = '"+((Trama)Antes).getNombre()+"';";
                    //JOptionPane.showMessageDialog(null, Consulta);
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Otaku){
                    Consulta = "update Otaku set nombre='"+((Otaku)Despues).getNombre()+"', genero = '"+((Otaku)Despues).getGenero()+"', manga = '"+((Otaku)Despues).getManga()+"', anime = '"+((Otaku)Despues).getAnime()+"', videosjuegos = '"+((Otaku)Despues).getJuegos()+"', mangas_vendidos = '"+((Otaku)Despues).getMangas_Vendidos()+"', persona_popular = '"+((Otaku)Despues).getPopularidad()+"', videosjuegos_vendidos = '"+((Otaku)Despues).getVidoejuegos_Vendidos()+"' where nombre = '"+((Otaku)Antes).getNombre()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Animacion){
                    Consulta = "update Animacion set nombre='"+((Animacion)Despues).getNombre()+"', genero = '"+((Animacion)Despues).getGenero()+"', casa_animacion = '"+((Animacion)Despues).getCasa_Animacion()+"', animadores = '"+((Animacion)Despues).getAnimadores()+"', tipo_animacion = '"+((Animacion)Despues).getTipo()+"' where nombre = '"+((Animacion)Antes).getNombre()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Personaje){
                    Consulta = "update Personaje set nombre='"+((Personaje)Despues).getNombre()+"', genero = '"+((Personaje)Despues).getGenero()+"', casa_animacion = '"+((Personaje)Despues).getCasa_Animacion()+"', personaje = '"+((Personaje)Despues).getPersonaje()+"', sexo = '"+((Personaje)Despues).getGen()+"', personalidad = '"+((Personaje)Despues).getPersonalidad()+"' where nombre = '"+((Personaje)Antes).getNombre()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Audio){
                    Consulta = "update Audio set nombre='"+((Audio)Despues).getNombre()+"', genero = '"+((Audio)Despues).getGenero()+"', casa_animacion = '"+((Audio)Despues).getCasa_Animacion()+"', actor_voz = '"+((Audio)Despues).getActor()+"', banda_opening = '"+((Audio)Despues).getOp()+"', banda_ending = '"+((Audio)Despues).getEnd()+"' where nombre = '"+((Audio)Antes).getNombre()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Guion){
                    Consulta = "update Guion set nombre='"+((Guion)Despues).getNombre()+"', genero = '"+((Guion)Despues).getGenero()+"', casa_animacion = '"+((Guion)Despues).getCasa_Animacion()+"', mangaka = '"+((Guion)Despues).getMangaka()+"' where nombre = '"+((Guion)Antes).getNombre()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Ingresos){
                    Consulta = "update Total_Ingresos set numero_reporte ='"+String.valueOf(((Ingresos)Despues).getNumero())+"', fecha = '"+((Ingresos)Despues).getFecha()+"', cantidad_ingreso = '"+((Ingresos)Despues).getCant()+"' where numero_reporte = '"+String.valueOf(((Ingresos)Antes).getNumero())+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Egresos){
                    Consulta = "update Total_Egresos set numero_reporte ='"+String.valueOf(((Egresos)Despues).getNumero())+"', fecha = '"+((Egresos)Despues).getFecha()+"', cantidad_egreso = '"+((Egresos)Despues).getCant()+"' where numero_reporte = '"+String.valueOf(((Egresos)Antes).getNumero())+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Series){
                    Consulta = "update Series set titulo ='"+((Series)Despues).getTitulo()+"', fecha_estreno = '"+((Series)Despues).getFecha()+"', numero_capitulo = '"+((Series)Despues).getCaps()+"', numero_temporadas = '"+((Series)Despues).getTemp()+"' where titulo = '"+((Series)Antes).getTitulo()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Peliculas){
                    Consulta = "update Peliculas set titulo ='"+((Peliculas)Despues).getTitulo()+"', fecha_estreno = '"+((Peliculas)Despues).getFecha()+"', duracion = '"+((Peliculas)Despues).getDuracion()+"' where titulo = '"+((Peliculas)Antes).getTitulo()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Ovas){
                    Consulta = "update Ovas set titulo ='"+((Ovas)Despues).getTitulo()+"', fecha = '"+((Ovas)Despues).getFecha()+"', numero_ova = '"+((Ovas)Despues).getNumero_Ova()+"', numero_capitulos = '"+((Ovas)Despues).getCaps()+"' where titulo = '"+((Ovas)Antes).getTitulo()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Directores){
                    Consulta = "update Directores set nombre ='"+((Directores)Despues).getNombre()+"', genero = '"+((Directores)Despues).getGenero()+"', primer_obra = '"+((Directores)Despues).getPrimer_Obra()+"', ultima_obra = '"+((Directores)Despues).getUltima_Obra()+"', obra_famosa = '"+((Directores)Despues).getObra_Famosa()+"'  where nombre = '"+((Directores)Antes).getNombre()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Precursores){
                    Consulta = "update Precursores set nombre ='"+((Precursores)Despues).getNombre()+"', genero = '"+((Precursores)Despues).getGenero()+"', primer_obra = '"+((Precursores)Despues).getPrimer_Obra()+"', ultima_obra = '"+((Precursores)Despues).getUltima_Obra()+"', obra_famosa = '"+((Precursores)Despues).getObra_Famosa()+"'  where nombre = '"+((Precursores)Antes).getNombre()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }else if(Antes instanceof Login){
                    Consulta = "update USUARIO set n_usuario ='"+((Login)Despues).getUser()+"', pass = '"+((Login)Despues).getPassword()+"' where n_usuario = '"+((Login)Antes).getUser()+"';";
                    
                    Pila.executeUpdate(Consulta);
                }
            }catch(java.sql.SQLException e){
                JOptionPane.showMessageDialog(null,"NO fue posible realizar la Modificación en la BD!!!");
            }finally{
                P.DesConecta(Con);
            } 
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTB_Mostrar = new javax.swing.JTable();
        jLbl_Menu = new javax.swing.JLabel();
        jRB_Mostrar = new javax.swing.JRadioButton();
        jRB_Registrar = new javax.swing.JRadioButton();
        jLbl_SubM = new javax.swing.JLabel();
        jRB_Trama = new javax.swing.JRadioButton();
        jLBL_Titulo = new javax.swing.JLabel();
        jRB_Otaku = new javax.swing.JRadioButton();
        jRB_Animacion = new javax.swing.JRadioButton();
        jRB_Personaje = new javax.swing.JRadioButton();
        jRB_Audio = new javax.swing.JRadioButton();
        jRB_Guion = new javax.swing.JRadioButton();
        jRB_Ingresos = new javax.swing.JRadioButton();
        jRB_Egresos = new javax.swing.JRadioButton();
        jRB_Series = new javax.swing.JRadioButton();
        jRB_Peliculas = new javax.swing.JRadioButton();
        jRB_Ovas = new javax.swing.JRadioButton();
        jRB_Directores = new javax.swing.JRadioButton();
        jRB_Precursores = new javax.swing.JRadioButton();
        jBtn_Aceptar = new javax.swing.JButton();
        jRB_Login = new javax.swing.JRadioButton();
        jRB_Guardar = new javax.swing.JRadioButton();
        jRB_Eliminar = new javax.swing.JRadioButton();
        jRB_Modificar = new javax.swing.JRadioButton();
        jBtn_Salir = new javax.swing.JButton();
        jTF_Cant = new javax.swing.JTextField();
        jTF_Pos = new javax.swing.JTextField();
        jBtn_Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTB_Mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTB_Mostrar);

        jLbl_Menu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLbl_Menu.setText("Menu");

        jRB_Mostrar.setText("Mostrar");
        jRB_Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_MostrarActionPerformed(evt);
            }
        });

        jRB_Registrar.setText("Registrar");
        jRB_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_RegistrarActionPerformed(evt);
            }
        });

        jLbl_SubM.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLbl_SubM.setText("SubMenu");

        jRB_Trama.setText("Trama");
        jRB_Trama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_TramaActionPerformed(evt);
            }
        });

        jLBL_Titulo.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLBL_Titulo.setText("Anime \"Tijuilote\"");

        jRB_Otaku.setText("Otaku");
        jRB_Otaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_OtakuActionPerformed(evt);
            }
        });

        jRB_Animacion.setText("Animacion");
        jRB_Animacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_AnimacionActionPerformed(evt);
            }
        });

        jRB_Personaje.setText("Personaje");
        jRB_Personaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_PersonajeActionPerformed(evt);
            }
        });

        jRB_Audio.setText("Audio");
        jRB_Audio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_AudioActionPerformed(evt);
            }
        });

        jRB_Guion.setText("Guion");
        jRB_Guion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_GuionActionPerformed(evt);
            }
        });

        jRB_Ingresos.setText("Total de Ingresos");
        jRB_Ingresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_IngresosActionPerformed(evt);
            }
        });

        jRB_Egresos.setText("Total de Egresos");
        jRB_Egresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_EgresosActionPerformed(evt);
            }
        });

        jRB_Series.setText("Series");
        jRB_Series.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_SeriesActionPerformed(evt);
            }
        });

        jRB_Peliculas.setText("Peliculas");
        jRB_Peliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_PeliculasActionPerformed(evt);
            }
        });

        jRB_Ovas.setText("Ovas");
        jRB_Ovas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_OvasActionPerformed(evt);
            }
        });

        jRB_Directores.setText("Directores");
        jRB_Directores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_DirectoresActionPerformed(evt);
            }
        });

        jRB_Precursores.setText("Precursores");
        jRB_Precursores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_PrecursoresActionPerformed(evt);
            }
        });

        jBtn_Aceptar.setText("Aceptar");
        jBtn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AceptarActionPerformed(evt);
            }
        });

        jRB_Login.setText("Login");
        jRB_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_LoginActionPerformed(evt);
            }
        });

        jRB_Guardar.setText("Guardar");
        jRB_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_GuardarActionPerformed(evt);
            }
        });

        jRB_Eliminar.setText("Eliminar");
        jRB_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_EliminarActionPerformed(evt);
            }
        });

        jRB_Modificar.setText("Modificar");
        jRB_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRB_ModificarActionPerformed(evt);
            }
        });

        jBtn_Salir.setText("Salir");
        jBtn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_SalirActionPerformed(evt);
            }
        });

        jTF_Cant.setText("Cantidad");
        jTF_Cant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_CantMouseClicked(evt);
            }
        });

        jTF_Pos.setText("Posicion");
        jTF_Pos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTF_PosMouseClicked(evt);
            }
        });

        jBtn_Regresar.setText("Regresar");
        jBtn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRB_Trama)
                            .addComponent(jRB_Otaku)
                            .addComponent(jRB_Animacion)
                            .addComponent(jRB_Personaje)
                            .addComponent(jRB_Audio)
                            .addComponent(jRB_Guion)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLbl_SubM))
                            .addComponent(jRB_Ingresos)
                            .addComponent(jRB_Egresos)
                            .addComponent(jRB_Series)
                            .addComponent(jRB_Peliculas)
                            .addComponent(jRB_Ovas)
                            .addComponent(jRB_Directores)
                            .addComponent(jRB_Mostrar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRB_Registrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_Cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRB_Precursores)
                            .addComponent(jRB_Login)
                            .addComponent(jRB_Guardar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRB_Eliminar)
                                    .addComponent(jRB_Modificar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTF_Pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLbl_Menu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jBtn_Aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtn_Salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jBtn_Regresar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLBL_Titulo)
                        .addGap(346, 346, 346))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLBL_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLbl_Menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Mostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRB_Registrar)
                    .addComponent(jTF_Cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRB_Eliminar)
                    .addComponent(jTF_Pos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLbl_SubM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Trama)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Otaku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Animacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Personaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Audio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Guion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Ingresos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Egresos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Series)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Peliculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Ovas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Directores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Precursores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRB_Login)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Aceptar)
                    .addComponent(jBtn_Salir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtn_Regresar)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRB_TramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_TramaActionPerformed
        OpSubM = 'a';
        Bloquear(true);
    }//GEN-LAST:event_jRB_TramaActionPerformed

    private void jRB_MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_MostrarActionPerformed
        OpMenu = 'A';
        Bloquear(true);
    }//GEN-LAST:event_jRB_MostrarActionPerformed

    private void jRB_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_RegistrarActionPerformed
        OpMenu = 'B';
        Bloquear(true);
    }//GEN-LAST:event_jRB_RegistrarActionPerformed

    private void jRB_OtakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_OtakuActionPerformed
        OpSubM = 'b';
        Bloquear(true);
    }//GEN-LAST:event_jRB_OtakuActionPerformed

    private void jRB_AnimacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_AnimacionActionPerformed
        OpSubM = 'c';
        Bloquear(true);
    }//GEN-LAST:event_jRB_AnimacionActionPerformed

    private void jRB_PersonajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_PersonajeActionPerformed
        OpSubM = 'd';
        Bloquear(true);
    }//GEN-LAST:event_jRB_PersonajeActionPerformed

    private void jRB_AudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_AudioActionPerformed
        OpSubM = 'e';
        Bloquear(true);
    }//GEN-LAST:event_jRB_AudioActionPerformed

    private void jRB_GuionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_GuionActionPerformed
        OpSubM = 'f';
        Bloquear(true);
    }//GEN-LAST:event_jRB_GuionActionPerformed

    private void jRB_IngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_IngresosActionPerformed
        OpSubM = 'g';
        Bloquear(true);
    }//GEN-LAST:event_jRB_IngresosActionPerformed

    private void jRB_EgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_EgresosActionPerformed
        OpSubM = 'h';
        Bloquear(true);
    }//GEN-LAST:event_jRB_EgresosActionPerformed

    private void jRB_SeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_SeriesActionPerformed
        OpSubM = 'i';
        Bloquear(true);
    }//GEN-LAST:event_jRB_SeriesActionPerformed

    private void jRB_PeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_PeliculasActionPerformed
        OpSubM = 'j';
        Bloquear(true);
    }//GEN-LAST:event_jRB_PeliculasActionPerformed

    private void jRB_OvasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_OvasActionPerformed
        OpSubM = 'k';
        Bloquear(true);
    }//GEN-LAST:event_jRB_OvasActionPerformed

    private void jRB_DirectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_DirectoresActionPerformed
        OpSubM = 'l';
        Bloquear(true);
    }//GEN-LAST:event_jRB_DirectoresActionPerformed

    private void jRB_PrecursoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_PrecursoresActionPerformed
        OpSubM = 'm';
        Bloquear(true);
    }//GEN-LAST:event_jRB_PrecursoresActionPerformed

    private void jBtn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AceptarActionPerformed
        int Cant, Pos;
        switch(OpMenu){
            case 'A':
                MostrarGUI();
                break;
            case 'B':
                Cant = ValidarInt(this.jTF_Cant.getText());
                Arreglo = P.Registrar(Arreglo, Cant, OpSubM);
                Insertar(Cant);
                MostrarGUI();
                break;
            case 'C':
                try{
                    P.Guardar(Arreglo, OpSubM);
                }catch(java.io.IOException e){
                    JOptionPane.showMessageDialog(null,"No fue posible Exportar a Excel!!!");
                }
                JOptionPane.showMessageDialog(null, "Se exporto con exito");
                break;
            case 'D':
                Pos = ValidarInt(this.jTF_Pos.getText());
                EliminarBD(Arreglo[Pos]);
                Arreglo = P.Eliminar(Arreglo, Pos);
                MostrarGUI();
                
                break;
            case 'E':
                Pos = ValidarInt(this.jTF_Pos.getText());
                if(Arreglo[Pos] instanceof Trama){
                    A = new Trama();
                    ((Trama)A).setNombre(((Trama)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Otaku){
                    A = new Otaku();
                    ((Otaku)A).setNombre(((Otaku)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Animacion){
                    A = new Animacion();
                    ((Animacion)A).setNombre(((Animacion)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Personaje){
                    A = new Personaje();
                    ((Personaje)A).setNombre(((Personaje)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Audio){
                    A = new Audio();
                    ((Audio)A).setNombre(((Audio)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Guion){
                    A = new Guion();
                    ((Guion)A).setNombre(((Guion)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Ingresos){
                    A = new Ingresos();
                    ((Ingresos)A).setNumero(((Ingresos)Arreglo[Pos]).getNumero());
                    
                }else if(Arreglo[Pos] instanceof Egresos){
                    A = new Egresos();
                    ((Egresos)A).setNumero(((Egresos)Arreglo[Pos]).getNumero());
                    
                }else if(Arreglo[Pos] instanceof Series){
                    A = new Series();
                    ((Series)A).setTitulo(((Series)Arreglo[Pos]).getTitulo());
                    
                }else if(Arreglo[Pos] instanceof Peliculas){
                    A = new Peliculas();
                    ((Peliculas)A).setTitulo(((Peliculas)Arreglo[Pos]).getTitulo());
                    
                }else if(Arreglo[Pos] instanceof Ovas){
                    A = new Ovas();
                    ((Ovas)A).setTitulo(((Ovas)Arreglo[Pos]).getTitulo());
                    
                }else if(Arreglo[Pos] instanceof Directores){
                    A = new Directores();
                    ((Directores)A).setNombre(((Directores)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Precursores){
                    A = new Precursores();
                    ((Precursores)A).setNombre(((Precursores)Arreglo[Pos]).getNombre());
                    
                }else if(Arreglo[Pos] instanceof Login){
                    A = new Login();
                    ((Login)A).setUser(((Login)Arreglo[Pos]).getUser());
                    
                }
                Arreglo[Pos] = P.Modificar(Arreglo[Pos],"");
                ModificarBD(A,Arreglo[Pos]);
                MostrarGUI();
                break;
        }
        this.jTF_Cant.setText("Cantidad");
        this.jTF_Pos.setText("Posicion");

    }//GEN-LAST:event_jBtn_AceptarActionPerformed

    private void jRB_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_LoginActionPerformed
        OpSubM = 'n';
        Bloquear(true);
    }//GEN-LAST:event_jRB_LoginActionPerformed

    private void jRB_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_GuardarActionPerformed
        OpMenu = 'C';
        Bloquear(true);
    }//GEN-LAST:event_jRB_GuardarActionPerformed

    private void jRB_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_EliminarActionPerformed
        OpMenu = 'D';
        Bloquear(true);
    }//GEN-LAST:event_jRB_EliminarActionPerformed

    private void jRB_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRB_ModificarActionPerformed
        OpMenu = 'E';
        Bloquear(true);
    }//GEN-LAST:event_jRB_ModificarActionPerformed

    private void jBtn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBtn_SalirActionPerformed

    private void jTF_CantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_CantMouseClicked
        this.jTF_Cant.setText("");
    }//GEN-LAST:event_jTF_CantMouseClicked

    private void jTF_PosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTF_PosMouseClicked
        this.jTF_Pos.setText("");
    }//GEN-LAST:event_jTF_PosMouseClicked

    private void jBtn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_RegresarActionPerformed
        EleccionGUI Re = new EleccionGUI();
        Re.setDefaultCloseOperation(2);
        Re.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtn_RegresarActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Aceptar;
    private javax.swing.JButton jBtn_Regresar;
    private javax.swing.JButton jBtn_Salir;
    private javax.swing.JLabel jLBL_Titulo;
    private javax.swing.JLabel jLbl_Menu;
    private javax.swing.JLabel jLbl_SubM;
    private javax.swing.JRadioButton jRB_Animacion;
    private javax.swing.JRadioButton jRB_Audio;
    private javax.swing.JRadioButton jRB_Directores;
    private javax.swing.JRadioButton jRB_Egresos;
    private javax.swing.JRadioButton jRB_Eliminar;
    private javax.swing.JRadioButton jRB_Guardar;
    private javax.swing.JRadioButton jRB_Guion;
    private javax.swing.JRadioButton jRB_Ingresos;
    private javax.swing.JRadioButton jRB_Login;
    private javax.swing.JRadioButton jRB_Modificar;
    private javax.swing.JRadioButton jRB_Mostrar;
    private javax.swing.JRadioButton jRB_Otaku;
    private javax.swing.JRadioButton jRB_Ovas;
    private javax.swing.JRadioButton jRB_Peliculas;
    private javax.swing.JRadioButton jRB_Personaje;
    private javax.swing.JRadioButton jRB_Precursores;
    private javax.swing.JRadioButton jRB_Registrar;
    private javax.swing.JRadioButton jRB_Series;
    private javax.swing.JRadioButton jRB_Trama;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTB_Mostrar;
    private javax.swing.JTextField jTF_Cant;
    private javax.swing.JTextField jTF_Pos;
    // End of variables declaration//GEN-END:variables
}
