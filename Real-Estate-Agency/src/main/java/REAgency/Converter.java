package REAgency;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Converter {

    public static String SHA256(String password)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            StringBuilder hashtext = new StringBuilder(no.toString(16));

            while (hashtext.length() < 32)
            {
                hashtext.insert(0, "0");
            }

            return hashtext.toString();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static String convertSpec(String oldSpec){
        switch (oldSpec)
        {
            case "Продажа":
                return "sale";
            case "Покупка":
                return "buy";
            case "Аренда":
                return "rent";
            case "Обмен":
                return "trade";

            case "sale":
                return "Продажа";
            case "buy":
                return "Покупка";
            case "rent":
                return "Аренда";
            case "trade":
                return "Обмен";

            default:
                return "none";
        }
    }
}
