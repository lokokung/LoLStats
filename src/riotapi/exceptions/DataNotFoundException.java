package riotapi.exceptions;

public class DataNotFoundException extends Exception{

    public DataNotFoundException(){
        super();
    }

    public DataNotFoundException(String message){
        super(message);
    }
}