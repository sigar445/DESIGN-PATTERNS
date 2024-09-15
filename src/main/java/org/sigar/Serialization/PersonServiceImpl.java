package org.sigar.Serialization;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PersonServiceImpl extends UnicastRemoteObject implements PersonService {

    protected PersonServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public Person getPerson() throws RemoteException {
        return new Person("John Doe", 30);  // Return a new Person object
    }
}