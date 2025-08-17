package Interfaces;

import Domain.Employees;

import java.rmi.Remote;
import java.util.List;

public interface IEmployees<T> extends Remote {
    public T randomPayments(T employees, int numMonths);
    public float totalPaidForEmployee(List<T> list);
    public float averageForMonth(List<T> list);
    public float totalPaid(List<T> list);
}
