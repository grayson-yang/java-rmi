## RMI Quick Start


```java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIServer extends Remote {
    String getGreet(String name) throws RemoteException;
}
```


```java
import java.rmi.RemoteException;

public class RMIServer implements IRMIServer {

    @Override
    public String getGreet(String name) throws RemoteException {
        return "Hello, " + name;
    }
}
```

```java
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
```

```java
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
```