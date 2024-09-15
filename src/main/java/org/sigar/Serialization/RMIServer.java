package org.sigar.Serialization;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Start the RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create an instance of the PersonServiceImpl
            PersonService personService = new PersonServiceImpl();

            // Bind the instance to the RMI registry with a name
            Naming.rebind("PersonService", personService);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
