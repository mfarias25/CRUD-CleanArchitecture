package com.mfarias25.people.controller;

import com.mfarias25.people.dto.request.RequestPersonDTO;
import com.mfarias25.people.dto.response.ResponsePersonDTO;
import com.mfarias25.people.entity.Person;
import com.mfarias25.people.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponsePersonDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponsePersonDTO>> findAll() {
        return ResponseEntity.ok().body(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<ResponsePersonDTO> register (@RequestBody RequestPersonDTO personDTO,
                                                        UriComponentsBuilder uriBuilder) {
        ResponsePersonDTO responsePersonDTO = personService.register(personDTO);
        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(responsePersonDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responsePersonDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponsePersonDTO> update(@RequestBody RequestPersonDTO personRequestDTO,
                                                     @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(personService.update(id, personRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable (value = "id") Long id) {
        return ResponseEntity.ok().body(personService.delete(id));
    }


}
