
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hecto
 */
public class PSNUsers {
    static RandomAccessFile raf;
    static HashTable users;

    public PSNUsers() throws IOException {
        raf = new RandomAccessFile("Registro.psn", "rw");
        reloadHashTable();
    }

    private void reloadHashTable() throws IOException{
        users = new HashTable();

        raf.seek(0);
        long pos = 0;

        while (raf.getFilePointer() < raf.length()){
            String username = (String) raf.readUTF();
            raf.skipBytes(16);
            boolean activado = (boolean) raf.readBoolean();

            if (activado){
                users.add(username, pos);
            }

            pos++;
        }
    }

    /*
    Formato de Registro.psn

    String username
    long puntos por trofeos
    long trofeos
    boolean activado
    */

    public static boolean addUser(String username) throws IOException{
        if(users.search(username) == -1){
            
            raf.seek(raf.length());
            raf.writeUTF(username);
            raf.writeLong(0);
            raf.writeLong(0);
            raf.writeBoolean(true);

            raf.seek(0);
            long pos = 0;

            while (raf.getFilePointer() < raf.length()){
                raf.readUTF();
                raf.skipBytes(17);
                pos++;
            }

            users.add(username, pos);

            JOptionPane.showMessageDialog(null, "Se ha añadido a " + username);
            return true;
        }

        JOptionPane.showMessageDialog(null, "El username ya existe, intente de nuevo");
        return false;
    }

    public static boolean isUserUnique(String username) throws IOException{
        if (raf.length() == 0){
            return true;
        }
        
        raf.seek(0);

        while (raf.getFilePointer() < raf.length()){
            String userRef = (String) raf.readUTF();

            if (username.equals(userRef)){
                return false;
            }

            raf.skipBytes(17); //8 bytes de long + 8 bytes de long + 1 byte de boolean = 17bytes
        }

        return true;
    }

    public static boolean deactivateUser(String username) throws IOException{
        long pos = users.search(username);
        
        if (pos != -1){
            
            if (raf.length() == 0){
                JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
                return false;
            }
            
            raf.seek(0);
            long rafPos = 0;
            while(raf.getFilePointer() < raf.length()){
                raf.readUTF();
                raf.skipBytes(16);
                
                if (rafPos == pos){
                    raf.writeBoolean(false);
                } else {
                    raf.skipBytes(1);
                }
                
                rafPos++;
            }
            users.remove(username);
            JOptionPane.showMessageDialog(null, "Se ha desactivado " + username);
            return true;
        }
        
        JOptionPane.showMessageDialog(null, "User no existe");
        return false;
    }
    
    /*
    Formato de psn.psn
    
    long codigo del ganador
    String tipo de trofeo
    String juego al que pertenece el trofeo
    String nombre del trofeo
    long fecha en la que se gano
    */
    
    public static void addTrophyTo(String username, String trophyGame, String trophyName, Trophy type) throws IOException{
        RandomAccessFile psn = new RandomAccessFile ("psn.psn" , "rw");
        long pos = users.search(username);
        
        System.out.println("Pos en escritura: " + pos);
        
        if (pos != -1){
            psn.seek(psn.length());
            psn.writeLong(pos);
            psn.writeUTF(type.name());
            psn.writeUTF(trophyGame);
            psn.writeUTF(trophyName);
            psn.writeLong(Calendar.getInstance().getTimeInMillis());
            
            raf.seek(0);
            long rafPos = 0;
            
            while (raf.getFilePointer() < raf.length()){
                raf.readUTF();
                long pts = (long) raf.readLong() + type.points;
                long trophies = (long) raf.readLong() + 1;
                
                if (rafPos == pos){
                    raf.seek(raf.getFilePointer() - 16);
                    raf.writeLong(pts);
                    raf.writeLong(trophies);
                    JOptionPane.showMessageDialog(null, "Se ha asignado el trofeo. Felicidades!");
                }
                
                raf.readBoolean();
                rafPos++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe el usuario");
        }
    }
    
    /*
    Formato de psn.psn
    
    long codigo del ganador
    String tipo de trofeo
    String juego al que pertenece el trofeo
    String nombre del trofeo
    long fecha en la que se gano
    */
    
    /*
    Formato de Registro.psn

    String username
    long puntos por trofeos
    long trofeos
    boolean activado
    */
    public static void playerInfo(String username) throws IOException{
        long pos = users.search(username);
        
        if (pos != -1){
            String accum = "";
            
            raf.seek(0);
            long rafPos = 1;
            while(raf.getFilePointer() < raf.length()){
                System.out.println("Entra al primero");
                String user = (String) raf.readUTF();
                long pts = (long) raf.readLong();
                long trofeos = (long) raf.readLong();
                boolean activado = (boolean) raf.readBoolean();
                String state = "";
                
                if (activado){
                    state = "Activado";
                } else {
                    state = "Desactivado";
                }
                
                System.out.println(pos + ", " + rafPos);
                System.out.println(pos == rafPos);
                if (pos == rafPos){
                    accum += "Username: " + user + "\nPuntos por trofeos: " + pts + "\nCantidad de trofeos: " + trofeos + "\nEstado: " + state + "\nTrofeos:\n";
                }
                
                rafPos++;
            }
            
            RandomAccessFile psn = new RandomAccessFile("psn.psn", "rw");
            psn.seek(0);
            while (psn.getFilePointer() < psn.length()){
                System.out.println("Entra al segundo");
                long psnPos = (long) psn.readLong();
                String tipo = (String) psn.readUTF();
                String juego = (String) psn.readUTF();
                String nombre = (String) psn.readUTF();
                long date = (long) psn.readLong();
                
                
                System.out.println(psnPos + ", " + pos);
                System.out.println(psnPos == pos);
                if (psnPos == pos){
                    
                    Calendar fecha = Calendar.getInstance();
                    fecha.setTimeInMillis(date);
                    accum += "Fecha: " + fecha.getTime() + "   Tipo: " + tipo + "   Juego: " + juego + "   Descripcion: " + nombre + "\n";
                }
                
                psnPos++;
            }
            
            if (accum.equals("")){
                JOptionPane.showMessageDialog(null, username + " no tiene trofeos :(");
            } else {
                JOptionPane.showMessageDialog(null, accum);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe");
        } 
    }
    
    
}
