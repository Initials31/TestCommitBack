package com.apside.prono.errors;

public class PronosException extends Exception{

	public PronosException() {

	}

	public PronosException(String m, Throwable c) {
		super(m, c);
	}

	public PronosException(String m) {
		super(m);
	}

	public PronosException(Throwable c) {
		super(c);
	}



}
