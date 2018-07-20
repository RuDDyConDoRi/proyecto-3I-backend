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
public class Utiles {

    int indice;
    int indValor;
    String[] atributos;
    public double[] valoresAtri;

    public Utiles(int canAtriV) {
        indice = 0;
        indValor = 0;
        atributos = new String[1000];
        valoresAtri = new double[canAtriV];
    }
    
    public void setIndiceAtri(int valor) {
        indice = valor;
    }
    
    public void adicionarAtri(String atri) {
        atributos[indice]=atri;
        indice++;
    }
    
    public void adicionarValorAtri(double vAtri) {
        valoresAtri[indValor]=vAtri;
        indValor++;
    }
    
    public static void imprimirTabla(String[][] tab, int ejemplos, int atributos) {
        for (int i = 0; i < ejemplos; i++) {
            for (int k = 0; k < atributos; k++) {
                System.out.print("    " + tab[i][k]);
            }
            System.out.println("");
        }
    }

    public static int[] atributoDesicion(String atributo, int pos, int deci, String[][] tab, int ejemplos) {
        int sis = 0;
        int nos = 0;
        int resp[] = new int[3];

        for (int i = pos; i < pos + 1; i++) {
            for (int k = 0; k < ejemplos; k++) {
                if (tab[k][i].equals(atributo)) {
                    if (tab[k][deci].equals("SI")) {
                        sis++;
                    } else if (tab[k][deci].equals("NO")) {
                        nos++;
                    }
                }
            }
        }
        resp[0] = sis;
        resp[1] = nos;
        resp[2] = nos + sis;
        return resp;
    }

    public boolean procesadoAtri(String atri) {
        for (int i = 0; i < indice; i++) {
            if (atributos[i].equals(atri)) {
                return true;
            }
        }
        return false;
    }

    public double log2(double num) {
        return (Math.log(num) / Math.log(2));
    }

    public double infor(double pos, double nega) {
        double posi = 0;
        double negai = 0;
        if (pos == 0) {
            posi = 0;
        } else {
            posi = -pos * log2(pos);
        }
        if (nega == 0) {
            negai = 0;
        } else {
            negai = -nega * log2(nega);
        }
        double total = posi + negai;

        return total;
    }

    public void ordenaV(String[] atri) {
        double aux = 0;
        String auxA = "";
        for (int i = 0; i < valoresAtri.length - 1; i++) {
            for (int k = 0; k < valoresAtri.length - 1; k++) {
                if (valoresAtri[k] > valoresAtri[k + 1]) {
                    aux = valoresAtri[k];
                    auxA = atri[k];
                    valoresAtri[k] = valoresAtri[k + 1];
                    atri[k] = atri[k + 1];
                    valoresAtri[k + 1] = aux;
                    atri[k + 1] = auxA;
                }
            }
        }
    }

    public void imprimeV(String[] atri) {
        System.out.println("Atributos ordenados Nivel Informacion ");
        System.out.println("*************************************");
        for (int i = 0; i < valoresAtri.length; i++) {
            System.out.println(atri[i]+"......"+valoresAtri[i]);
        }
    }

    

}
