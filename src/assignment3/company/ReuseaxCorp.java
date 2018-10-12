package assignment3.company;


import assignment3.employees.Director;
import assignment3.employees.Employee;
import assignment3.employees.Intern;
import assignment3.employees.Manager;

import java.util.ArrayList;

public class ReuseaxCorp {


    private ArrayList<Employee> employees;

    public ReuseaxCorp() {
        this.employees = new ArrayList<>();
    }


    public void registerEmployee(String name, String ID, double salary) {
        Employee employee = new Employee(name, ID, salary);
        this.employees.add(employee);
    }
    public void registerIntern(String name, String ID, double salary, int gpa) {
        Intern intern = new Intern(name, ID, salary, gpa);
        this.employees.add(intern);
    }

    public void registerManager(String name, String ID, double salary, String degree) {
        Manager manager = new Manager(name, ID, salary, degree);
        this.employees.add(manager);
    }
    public void registerDirector(String name, String ID, double salary, String degree, String department) {
        Director director = new Director(name, ID, salary, degree, department);
        this.employees.add(director);
    }

    public void removeEmployee(String ID) {
        this.employees.remove(retrieveEmployee(ID));
    }

    public Employee retrieveEmployee(String ID) {
        if (this.employees.size() > 0) {

            for (Employee employee : this.employees) {
                if (employee.getID().equalsIgnoreCase(ID)) {
                    return employee;
                }
            }
        } else {
            return null;
        }
        return null;
    }

    public void printAllEmployees() {
        if (this.employees.size() > 0) {
            for (int i = 0; i < this.employees.size(); i++) {
                this.employees.get(i).printEmployee();
                System.out.println("======================================");
            }
        } else {
            System.out.println("No employees registered yet");
        }
    }


    public void updateName(String ID, String newName) {
        Employee nameEmployee = retrieveEmployee(ID);
        if (nameEmployee != null) {
            nameEmployee.setName(newName);
        }
    }

    public void updateSalary(String ID, double newSalary) {
        Employee salaryEmployee = retrieveEmployee(ID);
        if (salaryEmployee != null) {
            salaryEmployee.setGrossSalary(newSalary);
            salaryEmployee.setNetSalary();
        }
    }


    public double calcGrossSalaries() {
        double totalGrossSalaries = 0.0;
        if (!this.employees.isEmpty()) {

            for (int i = 0; i < this.employees.size(); i++) {
                this.employees.get(i).getGrossSalary();
                totalGrossSalaries += this.employees.get(i).getGrossSalary();
            }
        }
        return totalGrossSalaries;
    }

    public double calcNetSalaries() {
        double totalNetSalaries = 0;
        if (!this.employees.isEmpty()) {
            for (int i = 0; i < this.employees.size(); i++) {
                this.employees.get(i).getNetSalary();
                totalNetSalaries += this.employees.get(i).getNetSalary();
            }
        }
        return totalNetSalaries;
    }


    public int totalNumOfEmployees() {
        return this.employees.size();
    }

    public Intern promoteToIntern(String ID, int gpa) {
        Employee myNewEmployee = retrieveEmployee(ID);

        if (myNewEmployee != null) {
            Intern ne = new Intern(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary, gpa);
            this.employees.remove(myNewEmployee);
            this.employees.add(ne);
            return ne;
        } else {
            System.out.println("nulle");
            return null;
        }
    }

    public Employee promoteToEmployee(String ID) {
        Employee myNewEmployee = retrieveEmployee(ID);

        if (myNewEmployee != null) {
            Employee ne = new Employee(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary);
            this.employees.remove(myNewEmployee);
            this.employees.add(ne);
            return ne;
        } else {
            System.out.println("nulle");
            return null;
        }
    }


    public Manager promoteToManager(String ID, String degree) {
        Employee myNewEmployee = retrieveEmployee(ID);

        if (myNewEmployee != null) {
            if (myNewEmployee instanceof Intern) {
                Intern newIntern = (Intern) myNewEmployee;
                Manager newEmployee = new Manager(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, degree);
                this.employees.remove(newIntern);
                this.employees.add(newEmployee);
                newEmployee.setNetSalary();
                return newEmployee;
            }
            if (myNewEmployee instanceof Director) {
                Manager newEmp = new Manager(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary, degree);
                employees.remove(myNewEmployee);
                employees.add(newEmp);
                return null;
            }
            if (!(myNewEmployee instanceof Manager)) {
                Manager newEmployee = new Manager(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary, degree);
                this.employees.remove(myNewEmployee);
                this.employees.add(newEmployee);
                newEmployee.setNetSalary();
                return newEmployee;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


    public Director promoteToDirector(String ID, String degree, String department) {
        Employee myNewEmployee = retrieveEmployee(ID);
        if (myNewEmployee != null) {
            if (myNewEmployee instanceof Intern) {
                Intern newIntern = (Intern) myNewEmployee;
                Director newEmployee = new Director(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, degree, department);
                this.employees.remove(newIntern);
                this.employees.add(newEmployee);
                newEmployee.setNetSalary();
                return newEmployee;
            }
            if (myNewEmployee instanceof Manager) {
                Manager newIntern = (Manager) myNewEmployee;
                Director newEmployee = new Director(newIntern.getName(), newIntern.getID(), newIntern.grossSalary, newIntern.getDegree(), department);
                this.employees.remove(newIntern);
                this.employees.add(newEmployee);
                newEmployee.setNetSalary();
                return newEmployee;
            }
            else {
                Director newEmployee = new Director(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary, degree, department);
                this.employees.remove(myNewEmployee);
                this.employees.add(newEmployee);
                newEmployee.setNetSalary();
                return newEmployee;
            }
        } else {
            return null;
        }
    }

    public double setDirectorBenefit(double newDirectorBenefit) {
        Director.benefit = newDirectorBenefit;
        return Director.benefit;
    }
}