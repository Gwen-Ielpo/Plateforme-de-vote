package multimif.grpc.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {

    private static Logger logger = Logger.getLogger(Crypto.class.getName());

    private Crypto() {
        // on empêche l'instanciation
    }

   /*
    public static void main(String[] args) {
        try {
            String message = "Mon Message";
            String resultat = computeMAC(message, "maCle", "HmacSHA256");
            System.out.println("Message: " + message);
            System.out.println("HmacSHA256 digest : " + resultat);


            resultat = computeMAC("Mon message", "maCle", "HmacMD5");
            System.out.println("HmacMD5 digest : " + resultat);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }*/

   public static String hash(String message){

       return computeMAC( message, "multimif","HmacSHA256");
   }


    public static String computeMAC(String message, String key, String algorithm) {
        String result = null;

        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes("UTF-8"), algorithm);

            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);

            byte[] b = message.getBytes("UTF-8");
            byte[] digest = mac.doFinal(b);

            result = ConvertionHelper.bytesToHex(digest);


        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException e) {
            logger.log(Level.WARNING, "Impossible de calculer le MAC du message", e);
        }

        return result;
    }

}

