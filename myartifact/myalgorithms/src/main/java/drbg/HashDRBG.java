package drbg;

public class HashDRBG {

	byte[] entropy;
	byte[] nonce;
	Hash digest;
	InternalState workingState;
	int securityStrength;
	int seedlen;
	boolean predictionResistanceFlag;

	public HashDRBG(DigestAlg alg, byte[] personalizationString,
			int securityStrength) {
		try {
			this.digest = new Hash(alg);
			this.seedlen = alg.getSeedlen();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// FIXME
	// This is public methods to provide entropy and nonce from World
	public void setEntropy(byte[] entropy) {
		this.entropy = entropy;
	}

	public void setNonce(byte[] nonce) {
		this.nonce = nonce;
	}

	public void setEntropy(String entropy) {
		this.setEntropy(DRBGUtils.toByteArray(entropy));
	}

	public void setNonce(String nonce) {
		this.setNonce(DRBGUtils.toByteArray(nonce));
	}
}
