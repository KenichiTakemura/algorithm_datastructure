package drbg;

import java.nio.ByteBuffer;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

public class DRBGUtils {

	public static byte[] toByteArray(String s) {
		return DatatypeConverter.parseHexBinary(s);
	}
	
	public static void  prettyPrintByteHex(byte[] val) {
		System.out.println("hex=" + DatatypeConverter.printHexBinary(val));
	}

	public static int toByte(int bits) {
		return (bits + 7) / 8;
	}

	public static byte[] hash_df(final Hash hash, final byte[] inputString,
			int numberOfBits) throws Exception {
		System.out.println("hash_df with " + hash);
		byte[] temp = null;
		int outlen = hash.getDigestLength();
		byte[] h = new byte[outlen];
		int len = numberOfBits / (outlen * 8);
		int counter = 1;
		byte[] numberOfBitsByte = intToByteArray(numberOfBits);
		for (int i = 0; i <= len; i++) {
			hash.update(new byte[]{(byte)counter});
			hash.update(numberOfBitsByte);
			hash.update(inputString);
			hash.digest(h);
			prettyPrintByteHex(h);
			temp = concatBytes(temp, h);
			prettyPrintByteHex(temp);
			counter++;
		}
		byte[] requestedBits = leftMost(temp, numberOfBits);
		prettyPrintByteHex(requestedBits);
		return requestedBits;
	}
	
	public static byte[] leftMost(byte[] original, int bits) {
		int requestByte = toByte(bits);
		int to = requestByte;
		return Arrays.copyOfRange(original, 0, to);
	}
	
	public static byte[] intToByteArray(int value) {
		return ByteBuffer.allocate(4).putInt(value).array();
	}
	
	/**
	 * @param a
	 * @param b
	 * @return a || b
	 */
	public static byte[] concatBytes(byte[] a, byte[] b) {
		if (a == null) {
			return Arrays.copyOfRange(b, 0, b.length);
		}
		if (b == null) {
			return Arrays.copyOfRange(a, 0, a.length);
		}
		byte[] returned = new byte[a.length + b.length];
		System.arraycopy(a, 0, returned, 0, a.length);
		System.arraycopy(b, 0, returned, a.length, b.length);		
		return returned;
	}

}
