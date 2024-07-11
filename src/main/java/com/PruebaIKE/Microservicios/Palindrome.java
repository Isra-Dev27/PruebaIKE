package com.PruebaIKE.Microservicios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.json.JSONObject;

@RestController
@RequestMapping("/api")
public class Palindrome {

    @PostMapping("/palindromeChecker")
    public ResponseEntity<String> palindromeChecker(@RequestBody String jsonBody) {
        if (jsonBody == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Please pass a JSON body with the parameter 'palindromo'");
        }

        JSONObject jsonRequest = new JSONObject(jsonBody);
        if (!jsonRequest.has("palindromo")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("JSON body must contain the parameter 'palindromo'");
        }

        String palindromo = jsonRequest.getString("palindromo");

        int lengthCadena = palindromo.length();

        boolean isPalindrome = isPalindrome(palindromo);

        int lengthCaracteresEspeciales = getSpecialCharacterCount(palindromo);

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("lengthCadena", lengthCadena);
        jsonResponse.put("isPalindromo", isPalindrome ? 1 : 0);
        jsonResponse.put("lengthCaracteresEspeciales", lengthCaracteresEspeciales);

        return ResponseEntity.ok(jsonResponse.toString());
    }

    private boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        return cleanedStr.equals(reversedStr);
    }

    private int getSpecialCharacterCount(String str) {
        return (int) str.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isWhitespace(c)).count();
    }
}
