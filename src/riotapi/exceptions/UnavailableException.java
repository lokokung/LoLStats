package riotapi.exceptions;

public class UnavailableException extends Exception{

    public UnavailableException(){
        super();
    }

    public UnavailableException(String message){
        super(message);
    }
}