package com.information.friends.basic_information.dao;

import com.information.friends.basic_information.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDao extends JpaRepository<PersonEntity,Integer> {

}
