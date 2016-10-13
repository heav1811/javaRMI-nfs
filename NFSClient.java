

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class NFSClient {
	static String host="localhost";
	static NFS service;
	static Registry registry;

    private NFSClient() {}

    public static void main(String[] args) throws NotBoundException {
    	Scanner in = new Scanner(System.in);
    	String host = (args.length < 1) ? null : args[0];
    	String input = in.nextLine();
    	while(!(input.equals("quit"))){
    		//System.out.print(input);
    		inputHandler(input);
    		break;
    	}
    	
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            NFS stub = (NFS) registry.lookup("NFS");

        
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

	private static boolean inputHandler(String input) throws NotBoundException {
		String[] commandTokens=input.split(" ");
		
		if(commandTokens[0].equals("create")) {
			create();
			return true;
		}
		
		return false;
	}

	private static void create() throws NotBoundException {
		 try {
	             registry = LocateRegistry.getRegistry(host, 1099);
	             service = (NFS) registry.lookup("NFS");
	             String response = service.create();
	             System.out.println("response: " + response);

	        
	        } catch (Exception e) {
	            System.err.println("Client exception: " + e.toString());
	            e.printStackTrace();
	        }
		
		
	}
}
