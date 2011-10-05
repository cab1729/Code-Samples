package org.cab1729.beans.mdb;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;

/**
 * Message-Driven Bean implementation class for: StubMessageBean
 *
 */
@MessageDriven(
		mappedName="FooQueue",
		activationConfig = { 
				@ActivationConfigProperty(
						propertyName = "connectionFactoryJndiName", propertyValue="FooCF"),
			    @ActivationConfigProperty(
			    		propertyName = "destinationName", propertyValue="FooQueue"),
				@ActivationConfigProperty(
						propertyName = "destinationType", propertyValue = "javax.jms.Queue") 
		})
public class StubMessageBean implements MessageListener {

    
	/**
     * Default constructor. 
     */
    public StubMessageBean() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        
    }

}
