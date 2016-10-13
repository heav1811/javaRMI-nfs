

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class NFSClient {
	static String host="localhost";

    private NFSClient() {}

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String host = (args.length < 1) ? null : args[0];
    	String input = in.nextLine();
    	while(!(input.equals("quit"))){
    		System.out.print(input);
    		inputHandler(input);
    	}
    	
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            NFS stub = (NFS) registry.lookup("NFS");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

	private static void inputHandler(String input) {
		
		
	}
}
