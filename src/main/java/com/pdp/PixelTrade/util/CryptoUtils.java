package com.pdp.PixelTrade.util;

import com.pdp.PixelTrade.dto.util.DecryptedDataDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.exceptions.crypto.DecryptionException;
import com.pdp.PixelTrade.exceptions.crypto.EncryptionException;
import com.pdp.PixelTrade.exceptions.validation.InvalidDataException;
import lombok.experimental.UtilityClass;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  11:13
 **/
@UtilityClass
public class CryptoUtils {

    private static final String SECRET_KEY = "1234567890123456"; // 16-byte key for AES-128
    private static final String ALGORITHM = "AES";

    private static final ThreadLocal<Cipher> cipherThreadLocal = ThreadLocal.withInitial(() -> {
        try {
            return Cipher.getInstance(ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing Cipher", e);
        }
    });

    public String encrypt(String input) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = cipherThreadLocal.get();
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return new BigInteger(1, encryptedBytes).toString(36);
        } catch (Exception e) {
            throw new EncryptionException("Error occurred while encrypting: {0}", input);
        }
    }

    public String decrypt(String encrypted) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = cipherThreadLocal.get();
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = new BigInteger(encrypted, 36).toByteArray();
            return new String(cipher.doFinal(decryptedBytes));
        } catch (Exception e) {
            throw new DecryptionException("Error occurred while decrypting: {0}", encrypted);
        }
    }

    public DecryptedDataDTO decryptData(String data) {
        String[] split = data.split("\\.");
        if (split.length != 2)
            throw new InvalidDataException("Invalid format: expected 'walletID.encryptedCryptoType'");
        String walletID = split[0];
        CryptoType cryptoType = CryptoType.valueOf(decrypt(split[1]));
        return new DecryptedDataDTO(walletID, cryptoType);
    }
}