package io.swagger.client;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

public class Hex {

    public Hex(){
    }
    public static String hmacSha256(String value, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(value.getBytes());
        System.out.println(String.format("%0" + (rawHmac.length << 1) + "x", new BigInteger(1, rawHmac)));
        return String.format("%0" + (rawHmac.length << 1) + "x", new BigInteger(1, rawHmac));


            }
        }



