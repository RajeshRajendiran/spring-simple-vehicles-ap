package com.company.vehicles.helpers;

import com.company.vehicles.entities.Vehicle;
import com.company.vehicles.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SampleDataRunner implements CommandLineRunner {

    private final VehicleRepository vehicleRepository;

    public SampleDataRunner(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Vehicle audi = new Vehicle();
        audi.setId(UUID.randomUUID());
        audi.setVehicleIdentityNumber("Reg#1234");
        audi.setMake("Audi");
        audi.setModel("Q5");

        vehicleRepository.save(audi);

        Vehicle tesla = new Vehicle();
        tesla.setId(UUID.randomUUID());
        tesla.setVehicleIdentityNumber("Reg#6789");
        tesla.setMake("Tesla");
        tesla.setModel("Model S");

        vehicleRepository.save(tesla);

        System.out.println("Data inserted ");
    }
}

