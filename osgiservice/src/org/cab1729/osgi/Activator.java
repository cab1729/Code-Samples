package org.cab1729.osgi;

import org.cab1729.osgi.service.GetEmpInfo;
import org.cab1729.osgi.service.IGetEmpInfo;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		IGetEmpInfo service = new GetEmpInfo();
		context.registerService(IGetEmpInfo.class.getName(), service, null);
		System.out.println("IGetEmpInfo service is registered");
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		
	}

}
