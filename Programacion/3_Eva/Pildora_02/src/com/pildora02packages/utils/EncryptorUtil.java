package com.pildora02packages.utils;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class EncryptorUtil {
private StrongPasswordEncryptor passwordEncryptor; 


public EncryptorUtil() {
	this.passwordEncryptor = new StrongPasswordEncryptor();
}

public String Encrypt(String password){
	return passwordEncryptor.encryptPassword(password);
}

public boolean verify(String encryptPassword, String passwordToVerify) {;
	return passwordEncryptor.checkPassword(passwordToVerify, encryptPassword);

}
}