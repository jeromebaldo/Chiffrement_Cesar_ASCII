import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("CHIFFREMENT DE CESAR");
        System.out.println("Donnez votre clé de chiffrement qui correspond à un mot de securite");

        Scanner scanner = new Scanner(System.in);
        String cles = scanner.nextLine();

        Chiff_Dechiffr_Cesar chiff_dechiffr_cesar = new Chiff_Dechiffr_Cesar(cles);

        System.out.println("donnez votre texte à crypter");
        String texteClair = scanner.nextLine();

        ArrayList<Integer>asciiText = chiff_dechiffr_cesar.Conversion_ASCII(texteClair);
        System.out.println("Codes ASCII du texte en clair: " + String.join("/", asciiText.toString()));

        ArrayList<Integer>asciiSecu = chiff_dechiffr_cesar.Conversion_ASCII(cles);
        System.out.println("Codes ASCII de la clé de sécurité : " + String.join("/", asciiSecu.toString()));

        ArrayList<Integer> asciiChiffr = chiff_dechiffr_cesar.ChiffrerAscii(asciiSecu, asciiText);
        System.out.println("Codes ASCII de l'addition : " + String.join("/", asciiChiffr.toString()));

        String cryptText = chiff_dechiffr_cesar.Conversion_Texte(asciiChiffr);
        System.out.println("Le texte crypté : " + cryptText);

        ArrayList<Integer> asciiDechiffr = chiff_dechiffr_cesar.DechiffrerAscii(asciiSecu, asciiChiffr);
        System.out.println("Codes ASCII suite au décryptage : " + String.join("/", asciiDechiffr.toString()));

        String ConversText = chiff_dechiffr_cesar.Conversion_Texte(asciiDechiffr);
        System.out.println("Le texte de retour : " + ConversText);
    }
}