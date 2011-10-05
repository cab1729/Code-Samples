package org.cab1729.beans.session;
import javax.ejb.Remote;

@Remote
public interface GetEmpInfoRemote {
	
	public String getEmpEmail(long empId);

}
