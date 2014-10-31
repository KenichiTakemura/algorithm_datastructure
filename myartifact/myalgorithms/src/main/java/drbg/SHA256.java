package drbg;

public class SHA256 extends InternalDigest {
	String provider = null;
	
	public SHA256(String provider) {
		this.provider = provider;
	}
}
