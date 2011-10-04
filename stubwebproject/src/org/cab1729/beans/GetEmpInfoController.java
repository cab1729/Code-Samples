package org.cab1729.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.cab1729.beans.session.GetEmpInfoLocal;

@ManagedBean
@SessionScoped
public class GetEmpInfoController {
	
	@EJB(beanName="GetEmpInfo")
	private GetEmpInfoLocal getEmpInfoBean;
	
	private long empId = 0;
	
	public void setEmpId (long empId) {
		this.empId = empId;
	}
	public long getEmpId () {
		return this.empId;
	}
	
	public String getEmail() {
		String email = getEmpInfoBean.getEmpEmail(this.empId);
		
		return email;
	}

}
