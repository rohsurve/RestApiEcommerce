package com.fastsprings.controllers;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fastsprings.model.AccessToken;

import sun.misc.BASE64Encoder;

@RestController
public class TokenGenerator {
	
	@Value("clientSecretkey")
	private String clientkey;
	
	@Value("clientId")
	private String clientId;

	@RequestMapping(value = "/accessToken", method = RequestMethod.GET)
	public ResponseEntity<AccessToken> generateClientToken(@RequestBody AccessToken accessToken) {
		
		if(!accessToken.getClientId().equalsIgnoreCase(clientId)||!accessToken.getClientSecretKey().equalsIgnoreCase(clientkey)){
			return new ResponseEntity<AccessToken>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		try {
			Cipher c = Cipher.getInstance("AES");
			Key key = new SecretKeySpec(accessToken.getClientSecretKey().getBytes(), "AES");
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(accessToken.getClientId().getBytes());
			String accessTokenStr = new BASE64Encoder().encode(encVal);
			accessToken.setAccessToken(accessTokenStr);

		} catch (Exception e) {
			return new ResponseEntity<AccessToken>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AccessToken>(accessToken, HttpStatus.OK);
	}

}
