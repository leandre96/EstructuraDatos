/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2edd;

import TDA.ArbolHuffman;
import TDA.Util;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class NewClass {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("A", 1);
        hm.put("B", 1);
        hm.put("C", 3);
        hm.put("D", 4);
        hm.put("F", 2);
        hm.put("H", 5);
        hm.put("I", 1);
       
        HashMap<String,Integer> hm1=Util.calcularFrecuencias("AFTFTHSIKWOWWMWH");
        ArbolHuffman ab=new ArbolHuffman(hm1);
        System.out.println(ab);
    }
}
