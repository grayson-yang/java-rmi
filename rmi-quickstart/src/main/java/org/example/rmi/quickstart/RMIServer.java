package org.example.rmi.quickstart;

import java.rmi.RemoteException;

public class RMIServer implements IRMIServer {

    @Override
    public String getGreet(String name) throws RemoteException {
        return "Hello, " + name;
    }
}
