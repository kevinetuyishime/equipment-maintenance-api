
package com.example.equipmentmaintenanceapi.service;

import com.example.equipmentmaintenanceapi.model.Maintenance;
import com.example.equipmentmaintenanceapi.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public Maintenance createMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    public Maintenance getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maintenance record not found with ID: " + id));
    }

    public Maintenance updateMaintenance(Long id, Maintenance updatedMaintenance) {
        Maintenance maintenance = getMaintenanceById(id);

        maintenance.setEquipment(updatedMaintenance.getEquipment());
        maintenance.setMaintenanceType(updatedMaintenance.getMaintenanceType());
        maintenance.setDescription(updatedMaintenance.getDescription());
        maintenance.setMaintenanceDate(updatedMaintenance.getMaintenanceDate());
        maintenance.setCompletionDate(updatedMaintenance.getCompletionDate());
        maintenance.setPriority(updatedMaintenance.getPriority());
        maintenance.setStatus(updatedMaintenance.getStatus());
        maintenance.setTechnicianName(updatedMaintenance.getTechnicianName());
        maintenance.setCost(updatedMaintenance.getCost());

        return maintenanceRepository.save(maintenance);
    }

    public void deleteMaintenance(Long id) {
        Maintenance maintenance = getMaintenanceById(id);
        maintenanceRepository.delete(maintenance);
    }

    public List<Maintenance> getMaintenanceByEquipment(Long equipmentId) {
        return maintenanceRepository.findByEquipmentId(equipmentId);
    }

    public List<Maintenance> getMaintenanceByStatus(String status) {
        return maintenanceRepository.findByStatusIgnoreCase(status);
    }

    public List<Maintenance> getMaintenanceByPriority(String priority) {
        return maintenanceRepository.findByPriorityIgnoreCase(priority);
    }

    public List<Maintenance> getMaintenanceByType(String type) {
        return maintenanceRepository.findByMaintenanceTypeIgnoreCase(type);
    }

    public Maintenance completeMaintenance(Long id) {
        Maintenance maintenance = getMaintenanceById(id);

        maintenance.setStatus("COMPLETED");
        maintenance.setCompletionDate(LocalDate.now());

        return maintenanceRepository.save(maintenance);
    }
}
