package lesson13;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private Integer tabelNumber;
    private String name;
    private Integer workAge;

    public Employee(Integer tabelNumber, String name, Integer workAge) {
        this.tabelNumber = tabelNumber;
        this.name = name;
        this.workAge = workAge;
    }

    public Employee() {
    }

    public Integer getTabelNumber() {
        return tabelNumber;
    }

    public void setTabelNumber(Integer tabelNumber) {
        this.tabelNumber = tabelNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Integer workAge) {
        this.workAge = workAge;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "tabelNumber=" + tabelNumber +
                ", name='" + name + '\'' +
                ", workAge=" + workAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(tabelNumber, employee.tabelNumber) && Objects.equals(name, employee.name)
                && Objects.equals(workAge, employee.workAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tabelNumber, name, workAge);
    }

    @Override
    public int compareTo(Employee o) {
        return this.tabelNumber.compareTo(o.getTabelNumber());
    }
}

