package anime_tijuilote;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;
public class Programa {
    public Anime[] Registrar(Anime Arreglo[], Anime A) {
        Anime tmp[] = new Anime[Arreglo.length + 1];//1
        for (int i = 0; i < tmp.length; i++) {
            if (i < Arreglo.length) {//2
                tmp[i] = Arreglo[i];
            } else {//3
                tmp[i] = A;
            }
        }
        return tmp;//4
    }
    public Anime[] Predefinido(){
        
        Anime Arreglo[] = new Anime[27];
        //Trama(String Nombre, String Genero,String Sinopsis
        Arreglo[0] = new Trama("One piece","Shonen","Una historia épica de piratas");
        Arreglo[1] = new Trama("Naruto", "Shonen","un aprendiz de ninja de la Aldea Oculta de Konoha ");
        //Otaku( String Nombre, String Genero, String Manga, String Anime, String Juegos,int Mangas_Vendidos, int Popularidad, int Vidoejuegos_Vendidos)
        Arreglo[2] = new Otaku("Dragon ball", "Shonen", "Dragon ball Z","Dragon ball Z", "Dragon Ball Z: Budokai",300000000,"Vegeta",12000000);
        Arreglo[3] = new Otaku("Boku no hero", "Shonen", "Boku no Hero Academia","Boku no Hero Academia", "My Hero One's Justice 2",65000000,"Vegeta",1000000);
        //Animacion(String Nombre, String Genero, String Casa_Animacion, String Animadores, String Tipo )
        Arreglo[4] = new Animacion("Hunter X Hunter","Shonen","Nippon Animation","Takahiro Yoshimatsu","2D");
        Arreglo[5] = new Animacion("One Punch Man","Seinen","Madhouse"," Yusuke Murata","2D");
        //Personaje(String Nombre, String Genero,String Casa_Animacion, String Personaje, char Gen, String Personalidad )
        Arreglo[6] = new Personaje("Super Campeones","Deporte","Tsuchida Production","Oliver",'M',"Alegre");
        Arreglo[7] = new Personaje("Super Campeones","Deporte", "Tsuchida Production", "Benji",'M',"Caracte Fuerte");
        //Audio(String Nombre, String Genero,  String Casa_Animacion, String Actor, String Op, String End )
        Arreglo[8] = new Audio("Fairy Tail", "Shonen", "A-1 Pictures", "Tetsuya Kakihara", " Funkist", " Watarirouka Hashirita");
        Arreglo[9] = new Audio("Shingeki no Kyojin", "Seinen", "MAPPA","Yui Ishikawa","Linked Horizon","Yōko Hikasa");
        //Guion( String Nombre, String Genero, String Casa_Animacion,String Mangaka)
        Arreglo[10] = new Guion("Tengen Toppa Gurren-Lagann", "Mecha", "Gainax","Hiroyuki Imaishi");
        Arreglo[11] = new Guion("Neon Genesis Evangelion", "Mecha", "Gainax"," Yoshiyuki Sadamoto");
        //Ingresos( char[] Numero, String Fecha, float Cant)
        Arreglo[12] = new Ingresos("A-5554".toCharArray(),"12/8/2022",5000000);
        Arreglo[13] = new Ingresos("A-5558".toCharArray(),"16/8/2022",3000000);
        //Egresos(char[] Numero, String Fecha, float Cant )
        Arreglo[14] = new Egresos("A-5554".toCharArray(),"12/8/2021",2000000);
        Arreglo[15] = new Egresos("A-5558".toCharArray(),"16/8/2021",1000000);
        //Series(String Titulo, String Fecha,int Caps, int Temp
        Arreglo[16] = new Series("Kengan Ashura","31/7/2019",24,2);
        Arreglo[17] = new Series("Kakegurui","1/7/2017",24,2);
        //Peliculas(String Titulo, String Fecha, String Duracion)
        Arreglo[18] = new Peliculas("Dragon Ball Super: Super Hero", "11/6/2022", "1h 40m");
        Arreglo[19] = new Peliculas("One Piece: Estampida", "9/8/2019","1h 41m");
        //Ovas(String Titulo, String Fecha, int Numero_Ova, int Caps)
        Arreglo[20] = new Ovas("One Piece 3D2Y","30/8/2014",8,1);
        Arreglo[21] = new Ovas("One Piece: Heart of Gold","13/7/2016",9,1);
        //Directores(String Nombre, char Genero, String Primer_Obra, String Ultima_Obra, String Obra_Famosa)
        Arreglo[22] = new Directores("Akira Toriyama",'M',"Dr. Slump","Dragon Ball Super","Dragon Ball");
        //Precursores(String Nombre, char Genero, String Primer_Obra, String Ultima_Obra, String Obra_Famosa)
        Arreglo[23] = new Precursores("Masashi Kishimoto",'M',"Karakuri","Boruto: Naruto Next Generations","Naruto");
        Arreglo[24] = new Precursores("Eiichirō Oda",'M',"One Piece","One Piece x Toriko x Dragon Ball Z: Cross Epoch","One Piece");
        //Login(String User, String Password)
        Arreglo[25] = new Login("Fercast", "Matematicas5-5");
        Arreglo[26] = new Login("Omarhh", "245456");
        return Arreglo;
}
    public Anime[] Registrar(Anime Arreglo[], int Cant, char sm) {//Saul, Fernando
        Anime tmp[] = new Anime[Arreglo.length + Cant];
        for (int i = 0; i < tmp.length; i++) {
            if (i < Arreglo.length) {
                tmp[i] = Arreglo[i];
            } else {
                switch (sm) {
                    case 'a':
                        tmp[i] = new Trama();                        
                        break;
                    case 'b':
                        tmp[i] = new Otaku();
                        break;
                    case 'c':
                        tmp[i] = new Animacion();
                        break;
                    case 'd':
                        tmp[i] = new Personaje();
                        break;
                    case 'e':
                        tmp[i] = new Audio();
                        break;
                    case 'f':
                        tmp[i] = new Guion();
                        break;
                    case 'g':
                        tmp[i] = new Ingresos();
                        break;
                    case 'h':
                        tmp[i] = new Egresos();
                        break;
                    case 'i':
                        tmp[i] = new Series();
                        break;
                    case 'j':
                        tmp[i] = new Peliculas();
                        break;
                    case 'k':
                        tmp[i] = new Ovas();
                        break;
                    case 'l':
                        tmp[i] = new Directores();
                        break;
                    case 'm':
                        tmp[i] = new Precursores();
                        break;
                    case 'n':
                        tmp[i] = new Login();
                        break;
                }
                tmp[i].LeerGUI(i);
            }
        }
        return tmp;
    }
    public Anime[] Eliminar(Anime Arreglo[], int Pos) { //Jorge
        Anime tmp[] = new Anime[Arreglo.length - 1];//1
        for (int i = 0; i < Arreglo.length; i++) {
            if (i < Pos) {
                tmp[i] = Arreglo[i];
            } else if (i > Pos) {
                tmp[i - 1] = Arreglo[i];
            }
        }
        return tmp;
    }
    public Anime Modificar(Anime Var, String Leer) {
        if (Var instanceof Trama) {
            Var = Modificar( ((Trama)Var), Leer);                
        } else if (Var instanceof Otaku) {
            Var = Modificar( ((Otaku)Var), Leer );
        } else if (Var instanceof Animacion) {
            Var = Modificar( ((Animacion)Var), Leer );
        } else if (Var instanceof Personaje) {
            Var = Modificar( ((Personaje)Var), Leer );
        } else if (Var instanceof Audio) {
            Var = Modificar( ((Audio)Var), Leer );
        } else if (Var instanceof Guion) {
            Var = Modificar( ((Guion)Var), Leer );
        }else if (Var instanceof Ingresos) {
            Var = Modificar( ((Ingresos)Var), Leer );
        }else if (Var instanceof Egresos) {
            Var = Modificar( ((Egresos)Var), Leer );
        }else if (Var instanceof Series) {
            Var = Modificar( ((Series)Var), Leer );
        }else if (Var instanceof Peliculas) {
            Var = Modificar( ((Peliculas)Var), Leer );
        }else if (Var instanceof Ovas) {
            Var = Modificar( ((Ovas)Var), Leer );
        }else if (Var instanceof Directores) {
            Var = Modificar( ((Directores)Var), Leer );
        }else if (Var instanceof Precursores) {
            Var = Modificar( ((Precursores)Var), Leer );
        }else if (Var instanceof Login) {
            Var = Modificar( ((Login)Var), Leer );
        }
        return Var;
    }
    public Trama Modificar(Trama Var, String Leer){
        switch ( SubMenu() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Genero de "+Var.getNombre()+":");
                Var.setGenero(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva sinopsis de " + Var.getNombre() + ":");
                Var.setSinopsis(Leer);
                break;
        }
        return Var;
    }
    public Otaku Modificar(Otaku Var, String Leer){
        switch ( SubMenuO() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo genero de "+Var.getNombre()+":");
                Var.setGenero(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo manga de " + Var.getNombre() + ":");
                Var.setManga(Leer);
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo anime de " + Var.getNombre() + ":");
                Var.setAnime(Leer);
                break;
            case 'e':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo juego de " + Var.getNombre() + ":");
                Var.setJuegos(Leer);
                break;
            case 'f':
                Leer = JOptionPane.showInputDialog("Ingrese los Nuevos manga vendidos de " + Var.getNombre() + ":");
                try{
                Var.setMangas_Vendidos(Integer.parseInt(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setMangas_Vendidos(Var.getMangas_Vendidos());
                }catch(java.lang.NullPointerException e){
                    Var.setMangas_Vendidos(Var.getMangas_Vendidos());
                }
                break;
            case 'g':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo personaje famoso de " + Var.getNombre() + ":");
                Var.setPopularidad(Leer);
                break;
            case 'h':
                Leer = JOptionPane.showInputDialog("Ingrese los Nuevos juegos vendidos de " + Var.getNombre() + ":");
                try{
                Var.setVidoejuegos_Vendidos(Integer.parseInt(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setVidoejuegos_Vendidos(Var.getVidoejuegos_Vendidos());
                }catch(java.lang.NullPointerException e){
                    Var.setVidoejuegos_Vendidos(Var.getVidoejuegos_Vendidos());
                }
                break;
        }
        return Var;
    }
    public Animacion Modificar(Animacion Var, String Leer){
        switch ( SubMenuA() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo genero de "+Var.getNombre()+":");
                Var.setGenero(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva casa de animacion de " + Var.getNombre() + ":");
                Var.setCasa_Animacion(Leer);
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo animador de " + Var.getNombre() + ":");
                Var.setAnimadores(Leer);
                break;
            case 'e':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo tipo de animacion de " + Var.getNombre() + ":");
                Var.setTipo(Leer);
                break;
            
        }
        return Var;
    }
    public Personaje Modificar(Personaje Var, String Leer){
        switch ( SubMenuP() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo genero de "+Var.getNombre()+":");
                Var.setGenero(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva casa de animacion de " + Var.getNombre() + ":");
                Var.setCasa_Animacion(Leer);
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo personaje de " + Var.getNombre() + ":");
                Var.setPersonaje(Leer);
                break;
            case 'e':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo genero de " + Var.getPersonaje() + ":");
                try{
                Var.setGen(Leer.charAt(0));
                }catch(java.lang.StringIndexOutOfBoundsException e){
                    Var.setGen(Var.getGen());
                }catch(java.lang.NullPointerException e){
                    Var.setGen(Var.getGen());
                }
                break;
            case 'f':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva personalidad de " + Var.getPersonaje() + ":");
                Var.setPersonalidad(Leer);
                break;
            
        }
        return Var;
    }
    public Audio Modificar(Audio Var, String Leer){
        switch ( SubMenuAu() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo genero de "+Var.getNombre()+":");
                Var.setGenero(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva casa de animacion de " + Var.getNombre() + ":");
                Var.setCasa_Animacion(Leer);
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo actor de voz de " + Var.getNombre() + ":");
                Var.setActor(Leer);
                break;
            case 'e':
                Leer = JOptionPane.showInputDialog("Ingrese el Nueva banda de opening de " + Var.getNombre() + ":");
                Var.setOp(Leer);
                break;
            case 'f':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva banda de ending de " + Var.getNombre() + ":");
                Var.setEnd(Leer);
                break;
            
        }
        return Var;
    }
    public Guion Modificar(Guion Var, String Leer){
        switch ( SubMenuGu() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo genero de "+Var.getNombre()+":");
                Var.setGenero(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva casa de animacion de " + Var.getNombre() + ":");
                Var.setCasa_Animacion(Leer);
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo mangaka de " + Var.getNombre() + ":");
                Var.setMangaka(Leer);
                break;
            
        }
        return Var;
    }
    public Ingresos Modificar(Ingresos Var, String Leer){
        switch ( SubMenuI() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo numero de reporte de "+String.valueOf(Var.getNumero())+":");
                try{
                Var.setNumero(Leer.toCharArray());
                }catch(java.lang.NullPointerException e){
                    Var.setNumero(Var.getNumero());
                }
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Fecha de "+String.valueOf(Var.getNumero())+":");
                Var.setFecha(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva cantidad de " + String.valueOf(Var.getNumero()) + ":");
                try{
                Var.setCant(Float.parseFloat(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setCant(Var.getCant());
                }catch(java.lang.NullPointerException e){
                    Var.setCant(Var.getCant());
                }
                break;
        }
        return Var;
    }
    public Egresos Modificar(Egresos Var, String Leer){
        switch ( SubMenuI() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo numero de reporte de "+String.valueOf(Var.getNumero())+":");
                try{
                Var.setNumero(Leer.toCharArray());
                }catch(java.lang.NullPointerException e){
                    Var.setNumero(Var.getNumero());
                }
                
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Fecha de "+String.valueOf(Var.getNumero())+":");
                Var.setFecha(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva cantidad de " + String.valueOf(Var.getNumero()) + ":");
                try{
                Var.setCant(Float.parseFloat(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setCant(Var.getCant());
                }catch(java.lang.NullPointerException e){
                    Var.setCant(Var.getCant());
                }
                break;
        }
        return Var;
    }
    public Series Modificar(Series Var, String Leer){
        switch ( SubMenuS() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo titulo de "+Var.getTitulo()+":");
                Var.setTitulo(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva fecha de estreno de "+Var.getTitulo()+":");
                Var.setFecha(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva cantidad de capitulos de " + Var.getTitulo() + ":");
                try{
                Var.setCaps(Integer.parseInt(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setCaps(Var.getCaps());
                }catch(java.lang.NullPointerException e){
                    Var.setCaps(Var.getCaps());
                }
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva cantidad de temporadas de " + Var.getTitulo() + ":");
                try{
                Var.setTemp(Integer.parseInt(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setTemp(Var.getTemp());
                }catch(java.lang.NullPointerException e){
                    Var.setTemp(Var.getTemp());
                }
                break;
            
        }
        return Var;
    }
     public Peliculas Modificar(Peliculas Var, String Leer){
        switch ( SubMenuPE() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo titulo de "+Var.getTitulo()+":");
                Var.setTitulo(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva fecha de estreno de "+Var.getTitulo()+":");
                Var.setFecha(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva duracion de " + Var.getTitulo() + ":");
                
                Var.setDuracion(Leer);
                
                break;
            
        }
        return Var;
    }
     public Ovas Modificar(Ovas Var, String Leer){
        switch ( SubMenuOV() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo titulo de "+Var.getTitulo()+":");
                Var.setTitulo(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva fecha de estreno de "+Var.getTitulo()+":");
                Var.setFecha(Leer);
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva cantidad de ovas de " + Var.getTitulo() + ":");
                try{
                Var.setNumero_Ova(Integer.parseInt(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setNumero_Ova(Var.getNumero_Ova());
                }catch(java.lang.NullPointerException e){
                    Var.setNumero_Ova(Var.getNumero_Ova());
                }
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva cantidad de capitulos de " + Var.getTitulo() + ":");
                try{
                Var.setCaps(Integer.parseInt(Leer));
                }catch(java.lang.NumberFormatException e){
                    Var.setCaps(Var.getCaps());
                }catch(java.lang.NullPointerException e){
                    Var.setCaps(Var.getCaps());
                }
                break;
            
        }
        return Var;
    }
     public Directores Modificar(Directores Var, String Leer){
        switch ( SubMenuDP() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Genero de "+Var.getNombre()+":");
                try{
                Var.setGenero(Leer.charAt(0));
                }catch(java.lang.StringIndexOutOfBoundsException e){
                    Var.setGenero(Var.getGenero());
                }
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Primer Obra de " + Var.getNombre() + ":");
                Var.setPrimer_Obra(Leer);
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Ultima obra de " + Var.getNombre() + ":");
                Var.setUltima_Obra(Leer);
                break;
            case 'e':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Obra mas famosa de " + Var.getNombre() + ":");
                Var.setObra_Famosa(Leer);
                break;
        }
        return Var;
    }
     public Precursores Modificar(Precursores Var, String Leer){
        switch ( SubMenuDP() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Nombre de "+Var.getNombre()+":");
                Var.setNombre(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Genero de "+Var.getNombre()+":");
                try{
                Var.setGenero(Leer.charAt(0));
                }catch(java.lang.StringIndexOutOfBoundsException e){
                    Var.setGenero(Var.getGenero());
                }
                break;
            case 'c':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Primer Obra de " + Var.getNombre() + ":");
                Var.setPrimer_Obra(Leer);
                break;
            case 'd':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Ultima obra de " + Var.getNombre() + ":");
                Var.setUltima_Obra(Leer);
                break;
            case 'e':
                Leer = JOptionPane.showInputDialog("Ingrese la Nueva Obra mas famosa de " + Var.getNombre() + ":");
                Var.setObra_Famosa(Leer);
                break;
        }
        return Var;
    }
     public Login Modificar(Login Var, String Leer){
        switch ( SubMenuL() ) {
            case 'a':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo usuario de "+Var.getUser()+":");
                Var.setUser(Leer);
                break;
            case 'b':
                Leer = JOptionPane.showInputDialog("Ingrese el Nuevo Genero de "+Var.getUser()+":");
                Var.setPassword(Leer);
                break;
            
        }
        return Var;
    }
    public char SubMenu(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Nombre.\n"
                    + "b.-> Genero.\n"
                    + "c.-> Sinopsis.\n"
                    + "d.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'd';
        }
        
        if(Op<'a' || Op>'d'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuO(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Nombre.\n"
                    + "b.-> Genero.\n"
                    + "c.-> Manga.\n"
                    + "d.-> Anime. \n"
                    + "e.-> Videojuegos. \n"
                    + "f.-> Mangas vendidos. \n"
                    + "g.-> Personaje Popular. \n"
                    + "h.-> Videojuegos Vendidos. \n"
                    + "i.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'i';
        }
        
        if(Op<'a' || Op>'i'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuA(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Nombre.\n"
                    + "b.-> Genero.\n"
                    + "c.-> Casa de animacion.\n"
                    + "d.-> Animadores. \n"
                    + "e.-> Tipo de animacion. \n"
                    + "f.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'f';
        }
        
        if(Op<'a' || Op>'f'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuP(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Nombre.\n"
                    + "b.-> Genero.\n"
                    + "c.-> Casa de animacion.\n"
                    + "d.-> Personaje. \n"
                    + "e.-> Genero del personaje. \n"
                    + "f.-> Personalidad. \n"
                    + "g.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'g';
        }
        
        if(Op<'a' || Op>'g'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuAu(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Nombre.\n"
                    + "b.-> Genero.\n"
                    + "c.-> Casa de animacion.\n"
                    + "d.-> Actor de voz. \n"
                    + "e.-> Banda de Opening. \n"
                    + "f.-> Banda de Ending. \n"
                    + "g.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'g';
        }
        
        if(Op<'a' || Op>'g'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuGu(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Nombre.\n"
                    + "b.-> Genero.\n"
                    + "c.-> Casa de animacion.\n"
                    + "d.-> Mangaka \n"
                    + "e.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'e';
        }
        
        if(Op<'a' || Op>'e'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuI(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Numero de reporte.\n"
                    + "b.-> Fecha.\n"
                    + "c.-> Cantidad.\n"
                    + "d.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'd';
        }
        
        if(Op<'a' || Op>'d'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuS(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Titulo.\n"
                    + "b.-> Fecha de estreno.\n"
                    + "c.-> Numero de capitulos.\n"
                    + "d.-> Numero de temporadas. \n"
                    + "e.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'e';
        }
        
        if(Op<'a' || Op>'e'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuPE(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Titulo.\n"
                    + "b.-> Fecha de estreno.\n"
                    + "c.-> Duracion.\n"
                    + "d.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'd';
        }
        
        if(Op<'a' || Op>'d'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuOV(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Titulo.\n"
                    + "b.-> Fecha de estreno.\n"
                    + "c.-> Numero de ovas.\n"
                    + "d.-> Numero de capitulos. \n"
                    + "e.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'e';
        }
        
        if(Op<'a' || Op>'e'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuDP(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Nombre.\n"
                    + "b.-> Genero.\n"
                    + "c.-> Primer obra.\n"
                    + "d.-> Ultima obra. \n"
                    + "e.-> Obra mas famosa. \n"
                    + "f.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'f';
        }
        
        if(Op<'a' || Op>'f'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public char SubMenuL(){
        char Op;
        try{
            Op = JOptionPane.showInputDialog("*****Menú Modificar*****\n"
                    + "a.-> Usuario.\n"
                    + "b.-> Contraseña.\n"
                    + "c.-> Regresar al Menú Principal.\n"
                    + "Su Elección Es:").toLowerCase().charAt(0);
        }catch(java.lang.StringIndexOutOfBoundsException e){
            Op = ' ';
        }catch(java.lang.NullPointerException e){
            Op = 'd';
        }
        
        if(Op<'a' || Op>'d'){
            JOptionPane.showMessageDialog(null, "La Opción Ingresada NO Existe!!!\n"
                    + "Favor Vuelva a Intentarlo!!!");
            Op = SubMenu();//Llamado Recursivo
        }
        return Op;
    }
    public void Guardar(Anime Arreglo[],char sm) throws IOException {//Odaly
        //char sm = SubMenuTipos();
        //Arreglo = Predefinido();
        FileWriter Archivo = null;
        PrintWriter Linea = null;
        switch (sm) {
            case 'a':
                Archivo = new FileWriter("TramaBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre\tGenero\tSinopsis\n");
                break;
            case 'b':
                Archivo = new FileWriter("OtakuBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre \t Genero \t Manga \t Anime \t Juegos \t Mangas Vendidos \t Personaje mas popular \t Video Juegos Vendidos\n");
                break; 
            case 'c':
                Archivo = new FileWriter("AnimacionBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre \t Genero \t Casa de animacion \t Animadores \t Tipo de animacion \n");
                break;
            case 'd':
                Archivo = new FileWriter("PersonajeBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre \t Genero \t Casa de animacion \t Personaje \t Sexo \t Personalidad\n");
                break;
            case 'e':
                Archivo = new FileWriter("AudioBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre \t Genero \t Casa de animacion \t Actor de voz \t Banda de Opening \t Banda de ending\n");
                break;
           case 'f':
                Archivo = new FileWriter("GuionBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre \t Genero \t Casa de animacion \t Mangaka \n");
                break;
            case 'g':
                Archivo = new FileWriter("IngresosBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Numero de reporte \t Fecha \t Cantidad de ingresos \n");
                break;
            case 'h':
                Archivo = new FileWriter("EgresosBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Numero de reporte \t Fecha \t Cantidad de egresos \n");
                break;
            case 'i':
                Archivo = new FileWriter("SeriesBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Titulo \t Fecha \t Capitulos \t Temporadas \n");
                break;
            case 'j':
                Archivo = new FileWriter("PeliculasBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Titulo \t Fecha \t Duracion\n");
                break;
            case 'k':
                Archivo = new FileWriter("OvasBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Titulo \t Fecha \t Ovas \t Capitulos \n");
                break;
            case 'l':
                Archivo = new FileWriter("DirectoresBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre \t Genero \t Primer Obra \t Ultima Obra \t Obra famosa\n");
                break;
            case 'm':
                Archivo = new FileWriter("PrecursoresBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Nombre \t Genero \t Primer Obra \t Ultima Obra \t Obra famosa\n");
                break;
            case 'n':
                Archivo = new FileWriter("UsuariosBD.xls");
                Linea = new PrintWriter(Archivo);
                Linea.print("Usuario \t Contraseña \n");
                break;
        }
        
        if(Linea != null){
            for (int i = 0; i < Arreglo.length; i++) {
                if( sm == 'a' && Arreglo[i] instanceof Trama ||
                    sm == 'b' && Arreglo[i] instanceof Otaku ||
                    sm == 'c' && Arreglo[i] instanceof Animacion ||
                    sm == 'd' && Arreglo[i] instanceof Personaje ||
                    sm == 'e' && Arreglo[i] instanceof Audio ||
                    sm == 'f' && Arreglo[i] instanceof Guion ||
                    sm == 'g' && Arreglo[i] instanceof Ingresos ||
                    sm == 'h' && Arreglo[i] instanceof Egresos ||
                    sm == 'i' && Arreglo[i] instanceof Series ||
                    sm == 'j' && Arreglo[i] instanceof Peliculas ||
                    sm == 'k' && Arreglo[i] instanceof Ovas ||
                    sm == 'l' && Arreglo[i] instanceof Directores ||
                    sm == 'm' && Arreglo[i] instanceof Precursores ||
                    sm == 'n' && Arreglo[i] instanceof Login){
                    Arreglo[i].Guardar(Linea);
                }
            }//Fin del ciclo for
        }

        Archivo.close();
    }
    public Connection Conec(Connection Con){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://remotemysql.com/I66eN9EkOA","I66eN9EkOA","eryxH5VrAn");
            return Con;
        }catch(java.sql.SQLException e){
            JOptionPane.showMessageDialog(null,"NO fue posible establecer Conexión!!!\nFavor Verifique Driver, Servidor, Base de Datos, Usuario y Contraseña!!!");
        }catch(java.lang.ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "El proyecto carece del Driver de Conexión!!!\nFavor Verifique su Inclusión y Ruta!!!");
        }
        return null;
    }
    public boolean DesConecta(java.sql.Connection Con){
        try {
            Con.close();
            return true;
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null,"NO fue posible cerrar la Conexión!!!\nFavor Espere un Momento y Vuelva a Intentarlo!!!");
        } catch(java.lang.NullPointerException e){
            JOptionPane.showMessageDialog(null,"NO es posible cerrar una Conexión, que nunca se creó!!!");
        }
        return false;
    }

    
}
