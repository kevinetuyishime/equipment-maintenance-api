
package com.example.equipmentmaintenanceapi.repository;

import com.example.equipmentmaintenanceapi.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> findByNameContainingIgnoreCase(String name);

    List<Equipment> findByCategoryIgnoreCase(String category);

    List<Equipment> findByStatusIgnoreCase(String status);

    List<Equipment> findByLocationContainingIgnoreCase(String location);
}
