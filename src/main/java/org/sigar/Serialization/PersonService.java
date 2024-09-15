package org.sigar.Serialization;
import java.rmi.Remote;
import java.rmi.RemoteException;

// Remote interface extending java.rmi.Remote
public interface PersonService extends Remote {
    Person getPerson() throws RemoteException;  // This will return a serialized object
}