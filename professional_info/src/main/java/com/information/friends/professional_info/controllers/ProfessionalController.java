package com.information.friends.professional_info.controllers;

import com.information.friends.professional_info.entity.ProfessionEntity;
import com.information.friends.professional_info.repos.ProfessionalRep;
import com.information.friends.professional_info.responses.ProfessionalResponse;
import com.information.friends.professional_info.services.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessionalController {
    @Autowired
    private ProfessionalService professionalService;
    @PostMapping("/professions")
    public ResponseEntity<ProfessionalResponse> saveProfession(@RequestBody ProfessionEntity professionEntity){
        return professionalService.saveProfession(professionEntity);
    }
    @GetMapping("/professions/{id}")
    public ResponseEntity<ProfessionalResponse> getDetailsById(@PathVariable("id") int id){
        return professionalService.getDetailsById(id);
    }
    @GetMapping("/professions")
    public ResponseEntity<List<ProfessionalResponse>> getAllProfessionalDetais(){
        return professionalService.getAllProfessionalDetais();
    }
    @PutMapping("/professions")
    public ResponseEntity<ProfessionalResponse> updateProfessionalDetails(@RequestBody ProfessionEntity professionEntity){
        return professionalService.updateProfessionalDetails(professionEntity);
    }
    @DeleteMapping("/professions/{id}")
    public void deleteProfessionsById(@PathVariable("id") int id){
        professionalService.deleteProfessionsById( id);
    }
}
