package riotapi.exceptions;

public class InternalServerException extends Exception{

    public InternalServerException(){
        super();
    }

    public InternalServerException(String message){
        super(message);
    }
}