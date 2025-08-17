package Server;

import Impl.EmployeesService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EmployeesServer {

    public static void main(String []args) throws RemoteException {

        Registry reg= LocateRegistry.createRegistry(1099);
        EmployeesService employeesService = new EmployeesService();
        reg.rebind("employees", employeesService);
        System.out.println("servidor iniciado");

    }
}
