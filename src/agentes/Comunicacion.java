package agentes;

import jade.core.AID;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.core.Agent;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class Comunicacion {
    //El comportamiento del agente solo esta atado a uno y solo se puede enviar un tipo de contenido
    public static void msj(int tipoMSJ, Agent emisor, String receptor,
                           String contenidoStr, Serializable contenidoObj, String conversationId) {
        ACLMessage acl = new ACLMessage(tipoMSJ);
        AID receptorID = new AID();
        receptorID.setLocalName(receptor); //El nombre del receptor
        acl.addReceiver(receptorID); //El receptor del mensaje
        acl.setSender(emisor.getAID()); //El emisor del mensaje
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL); //Lenguaje del contenido

        if (contenidoStr == null) {
            try {
                acl.setContentObject(contenidoObj); //El contenido del mensaje
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            acl.setContent(contenidoStr); //El contenido del mensaje
        }

        acl.setConversationId(conversationId); //El id de la conversacion

        emisor.send(acl); //Se envia el mensaje

    }
}
