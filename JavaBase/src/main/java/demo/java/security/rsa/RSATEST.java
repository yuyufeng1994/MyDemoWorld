package demo.java.security.rsa;

import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 公钥负责加密，私钥负责解密；
 * 私钥负责签名，公钥负责验证。
 * Created by yuyufeng on 2017/4/12.
 */

public class RSATEST {


    static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDFEkKrOM6p4bysxVrMqA5eR0BnMg2a8t66JLOIXq3KXiKTTjC/BsbGid7jDAV7MYmmBvB2mxiq5TB9/Qwwql57Pn1kz+lpsr4tXHZh9P6iORFis5cbq9wNO1e3WtEItDet/UHS+2TZMyX9PBiryPHCbcXvZEQHv189FoGpHR09NwIDAQAB";
    static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMUSQqs4zqnhvKzFWsyoDl5HQGcyDZry3roks4hercpeIpNOML8GxsaJ3uMMBXsxiaYG8HabGKrlMH39DDCqXns+fWTP6Wmyvi1cdmH0/qI5EWKzlxur3A07V7da0Qi0N639QdL7ZNkzJf08GKvI8cJtxe9kRAe/Xz0WgakdHT03AgMBAAECgYEAlaEnvZmEULh06Tlvl7SCNFMlMzVt3xhIxEzZg9FfYyfWWMIlgOVER7qm4P1frAoQ2V6rdWKNeDRMfVyExO6WjOcIzlT1N67QTfOoNffTS/37zOBvZdxHWmi1QuaFf/acTsXaQCD63irLO6v9OjgDkTU2GPCcrBdnNl7eQzkrjAECQQDxjsi7sDy6soW2A07uF8WgcwvP7JSuYgWO2rbA87GHbpqMHBbjtdsGSi8ArsNH8fRG09b05Cr2Qik95Fzupp5nAkEA0NqUWlZqMM1G08X/mbRM8yADHKW4e9g/ElBT7PWsJOcCzZ+Hw7911Q/1ydr6LLhO7hxVJireVCB2wfQ2KkWIsQJAXeGvlHqvb6Q4oX/xqkmk7nIoMhxxwMCqBlZs1tsfsVJEUJYOM1wXjv8/+1Tw4sJfvTNSBQW0yNb37m0VzU8GmwJAMwlm/VhmpLxVFYUp+9aKg1MMT6DTnzft2bzVdW9nfLETB0p3s8cCtWksCALB5dG4QAmeaTBKmkZAnw7deaD6UQJAFPo159yJZQ8LFHs/kS24OARgMGpoqpOoHJQ5twHgsiUxN6is3RgWLy05FVv3d/IcgUgCTgrDHcF83aaqpJbt1A==";

    @Test
    public void test() {
        System.out.println("RSATEST.test");
    }

    @Test
    public void testEncrypt1() throws Exception {
        //私钥加密
        byte[] data = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), "这是RSA加密".getBytes());

        //公钥解密
        byte[] results = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(publicKey), data);
        System.out.println(new String(results));
    }

    @Test
    public void testEncrypt2() throws Exception {
        //公钥加密
        byte[] data = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(publicKey), "这是RSA加密".getBytes());
        System.out.println(data);
        String dataStr = new String(data, "ISO-8859-1");
        System.out.println(dataStr);
        byte[] dataDe = dataStr.getBytes("ISO-8859-1");
        //私钥解密
        byte[] results = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), dataDe);
        System.out.println(new String(results));
    }


    @Test
    public void testCheck() throws NoSuchAlgorithmException {
        //发送信息
        String sign = RSASignature.sign("test", privateKey);
        System.out.println("sign:" + sign);

        //接收信息
        boolean res = RSASignature.doCheck("test", sign, publicKey);
        System.out.println(res);

    }


    public String getMD5(String str) throws NoSuchAlgorithmException {
        // 生成一个MD5加密计算摘要
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 计算md5函数
        md.update(str.getBytes());
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        str = new BigInteger(1, md.digest()).toString(16);
        return str;
    }


}
