
package com.example.equipmentmaintenanceapi.controller;

import com.example.equipmentmaintenanceapi.model.Maintenance;
import com.example.equipmentmaintenanceapi.service.MaintenanceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public Maintenance createMaintenance(@Valid @RequestBody Maintenance maintenance) {
        return maintenanceService.createMaintenance(maintenance);
    }

    @GetMapping
    public List<Maintenance> getAllMaintenance() {
        return maintenanceService.getAllMaintenance();
    }

    @GetMapping("/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.getMaintenanceById(id);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(
            @PathVariable Long id,
            @Valid @RequestBody Maintenance maintenance) {
        return maintenanceService.updateMaintenance(id, maintenance);
    }

    @DeleteMapping("/{id}")
    public String deleteMaintenance(@PathVariable Long id) {
        maintenanceService.deleteMaintenance(id);
        return "Maintenance record deleted successfully";
    }

    @GetMapping("/equipment/{equipmentId}")
    public List<Maintenance> getByEquipment(@PathVariable Long equipmentId) {
        return maintenanceService.getMaintenanceByEquipment(equipmentId);
    }

    @GetMapping("/status/{status}")
    public List<Maintenance> getByStatus(@PathVariable String status) {
        return maintenanceService.getMaintenanceByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public List<Maintenance> getByPriority(@PathVariable String priority) {
        return maintenanceService.getMaintenanceByPriority(priority);
    }

    @GetMapping("/type/{type}")
    public List<Maintenance> getByType(@PathVariable String type) {
        return maintenanceService.getMaintenanceByType(type);
    }

    @PatchMapping("/{id}/complete")
    public Maintenance completeMaintenance(@PathVariable Long id) {
        return maintenanceService.completeMaintenance(id);
    }
}
