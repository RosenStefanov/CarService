package com.project.CarService.data.repository;

import com.project.CarService.data.entity.ServiceDone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDoneRepository extends JpaRepository<ServiceDone, Long> {
}
