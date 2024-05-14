package algoritmosGeneticos;

import org.jgap.IChromosome;

public class Impresion {

    public static void imprimirTodo(IChromosome[] ics) {
        for (IChromosome ic : ics) {
            int sx = (int) ic.getGene(0).getAllele(); //Signo de X
            int sy = (int) ic.getGene(6).getAllele(); //Signo de Y
            String vX = (int) ic.getGene(1).getAllele() + ""
                    + (int) ic.getGene(2).getAllele() + ""
                    + (int) ic.getGene(3).getAllele() + ""
                    + (int) ic.getGene(4).getAllele() + ""
                    + (int) ic.getGene(5).getAllele(); //Valor de X

            String vY = (int) ic.getGene(7).getAllele() + ""
                    + (int) ic.getGene(8).getAllele() + ""
                    + (int) ic.getGene(9).getAllele() + ""
                    + (int) ic.getGene(10).getAllele() + ""
                    + (int) ic.getGene(11).getAllele(); //Valor de Y

            int valX = Integer.parseInt(vX, 2);
            int valY = Integer.parseInt(vY, 2);

            if (sx == 0) {
                valX = -valX;
            }

            if (sy == 0) {
                valY = -valY;
            }

            System.out.println(valX + "; " + valY); //imprimimos los valores de X y Y
        }
    }

    public static void separador() {
        System.out.println("==========================================");
    }
}
