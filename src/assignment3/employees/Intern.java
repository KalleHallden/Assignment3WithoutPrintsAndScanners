package assignment3.employees;

public class Intern extends Employee {

    private static final double GPA_BONUS = 1000;
    private static final double TEN_PERCENT_TAX = 0.9;

    private int gpa;

    private int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    //constructor with the class specific parameters

    public Intern(String name, String ID, double grossSalary, int gpa) {
        super(name, ID, grossSalary);
        this.gpa = gpa;
    }


    // depending on the interns "gpa" value he/she gets three different kind of salaries
    @Override
    public double getGrossSalary() {
        if (this.gpa <= 5) {
            return 0.0;
        } else if (this.gpa < 8) {
            return super.getGrossSalary();
        } else if (this.gpa <= 10) {
            return super.getGrossSalary() + GPA_BONUS;
        } else {
            return super.getGrossSalary();
        }
    }

    // 10 percent tax for she salary

    @Override
    public double getNetSalary() {
        return this.getGrossSalary() * TEN_PERCENT_TAX;
    }


    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println("This is the interns GPA: " + this.getGpa());
    }
}
