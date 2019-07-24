package com.apside.prono.errors;

public class PlayerInconnuException  extends  PronosException{

	public PlayerInconnuException(long idPlayer) {
		super("Le player avec l'ID "+ idPlayer + " n'existe pas !");
	}
}
