package br.com.pesquisasPerifericos.pesquisasPerifericos.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
}
