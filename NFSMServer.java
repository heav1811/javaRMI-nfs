import java.io.*;
import java.nio.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;


@SuppressWarnings("unused")
public class NFSMServer implements NFS {

    public NFSMServer() {
    	}
    

 
    public static void main(String args[]) {
    	String SOURCE=System.getProperty("user.dir");

        try {
            NFSServer obj = new NFSServer();
            NFS stub = (NFS) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry(0);
            registry.bind("NFS", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
    }
}



	@Override
	public String create() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean del(String path, String blob) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public File get(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean init(String local_path, String remote_path) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean close(String path) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
    
}
