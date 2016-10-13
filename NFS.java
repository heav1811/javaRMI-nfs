import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NFS extends Remote {
	//Calls from the client to the StorageServer()
    public String create() throws RemoteException;
    public boolean del(String path, String blob) throws RemoteException;
    public File get(String path) throws RemoteException;
    public boolean init(String local_path, String remote_path) throws RemoteException;
    public boolean close(String path) throws RemoteException;
}
