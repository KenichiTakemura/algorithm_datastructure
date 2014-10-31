package drbg;

public class SHA1 extends InternalDigest {

	String provider = null;
	
	public SHA1(String provider) {
		this.provider = provider;
	}
}
