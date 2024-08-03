package revision.basicClassObject;

public class CallEmployee {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Carl", 20, 100, "Nth");
        Employee employee2 = new Employee("Nat", 21, 200, "Nth");

        employee1.raiseSalary();

        System.out.println("employee1 detail: " + employee1.getName() + " " + employee1.getSalary());
        System.out.println("employee2 detail: " + employee2.getName() + " " + employee2.getSalary());
    }
}
