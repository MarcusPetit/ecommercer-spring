package br.com.marcus.ecommerce.dto;

public class ValidationMenssagem {

    private String fieldName;
    private String message;

    public ValidationMenssagem(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
