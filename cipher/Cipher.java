package hofbauer.cipher;

/**
 * Interface for all Ciphers in hofbauer.cipher
 * 
 * @author Manfred Hofbauer
 *
 */
public interface Cipher {	
	
	/**
	 * Given message will be encrypted with this method.
	 * 
	 * The methods encrypt and decrypt are reverse operations,
	 * both can return the same result, if used both with the same String
	 * 
	 * @param 	text message to encrypt
	 * @return 	encrypted message
	 */
	public String encrypt(String text);
	
	/**
	 * Given message will be decrypted with this method
	 * 
	 * The methods encrypt and decrypt are reverse operations,
	 * both can return the same result, if used both with the same String
	 * 
	 * @param 	text message to decrypt
	 * @return 	decrypted message
	 */
	public String decrypt(String text);
}
