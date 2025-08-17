package Interfaces;

import Impl.Employees;

import java.rmi.Remote;
import java.util.List;

public interface IEmployees<T> extends Remote {
    public float totalPaidForEmployee(List<T> list);
    public float averageForMonth(List<T> list);
    public float totalPaid(List<T> list);
}
