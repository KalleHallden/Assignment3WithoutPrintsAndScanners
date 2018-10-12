package assignment3.Main;

import assignment3.company.ReuseaxCorp;

public class MainClass {
    public static void main(String[] args) {
        ReuseaxCorp program = new ReuseaxCorp();
        program.registerIntern("Kale", "1", 1000, 3);
        program.printAllEmployees();
        program.promoteToDirector("1", "bsc", "human");
        program.printAllEmployees();
        program.promoteToEmployee("1");
        program.printAllEmployees();
        program.promoteToDirector("1", "bsc", "human");
        program.printAllEmployees();
        program.promoteToManager("1", "bsc");
        program.printAllEmployees();
        program.promoteToIntern("1", 3);
        program.printAllEmployees();
    }
}