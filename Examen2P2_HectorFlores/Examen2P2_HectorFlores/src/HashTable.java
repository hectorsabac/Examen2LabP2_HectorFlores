/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hecto
 */
public class HashTable {
    Entry inicio = null;
    int size = 0;
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    public void add(String username, long pos){
        
        Entry entrada = new Entry(username, pos);
        
        if (isEmpty()){
            inicio = entrada;
        } else {
            Entry actual = inicio;
            
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            
            actual.siguiente = entrada;
        }
        
        size++;
    }
    
    public boolean remove(String username){
        if (!isEmpty()){
            if (inicio.username.equals(username)){
                inicio = inicio.siguiente;
                size--;
                return true;
            } else {
                Entry actual = inicio;
                
                while (actual.siguiente != null){
                    if (actual.siguiente.username.equals(username)){
                        actual.siguiente = actual.siguiente.siguiente;
                        size--;
                        return true;
                    }
                    
                    actual = actual.siguiente;
                    
                }
            }
        }
        
        return false;
    }
    
    public long search(String username){
        if (!isEmpty()){
            if (inicio.username.equals(username)){
                return inicio.pos;
            } else {
                Entry actual = inicio;
                
                while (actual.siguiente != null){
                    if (actual.siguiente.username.equals(username)){
                        return actual.siguiente.pos;
                    }
                    
                    actual = actual.siguiente;
                }
            }
        }
        
        return -1;
    }
    
}
