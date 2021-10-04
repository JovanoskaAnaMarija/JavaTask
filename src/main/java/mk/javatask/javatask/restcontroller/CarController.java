package mk.javatask.javatask.restcontroller;

import mk.javatask.javatask.model.Car;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;

import java.util.List;


@RestController
@RequestMapping("api/cars")
public class CarController {
    @GetMapping
    public List<Car> listAllCars() throws IOException {
        List<Car> cars = new ArrayList<Car>();
        Reader in = new FileReader("cars.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("id", "manufacturer", "model").withIgnoreEmptyLines()
               .parse(in);
        for (CSVRecord record : records) {

            Integer id = Integer.parseInt(record.get("id"));
            String manufacturer = record.get("manufacturer");
            String model = record.get("model");
             cars.add(new Car(id, manufacturer, model));

        }
        return cars;
    }
}








