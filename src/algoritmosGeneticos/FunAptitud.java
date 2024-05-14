package algoritmosGeneticos;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FunAptitud extends FitnessFunction {

    //Metodo que agarra el cromosoma del hijo que resulta del cruce de los padres y lo evalua
    @Override
    protected double evaluate(IChromosome ic) {
        double score;
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

        int valX = Integer.parseInt(vX,2);
        int valY = Integer.parseInt(vY,2);

        if (sx == 0) {
            valX = -valX;
        }
        if (sy == 0) {
            valY = -valY;
        }

        score = (valX * valX * valX) + (valY * valY * valY * valY); //Ecuacion X^3 + Y^4

        if(score < 0){
            score = 0;
        }
        return score;
    }
}
