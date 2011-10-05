package org.cab1729.beans.session;

import java.io.Serializable;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cab1729.ent.Employee;


/**
 * Session Bean implementation class GetEmpInfo
 * added web service annotation
 */
@Stateless
@Local(GetEmpInfoLocal.class)
@Remote(GetEmpInfoRemote.class)

@WebService(serviceName="GetEmpInfoService", portName="GetEmpInfo")
public class GetEmpInfo implements Serializable, GetEmpInfoRemote, GetEmpInfoLocal {

	private static final long serialVersionUID = 1L;
	
@PersistenceContext(unitName="stubjpaproject")
	EntityManager em;
 
    /**
     * Default constructor. 
     */
    public GetEmpInfo() {
        // TODO Auto-generated constructor stub
    }
    
    @WebMethod
    public String getEmpEmail(@WebParam(name="empId") long empId) {
    	// TODO
    	String email;
		try {
			Employee employee = em.find(Employee.class, Long.valueOf(empId)); 
			email = employee.getEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			email = "NOT FOUND/ERROR";
		} 
    	//String email = (String) 
    	//	(em.createQuery("select email from Employee e where e.employeeId = " + empId)).getSingleResult();
    	
    	return email;
    }

}
