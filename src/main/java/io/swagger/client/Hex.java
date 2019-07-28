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
    static String key="Ph1D3HeaNIgDcBi3SacqD0Ojt35elX-kDxjrwwFW51r1VyDY";
    static String data="";
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

                    String method="GET";
                    String str="/api/v1/position";
                    String time="1564489167";
                    String body="";
                    data=method+str+time+body;
        System.out.println(data);
        System.out.println(hmacSha256(data,key));

        }

    private static String hmacSha256(String value, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(value.getBytes());


        return String.format("%0" + (rawHmac.length << 1) + "x", new BigInteger(1, rawHmac));


}
}
