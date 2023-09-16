package com.mfarias25.people.service;


import com.mfarias25.people.dto.request.RequestPersonDTO;
import com.mfarias25.people.dto.response.ResponsePersonDTO;

import java.util.List;

public interface PersonService {
    ResponsePersonDTO findById(Long id);
    List<ResponsePersonDTO> findAll();
    ResponsePersonDTO register (RequestPersonDTO PersonDTO); // register pelo request DTO
    ResponsePersonDTO update(Long id, RequestPersonDTO personDTO); // update

    String delete(Long id);

}
