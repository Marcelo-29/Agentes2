package agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Agente3 extends Agent {
    Random random = new Random();
    Map<String, Integer> configuracion = new HashMap<>();
    int poblacion = random.nextInt(4) + 1;
    int evoluciones = random.nextInt(10) + 1;
    int iteraciones = random.nextInt(8) + 1;
    int longGen = 12;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        super.takeDown();
    }

    class Comportamiento extends CyclicBehaviour {
        boolean enviado = true;

        @Override
        public void action() {
            if (enviado) {
                configuracion.put("p", poblacion);
                configuracion.put("i", iteraciones);
                configuracion.put("e", evoluciones);
                configuracion.put("l", longGen);
                Comunicacion.msj(ACLMessage.REQUEST, getAgent(), "Ag1", null, (Serializable) configuracion,
                        "COF-03-01");
                enviado = false;
            } else{

                ACLMessage aclmsj = blockingReceive();
                String[] mIindividuo = aclmsj.getContent().split(";");
                int x = Integer.parseInt(mIindividuo[0]);
                int y = Integer.parseInt(mIindividuo[1]);
                if(Math.abs(x)>30 && Math.abs(y)>30){
                    System.out.println("\nEl mejor individuo es: "+x+";"+y+"\nConfiguracion: Poblacion: "
                            +poblacion+" Iteraciones "+iteraciones+" Evoluciones "+evoluciones+" LongGen "+longGen);
                }else{
                    poblacion++;
                    iteraciones++;
                    evoluciones++;
                    configuracion.put("p", poblacion);
                    configuracion.put("i", iteraciones);
                    configuracion.put("e", evoluciones);
                    configuracion.put("l", longGen);
                    Comunicacion.msj(ACLMessage.REQUEST, getAgent(), "Ag1", null, (Serializable) configuracion,
                            "COF2-03-01");
                }


            }

        }
    }
}
