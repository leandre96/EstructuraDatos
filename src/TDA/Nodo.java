/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

/**
 *
 * @author User
 */

public class Nodo<E> {
    private E data;
    private Nodo<E> izq,der;
    public Nodo(E data){
        this.data=data;
        this.izq=this.der=null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Nodo<E> getIzq() {
        return izq;
    }

    public void setIzq(Nodo<E> izq) {
        this.izq = izq;
    }

    public Nodo<E> getDer() {
        return der;
    }

    public void setDer(Nodo<E> der) {
        this.der = der;
    }    
}
