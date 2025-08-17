package Impl;

import Domain.Employees;
import Interfaces.IEmployees;

import java.util.List;

public class EmployeesService implements IEmployees<Employees> {

    public EmployeesService() {

    }

    @Override
    public Employees randomPayments(Employees employees, int numMonths) {
        return employees;
    }

    @Override
    public float totalPaidForEmployee(List<Employees> list) {
        return 0;
    }

    @Override
    public float averageForMonth(List<Employees> list) {
        return 0;
    }

    @Override
    public float totalPaid(List<Employees> list) {
        return 0;
    }
}
