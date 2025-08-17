package Client;

import Domain.Employees;
import Impl.EmployeesService;
import Interfaces.IEmployees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesClient {
    public static void main(String[] args) throws IOException {
        float n1, n2, res; int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1.Suma    ");
            System.out.println("2.Resta    ");
            System.out.println("3.Multiplicacion    ");
            System.out.println("4.Division    ");
            System.out.println("5.Salir    ");
            System.out.println("OPCION:");
            choice=Integer.parseInt(br.readLine());
            if (choice!=5){
                try {
                    System.out.println("Ingresar numero de empleados");
                    n1= Integer.parseInt(br.readLine());
                    System.out.println("Ingresar numero de meses");
                    n2= Integer.parseInt(br.readLine());
                    IEmployees<Employees> employees= (EmployeesService) Naming.lookup("employees");
                    //res= calcinterface.calculate(n1, n2, choice); crear metodo privado para las opciones
                    //Remote lookup = Naming.lookup("Calc");
                    //CalcImplement calcImplement= new CalcImplement(n1,n2);
                    //res=calcImplement.calculate(n1, n2, choice);
                    System.out.println("Resultado:"+res);
                } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                    Logger.getLogger(EmployeesClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (choice != 5);
    }
}
