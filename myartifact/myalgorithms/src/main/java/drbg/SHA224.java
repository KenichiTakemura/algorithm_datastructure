package drbg;

public class SHA224 extends InternalDigest {
	String provider = null;
	
	public SHA224(String provider) {
		this.provider = provider;
	}
}
