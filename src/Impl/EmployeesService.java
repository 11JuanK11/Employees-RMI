package Impl;

import Domain.Employees;
import Interfaces.IEmployees;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class EmployeesService extends UnicastRemoteObject implements IEmployees<Employees> {

    public EmployeesService()throws RemoteException {

    }

    @Override
    public float totalPaidForEmployee(List<Employees> list) throws RemoteException {
        return 0;
    }

    @Override
    public float averageForMonth(List<Employees> list) throws RemoteException{
        return 0;
    }

    @Override
    public float totalPaid(List<Employees> list) throws RemoteException{
        return 0;
    }
}
