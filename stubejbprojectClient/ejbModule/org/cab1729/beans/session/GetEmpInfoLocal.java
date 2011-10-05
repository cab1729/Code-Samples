package org.cab1729.beans.session;
import javax.ejb.Local;

@Local
public interface GetEmpInfoLocal {
	
	public String getEmpEmail(long empId);

}
