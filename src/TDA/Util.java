/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Util {
    public static String leerTexto(String nombreArchivo){
        String s="";
        try {
            Scanner sc=new Scanner(new File(nombreArchivo));
            s=sc.nextLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    public static HashMap<String,Integer> calcularFrecuencias (String texto){
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<texto.length();i++){
            String s=String.valueOf(texto.charAt(i));
            if(!hm.containsKey(s)){
                hm.put(s,1);
            }
            else{
                hm.put(s,hm.get(s)+1);
            }
        }
        return hm;
    }
    public static String binarioHexadecimal (String binario){
        String s="";
        int size = binario.length();
        if(size%4==0){
            int size4=size/4;
            for(int i=0;i<size4;i++){
                String s1=binario.substring(4*i,4*i+4);
                if("1010".equals(s1)){
                    s=s+"A";
                }
                else if("1011".equals(s1)){
                    s=s+"B";
                }
                else if("1100".equals(s1)){
                    s=s+"C";
                }
                else if("1101".equals(s1)){
                    s=s+"D";
                }
                else if("1110".equals(s1)){
                    s=s+"E";
                }
                else if("1111".equals(s1)){
                    s=s+"F";
                }
                else {
                    int temp=Integer.parseInt(String.valueOf(s1.charAt(0)))*8+Integer.parseInt(String.valueOf(s1.charAt(1)))*4
                    +Integer.parseInt(String.valueOf(s1.charAt(2)))*2+Integer.parseInt(String.valueOf(s1.charAt(3)));
                    
                    s=s+temp;
                    
                }       
            }
        }
        else if(size%4==1){
            String fin=String.valueOf(binario.charAt(binario.length()-1));
            String binario2=binario.substring(0,binario.length()-1);
            int size2 = binario2.length();
            int size42=size2/4;
            for(int i=0;i<size42;i++){
                String s1=binario2.substring(4*i,4*i+4);
                if("1010".equals(s1)){
                    s=s+"A";
                }
                else if("1011".equals(s1)){
                    s=s+"B";
                }
                else if("1100".equals(s1)){
                    s=s+"C";
                }
                else if("1101".equals(s1)){
                    s=s+"D";
                }
                else if("1110".equals(s1)){
                    s=s+"E";
                }
                else if("1111".equals(s1)){
                    s=s+"F";
                }
                else {
                    int temp=Integer.parseInt(String.valueOf(s1.charAt(0)))*8+Integer.parseInt(String.valueOf(s1.charAt(1)))*4
                    +Integer.parseInt(String.valueOf(s1.charAt(2)))*2+Integer.parseInt(String.valueOf(s1.charAt(3)));
                    
                    s=s+temp;
                    
                }       
            }
            String bf=fin+"000";
            if("1010".equals(bf)){
                    s=s+"A---";
                }
                else if("1011".equals(bf)){
                    s=s+"B---";
                }
                else if("1100".equals(bf)){
                    s=s+"C---";
                }
                else if("1101".equals(bf)){
                    s=s+"D---";
                }
                else if("1110".equals(bf)){
                    s=s+"E---";
                }
                else if("1111".equals(bf)){
                    s=s+"F---";
                }
                else {
                    int temp=Integer.parseInt(String.valueOf(bf.charAt(0)))*8+Integer.parseInt(String.valueOf(bf.charAt(1)))*4
                    +Integer.parseInt(String.valueOf(bf.charAt(2)))*2+Integer.parseInt(String.valueOf(bf.charAt(3)));
                    
                    s=s+temp+"---";
                    
                }
            
        }
        else if(size%4==2){
            String fin=binario.substring(binario.length()-2,binario.length());;
            String binario2=binario.substring(0,binario.length()-2);
            int size2 = binario2.length();
            int size42=size2/4;
            for(int i=0;i<size42;i++){
                String s1=binario2.substring(4*i,4*i+4);
                if("1010".equals(s1)){
                    s=s+"A";
                }
                else if("1011".equals(s1)){
                    s=s+"B";
                }
                else if("1100".equals(s1)){
                    s=s+"C";
                }
                else if("1101".equals(s1)){
                    s=s+"D";
                }
                else if("1110".equals(s1)){
                    s=s+"E";
                }
                else if("1111".equals(s1)){
                    s=s+"F";
                }
                else {
                    int temp=Integer.parseInt(String.valueOf(s1.charAt(0)))*8+Integer.parseInt(String.valueOf(s1.charAt(1)))*4
                    +Integer.parseInt(String.valueOf(s1.charAt(2)))*2+Integer.parseInt(String.valueOf(s1.charAt(3)));
                    
                    s=s+temp;
                    
                }       
            }
            String bf=fin+"00";
            if("1010".equals(bf)){
                    s=s+"A--";
                }
                else if("1011".equals(bf)){
                    s=s+"B--";
                }
                else if("1100".equals(bf)){
                    s=s+"C--";
                }
                else if("1101".equals(bf)){
                    s=s+"D--";
                }
                else if("1110".equals(bf)){
                    s=s+"E--";
                }
                else if("1111".equals(bf)){
                    s=s+"F--";
                }
                else {
                    int temp=Integer.parseInt(String.valueOf(bf.charAt(0)))*8+Integer.parseInt(String.valueOf(bf.charAt(1)))*4
                    +Integer.parseInt(String.valueOf(bf.charAt(2)))*2+Integer.parseInt(String.valueOf(bf.charAt(3)));
                    
                    s=s+temp+"--";
                    
                }
        }
        else{
            String fin=binario.substring(binario.length()-3,binario.length());;
            String binario2=binario.substring(0,binario.length()-3);
            int size2 = binario2.length();
            int size42=size2/4;
            for(int i=0;i<size42;i++){
                String s1=binario2.substring(4*i,4*i+4);
                if("1010".equals(s1)){
                    s=s+"A";
                }
                else if("1011".equals(s1)){
                    s=s+"B";
                }
                else if("1100".equals(s1)){
                    s=s+"C";
                }
                else if("1101".equals(s1)){
                    s=s+"D";
                }
                else if("1110".equals(s1)){
                    s=s+"E";
                }
                else if("1111".equals(s1)){
                    s=s+"F";
                }
                else {
                    int temp=Integer.parseInt(String.valueOf(s1.charAt(0)))*8+Integer.parseInt(String.valueOf(s1.charAt(1)))*4
                    +Integer.parseInt(String.valueOf(s1.charAt(2)))*2+Integer.parseInt(String.valueOf(s1.charAt(3)));
                    
                    s=s+temp;
                    
                }       
            }
            String bf=fin+"0";
            if("1010".equals(bf)){
                    s=s+"A-";
                }
                else if("1011".equals(bf)){
                    s=s+"B-";
                }
                else if("1100".equals(bf)){
                    s=s+"C-";
                }
                else if("1101".equals(bf)){
                    s=s+"D-";
                }
                else if("1110".equals(bf)){
                    s=s+"E-";
                }
                else if("1111".equals(bf)){
                    s=s+"F-";
                }
                else {
                    int temp=Integer.parseInt(String.valueOf(bf.charAt(0)))*8+Integer.parseInt(String.valueOf(bf.charAt(1)))*4
                    +Integer.parseInt(String.valueOf(bf.charAt(2)))*2+Integer.parseInt(String.valueOf(bf.charAt(3)));
                    
                    s=s+temp+"-";
                    
                }
            
        }
        
    return s;
    }
    public static String hexadecimalBinario (String hex){
        String s="";
        if("-".equals(hex.substring(hex.length()-1,hex.length()))&&!"-".equals(hex.substring(hex.length()-2,hex.length()-1))){
            String fin=hex.substring(hex.length()-1,hex.length());
            String hex2=hex.substring(0,hex.length()-1);
            int m=0;
            for(int i=0;i<hex2.length();i++){
                String car=hex2.substring(m,i+1);
                if("A".equals(car)){
                    s=s+"1010";
                }
                else if("B".equals(car)){
                    s=s+"1011";
                }
                else if("C".equals(car)){
                    s=s+"1100";
                }
                else if("D".equals(car)){
                    s=s+"1101";
                }
                else if("E".equals(car)){
                    s=s+"1110";
                }
                else if("F".equals(car)){
                    s=s+"1111";
                }
                else{
                    int temp=Integer.parseInt(car);
                    String b=binario(temp);
                    if(b.length()==1){
                        b="000"+b;
                    }
                    else if(b.length()==2){
                        b="00"+b;
                    }
                    else if(b.length()==3){
                        b="0"+b;
                    }
                    s=s+b;
                }
                    
                m++;
            }
            return s.substring(0,s.length()-1);
        }
        else if("--".equals(hex.substring(hex.length()-2,hex.length()))&&!"-".equals(hex.substring(hex.length()-3,hex.length()-2))){
            String fin=hex.substring(hex.length()-2,hex.length());
            String hex2=hex.substring(0,hex.length()-2);
            int m=0;
            for(int i=0;i<hex2.length();i++){
                String car=hex2.substring(m,i+1);
                if("A".equals(car)){
                    s=s+"1010";
                }
                else if("B".equals(car)){
                    s=s+"1011";
                }
                else if("C".equals(car)){
                    s=s+"1100";
                }
                else if("D".equals(car)){
                    s=s+"1101";
                }
                else if("E".equals(car)){
                    s=s+"1110";
                }
                else if("F".equals(car)){
                    s=s+"1111";
                }
                else{
                    int temp=Integer.parseInt(car);
                    String b=binario(temp);
                    if(b.length()==1){
                        b="000"+b;
                    }
                    else if(b.length()==2){
                        b="00"+b;
                    }
                    else if(b.length()==3){
                        b="0"+b;
                    }
                    s=s+b;
                }
                    
                m++;
            }
            return s.substring(0,s.length()-2);
        }
        else if("---".equals(hex.substring(hex.length()-3,hex.length()))){
            String fin=hex.substring(hex.length()-3,hex.length());
            String hex2=hex.substring(0,hex.length()-3);
            int m=0;
            for(int i=0;i<hex2.length();i++){
                String car=hex2.substring(m,i+1);
                if("A".equals(car)){
                    s=s+"1010";
                }
                else if("B".equals(car)){
                    s=s+"1011";
                }
                else if("C".equals(car)){
                    s=s+"1100";
                }
                else if("D".equals(car)){
                    s=s+"1101";
                }
                else if("E".equals(car)){
                    s=s+"1110";
                }
                else if("F".equals(car)){
                    s=s+"1111";
                }
                else{
                    int temp=Integer.parseInt(car);
                    String b=binario(temp);
                    if(b.length()==1){
                        b="000"+b;
                    }
                    else if(b.length()==2){
                        b="00"+b;
                    }
                    else if(b.length()==3){
                        b="0"+b;
                    }
                    s=s+b;
                }
                    
                m++;
            }
            return s.substring(0,s.length()-3);
        }
        else{
            int m=0;
            for(int i=0;i<hex.length();i++){
                String car=hex.substring(m,i+1);
                if("A".equals(car)){
                    s=s+"1010";
                }
                else if("B".equals(car)){
                    s=s+"1011";
                }
                else if("C".equals(car)){
                    s=s+"1100";
                }
                else if("D".equals(car)){
                    s=s+"1101";
                }
                else if("E".equals(car)){
                    s=s+"1110";
                }
                else if("F".equals(car)){
                    s=s+"1111";
                }
                else{
                    int temp=Integer.parseInt(car);
                    String b=binario(temp);
                    if(b.length()==1){
                        b="000"+b;
                    }
                    else if(b.length()==2){
                        b="00"+b;
                    }
                    else if(b.length()==3){
                        b="0"+b;
                    }
                    s=s+b;
                }
                    
                m++;
            }
            return s;
            
        }

    }
    private static String binario(int i){
        
        if(i==1 || i==0){
            return Integer.toString(i);
        }
        else{
            return binario(i/2)+i%2;
        }
        
    }
    public static HashMap<String,String> leerMapa(String nombreArchivo){
        HashMap<String,String> hm=new HashMap<>();
        try {
            Scanner sc=new Scanner(new File(nombreArchivo));
            while(sc.hasNext()){
                String s=sc.nextLine();
                String[] split = s.split("=");
                hm.put(split[0], split[1]);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hm;
    }
    
    public static void guardarTexto(String nombreArchivo, String texto, HashMap<String,String> mapa){
        FileWriter fichero = null;
        PrintWriter escritor = null;
        try {
            fichero=new FileWriter(nombreArchivo);
            escritor=new PrintWriter(fichero);
            escritor.flush();
            escritor.write(texto);
            escritor.println();
            escritor.close();
            
            
                fichero=new FileWriter(nombreArchivo.substring(0,nombreArchivo.length()-4)+"_compress.txt");
                escritor=new PrintWriter(fichero);
                escritor.flush();
                for (Map.Entry<String,String> e: mapa.entrySet()){
                 escritor.write(e.getKey()+"="+e.getValue());
                 escritor.println();
                }
                escritor.close();
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
}
