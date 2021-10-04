package mk.javatask.javatask.model;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Driver {


    private String id;

    private String firstName;

    private String lastName;

    private String active;

    public Driver(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
}
