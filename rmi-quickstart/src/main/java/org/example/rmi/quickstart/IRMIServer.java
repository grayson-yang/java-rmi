package org.example.rmi.quickstart;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIServer extends Remote {
    String getGreet(String name) throws RemoteException;
}
