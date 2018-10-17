package assignment3.employees;

public class Employee {

    private String name;
    private final String ID;
    public double grossSalary;
    public double netSalary;
    private final double TEN_PERCENT_TAX = 0.9;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;

    }

    public void setNetSalary() {
        netSalary = grossSalary * TEN_PERCENT_TAX;
    }

    public double getNetSalary() {
        return this.getGrossSalary() * TEN_PERCENT_TAX;
    }


    // constructor of the super class

    public Employee(String name, String ID, double grossSalary) {
        this.name = name;
        this.ID = ID;
        this.grossSalary = grossSalary;

    }

    // " interesting " information about this object and its variables

    public void printEmployee() {
        System.out.println("ID: " + this.getID());
        System.out.println("Name: " + this.getName());
        System.out.println("Gross salary: " + this.grossSalary);
        System.out.println("Net salary: " + this.getNetSalary());
    }
}


