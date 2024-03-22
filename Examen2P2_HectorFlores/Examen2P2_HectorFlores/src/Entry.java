/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hecto
 */
public class Entry {
    String username;
    long pos;
    Entry siguiente;

    public Entry(String username, long pos) {
        this.username = username;
        this.pos = pos;
        this.siguiente = null;
    }
    
    
}
