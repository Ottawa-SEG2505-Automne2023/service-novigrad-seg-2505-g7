import com.example.servicesdenovigrad.User;

public class Employee extends User {
    // le constructeur
    public Employee ( String name, String username, String password) {
        super(name, username, password);
        this.role = "Employee";
    }
}
