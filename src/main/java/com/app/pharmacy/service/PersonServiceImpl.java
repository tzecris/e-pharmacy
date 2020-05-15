package com.app.pharmacy.service;

import com.app.pharmacy.dto.PersonDTO;
import com.app.pharmacy.mapper.PersonMapper;
import com.app.pharmacy.model.Person;
import com.app.pharmacy.repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonServiceImpl implements PersonService{
    
    @Autowired
    PersonRepository personRepo;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<PersonDTO> findAll() {
        return personMapper.entityToDTOList(personRepo.findAll());
    }

    @Override
    @Transactional
    public void save(PersonDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        personRepo.save(personMapper.dtoToEntity(dto));
    }

    @Override
    public PersonDTO findById(Integer id) {
        Optional<Person> result = personRepo.findById(id);
        return result.isPresent() ? personMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        personRepo.deleteById(id);
    }

    @Override
    public boolean uniqueEmail(String email) {
        personRepo.findByEmail(email).isPresent();
        return !personRepo.findByEmail(email).isPresent();
    }
    
}
