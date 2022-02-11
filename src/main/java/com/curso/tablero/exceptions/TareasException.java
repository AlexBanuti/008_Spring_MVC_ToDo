package com.curso.tablero.exceptions;

public class TareasException extends Exception {

	private String keyMensaje;
	private String[] args;

	 
	public TareasException(String msg) {
	super(msg);
	}

	public TareasException(String keyMensaje, String... args) {
	super();
	this.keyMensaje = keyMensaje;
	this.args = args;
	}


	public String getKeyMensaje() {
	return keyMensaje;
	}

	public String[] getArgs() {
	 return args;
	}
}