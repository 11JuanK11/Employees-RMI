package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEmployees<T> extends Remote {
    public T randomPayments(T employees, int numMonths) throws RemoteException;
    public String totalPaidForEmployee(List<T> list) throws RemoteException;
    public String averageForMonth(List<T> list) throws RemoteException;
    public String totalPaid(List<T> list) throws RemoteException;
}
