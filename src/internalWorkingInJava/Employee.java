package internalWorkingInJava;

import java.util.Objects;

public class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emp = (Employee) o;
        return id == emp.id && name.equals(emp.name);
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f}", id, name, salary);
    }
}
