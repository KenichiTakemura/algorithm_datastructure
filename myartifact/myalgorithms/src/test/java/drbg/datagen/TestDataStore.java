package drbg.datagen;

import java.util.Arrays;

public final class TestDataStore {
	/**
	 * 
	 */
	private int lineNumber;
	private String digest;
	private String bits;
	private String[] in;
	private String[] out;
	private int inlen;
	private int outlen;
	
	public TestDataStore() {
		in = new String[1];
		out = new String[1];
		outlen = 1;
		inlen = 1;
	}
	
	public TestDataStore(int outlen) {
		in = new String[1];
		out = new String[outlen];
		this.inlen = 1;
		this.outlen = outlen;
	}

	public TestDataStore(int inlen, int outlen) {
		in = new String[inlen];
		out = new String[outlen];
		this.inlen = inlen;
		this.outlen = outlen;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getBits() {
		return bits;
	}

	public void setBits(String bits) {
		this.bits = bits;
	}

	public String getIn() {
		return in[0];
	}

	public String getIn(int index) {
		return in[index];
	}

	public void setIn(String in) {
		this.in[0] = in;
	}

	public void setIn(String in, int index) {
		this.in[index] = in;
	}

	public String getOut() {
		return out[0];
	}
	
	public String getOut(int index) {
		return out[index];
	}

	public void setOut(String out) {
		this.out[0] = out;
	}

	public void setOut(String out, int index) {
		this.out[index] = out;
	}
	
	@Override
	public String toString() {
		return String.format("#%s [%s] [%s] [%s] [%s]", lineNumber, digest,
				bits, Arrays.deepToString(in), Arrays.deepToString(out));
	}

	public boolean isAllSet() {
		boolean ret = !digest.isEmpty() && !bits.isEmpty() && in != null
				&& out != null;
		for(int i=0;i<inlen;i++) {
			ret &= in[i] != null && !in[i].isEmpty();
		}
		for(int i=0;i<outlen;i++) {
			ret &= out[i] != null && !out[i].isEmpty();
		}
		return ret;
	}
}