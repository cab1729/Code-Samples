package org.cab1729.osgi.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import org.cab1729.osgi.service.*;

public class Activator implements BundleActivator {
	
	private BundleContext context;
	private IGetEmpInfo service;

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		this.context = context;
		ServiceReference reference = 
			this.context.getServiceReference(IGetEmpInfo.class.getName());
		service = (IGetEmpInfo) context.getService(reference);
		System.out.println("email for empId 101: " + service.getEmpEmail(101));
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		
	}

}
