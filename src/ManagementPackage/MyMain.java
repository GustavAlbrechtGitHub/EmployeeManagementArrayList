package ManagementPackage;

import static ManagementPackage.EmployeeManagement.*;
import static ManagementPackage.UI.*;
import static ManagementPackage.Utilities.*;

public class MyMain {

    static boolean mainLoop = true;
    static boolean managementLoop = true;
    static boolean statisticsLoop = true;

    public static void main (String[] args){

        loadListWithEmployees();

        while (mainLoop) {

            managementLoop = true;
            statisticsLoop = true;

            runEmployeeManagementProgram();
        }
    }

    private static void runEmployeeManagementProgram() {


        showMainMenu();

        String choice = getStringInput();

        switch (choice){

            case "1" -> {
                while (managementLoop){
                    employeeManagement();
                }
            }
            case "2" -> {
                while (statisticsLoop){
                    employeeStatistics();
                }
            }
            case "0" -> mainLoop = false;
            default -> System.out.println("Wrong input, please choose 1-2");

        }
    }


    private static void employeeManagement(){

        showManagementMenu();

        String choice = getStringInput();

        switch (choice) {

            case "1" -> addEmployee(registerEmployee());
            case "2" -> removeEmployeeById();
            case "3" -> updateEmployee();
            case "4" -> searchEmployeeName();
            case "5" -> searchEmploeeyIdNumber();
            case "6" -> searchByDepartment();
            case "7" -> showAllEmployess2();
            case "0" -> managementLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }

    public static Employee registerEmployee() {
        Employee employee = new Employee();

        System.out.print("Enter First Name: ");
        employee.setFirstname(getStringInput());

        System.out.print("Enter Last Name: ");
        employee.setLastname(getStringInput());

        System.out.print("Enter birthday(YYYYMMDD****): ");
        employee.setBirthday(getStringInput());

        System.out.print("Enter salary: ");
        employee.setSalary(getDoubleInput());

        enterDepartment(employee);


        return employee;
    }

    private static void employeeStatistics(){

        showStatisticsMenu();

        String input = getStringInput();

        switch (input){
            case "1" -> averageSalary();
            case "2" -> maximumSalary();
            case "3" -> minimumSalary();
            case "4" -> arrayListSortByName();
            case "5" -> womenPercentage();
            case "6" -> menPercentageDepartment();
            case "0" -> statisticsLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }

}
