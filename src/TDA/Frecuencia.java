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

public class Frecuencia {
    private String letra;
    private Integer hertz;

    public Frecuencia(String letra, Integer hertz) {
        this.letra = letra;
        this.hertz = hertz;
    }

    public String getLetra() {
        return letra;
    }

    @Override
    public boolean equals(Object obj) {
        Frecuencia f=(Frecuencia)obj;
        return this.hertz.equals(f.hertz)&&this.letra.equals(f.letra);
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Integer getHertz() {
        return hertz;
    }

    public void setHertz(Integer hertz) {
        this.hertz = hertz;
    }

    @Override
    public String toString() {
        return "{"  + letra + ", " + hertz + '}';
    }
}
