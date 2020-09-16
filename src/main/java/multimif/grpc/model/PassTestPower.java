package multimif.grpc.model;

public class PassTestPower {

    private PassTestPower() {
        // on empêche l'instanciation
    }

    public static int testPassword(String mdp) {
        int point = 0;
        int pointMin = 0;
        int pointMaj = 0;
        int pointDigit = 0;
        int pointChar = 0;

        int length = mdp.length();
        for (int i = 0; i < length; i++) {
            Character letter = mdp.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                point = point + 1;// On ajoute 1 point pour une minuscule
                pointMin = 1; // On rajoute le bonus pour une minuscule
            } else if (letter >= 'A' && letter <= 'Z') {
                point = point + 2;// On ajoute 2 points pour une majuscule
                pointMaj = 2;// On rajoute le bonus pour une majuscule
            } else if (letter >= '0' && letter <= '9') {
                point = point + 3;// On ajoute 3 points pour un chiffre
                pointDigit = 3;// On rajoute le bonus pour un chiffre
            } else {
                point = point + 5;  // On ajoute 5 points pour un caractère autre
                pointChar = 5;// On rajoute le bonus pour un caractère autre
            }
        }
        int step1 = point / length;
        int step2 = pointMin + pointMaj + pointDigit + pointChar;
        int result = step1 * step2;
        return result * length;
    }

}






