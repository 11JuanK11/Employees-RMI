package Client;

import Domain.Employees;
import Interfaces.IEmployees;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesClient {

    public static void main(String[] args) throws IOException {
        byte choice;
        List<Employees> employeesList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\n1.Registrar empleados.");
            System.out.println("2.Total pagado por cada empleado.");
            System.out.println("3.Promedio de pagos por mes.");
            System.out.println("4.Total pagado.");
            System.out.println("5.Historial por empleado.");
            System.out.println("6.Buscar empleados por nombre.");
            System.out.println("7.Salir    ");
            System.out.println("OPCIÓN: ");

            choice = Byte.parseByte(br.readLine());
            if (choice!=7){
                try {
                    optionChoise(choice, employeesList);

                } catch (Exception e) {
                    Logger.getLogger(EmployeesClient.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } while (choice != 7);
    }

    private static void registerEmployees(int numEmployees, List<Employees> employeesList, IEmployees<Employees> iEmployees){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initialSizeList = employeesList.size() + 1, newSizeList = employeesList.size()+numEmployees + 1;
        try {
            for (int i = initialSizeList; i < newSizeList; i++) {
                System.out.println("Ingresar nombre del empleado " + i + " : ");
                String name = br.readLine();
                System.out.println("Ingresar número de meses para " + name + " : ");
                int numMonths = Integer.parseInt(br.readLine());
                Employees employees = new Employees(i, name);
                employees = iEmployees.randomPayments(employees, numMonths);
                employeesList.add(employees);
            }

        } catch (IOException | NumberFormatException e){
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
                case 5 -> {
                    if (!employeesList.isEmpty()){
                        System.out.println(employees.employeeHistory(employeesList));
                    } else {
                        System.out.println("No se encontraron empleados registrados.");
                    }
                }
                case 6 -> {
                    if (!employeesList.isEmpty()){
                        System.out.println("Ingresar nombre del empleado: ");
                        String name = br.readLine();
                        System.out.println(employees.findEmployeeByName(employeesList, name));
                    } else {
                        System.out.println("No se encontraron empleados registrados.");
                    }
                }
                default -> System.out.println("Opción incorrecta.");
            }
        } catch (IOException | NumberFormatException | NotBoundException e) {
            Logger.getLogger(EmployeesClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
