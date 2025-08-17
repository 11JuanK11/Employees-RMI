package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EmployeesServer {
    public static void main(String []args) throws RemoteException
    { Registry reg= LocateRegistry.createRegistry(1099);
        CalcImplement calcImplement=new CalcImplement(0,0);
        //nombre objeto
        reg.rebind("Calc", calcImplement);
        System.out.println("servidor iniciado");

    }
}
