package com.mfarias25.people.util;

import com.mfarias25.people.dto.request.RequestPersonDTO;
import com.mfarias25.people.dto.response.ResponsePersonDTO;
import com.mfarias25.people.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class PersonMapper {
    public Person toPerson(RequestPersonDTO personDTO) {
        return Person.builder()
                .name(personDTO.getName())
                .cpf(personDTO.getCpf())
                .age(personDTO.getAge())
                .build();
    }
    public ResponsePersonDTO toPersonDTO(Person person) {
        return new ResponsePersonDTO(person);
    }

    public List<ResponsePersonDTO> toPeopleDTO(List<Person> peopleList) {
        return peopleList.stream().map(ResponsePersonDTO::new).collect(Collectors.toList());
    }

    public void updatePerson(Person person, RequestPersonDTO personDTO) {
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setAge(personDTO.getAge());

    }
}
