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
    public Employees randomPayments(Employees employees, int numMonths) throws RemoteException{
        List<Float> numberOfMonths = new ArrayList<>();

        for (int i = 0; i < numMonths; i++) {
            int randomInt = (int) (1_000_000 + Math.random() * (5_000_000 - 1_000_000));
            numberOfMonths.add((float) randomInt);
        }

        employees.setNumberOfMonths(numberOfMonths);

        return employees;
    }

    @Override
    public String totalPaidForEmployee(List<Employees> employeesList) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        for (Employees emp : employeesList) {
            float totalEmpleado = 0f;

            for (Float pago : emp.getNumberOfMonths()) {
                totalEmpleado += pago;
            }

            result.append("Empleado ")
                    .append(emp.getId())
                    .append(" (")
                    .append(emp.getName())
                    .append(") - Pago total: ")
                    .append(df.format(totalEmpleado))
                    .append("\n");
        }

        return result.toString();
    }

    @Override
    public String averageForMonth(List<Employees> list) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        int maxMonths = 0;
        for (Employees emp : list) {
            if (emp.getNumberOfMonths().size() > maxMonths) {
                maxMonths = emp.getNumberOfMonths().size();
            }
        }

        for (int month = 0; month < maxMonths; month++) {
            float sumaMes = 0f;
            int empleadosConMes = 0;

            for (Employees emp : list) {
                if (emp.getNumberOfMonths().size() > month) {
                    sumaMes += emp.getNumberOfMonths().get(month);
                    empleadosConMes++;
                }
            }

            if (empleadosConMes > 0) {
                float promedio = sumaMes / empleadosConMes;
                result.append("Mes ")
                        .append(month + 1)
                        .append(" - Promedio: ")
                        .append(df.format(promedio))
                        .append("\n");
            }
        }

        return result.toString();
    }

    @Override
    public String totalPaid(List<Employees> list) throws RemoteException {
        float totalGeneral = 0f;
        for (Employees emp : list) {
            for (Float pago : emp.getNumberOfMonths()) {
                totalGeneral += pago;
            }
        }

        DecimalFormat df = new DecimalFormat("#,###");
        return "Pago total de todos los empleados: " + df.format(totalGeneral);
    }

    @Override
    public String employeeHistory(List<Employees> list) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        for (Employees emp : list) {
            result.append("Empleado ")
                    .append(emp.getId())
                    .append(" (")
                    .append(emp.getName())
                    .append(")\n");

            float totalEmpleado = 0f;

            List<Float> pagos = emp.getNumberOfMonths();
            for (int i = 0; i < pagos.size(); i++) {
                totalEmpleado += pagos.get(i);

                result.append("   Mes ")
                        .append(i + 1)
                        .append(": ")
                        .append(df.format(pagos.get(i)))
                        .append("\n");
            }

            result.append("   Total: ")
                    .append(df.format(totalEmpleado))
                    .append("\n\n");
        }

        return result.toString();
    }

    @Override
    public String findEmployeeByName(List<Employees> list, String name) throws RemoteException {
        StringBuilder result = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#,###");

        for (Employees emp : list) {
            if (emp.getName().equalsIgnoreCase(name)) {
                result.append("Empleado ")
                        .append(emp.getId())
                        .append(" (")
                        .append(emp.getName())
                        .append(")\n");

                float totalEmpleado = 0f;
                String[] months = {
                        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
                };

                List<Float> pagos = emp.getNumberOfMonths();
                for (int i = 0; i < pagos.size(); i++) {
                    totalEmpleado += pagos.get(i);

                    String mesNombre = (i < months.length) ? months[i] : "Mes " + (i + 1);

                    result.append("   ")
                            .append(mesNombre)
                            .append(": ")
                            .append(df.format(pagos.get(i)))
                            .append("\n");
                }

                result.append("   Total: ")
                        .append(df.format(totalEmpleado))
                        .append("\n");

                return result.toString(); // retorna al encontrarlo
            }
        }

        return "Empleado con nombre '" + name + "' no encontrado.";
    }

}
