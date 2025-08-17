package Impl;

import Domain.Employees;
import Interfaces.IEmployees;

import java.util.ArrayList;
import java.util.List;

public class EmployeesService implements IEmployees<Employees> {

    public EmployeesService() {}

    @Override
    public Employees randomPayments(Employees employees, int numMonths) {
        List<Float> numberOfMonths = new ArrayList<>();

        for (int i = 0; i < numMonths; i++) {
            int randomInt = (int) (1_000_000 + Math.random() * (5_000_000 - 1_000_000));
            numberOfMonths.add((float) randomInt);
        }

        employees.setNumberOfMonths(numberOfMonths);
        return employees;
    }

    @Override
    public void totalPaidForEmployee(List<Employees> list) {
        float totalGeneral = 0;

        for (Employees emp : list) {
            float totalEmpleado = 0;

            for (Float pago : emp.getNumberOfMonths()) {
                totalEmpleado += pago;
            }

            System.out.println("Empleado " + emp.getId() + " - Pago total: " + totalEmpleado);
        }
    }

    @Override
    public void averageForMonth(List<Employees> list) {
        // Calcular el máximo número de meses entre todos los empleados
        int maxMonths = 0;
        for (Employees emp : list) {
            if (emp.getNumberOfMonths().size() > maxMonths) {
                maxMonths = emp.getNumberOfMonths().size();
            }
        }

        // Calcular promedios mes a mes
        for (int month = 0; month < maxMonths; month++) {
            float sumaMes = 0;
            int empleadosConMes = 0;

            for (Employees emp : list) {
                if (emp.getNumberOfMonths().size() > month) {
                    sumaMes += emp.getNumberOfMonths().get(month);
                    empleadosConMes++;
                }
            }

            if (empleadosConMes > 0) {
                float promedio = sumaMes / empleadosConMes;
                System.out.println("Mes " + (month + 1) + " (ej. Enero=1) - Promedio: " + promedio);
            }
        }
    }


    @Override
    public void totalPaid(List<Employees> list) {
        float totalGeneral = 0f;

        for (Employees emp : list) {
            for (Float pago : emp.getNumberOfMonths()) {
                totalGeneral += pago;
            }
        }

        System.out.println("Pago total de todos los empleados: " + totalGeneral);
    }
}
