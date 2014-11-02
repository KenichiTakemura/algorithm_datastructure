package drbg;

public enum DigestAlg {

	SHA1("SHA-1", 440), SHA224("SHA-224", 440), SHA256("SHA-256", 440), SHA384(
			"SHA-384", 888), SHA512("SHA-512", 888);

	private String name;
	private int seedlen;

	DigestAlg(String name, int seedlen) {
		this.name = name;
		this.seedlen = seedlen;
	}

	public String getName() {
		return name;
	}

	public int getSeedlen() {
		return seedlen;
	}
	
	public static DigestAlg getAlgbyName(String name) {
		return DigestAlg.valueOf(name);
	}
}
