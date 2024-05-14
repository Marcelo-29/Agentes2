package agentes;

import algoritmosGeneticos.Genetica;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Agente1 extends Agent {


    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {


            try {
                ACLMessage aclmsj = blockingReceive();
                Map configuracion = (Map) aclmsj.getContentObject();
                int tamanioPoblacion = (int) configuracion.get("p");
                int evoluciones = (int) configuracion.get("e");
                int iteraccion = (int) configuracion.get("i");
                int longCromosoma = (int) configuracion.get("l");

                Genetica genetica = new Genetica();
                int[] XY = genetica.evolucionar(genetica.get_Poblacion(genetica.configurarAG(tamanioPoblacion, longCromosoma)), evoluciones, iteraccion);

                System.out.print("================================================================================================");
                System.out.println("\nPoblacion: "+tamanioPoblacion+"\nEvoluciones: "+evoluciones+"\nIteraciones: "+iteraccion+"\nLonGen: "
                        +longCromosoma+"\nMejor Ind: "+ Arrays.toString(XY));
                System.out.print("================================================================================================");
                Comunicacion.msj(ACLMessage.REQUEST, getAgent(), "Ag3",
                        XY[0]+";"+XY[1], null,
                        "IND-01-03");

            } catch (UnreadableException e) {
                Logger.getLogger(Agente1.class.getName()).log(Level.SEVERE, null, e);
            }

        }
    }
}
