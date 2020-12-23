package com.company.vehicles.service.impl;

import com.company.vehicles.dto.VehicleQueryDTO;
import com.company.vehicles.entities.Vehicle;
import com.company.vehicles.repository.VehicleRepository;
import com.company.vehicles.service.VehicleQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleQueryServiceImpl implements VehicleQueryService {

    private final VehicleRepository vehicleRepository;

    public VehicleQueryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleQueryDTO getVehicle(UUID id) {
        if (vehicleRepository.findById(id).isPresent()) {
            Vehicle fetchedVehicle = vehicleRepository.findById(id).get();
            return new VehicleQueryDTO(fetchedVehicle.getId(), fetchedVehicle.getVehicleIdentityNumber(), fetchedVehicle.getMake(), fetchedVehicle.getModel());
        } else {
            return null;
        }
    }

    @Override
    public List<VehicleQueryDTO> listAllVehicles() {
        List<VehicleQueryDTO> vehicleList = new ArrayList<>();

        vehicleRepository.findAll().forEach(vehicle -> {
            vehicleList.add(new VehicleQueryDTO(vehicle.getId(), vehicle.getVehicleIdentityNumber(), vehicle.getMake(), vehicle.getModel()));
        });

        return vehicleList;
    }

    @Override
    public VehicleQueryDTO saveVehicle(VehicleQueryDTO vehicleDTO) {
        var entity = convertToEntity(vehicleDTO);
        var result = vehicleRepository.save(entity);
        return convertToDto(result);
    }

    private Vehicle convertToEntity(VehicleQueryDTO vehicleQueryDTO) {
        var entity = new Vehicle();
        entity.setId(vehicleQueryDTO.getId());
        entity.setMake(vehicleQueryDTO.getMake());
        entity.setModel(vehicleQueryDTO.getModel());
        entity.setVehicleIdentityNumber(vehicleQueryDTO.getVehicleIdentityNumber());
        return entity;
    }

    private VehicleQueryDTO convertToDto(Vehicle vehicle) {
        return new VehicleQueryDTO(vehicle.getId(), vehicle.getVehicleIdentityNumber(), vehicle.getMake(), vehicle.getModel());
    }
}
