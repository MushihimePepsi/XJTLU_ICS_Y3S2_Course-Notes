import java.time.LocalDate;

// Person class
class Person {
    protected String name;
    protected String address;
    protected String phone;
    protected String email;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + name;
    }
}

// Student class
class Student extends Person {
    public static final String[] STATUS = {"freshman", "sophomore", "junior", "senior"};
    private int classStatus;

    public Student(String name, int status) {
        super(name);
        this.classStatus = status;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Status: " + STATUS[classStatus];
    }
}

// Employee class
class Employee extends Person {
    protected String office;
    protected double salary;
    protected LocalDate dateHired;

    public Employee(String name, String office, double salary, LocalDate dateHired) {
        super(name);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", Office: " + office;
    }
}

// Faculty class
class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String office, double salary, LocalDate dateHired, String officeHours, String rank) {
        super(name, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty: " + name + ", Rank: " + rank;
    }
}

// Staff class
class Staff extends Employee {
    private String title;

    public Staff(String name, String office, double salary, LocalDate dateHired, String title) {
        super(name, office, salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff: " + name + ", Title: " + title;
    }
}

// Test program
public class TestPerson {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("John Doe");
        people[1] = new Student("Jane Smith", 1);
        people[2] = new Employee("Alice Johnson", "123 Main St", 50000, LocalDate.of(2020, 6, 1));
        people[3] = new Faculty("Bob Brown", "456 Elm St", 60000, LocalDate.of(2018, 8, 15), "8am-5pm", "Associate Professor");
        people[4] = new Staff("Charlie Davis", "789 Maple St", 45000, LocalDate.of(2019, 3, 20), "Manager");

        for (Person p : people) {
            System.out.println(p);
        }
    }
}