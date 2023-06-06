package com.information.friends.professional_info.services;

import com.information.friends.professional_info.entity.ProfessionEntity;
import com.information.friends.professional_info.repos.ProfessionalRep;
import com.information.friends.professional_info.responses.ProfessionalResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService{
    @Autowired
    private ProfessionalRep professionalRep;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ResponseEntity<ProfessionalResponse> saveProfession(ProfessionEntity professionEntity) {
        ProfessionEntity professionEntity1 = professionalRep.save(professionEntity);
        ProfessionalResponse professionalResponse = modelMapper.map(professionEntity1, ProfessionalResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(professionalResponse);
    }
    @Override
    public ResponseEntity<ProfessionalResponse> getDetailsById(int id) {
        ProfessionEntity professionEntity = professionalRep.findById(id).get();
        ProfessionalResponse professionalResponse = modelMapper.map(professionEntity, ProfessionalResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(professionalResponse);
    }
    @Override
    public ResponseEntity<List<ProfessionalResponse>> getAllProfessionalDetais() {
        List<ProfessionEntity> professionEntityList = professionalRep.findAll();
        List<ProfessionalResponse> professionalResponseList = new ArrayList<ProfessionalResponse>();
        for(ProfessionEntity professionEntity: professionEntityList){
            professionalResponseList.add(modelMapper.map(professionEntity, ProfessionalResponse.class));
        }
        return ResponseEntity.status(HttpStatus.OK).body(professionalResponseList);
    }
    @Override
    public ResponseEntity<ProfessionalResponse> updateProfessionalDetails(ProfessionEntity professionEntity) {
        ProfessionEntity professionEntity1 = professionalRep.save(professionEntity);
        ProfessionalResponse professionalResponse = modelMapper.map(professionEntity1, ProfessionalResponse.class);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(professionalResponse);
    }
    @Override
    public void deleteProfessionsById(int id) {
        professionalRep.deleteById(id);
    }
}
