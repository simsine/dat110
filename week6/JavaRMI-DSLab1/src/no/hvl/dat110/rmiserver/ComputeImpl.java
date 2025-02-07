package no.hvl.dat110.rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import no.hvl.dat110.rmiinterface.ComputeInterface;

/**
 * For demonstration purpose in dat110 course
 * This class is the implementation of the exposed addNumbers method in our interface.
 * @author tdoy
 */

public class ComputeImpl extends UnicastRemoteObject implements ComputeInterface {
	
	public boolean isStopped = false;
	
	public boolean getIsStopped() {
		return isStopped;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ComputeImpl() throws RemoteException {
		super();
	}

	public int addNumbers(int a, int b) {
		
		System.out.println("Server has received the message: "+a + "+" + b);
		int sum = a + b;
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
	@Override
	public void halt() throws RemoteException {
		this.isStopped = true;
	}
}
