package Client;

import Domain.Employees;
import Impl.EmployeesService;
import Interfaces.IEmployees;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesClient {

    public static void main(String[] args) throws IOException {
        byte choice = 0;
        List<Employees> employeesList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1.Registrar empleados.");
            System.out.println("2.Total pagado por cada empleado.");
            System.out.println("3.Promedio de pagos por mes.");
            System.out.println("4.Total pagado.");
            System.out.println("5.Salir    ");
            System.out.println("OPCIÓN: ");

            choice = Byte.parseByte(br.readLine());
            if (choice!=5){
                try {
                    optionChoise(choice, employeesList);

                } catch (Exception e) {
                    Logger.getLogger(EmployeesClient.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } while (choice != 5);
    }

    private static void registerEmployees(int numEmployees, List<Employees> employeesList, IEmployees<Employees> iEmployees){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initialSizeList = employeesList.size() + 1, newSizeList = employeesList.size()+numEmployees + 1;
        try {
            for (int i = initialSizeList; i < newSizeList; i++) {
                System.out.println("Ingresar número de meses para empleado " + i + " : ");
                int numMonths = Integer.parseInt(br.readLine());
                Employees employees = new Employees(i, "Empleado " + i);
                employeesList.add(iEmployees.randomPayments(employees, numMonths));
            }

        } catch (Exception e){
            System.out.println("Error al ingresar los empleados." + e);
        }
    }

    private static void optionChoise(byte choice, List<Employees> employeesList){

        try {
            IEmployees<Employees> employees= (IEmployees<Employees>) Naming.lookup("employees");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            switch (choice) {
                case 1 -> {
                    System.out.println("Ingresar número de empleados: ");
                    int numEmployees = Integer.parseInt(br.readLine());
                    registerEmployees(numEmployees, employeesList, employees);
                }
                case 2 -> {
                    if (!employeesList.isEmpty()){
                        System.out.println(employees.totalPaidForEmployee(employeesList));
                    } else {
                        System.out.println("No se encontraron empleados registrados.");
                    }
                }
                case 3 -> {
                    if (!employeesList.isEmpty()){
                        System.out.println(employees.averageForMonth(employeesList));
                    } else {
                        System.out.println("No se encontraron empleados registrados.");
                    }
                }
                case 4 -> {
                    if (!employeesList.isEmpty()){
                        System.out.println(employees.totalPaid(employeesList));
                    } else {
                        System.out.println("No se encontraron empleados registrados.");
                    }
                }
                default -> System.out.println("Opción incorrecta.");
            }
        } catch (Exception e) {
            Logger.getLogger(EmployeesClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
