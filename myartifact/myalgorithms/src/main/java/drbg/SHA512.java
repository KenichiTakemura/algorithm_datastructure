package drbg;

public class SHA512 extends InternalDigest {
	String provider = null;
	
	public SHA512(String provider) {
		this.provider = provider;
	}
}
