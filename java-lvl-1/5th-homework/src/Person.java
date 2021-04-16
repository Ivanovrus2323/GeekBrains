public class Person {
    private String fcs;
    private String post;
    private String email;
    private String phoneNumber;
    private int    salary;
    private int    age;


    public Person(String fcs, String post, String email, String phoneNumber, int salary, int age) {
        this.fcs         = fcs;
        this.post        = post;
        this.email       = email;
        this.phoneNumber = phoneNumber;
        this.salary      = salary;
        this.age         = age;
    }

    public String getFcs() {
        return fcs;
    }

    public String getPost() {
        return post;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "ФИО: " + this.fcs + "\n" +
                "Должность: " + this.post + "\n" +
                "e-mail: " + this.email + "\n" +
                "Номер телефона: " + this.phoneNumber + "\n" +
                "Зарплата: " + this.salary + "\n" +
                "Возраст: " + this.age;
    }
}
