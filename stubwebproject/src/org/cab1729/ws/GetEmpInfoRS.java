package org.cab1729.ws;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;

import org.cab1729.beans.session.GetEmpInfoLocal;

/**
 * @author jmenes
 * RESTful service interface to a session bean
 * - added JAXB code example to XML file option
 *
 */
@Path("getEmpInfoRS")
public class GetEmpInfoRS {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;
    
    @EJB(beanName="GetEmpInfo")
	private GetEmpInfoLocal getEmpInfoBean;

    /**
     * Default constructor. 
     */
    public GetEmpInfoRS() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of GetEmpInfoRS
     * @return an instance of String
     */
    @GET
    @Path("emailXml/{empId}")
    @Produces("application/xml")
    public String getEmailXml(@PathParam("empId") String empId) {
        String email = this.getEmail(empId);
        String result = "";
    	// TODO implement with JAXB code
    	try {
			ObjectFactory objFactory = new ObjectFactory();
			Employee empInfo = objFactory.createEmployee();
			empInfo.setEmail(email);
			empInfo.setId(Integer.valueOf(empId));
			JAXBElement<Employee> empElement = objFactory.createEmployeeinfo(empInfo);
			
			JAXBContext jc = JAXBContext.newInstance("org.cab1729.ws");
			Marshaller marshaller = jc.createMarshaller();
			// obviously outputting to a file is totally unnecessary, it's
			// only for checking the output and to illustrate use of the marshaller
			marshaller.marshal(
					empElement, new FileOutputStream("employee" + empId + ".xml"));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return "ERROR";
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			return "ERROR";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return "ERROR";
		}
		
		// read file back and return content
		try {
			result = readFileAsString("employee" + empId + ".xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "ERROR";
		}
		return result;
        
    }

    /**
     * Retrieves representation of an instance of GetEmpInfoRS
     * @return an instance of String
     */
    @GET
    @Path("emailJson/{empId}")
    @Produces("application/json")
    public String getEmailJson(@PathParam("empId") String empId) {
        // TODO return proper representation object
        return "{ \"empEmail\": " + this.getEmail(empId) + "}";
    }
    
    /**
     * Retrieves representation of an instance of GetEmpInfoRS
     * @return an instance of String
     */
    @GET
    @Path("emailText/{empId}")
    @Produces("text/plain")
    public String getEmailText(@PathParam("empId") String empId) {
        // TODO return proper representation object
    	return "empEmail: "  + this.getEmail(empId);
    }
    
    protected String getEmail(String empId) {
    	// TODO get null reference here - Glassfish problem?
    	return getEmpInfoBean.getEmpEmail((Long.valueOf(empId)));
    }
    
    private static String readFileAsString(String filePath)
    	throws java.io.IOException
    {
        StringBuffer fileData = new StringBuffer(1000);
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            buf = new char[1024];
        }
        reader.close();
        return fileData.toString();
    }

}