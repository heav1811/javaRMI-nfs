
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;


@SuppressWarnings("unused")
public class NFSServer implements NFS {

    public NFSServer() {}

    public String sayHello() {
        return "Hello, world!";
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
	public boolean create(String path, String blob) throws RemoteException {
		
		return false;
	}

	@Override
	public boolean del(String path, String blob) throws RemoteException {
	
		return false;
	}

	@Override
	public File get(String path) throws RemoteException {
		
		return null;
	}
	
	@Override
	public boolean init(String local_path, String remote_path) throws RemoteException {
		
		return false;
	}

	@Override
	public boolean close(String path) throws RemoteException {
		
		return false;
	}
}
