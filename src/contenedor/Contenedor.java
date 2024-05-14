package contenedor;

import agentes.*;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.Logger;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;

public class Contenedor {
    public void crearContendor(String host, int port, String name) {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile p = new ProfileImpl(host, port, name);
        AgentContainer contenedorPrincipal = runtime.createMainContainer(p);
        crearAgentes(contenedorPrincipal);
    }

    private void crearAgentes(AgentContainer contenedorPrincipal) {
        try {
            contenedorPrincipal.createNewAgent("Ag1", Agente1.class.getName(), null).start();
            contenedorPrincipal.createNewAgent("Ag3", Agente3.class.getName(), null).start();


        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
