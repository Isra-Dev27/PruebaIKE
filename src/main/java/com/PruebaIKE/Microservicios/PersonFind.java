package com.PruebaIKE.Microservicios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.json.JSONArray;
import org.json.JSONObject;

@RestController
@RequestMapping("/api")
public class PersonFind {

    @GetMapping("/PersonFind")
    public ResponseEntity<String> nameLookup(@RequestParam(value = "name", required = false) String name) {
        String myName = "TuNombre"; // Declare and initialize the variable with your name.

        if (name == null) {
            name = myName;
        }

        // Embedded JSON with the list of names and dates
        String jsonString = "{"
                + "\"people\": ["
                + "{ \"name\": \"Alice\", \"fecha\": \"Sun Feb 28 18:17:27 CST 2021\" },"
                + "{ \"name\": \"Bob\", \"fecha\": \"Sun Feb 28 18:17:27 CST 2021\" },"
                + "{ \"name\": \"Carlos\", \"fecha\": \"Sun Feb 28 18:17:27 CST 2021\" },"
                + "{ \"name\": \"David\", \"fecha\": \"Sun Feb 28 18:17:27 CST 2021\" },"
                + "{ \"name\": \"Eve\", \"fecha\": \"Sun Feb 28 18:17:27 CST 2021\" }"
                + "]"
                + "}";

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray peopleArray = jsonObject.getJSONArray("people");

            boolean nameFound = false;
            JSONObject foundPerson = null;

            for (int i = 0; i < peopleArray.length(); i++) {
                JSONObject person = peopleArray.getJSONObject(i);
                if (person.getString("name").equalsIgnoreCase(name)) {
                    nameFound = true;
                    foundPerson = person;
                    break;
                }
            }

            if (nameFound) {
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("fecha", foundPerson.getString("fecha"));
                jsonResponse.put("nombre", foundPerson.getString("name"));
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
