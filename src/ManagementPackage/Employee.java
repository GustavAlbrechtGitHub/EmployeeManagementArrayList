package ManagementPackage;


import java.text.*;

import java.util.Scanner;

public class Employee implements Comparable <Employee> {

    private String firstname;

    private String lastname;

    private String birthday;

    private double salary;

    private String department;

    private int id;

    public static int nextFreeId = 1;

    Scanner sc = new Scanner(System.in);


    public static int getNextFreeId() {

        return nextFreeId++;

    }

    public int compareTo(Employee e) {
        Collator col = Collator.getInstance();
        col.setStrength(Collator.PRIMARY);
        return col.compare(getFirstname(), e.getFirstname());

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(int id, String firstname, String lastname, String birthday, double salary, String department) {


        this.id = getNextFreeId();
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
        this.id = getNextFreeId();
    }


    @Override
    public String toString() {

        return "Employee id: " + getId() + " Name: " + getFirstname() + " " + getLastname()
                + " Birthday: " + getBirthday() + " Salary: " + getSalary() + " Department: " + getDepartment();
    }

}