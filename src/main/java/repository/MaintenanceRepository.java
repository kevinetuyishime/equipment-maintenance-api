
package com.example.equipmentmaintenanceapi.repository;

import com.example.equipmentmaintenanceapi.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

    List<Maintenance> findByEquipmentId(Long equipmentId);

    List<Maintenance> findByStatusIgnoreCase(String status);

    List<Maintenance> findByPriorityIgnoreCase(String priority);

    List<Maintenance> findByMaintenanceTypeIgnoreCase(String maintenanceType);
}
