/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arboles;

/**
 *
 * @author RuDDy
 */
public class ArbolesDesicion {
    
    public static void main(String[] args) {
        //String[] nombreAtri = {"Ruta", "Empresa", "Tiempo", "Distancia", "Prisa"};
        //String[] nombreAtri = {"PAIS", "GENERO"};
        /*String[] nombreAtri = {"DECADA", "PAIS", "GENERO"};*/
        String[] nombreAtri = {"EXISTIO_HECHO", "IMP_IND_II", "ELEM_CONVIC", "IMP_PROCESAL"};
        /*String[][] tabla = {{"2S", "A", "20", "05", "SI", "SI"},
                            {"03", "B", "30", "10", "SI", "NO"},
                            {"2S", "A", "10", "15", "SI", "SI"},
                            {"4B", "C", "20", "10", "NO", "SI"},
                            {"03", "B", "20", "05", "SI", "SI"},
                            {"4B", "A", "30", "15", "SI", "NO"},
                            {"03", "B", "10", "30", "SI", "NO"}};*/
        /*String[][] tabla = {{"70", "USA", "DRAMA", "SI"},
                            {"70", "NO USA", "COMEDIA", "SI"},
                            {"80", "NO USA", "DRAMA", "NO"},
                            {"90", "NO USA", "DRAMA", "NO"},
                            {"90", "NO USA", "COMEDIA", "SI"},
                            {"80", "NO USA", "ACCION", "NO"},
                            {"90", "USA", "ACCION", "NO"},
                            {"70", "NO USA", "DRAMA", "SI"}};*/
        String[][] tabla = {{"0", "SI", ">30", "SI", "SI"},
                            {"0", "NO", ">30", "SI", "SI"},
                            {"0", "NO", "<30", "SI", "SI"},
                            {"1", "SI", ">30", "SI", "NO"},
                            {"1", "SI", ">30", "NO", "SI"},
                            {"1", "NO", ">30", "SI", "SI"},
                            {"1", "NO", "<30", "SI", "SI"},
                            {"1", "SI", "<30", "SI", "SI"}};
        Utiles util = new Utiles(nombreAtri.length);
        int totalAtributos = nombreAtri.length;
        int posdesicion = nombreAtri.length;
        int totalEjemplos = tabla.length;
        
        System.out.println("Filas**"+tabla.length);
        int[] noSi = new int[3];
        util.imprimirTabla(tabla, totalEjemplos, totalAtributos);
        String atri ="";
        double suma;
        
        for (int posAtributo = 0; posAtributo < posdesicion; posAtributo++) {
            suma = 0;
            util.setIndiceAtri(0);
            
            for (int k = 0; k < totalEjemplos; k++) {
                atri = tabla[k][posAtributo];
                if(!util.procesadoAtri(atri)){
                    noSi = util.atributoDesicion(atri, posAtributo, posdesicion, tabla, totalEjemplos);
                    double infor = util.infor((double) noSi[0] / noSi[2], (double) noSi[1] / noSi[2]);
                    System.out.println(atri + " pos ("+noSi[0]+") nega ("+noSi[1]+") "+ " total("+ noSi[2]
                            +") total/ejemplos("+((double)noSi[2]/totalEjemplos)
                            +") --Infor("+infor+") total*infor("+(noSi[0]*infor)+")");
                    suma += (double) noSi[2] / totalEjemplos * infor;
                }
                util.adicionarAtri(atri);
            }
            System.out.println("***************************");
            System.out.println(""+nombreAtri[posAtributo]+"--> "+suma);
            System.out.println("***************************");
            util.adicionarValorAtri(suma);
        }
        util.ordenaV(nombreAtri);
        util.imprimeV(nombreAtri);
        //System.out.println("--> "+util.valoresAtri[0]);
        
    }
}
