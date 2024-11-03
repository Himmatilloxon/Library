public class Person{
    private final String name;
    private final String ID;
    private int age;
    private final String login;
    private final String password;
    private final Role role;

    public Person(String name, int age,  String login, String password, Role role) {
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role = role;
        this.ID = PersonIDGenerator.generatePersonID();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Age: " + age);
        System.out.println("Role: " + role);
    }
}
