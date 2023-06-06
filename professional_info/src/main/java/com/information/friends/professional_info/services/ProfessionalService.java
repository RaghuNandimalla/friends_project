package com.information.friends.professional_info.services;

import com.information.friends.professional_info.entity.ProfessionEntity;
import com.information.friends.professional_info.responses.ProfessionalResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfessionalService {
    public ResponseEntity<ProfessionalResponse> saveProfession(ProfessionEntity professionEntity);

   public ResponseEntity<ProfessionalResponse> getDetailsById(int id);

    ResponseEntity<List<ProfessionalResponse>> getAllProfessionalDetais();

    ResponseEntity<ProfessionalResponse> updateProfessionalDetails(ProfessionEntity professionEntity);

    void deleteProfessionsById(int id);
}
