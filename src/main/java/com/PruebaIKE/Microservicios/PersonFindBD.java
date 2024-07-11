package com.PruebaIKE.Microservicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.json.JSONObject;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonFindBD {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/PersonFindBD")
    public ResponseEntity<String> nameLookup(@RequestParam(value = "name", required = false) String name) {
        String myName = "TuNombre"; // Declare and initialize the variable with your name.

        if (name == null) {
            name = myName;
        }

        try {
            List<Person> people = personRepository.findByName(name);

            if (!people.isEmpty()) {
                Person person = people.get(0);
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("fecha", person.getFecha());
                jsonResponse.put("nombre", person.getName());
                return ResponseEntity.status(HttpStatus.FOUND).body(jsonResponse.toString()); // 302 Found
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nombre no encontrado."); // 404 Not Found
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error: " + e.getMessage());
        }
    }
}
