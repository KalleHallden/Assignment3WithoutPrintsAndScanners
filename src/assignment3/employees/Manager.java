package assignment3.employees;

public class Manager extends Employee {

    private String degree;
    private double bonus;
    private static final double TEN_PERCENT_TAX = 0.9;
    private static final double BACHELOR_BONUS = 1.1;
    private static final double MASTER_BONUS = 1.2;
    private static final double PHD_BONUS = 1.35;


    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public double getBonus() {
        return this.getGrossSalary() * bonus;
    }


    // salary calculation depending the the managers academic degree

    @Override
    public double getGrossSalary() {
        if (degree.equalsIgnoreCase("BSc")) {
            this.bonus = BACHELOR_BONUS;
        }
        if (degree.equalsIgnoreCase("MSc")) {
            this.bonus = MASTER_BONUS;
        }
        if (degree.equalsIgnoreCase("Phd")) {
            this.bonus = PHD_BONUS;
        }
        return super.getGrossSalary() * bonus;
    }

    //logic to calculate the tax of the salary

    @Override
    public double getNetSalary() {
        return this.getGrossSalary() * TEN_PERCENT_TAX;
    }

    // constructor with the class specific parameters

    public Manager(String name, String ID, double grossSalary, String degree){
        super(name, ID, grossSalary);
        this.degree = degree;
        this.bonus = bonus;
    }

    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println("Degree: " + this.degree);
        System.out.println("Bonus: " + this.bonus);
        System.out.println("New gross salary: " + this.getGrossSalary());
    }
}
