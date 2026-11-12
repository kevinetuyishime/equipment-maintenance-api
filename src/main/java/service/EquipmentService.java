
package com.example.equipmentmaintenanceapi.service;

import com.example.equipmentmaintenanceapi.model.Equipment;
import com.example.equipmentmaintenanceapi.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment createEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found with ID: " + id));
    }

    public Equipment updateEquipment(Long id, Equipment updatedEquipment) {
        Equipment equipment = getEquipmentById(id);

        equipment.setName(updatedEquipment.getName());
        equipment.setCategory(updatedEquipment.getCategory());
        equipment.setSerialNumber(updatedEquipment.getSerialNumber());
        equipment.setManufacturer(updatedEquipment.getManufacturer());
        equipment.setLocation(updatedEquipment.getLocation());
        equipment.setStatus(updatedEquipment.getStatus());

        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        Equipment equipment = getEquipmentById(id);
        equipmentRepository.delete(equipment);
    }

    public List<Equipment> searchEquipment(String keyword) {
        return equipmentRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Equipment> getEquipmentByCategory(String category) {
        return equipmentRepository.findByCategoryIgnoreCase(category);
    }

    public List<Equipment> getEquipmentByStatus(String status) {
        return equipmentRepository.findByStatusIgnoreCase(status);
    }

    public List<Equipment> getEquipmentByLocation(String location) {
        return equipmentRepository.findByLocationContainingIgnoreCase(location);
    }
}
