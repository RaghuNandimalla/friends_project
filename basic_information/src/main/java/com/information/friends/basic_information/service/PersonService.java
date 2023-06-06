package com.information.friends.basic_information.service;

import com.information.friends.basic_information.dao.PersonDao;
import com.information.friends.basic_information.entity.PersonEntity;
import com.information.friends.basic_information.feign_clients.ProfessionalClient;
import com.information.friends.basic_information.response.PersonResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ProfessionalClient professionalClient;
    public ResponseEntity<PersonResponse> addPerson(PersonEntity personEntity){
       PersonEntity person = personDao.save(personEntity);
        PersonResponse personResponse = modelMapper.map(person,PersonResponse.class);
        return new ResponseEntity<>(personResponse,HttpStatus.CREATED);
    }
    public ResponseEntity<List<PersonResponse>> getAllThePersons() {
        List<PersonEntity> personEntityList = personDao.findAll();
        List<PersonResponse> personResponseList=new ArrayList<PersonResponse>();

        for(PersonEntity personEntity: personEntityList){
            personResponseList.add(modelMapper.map(personEntity, PersonResponse.class));
        }
        return new ResponseEntity<>(personResponseList,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<PersonResponse> update(PersonEntity personEntity) {
        PersonEntity person = personDao.save(personEntity);
        PersonResponse personResponse = modelMapper.map(person,PersonResponse.class);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }

    public void deleteById(int id) {
        personDao.deleteById(id);
    }

    public ResponseEntity<PersonResponse> getPersonById(int id) {
        PersonEntity personEntity = personDao.findById(id).get();
        PersonResponse personResponse = modelMapper.map(personEntity, PersonResponse.class);
        personResponse.setProfessionalResponse(professionalClient.getProfessionalResponse(id).getBody());
        return ResponseEntity.status(HttpStatus.OK).body(personResponse);
    }
}
