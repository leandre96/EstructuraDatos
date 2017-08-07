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

    public ArbolHuffman(HashMap<String, Integer> mapa) {
        raiz = null;

        PriorityQueue<Nodo<Frecuencia>> colaPrioridadFrecuencia = new PriorityQueue<>((Nodo<Frecuencia> f1, Nodo<Frecuencia> f2) -> f1.getData().getHertz() - f2.getData().getHertz());
        for (Map.Entry<String, Integer> elem : mapa.entrySet()) {
            colaPrioridadFrecuencia.offer(new Nodo(new Frecuencia(elem.getKey(), elem.getValue())));
        }
        while (colaPrioridadFrecuencia.size() != 1) {
            Nodo<Frecuencia> f1 = colaPrioridadFrecuencia.poll();
            Nodo<Frecuencia> f2 = colaPrioridadFrecuencia.poll();
            Frecuencia fs1 = f1.getData();
            Frecuencia fs2 = f2.getData();
            Nodo<Frecuencia> temp = new Nodo(new Frecuencia(fs1.getLetra() + fs2.getLetra(), fs1.getHertz() + fs2.getHertz()));
            temp.setDer(f1);
            temp.setIzq(f2);
            colaPrioridadFrecuencia.offer(temp);
        }
        raiz = colaPrioridadFrecuencia.poll();
    }

    public HashMap<String, String> calcularCodigos() {
        HashMap<String, String> mapaCodigos = new HashMap<>();
        String txt = code("", raiz);
        String[] split = txt.split("¨");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(":");
            mapaCodigos.put(split1[0], split1[1]);
        }
        return mapaCodigos;
    }

    public static String codificar(String texto, HashMap<String, String> mapa) {
        String s = "";
        int indexI = 0;
        for (int i = 0; i < texto.length(); i++) {
            String caracter = texto.substring(indexI, i + 1);
            String valor = mapa.get(caracter);
            s = s + valor;
            indexI++;
        }
        s = Util.binarioHexadecimal(s);
        return s;
    }

    public static String decodificar(String texto, HashMap<String, String> mapa) {
        String s = "";
        String txt = Util.hexadecimalBinario(texto);
        HashMap<String, String> reversar = reversar(mapa);
        for (int i = 0; i < txt.length(); i++) {
            String caracter = txt.substring(i, i + 1);
            while (!reversar.containsKey(caracter)) {
                i++;
                caracter = caracter + txt.substring(i, i + 1);
            }
            String valor = reversar.get(caracter);
            s = s + valor;
        }
        return s;
    }

    private String code(String s, Nodo<Frecuencia> n) {
        if (n.getDer() == null && n.getDer() == null) {
            return n.getData().getLetra() + ":" + s + "¨";
        } else {
            return code(s + "0", n.getIzq()) + code(s + "1", n.getDer());
        }
    }

    private static HashMap<String, String> reversar(HashMap<String, String> mapa) {
        HashMap<String, String> hmReverse = new HashMap<>();
        for (Map.Entry<String, String> e : mapa.entrySet()) {
            hmReverse.put(e.getValue(), e.getKey());
        }
        return hmReverse;
    }

    private String toString(Nodo<Frecuencia> root) {
        String result = "";
        if (root == null) {
            return "";
        }else{           
        result += toString(root.getIzq());
        result += root.getData().toString();
        result += toString(root.getDer());
        return result;
        }
    }

    public String toString() {
        return toString(raiz);
    }
}