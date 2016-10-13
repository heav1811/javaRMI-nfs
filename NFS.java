


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NFS extends Remote {
    String sayHello() throws RemoteException;
}
