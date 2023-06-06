package com.information.friends.professional_info.repos;

import com.information.friends.professional_info.entity.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRep extends JpaRepository<ProfessionEntity, Integer> {
}
