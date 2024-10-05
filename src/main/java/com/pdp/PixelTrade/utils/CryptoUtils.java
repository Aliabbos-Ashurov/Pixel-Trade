package com.pdp.PixelTrade.utils;

import com.pdp.PixelTrade.dto.util.DecryptedDataDTO;
import com.pdp.PixelTrade.enums.CryptoType;
import com.pdp.PixelTrade.exceptions.crypto.DecryptionException;
import com.pdp.PixelTrade.exceptions.crypto.EncryptionException;
import com.pdp.PixelTrade.exceptions.validation.InvalidDataException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @author Aliabbos Ashurov
 * @since 01/October/2024  11:13
 **/
@Getter
@Component
public class CryptoUtils {

    @Value("${crypto.encode-decode.secret-key}")
    private String SECRET_KEY;

    @Value("${crypto.encode-decode.algorithm}")
    private String ALGORITHM;

    public String encrypt(String input) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new EncryptionException("Error occurred while encrypting: {0} ", input);
        }
    }

    public String decrypt(String encrypted) {
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = Base64.getDecoder().decode(encrypted);
            return new String(cipher.doFinal(decryptedBytes));
        } catch (Exception e) {
            throw new DecryptionException("Error occurred while decrypting: {0}", encrypted);
        }
    }

    public DecryptedDataDTO decryptData(String data) {
        String[] split = data.split("\\.");
        if (split.length != 2) {
            throw new InvalidDataException("Invalid format: expected 'walletID.encryptedCryptoType'");
        }
        CryptoType cryptoType = CryptoType.valueOf(decrypt(split[1]));
        return new DecryptedDataDTO(split[0], cryptoType);
    }
}