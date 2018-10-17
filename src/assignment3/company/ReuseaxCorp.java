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

    // retrieving the employee based on its ID and removing it from the arraylist

    public void removeEmployee(String ID) {
        this.employees.remove(retrieveEmployee(ID));
    }

    // retrieving  the employee based on its ID


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

    // searching through the arraylist and printing all of the objects stored in it
    // and if there are non printing error message

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

    //updating the name of an employee using the retrieveEmployee method


    public void updateName(String ID, String newName) {
        Employee nameEmployee = retrieveEmployee(ID);
        if (nameEmployee != null) {
            nameEmployee.setName(newName);
        }
    }

    //updating the salary of an employee using the retrieveEmployee method


    public void updateSalary(String ID, double newSalary) {
        Employee salaryEmployee = retrieveEmployee(ID);
        if (salaryEmployee != null) {
            salaryEmployee.setGrossSalary(newSalary);
            salaryEmployee.setNetSalary();
        }
    }

    //searching through the arraylist and adding all of the gross salaries together


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

    //searching through the arraylist and adding all of the net salaries together


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


    //searching through the arraylist and adding all of the objects together

    public int totalNumOfEmployees() {
        return this.employees.size();
    }

    // ARGUMENTATION FOR UPCAST/DOWNCAST
    // The way we decided to do this was based on what we could come up with whilst trying to solve the problem
    // but there are problems with this way besides it being "ugly".
    //
    // First of all there are redundant code which could with more knowledge probably be reduced and made better.
    //
    // Secondly we save the desired information (or kind of copy) onto a new object which we add to the array
    // and then remove the retrieved "person" instead of just updating the retrieved "person" to the desired position.
    // Logically this would be done in a different way and this shows the struggle of inheritance.
    //
    // Thirdly these kind of methods are risky in the sense that it's easy to lose valuable information and
    // variables.

    public Intern promoteToIntern(String ID, int gpa) {
        Employee myNewEmployee = retrieveEmployee(ID);

        //promoting any employee using the retrieveEmployee method then casting the values to an intern
        // and creating a new intern with those values of the employee retrieved and deleting the old employee
        // and then creating a new object (intern)

        if (myNewEmployee != null) {
            Intern ne = new Intern(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary, gpa);
            this.employees.remove(myNewEmployee);
            this.employees.add(ne);
            return ne;
        } else {
            return null;
        }
    }



    public Employee promoteToEmployee(String ID) {
        Employee myNewEmployee = retrieveEmployee(ID);

        //promoting any employee using the retrieveEmployee method then casting the values to an employee
        // and creating a new employee with those values of the employee retrieved and deleting the old employee
        // and then creating a new object (employee)

        if (myNewEmployee != null) {
            Employee ne = new Employee(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary);
            this.employees.remove(myNewEmployee);
            this.employees.add(ne);
            return ne;
        } else {
            return null;
        }
    }


    public Manager promoteToManager(String ID, String degree) {
        Employee myNewEmployee = retrieveEmployee(ID);

        //promoting any employee using the retrieveEmployee method then casting the values to an manager
        // and creating a new manager with those values of the employee retrieved and deleting the old employee
        // and then creating a new object (manager)

        if (myNewEmployee != null) {


            if (myNewEmployee instanceof Intern) {
                Intern intern = (Intern) myNewEmployee;
                Manager newEmployee = new Manager(intern.getName(), intern.getID(), intern.grossSalary, degree);
                this.employees.remove(intern);
                this.employees.add(newEmployee);
                newEmployee.setNetSalary();
                return newEmployee;
            }
            if (myNewEmployee instanceof Director) {
                Manager newEmployee = new Manager(myNewEmployee.getName(), myNewEmployee.getID(), myNewEmployee.grossSalary, degree);
                employees.remove(myNewEmployee);
                employees.add(newEmployee);
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

        //promoting any employee using the retrieveEmployee method then casting the values to an director
        // and creating a new director with those values of the employee retrieved and deleting the old employee
        // and then creating a new object (director)

        if (myNewEmployee != null) {
            if (myNewEmployee instanceof Intern) {
                Intern intern = (Intern) myNewEmployee;
                Director newEmployee = new Director(intern.getName(), intern.getID(), intern.grossSalary, degree, department);
                this.employees.remove(intern);
                this.employees.add(newEmployee);
                newEmployee.setNetSalary();
                return newEmployee;
            }
            // since we want the director to keep its degree if the employee that we retrieve is a manager
            // we need a separate "if statement" for this
            if (myNewEmployee instanceof Manager) {
                Manager director = (Manager) myNewEmployee;
                //constructor for creating a director
                Director newEmployee = new Director(director.getName(), director.getID(), director.grossSalary, director.getDegree(), department);
                this.employees.remove(director);
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

    // method to set the directors benefit for all directors no matter which department they are in charge of

    public double setDirectorBenefit(double newDirectorBenefit) {
        Director.benefit = newDirectorBenefit;
        return Director.benefit;
    }
}