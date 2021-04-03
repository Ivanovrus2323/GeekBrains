public class MyApp {

    public static void main(String[] args) {
        Person[] employees = createEmployees();

        // Выводим в консоль сотрудников, чей возраст больше 40
        for (Person employee : employees) {
            if (employee.age > 40) {
                System.out.println(employee.toString());
            }
        }
    }
    
    public static Person[] createEmployees() {
        Person[] employees = new Person[5];

        // Заполняем массив сотрудников
        employees[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 40000, 30);
        employees[1] = new Person("Kazakova Alice Pavlovna", "Designer", "KazakovaMail@mail.ru", "89151374567", 70000, 26);
        employees[2] = new Person("Ilinskaya Polina Mikhailovna", "Janitor", "Ilinskaya@rambler.ru", "89774564890", 30000, 47);
        employees[3] = new Person("Kuznetsova Margarita Igorevna", "System Administrator", "Kuznetsova@gmail.com", "84958880001", 60000, 49);
        employees[4] = new Person("Dementyev Arseny Alexandrovich", "Accountant", "Dementyev@gmail.com", "89261374568", 50000, 34);
        return employees;
    }
    
}
