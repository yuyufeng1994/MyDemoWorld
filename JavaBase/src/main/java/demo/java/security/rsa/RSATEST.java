package demo.java.security.rsa;

import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yuyufeng on 2017/4/12.
 */

public class RSATEST {


    static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOFIYo0RnRJ15UIn/tnDy6ntlDFFNQYYm5yY/96Qp3+64v32dXmjUS+2c6Ar12haxH4tKBrp+k8p8Wl9awVfIDh0oNuVcvFMZYeWVHsIVyzb4lLp62CzaFEu1bpY53Bh0ZQYlrC6egr5y20McV5ZznNpb96OYYnpVgKNimKFQYhwIDAQAB";
    static String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKqSMMe0Y5PvhE+ZbAD9jhu2qmE/IkQ/DHL/fX5H1fXbbj20ed68yPenERhBICA3FoZTb9riQz5zvumUHlRNoe/qg3dktxaHbDCWAUlqffmAFVEVcoyQHsYzCt5A/Ajlw3X2v/y0qJB86LEREKEg/8TFE9TodRdZ800klylix8BfAgMBAAECgYAp6H0/s9x7bm/Ntt5IaAPQX1MBTae3qN4AKzHEIxY4r88oLf17clrWLiAPG4EvKRnJqxpiZxEqePnBHflNsT1F8+3H6ak2UdwQ4Brjktv3J0q2V3YbEKyty31Jf2rpNHrieADtXZAE9ifN5lQdomPhKDT1PfemMNBR0HZZPfel8QJBAOWyqI+r4H5IQ+1xNm8+aGBbFnwj3nnPG7J5dw77nviGYXwvdDFOCUoKoaOK3kFVygmIUpXeOzfwCxARl7exf9UCQQC+GktDjaTVDNwW3xBQgRGxM8OULk1Qyl1DkEZGH3AjCcaf98HeHOWJ2kaHyW0sBFrCUOI1Yp1LRwo7T9YXT41jAkA/L4JG41UB6AcnjfkXaOd1ehkZVRSiFWLdGaSyrmzwmKbAbp1b4seTYpFMV6sD9gF51dJB/7vyi0m/xdciZOVxAkBu0ulZonObeHm+I6BhLj1gLqsv8aZFGRQx1SQCsUUwR/yxOUCd+f6e1M8VTgoFBSzb50dYk/ra7bk7Rpmq0Ue9AkA2dkc8bGvTYXvn1VbTYQZnN5GxoLh25f0b+BOC4t+UqgU9L0ScLmKotwBlKJx5uJifWJNhO7TSVYNN9zIIsQdT";

    @Test
    public void test() {
        System.out.println("RSATEST.test");
    }


    @Test
    public void testCheck() throws NoSuchAlgorithmException {
        String str = "test";
        // 生成一个MD5加密计算摘要
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 计算md5函数
        md.update(str.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        str = new BigInteger(1, md.digest()).toString(16);

        String sign = RSASignature.sign(str, privateKey);
        System.out.println("sign:" + sign);

        boolean res = RSASignature.doCheck(str, sign, publicKey);
        System.out.println(res);
    }


}
