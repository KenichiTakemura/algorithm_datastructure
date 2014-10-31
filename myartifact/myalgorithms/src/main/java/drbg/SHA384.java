package drbg;

public class SHA384 extends InternalDigest {
	String provider = null;
	
	public SHA384(String provider) {
		this.provider = provider;
	}
}
