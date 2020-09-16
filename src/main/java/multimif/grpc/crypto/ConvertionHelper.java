package multimif.grpc.crypto;


public class ConvertionHelper {

    public static String bytesToHex(byte[] b) {
        char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F' };
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < b.length; j++) {
            sb.append(hexDigit[(b[j] >> 4) & 0x0f]);
            sb.append(hexDigit[b[j] & 0x0f]);
        }
        return sb.toString();
    }
}