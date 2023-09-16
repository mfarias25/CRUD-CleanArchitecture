package com.mfarias25.people.service;

import com.mfarias25.people.dto.request.RequestPersonDTO;
import com.mfarias25.people.dto.response.ResponsePersonDTO;
import com.mfarias25.people.entity.Person;
import com.mfarias25.people.repository.PersonRepository;
import com.mfarias25.people.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImplement implements PersonService {

    private final PersonRepository personRepository; // manipulação injetando a dependencia

    private final PersonMapper personMapper; //

    @Override
    public ResponsePersonDTO findById(Long id) {
        Person person = returnPerson(id);
        return personMapper.toPersonDTO(person);
    }

    @Override
    public List<ResponsePersonDTO> findAll() {
        List<Person> peopleList = (personRepository.findAll());
        return personMapper.toPeopleDTO(peopleList);
    }

    @Override
    public ResponsePersonDTO register(RequestPersonDTO personDTO) {
        Person person = personMapper.toPerson(personDTO);
        person = personRepository.save(person);
        return personMapper.toPersonDTO( person);
    }


    @Override
    public ResponsePersonDTO update(Long id, RequestPersonDTO personDTO) {
        Person person = returnPerson(id);
        personMapper.updatePerson(person, personDTO);
        person = personRepository.save(person);
        return personMapper.toPersonDTO(person);

    }

    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Person id: " + id + " deleted";
    }


    private Person returnPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person wasn't fount on database"));
    }
}
