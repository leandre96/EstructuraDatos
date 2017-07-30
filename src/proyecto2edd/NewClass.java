/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2edd;

import TDA.ArbolHuffman;
import TDA.Util;
import java.io.File;
import java.nio.file.Files;
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
        hm.put("T", 3);
        HashMap<String,Integer> hm1=Util.calcularFrecuencias("Avtgdbdusksoyiojjooiji");
        ArbolHuffman ab=new ArbolHuffman(hm);
        
        System.out.println(ab);
        System.out.println(ab.calcularCodigos());
        File f=new File("hi_compress.txt");
        System.out.println(f.delete());
//        String txt=Util.leerTexto("estu.txt");
//        HashMap<String,Integer> hm2=Util.calcularFrecuencias(txt);
//        ArbolHuffman ab2=new ArbolHuffman(hm2);
//        HashMap<String,String> hss=ab2.calcularCodigos();
//        String nou=ArbolHuffman.codificar(txt, hss);
//        Util.guardarTexto("estu", nou, hss);
//          String txt=Util.leerTexto("estu.txt");
//          HashMap<String,String> hss=Util.leerMapa("estu_compress.txt");
//          String n=ArbolHuffman.decodificar(txt, hss);
//          Util.guardarTexto("estu", n, hss);
        
    }
}
