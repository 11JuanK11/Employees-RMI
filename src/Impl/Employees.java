package Impl;

import Interfaces.IEmployees;

import java.util.List;

public class Employees implements IEmployees<Employees> {

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
