package com.revature;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class PStore {
	//one step away from web security
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String password = "password";
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		md.update(salt);
		
		//adds more computation time, 100000 is adding more salt to it, equals 1 second
		KeySpec ks = new PBEKeySpec(password.toCharArray(), salt, 100000, 128);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		
		//byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
		byte[] hash = skf.generateSecret(ks).getEncoded();
		for (byte i : hash) {
			System.out.println(i);
		}
	}
}
