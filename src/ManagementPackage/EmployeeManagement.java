package ManagementPackage;
import java.util.*;
import static ManagementPackage.Utilities.*;
import static ManagementPackage.UI.*;

public class EmployeeManagement {

    static ArrayList<Employee> alEmployees = new ArrayList<>();


    public static void addEmployee(Employee e) {
        alEmployees.add(e);
    }

    public static String enterDepartment(Employee e){
        System.out.println("Please enter department");
        System.out.println("1.DBAdmin, 2.Developer, 3.Technician, 4.Marketing, 5.Secretary, 6.Web Designer 7. Chief");
        String choiceDepartment = sc.nextLine();

        switch (choiceDepartment) {
            case "1" -> e.setDepartment("DBAdmin");
            case "2" -> e.setDepartment("Developer");
            case "3" -> e.setDepartment("Technician");
            case "4" -> e.setDepartment("Marketing");
            case "5" -> e.setDepartment("Secretary");
            case "6" -> e.setDepartment("Web Designer");
            case "7" -> e.setDepartment("Chief");
            default -> System.out.println("Wrong input, please choose option 1-7.");
        }

        return e.getDepartment();
    }

    public static void updateEmployee() {
        //array.get(i)
        //array.add(e);

        System.out.print("Please enter id:");
        int id = getIntInput();

        System.out.println(findEmployeeById(id));

        boolean updateLoop = true;


        while (updateLoop) {

            showUpdateMenu();

            String input = getStringInput();

            switch (input) {

                case "1" -> updateEmployeeNameById(id);
                case "2" -> updateEmployeeBirthdayById(id);
                case "3" -> updateEmployeeSalaryById(id);
                case "4" -> updateEmployeeDepartmentById(id);
                case "0" -> updateLoop = false;
                default -> System.out.println("Wrong input, please choose 1-4.");


            }
        }

    }

    public static void updateEmployeeNameById(int id) {
        System.out.println("New first name: ");
        String newFirstName = getStringInput();
        System.out.println("New last name: ");
        String newLastName = getStringInput();

        Employee e = findEmployeeById(id);
        e.setFirstname(newFirstName);
        e.setLastname(newLastName);

        System.out.println("Name has been updated!");

        //System.out.println(e);
    }

    public static void updateEmployeeBirthdayById(int id) {
        System.out.println("New Birthday: ");

        String newBirthday = getStringInput();

        Employee e = findEmployeeById(id);

        e.setBirthday(newBirthday);

        System.out.println("Birthday has been updated!");

        //System.out.println(e);


    }

    public static void updateEmployeeSalaryById(int id) {
        System.out.println("New Salary: ");

        double newSalary = getDoubleInput();

        Employee e = findEmployeeById(id);
        e.setSalary(newSalary);
        System.out.println("Salary has been updated!");
        //System.out.println(e);
    }

    public static void updateEmployeeDepartmentById(int id) {


        String newDepartment = choiceOfDepartment();

        Employee e = findEmployeeById(id);
        e.setDepartment(newDepartment);

        System.out.println("Department has been updated!");



    }

    public static Employee findEmployeeById(int id) {
        for (Employee e : alEmployees) {

            if (e.getId() == id)
                return e;
        }
        return null;
    }

    public static void removeEmployeeById() {
        System.out.println("Please enter id: ");
        int id = getIntInput();

        Employee e = findEmployeeById(id);
        alEmployees.remove(e);

        System.out.println(e.toString() + " has been removed!");


    }

    public static void showAllEmployees() {
        for (Employee e : alEmployees) {
            System.out.println(e);
        }
    }

    public static void showAllEmployess2() {
        UI.header();

        for (Employee e : alEmployees) {
            System.out.println("  " +
                     fixString(6, String.valueOf(e.getId())) +
                     fixString(22, e.getFirstname() + " " + e.getLastname()) +
                     fixString(22, e.getBirthday()) +
                     fixString(19, String.valueOf(e.getSalary())) +
                     fixString(18, e.getDepartment()));
        }
        UI.footer();
        System.out.println("\n Press any key to continue.");
        getStringInput();


    }

    public static void averageSalary() {

        double sumSalary = 0;

        for (Employee e : alEmployees) {
            sumSalary = sumSalary + e.getSalary();
        }
        double averageSalary = sumSalary / alEmployees.size();

        System.out.println("The average salary is: " + averageSalary + " kr");
    }

    public static void maximumSalary() {
        int maximum = 0;

        for (int i = 1; i < alEmployees.size(); i++) {
            if (alEmployees.get(i).getSalary() > alEmployees.get(maximum).getSalary())
                maximum = i;
        }
        System.out.println("The highest salary is: " + alEmployees.get(maximum).getSalary() + " kr");


    }

    public static void minimumSalary() {
        int minimum = 0;

        for (int i = 1; i < alEmployees.size(); i++) {
            if (alEmployees.get(i).getSalary() < alEmployees.get(minimum).getSalary())
                minimum = i;
        }
        System.out.println("The lowest salary is : " + alEmployees.get(minimum).getSalary() + " kr");


    }

    public static void searchEmployeeName() {

        boolean foundLoop = false;

        System.out.println("Search employee by first name: ");

        String search = getStringInput();

        for (int i = 0; i < alEmployees.size(); i++) {
            if (search.equalsIgnoreCase(alEmployees.get(i).getFirstname())) {
                foundLoop = true;
                System.out.println("Your search gave a hit for: " + alEmployees.get(i).toString());
            }
        }
            if (foundLoop == false) {
                System.out.println("Search was not found.");

        }

    }

    public static void searchEmploeeyIdNumber() {
        boolean foundLoop = false;

        try {
            System.out.print("Search employee id number: ");

            int search = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < alEmployees.size(); i++) {

                if (alEmployees.get(i).getId() == search) {
                    foundLoop = true;
                    System.out.println("Your search gave a hit for employee: " + alEmployees.get(i).toString());

                }
            }

            if (foundLoop == false) {

                    System.out.println("Search was not found.");

            }

        } catch (InputMismatchException e) {
            System.out.println("Incorrect input, Please input number.");
        }
    }

    public static void searchByDepartment() {

        boolean foundLoop = false;

        String department = choiceOfDepartment();



        for (int i = 0; i < alEmployees.size(); i++) {

            if (department.equalsIgnoreCase(alEmployees.get(i).getDepartment())) {
                foundLoop = true;
                System.out.println("Employees in this department: " + alEmployees.get(i).toString());


            }
        }

            if (foundLoop == false) {
                System.out.println("No Employee in this department.");


        }


    }

    public static void arrayListSortByName(){

        Collections.sort(alEmployees);

        UI.header();

        for (Employee e : alEmployees) {
            System.out.println("  " +
                    fixString(6, String.valueOf(e.getId())) +
                    fixString(22, e.getFirstname() + " " + e.getLastname()) +
                    fixString(22, e.getBirthday()) +
                    fixString(19, String.valueOf(e.getSalary())) +
                    fixString(18, e.getDepartment()));
        }
        UI.footer();
        System.out.println("\n Press any key to continue.");
        getStringInput();


    }

    public static void womenPercentage() {
        double numberOfWomen = 0;

        try {


            for (int i = 0; i < alEmployees.size(); i++) {
                char s = alEmployees.get(i).getBirthday().charAt(9);
                if (s % 2 == 0) {
                    numberOfWomen++;
                }
            }
            double womenPercentage = (numberOfWomen / alEmployees.size()) * 100;
            System.out.println("Percentage of women is: " + womenPercentage + "%");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Incorrect input of birthday, please update in update birthday option.");
        }

    }

    public static void menPercentageDepartment(){
    double  numberOfMen = 0;
    double totalOnDepartment = 0;


    try {
        String department = choiceOfDepartment();

        for (int i = 0; i < alEmployees.size(); i++) {

            char s = alEmployees.get(i).getBirthday().charAt(9);
            if (s % 2 == 1 && department.equalsIgnoreCase(alEmployees.get(i).getDepartment())) {
                numberOfMen++;
            }
            if(department.equalsIgnoreCase(alEmployees.get(i).getDepartment())){
                totalOnDepartment++;
            }
        }
        double menPercentage = (numberOfMen / totalOnDepartment) * 100;
        System.out.println("Percentage of men is: " + menPercentage + "%");
    }
                catch (StringIndexOutOfBoundsException e){
        System.out.println("Incorrect input of birthday, please update in update birthday option.");

    }
  }

    public static void loadListWithEmployees() {


        Employee e1 = new Employee(1, "Linda", "Danielsson", "199403051245", 25000, "Developer");
        Employee e2 = new Employee(2, "Rebecka", "Strand", "199205062468", 30000, "Developer");
        Employee e3 = new Employee(3, "Sara", "Svensson", "199003203686", 20000, "Technician");
        Employee e4 = new Employee(4, "Julian", "Amandusson", "199605103576", 22000, "Technician");
        Employee e5 = new Employee(5, "Gustav", "Albrecht", "199409071314", 50000, "Chief");

        alEmployees.add(e1);
        alEmployees.add(e2);
        alEmployees.add(e3);
        alEmployees.add(e4);
        alEmployees.add(e5);
    }
    public static String choiceOfDepartment(){

        boolean loop = true;


        while (loop) {
            System.out.println("Please enter department: ");
            System.out.println("1.DBAdmin, 2.Developer, 3.Technician, 4.Marketing, 5.Secretary, 6.Web Designer 7. Chief");
            String choice = getStringInput();



            switch (choice) {
                case "1":
                    loop = false;
                    return "DBAdmin";


                case "2":
                    loop = false;
                    return "Developer";

                case "3":
                    loop = false;
                    return "Technician";

                case "4":
                    loop = false;
                    return "Marketing";

                case "5":
                    loop = false;
                    return "Secretary";

                case "6":
                    loop = false;
                    return "Webdesigner";

                case "7":
                    loop = false;
                    return "Chief";

                default:
                    System.out.println("Wrong input, Please choose option 1-7");
            }

        }

        return null;
    }

}

