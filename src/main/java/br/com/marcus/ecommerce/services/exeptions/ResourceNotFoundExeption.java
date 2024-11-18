package br.com.marcus.ecommerce.services.exeptions;

public class ResourceNotFoundExeption extends RuntimeException {

    public ResourceNotFoundExeption(String msg) {
        super(msg);
    }
}
