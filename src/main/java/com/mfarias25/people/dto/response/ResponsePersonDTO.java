package com.mfarias25.people.dto.response;

import com.mfarias25.people.entity.Person;
import lombok.Getter;

@Getter
public class ResponsePersonDTO {
    private Long id;

    private String name;

    private String cpf;

    private Integer age;

    public ResponsePersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();
    }
}
