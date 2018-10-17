package assignment3.employees;


public class Director extends Manager {

    public static double benefit;

    private static final double LOW_SALARY = 30000;
    private static final double HIGH_SALARY = 50000;
    private static final double TEN_PERCENT_TAX = 0.9;
    private static final double TWENTY_PERCENT_TAX = 0.8;
    private static final double FORTY_PERCENT_TAX = 0.6;
    private static final double DEFAULT = 0.0;

    private String department;

    //constructor with parameters specific for this class

    public Director(String name, String ID, double grossSalary, String degree, String department) {
        super(name, ID, grossSalary, degree);
        this.department = department;
    }

    //calculating the net salary which in  this case is dependent on three different way to calculate it
    // and setting the net salary.
    @Override
    public double getNetSalary() {
        if (this.getGrossSalary() < LOW_SALARY) {
            return this.getGrossSalary() * TEN_PERCENT_TAX;
        } else if (this.getGrossSalary() <= HIGH_SALARY && this.getGrossSalary() >= LOW_SALARY) {
            return this.getGrossSalary() * TWENTY_PERCENT_TAX;
        } else if (this.getGrossSalary() > HIGH_SALARY) {
            double newNet = this.getGrossSalary() - LOW_SALARY;
            newNet = (newNet * FORTY_PERCENT_TAX) + (LOW_SALARY * TWENTY_PERCENT_TAX);
            return newNet;
        } else {
            return DEFAULT;
        }
    }

    //overriding the inherited gross salary and adding the benefit (if we have set it)
    @Override
    public double getGrossSalary() {
        return super.getGrossSalary() + benefit;
    }


    // printing the "interesting" stats about this director
    @Override
    public void printEmployee() {
        super.printEmployee();
        System.out.println("This is the directors benefit: " + this.benefit);
        System.out.println("This is the new salary: " + this.getGrossSalary());
        System.out.println("This is department: " + this.department);
    }

}

