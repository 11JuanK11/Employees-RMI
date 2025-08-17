package Interfaces;

import Domain.Employees;

import java.rmi.Remote;
import java.util.List;

public interface IEmployees<T> extends Remote {
    public T randomPayments(T employees, int numMonths);
    public void totalPaidForEmployee(List<T> list);
    public void averageForMonth(List<T> list);
    public void totalPaid(List<T> list);
}
