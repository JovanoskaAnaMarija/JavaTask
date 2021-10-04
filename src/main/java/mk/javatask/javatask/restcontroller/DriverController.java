package mk.javatask.javatask.restcontroller;

import mk.javatask.javatask.model.Driver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;


@RestController
@RequestMapping("api/drivers")
public class DriverController {


    @GetMapping
    public List<Driver> listAllDrivers() throws IOException {
        List<Driver> drivers = new ArrayList<Driver>();
        Reader in = new FileReader("drivers.csv");

        Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader("id", "firstName", "lastName", "active").withIgnoreEmptyLines().withAllowMissingColumnNames(true)
                .parse(in);
        for (CSVRecord record : records) {
            String id = (record.get("id"));
            String firstName = record.get("firstName");
            String lastName = record.get("lastName");
            String active = record.get("active");
            if (record.size() < 4 ) {
                continue;
            }
           if((record.get(3).equals(" true") && record.get(0).matches("\\d+")) || ((record.isMapped(id) && record.isMapped(firstName) && record.isMapped(lastName) && record.isMapped(active)))){
                    drivers.add(new Driver(id, firstName, lastName, active));

            }
        }
        return drivers;
    }
}

