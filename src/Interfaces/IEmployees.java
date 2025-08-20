package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEmployees<T> extends Remote {
    public float totalPaidForEmployee(List<T> list) throws RemoteException;
    public float averageForMonth(List<T> list) throws RemoteException;
    public float totalPaid(List<T> list) throws RemoteException;
}
