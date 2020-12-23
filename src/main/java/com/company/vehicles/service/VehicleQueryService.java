package com.company.vehicles.service;

import com.company.vehicles.dto.VehicleQueryDTO;

import java.util.List;
import java.util.UUID;

public interface VehicleQueryService {
    public VehicleQueryDTO getVehicle(UUID id);

    public List<VehicleQueryDTO> listAllVehicles();

    public VehicleQueryDTO saveVehicle(VehicleQueryDTO vehicleDTO);
}
