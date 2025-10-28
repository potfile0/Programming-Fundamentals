//represent a person
public class Person {
    //what data do I want to store about an individual person?
    //each piece of data will be a field(also called instance variable)

    //declare a field:
    //private type fieldName;
    private String name;
    private int age;

    //constructor(create a new Person, initialize its data)
    //public ClassName(params)
    public Person(String n, int a) {
        name = n;
        age = a;
    }
    //operations
    public void print() {
        System.out.printf("%s, age %d%n", name, age);
    }

    public void birthday() {
        age++;
    }

    public String getName() {
        return name;
    }
}