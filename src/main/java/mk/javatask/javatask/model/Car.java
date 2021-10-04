package mk.javatask.javatask.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private Integer id;

    private String manufacturer;

    private String model;
}
