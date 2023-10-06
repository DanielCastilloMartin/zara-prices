package com.zara.demo.infrastructure.exception;

public class PricesNotFoundException extends RuntimeException{

    public PricesNotFoundException(){
	super();
    }

    public PricesNotFoundException(String message){
	super(message);
    }
}
