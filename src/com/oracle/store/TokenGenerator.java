package com.oracle.store;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TokenGenerator {
		
	private SecureRandom _random = new SecureRandom();
	
	public SecureRandom get_random() {
		return _random;
	}

	public void set_random(SecureRandom _random) {
		this._random = _random;
	}

	public String giveToken()
	{
		return generateToken();
	}
	
	private String generateToken()
	{
			
		return new BigInteger(130, get_random()).toString(32);
		
		
	}
	
}
