
package com.example.equipmentmaintenanceapi.controller;

import com.example.equipmentmaintenanceapi.model.Equipment;
import com.example.equipmentmaintenanceapi.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping
    public Equipment createEquipment(@Valid @RequestBody Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @GetMapping("/{id}")
    public Equipment getEquipmentById(@PathVariable Long id) {
        return equipmentService.getEquipmentById(id);
    }

    @PutMapping("/{id}")
    public Equipment updateEquipment(
            @PathVariable Long id,
            @Valid @RequestBody Equipment equipment) {
        return equipmentService.updateEquipment(id, equipment);
    }

    @DeleteMapping("/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return "Equipment deleted successfully";
    }

    @GetMapping("/search")
    public List<Equipment> searchEquipment(@RequestParam String keyword) {
        return equipmentService.searchEquipment(keyword);
    }

    @GetMapping("/category/{category}")
    public List<Equipment> getByCategory(@PathVariable String category) {
        return equipmentService.getEquipmentByCategory(category);
    }

    @GetMapping("/status/{status}")
    public List<Equipment> getByStatus(@PathVariable String status) {
        return equipmentService.getEquipmentByStatus(status);
    }

    @GetMapping("/location/{location}")
    public List<Equipment> getByLocation(@PathVariable String location) {
        return equipmentService.getEquipmentByLocation(location);
    }
}
