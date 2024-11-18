package br.com.marcus.ecommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {
    private final List<ValidationMenssagem> errors;

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
        this.errors = new ArrayList<>();
    }

    public List<ValidationMenssagem> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new ValidationMenssagem(fieldName, message));
    }
}