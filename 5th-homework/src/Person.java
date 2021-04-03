public class Person {
    public String FCS;
    public String post;
    public String email;
    public String phoneNumber;
    public int    salary;
    public int    age;

    public Person(String FCS, String post, String email, String phoneNumber, int salary, int age) {
        this.FCS         = FCS;
        this.post        = post;
        this.email       = email;
        this.phoneNumber = phoneNumber;
        this.salary      = salary;
        this.age         = age;
    }

    public String toString() {
        return "ФИО: " + this.FCS + "\n" +
               "Должность: " + this.post + "\n" +
               "e-mail: " + this.email + "\n" +
               "Номер телефона: " + this.phoneNumber + "\n" +
               "Зарплата: " + this.salary + "\n" +
               "Возраст: " + this.age;
    }
}
