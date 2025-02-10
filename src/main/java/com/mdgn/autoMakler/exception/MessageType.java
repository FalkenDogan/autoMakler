package com.mdgn.autoMakler.exception;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1004", "Kein Eintrag gefunden!"),
	TOKEN_IS_EXPIRED("1005", "Token ist abgelaufen!"),
	USERNAME_NOT_FOUND("1006", "Username nicht gefunden!"),
	USERNAME_OR_PASSWORD_INVALID("1007", "Username oder Passwort falsch!"),
	REFRESH_TOKEN_NOT_FOUND("1008", "Refreshtoken is nict gefunden"),
	REFRESSH_TOKEN_IS_EXPIRED("1009", "Refreshtoken is expired"),
	CURRENCY_RATES_IS_OCCURED("1010", "Currency ist nicht bekommen"),
	CUSTOMER_AMOUNT_IS_NOT_ENOUGH("1011", "Kunde hat nicht genug Geld"),
	CAR_STATUS_IS_SOLD("1012", "Das Auto ist bereits verkauft!"),
	GENERAL_EXCEPTION("9999", "Ein allgemeiner Fehler ist aufgetreten!");
	
	private String code;
	private String message;
	
	MessageType(String code , String message) {
		this.code =code;
		this.message=message;
	}
	
	
}
