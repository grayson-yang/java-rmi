package org.example.rmi.quickstart;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String args[]) {
        try {
            String name = "RMIServer";
            Registry registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
            IRMIServer rmiServer = (IRMIServer) registry.lookup(name);
            String rmiResponse = rmiServer.getGreet("Grayson");
            System.out.println(rmiResponse);
        } catch (Exception e) {
            System.err.println("RMIClient exception:");
            e.printStackTrace();
        }
    }
}
