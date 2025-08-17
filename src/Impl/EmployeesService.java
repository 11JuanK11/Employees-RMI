package Impl;

import Domain.Employees;
import Interfaces.IEmployees;

import java.util.List;

public class EmployeesService implements IEmployees<Employees> {

    public EmployeesService() {

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
