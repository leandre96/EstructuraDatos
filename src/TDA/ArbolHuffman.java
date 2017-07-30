/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author User
 */
public class ArbolHuffman {
    private Nodo<Frecuencia> raiz;
    
    public ArbolHuffman(HashMap<String,Integer> mapa) {
        raiz=null;
        
        PriorityQueue<Nodo<Frecuencia>> pq=new PriorityQueue<>((Nodo<Frecuencia> f1,Nodo<Frecuencia> f2)-> f1.getData().getHertz()-f2.getData().getHertz() );
        for(Map.Entry<String,Integer> me:mapa.entrySet()){
            pq.offer(new Nodo(new Frecuencia(me.getKey(),me.getValue())));
        }  
        while(pq.size()!=1){
             
            Nodo<Frecuencia> f1=pq.poll();
            Nodo<Frecuencia> f2=pq.poll();
            Frecuencia fs1=f1.getData();
            Frecuencia fs2=f2.getData();
           Nodo<Frecuencia> temp=new Nodo(new Frecuencia(fs1.getLetra()+fs2.getLetra(),fs1.getHertz()+fs2.getHertz()));
            temp.setDer(f1);
            temp.setIzq(f2);
            pq.offer(temp);
        }
        raiz=pq.poll();
        
    }
    
     public HashMap<String,String> calcularCodigos (){
         HashMap<String,String> hss=new HashMap<>();
         String txt=code("",raiz);
        String[] split = txt.split("¨");
        for(int i=0;i<split.length;i++){
             String[] split1 = split[i].split(":");
             hss.put(split1[0],split1[1]);
        }
         return hss;
     }
    public static String codificar(String texto, HashMap<String,String> mapa){
        String s="";
        int m=0;
            for(int i=0;i<texto.length();i++){
                String car=texto.substring(m,i+1);
                String au=mapa.get(car);
                s=s+au;
                m++;
            }
        s=Util.binarioHexadecimal(s);
        return s;
    }
    public static String decodificar(String texto, HashMap<String,String> mapa){
        String s="";
        String txt=Util.hexadecimalBinario(texto);
        HashMap<String, String> reversar = reversar(mapa);
        
            for(int i=0;i<txt.length();i++){
                String car=txt.substring(i,i+1);
                while(!reversar.containsKey(car)){
                    i++;
                    car=car+txt.substring(i,i+1);
                    
                    
                }
                String val=reversar.get(car);
                s=s+val;
                
            }
        return s;
    }
    private String code(String s,Nodo<Frecuencia> n){
        if(n.getDer()==null &&n.getDer()==null){
            return n.getData().getLetra()+":"+s+"¨";
        }
        else{
        return code(s+"0",n.getIzq())+code(s+"1",n.getDer());
        }
    }
    
    private static HashMap<String,String> reversar(HashMap<String,String> mapa){
        HashMap<String,String> hm=new HashMap<>();
        for(Map.Entry<String,String> e:mapa.entrySet()){
            hm.put(e.getValue(),e.getKey());
        }
        return hm;
        
    }
    private String toString(Nodo<Frecuencia> root)
{
    String result = "";
    if (root == null)
        return "";
    
    
//    if(root.getDer()!=null || root.getIzq()!=null){
//        result+=": ";
//    }
    result+= toString(root.getIzq()) ;
    result += root.getData().toString();
    result+=toString(root.getDer());
    return result;
}
    public String toString(){
        return toString(raiz);
    }
}
