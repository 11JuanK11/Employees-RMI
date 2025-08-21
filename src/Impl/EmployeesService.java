package Impl;

import Domain.Employees;
import Interfaces.IEmployees;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeesService extends UnicastRemoteObject implements IEmployees<Employees> {

    public EmployeesService() throws RemoteException {

    }

    @Override
    public Employees randomPayments(Employees employee, int numMonths) throws RemoteException {
        List<Float> monthsPayments = new ArrayList<>();

        for (int i = 0; i < numMonths; i++) {
            int randomInt = (int) (1_000_000 + Math.random() * (5_000_000 - 1_000_000));
            monthsPayments.add((float) randomInt);
        }

        employee.setNumberOfMonths(monthsPayments);

        return employee;
    }

    @Override
    public String totalPaidForEmployee(List<Employees> employeeList) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        for (Employees emp : employeeList) {
            float totalEmployee = 0f;

            for (Float payment : emp.getNumberOfMonths()) {
                totalEmployee += payment;
            }

            result.append("Empleado ")
                    .append(emp.getId())
                    .append(" (")
                    .append(emp.getName())
                    .append(") - Pago total: ")
                    .append(df.format(totalEmployee))
                    .append("\n");
        }

        return result.toString();
    }

    @Override
    public String averageForMonth(List<Employees> employeeList) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        int maxMonths = 0;
        for (Employees emp : employeeList) {
            if (emp.getNumberOfMonths().size() > maxMonths) {
                maxMonths = emp.getNumberOfMonths().size();
            }
        }

        for (int month = 0; month < maxMonths; month++) {
            float monthSum = 0f;
            int employeesWithMonth = 0;

            for (Employees emp : employeeList) {
                if (emp.getNumberOfMonths().size() > month) {
                    monthSum += emp.getNumberOfMonths().get(month);
                    employeesWithMonth++;
                }
            }

            if (employeesWithMonth > 0) {
                float average = monthSum / employeesWithMonth;
                result.append("Mes ")
                        .append(month + 1)
                        .append(" - Promedio: ")
                        .append(df.format(average))
                        .append("\n");
            }
        }

        return result.toString();
    }

    @Override
    public String totalPaid(List<Employees> employeeList) throws RemoteException {
        float totalGeneral = 0f;
        for (Employees emp : employeeList) {
            for (Float payment : emp.getNumberOfMonths()) {
                totalGeneral += payment;
            }
        }

        DecimalFormat df = new DecimalFormat("#,###");
        return "Pago total de todos los empleados: " + df.format(totalGeneral);
    }

    @Override
    public String employeeHistory(List<Employees> employeeList) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        for (Employees emp : employeeList) {
            result.append("Empleado ")
                    .append(emp.getId())
                    .append(" (")
                    .append(emp.getName())
                    .append(")\n");

            float totalEmployee = 0f;

            List<Float> payments = emp.getNumberOfMonths();
            for (int i = 0; i < payments.size(); i++) {
                totalEmployee += payments.get(i);

                result.append("   Mes ")
                        .append(i + 1)
                        .append(": ")
                        .append(df.format(payments.get(i)))
                        .append("\n");
            }

            result.append("   Total: ")
                    .append(df.format(totalEmployee))
                    .append("\n\n");
        }

        return result.toString();
    }

    @Override
    public String findEmployeeByName(List<Employees> employeeList, String name) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        boolean found = false;

        for (Employees emp : employeeList) {
            if (emp.getName().equalsIgnoreCase(name)) {
                found = true;
                result.append("Empleado ")
                    .append(emp.getId())
                    .append(" (")
                    .append(emp.getName())
                    .append(")\n");

                float totalEmployee = 0f;
                List<Float> payments = emp.getNumberOfMonths();

                for (int i = 0; i < payments.size(); i++) {
                    totalEmployee += payments.get(i);

                    result.append("   Mes ")
                        .append(i + 1)
                        .append(": ")
                        .append(df.format(payments.get(i)))
                        .append("\n");
                }

                result.append("   Total: ")
                    .append(df.format(totalEmployee))
                    .append("\n\n");
            }
        }

        if (!found) {
            return "Empleado con nombre '" + name + "' no encontrado.";
        }

        return result.toString();
    }


}
