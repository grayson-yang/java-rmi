package org.example.rmi.quickstart;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main {
    public static void main(String[] args) {

        try {
            String name = "RMIServer";
            IRMIServer rmiServer = new RMIServer();
            IRMIServer stub =
                    (IRMIServer) UnicastRemoteObject.exportObject(rmiServer, 0);
            Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            registry.rebind(name, stub);
            System.out.println("RMIServer bound");
        } catch (Exception e) {
            System.err.println("RMIServer exception:");
            e.printStackTrace();
        }
    }
}
