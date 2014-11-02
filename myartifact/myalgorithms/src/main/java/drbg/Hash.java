package drbg;

import java.security.MessageDigest;

public class Hash {

	private MessageDigest md;
	
	public Hash(DigestAlg alg) throws Exception {
		this.md = MessageDigest.getInstance(alg.getName());
	}
	
	public void update(byte[] input) {
		md.update(input, 0, input.length);
	}

	public void update(byte[] input, int offset, int len) {
		md.update(input, offset, len);
	}
	
	public int digest(byte[] buf, int offset) throws Exception {
			return md.digest(buf, offset, buf.length);
	}

	public int digest(byte[] buf) throws Exception {
		return md.digest(buf, 0, buf.length);
	}
	
	public int getDigestLength() {
		return md.getDigestLength();
	}
	
	@Override
	public String toString() {
		return md.getAlgorithm() + "/" + md.getDigestLength();
	}
	
}
