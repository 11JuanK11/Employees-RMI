package Server;

import Domain.Employees;
import Impl.EmployeesService;
import Interfaces.IEmployees;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EmployeesServer {

    public static void main(String []args) throws RemoteException {

        Registry reg= LocateRegistry.createRegistry(1099);
        IEmployees<Employees> employeesService = new EmployeesService();
        reg.rebind("employees", employeesService);
        System.out.println("servidor iniciado");

    }
}
