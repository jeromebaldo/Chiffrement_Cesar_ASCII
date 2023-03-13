import java.util.ArrayList;

public class Chiff_Dechiffr_Cesar
{
    private String cles;

    public Chiff_Dechiffr_Cesar(String cles)
    {
        this.cles = cles;
    }

    public ArrayList<Integer> Conversion_ASCII(String texte)
    {
        //méthode pour convertir des chars en ASCII
        ArrayList<Integer>ascii = new ArrayList<Integer>();
        for (char carac : texte.toCharArray())
        {
            ascii.add((int) carac);
        }
        return ascii;
    }

    public String Conversion_Texte(ArrayList<Integer> ascii)
    {
        //méthode pour convertir des ASCII en une string
        String textConvers = "";
        for(int chiff : ascii)
        {
            textConvers += (char) chiff;

        }
        return textConvers;
    }

    public ArrayList<Integer> ChiffrerAscii(ArrayList<Integer> asciiSecu, ArrayList<Integer> asciiText)
    {
        //méthode pour chiffrer le code César
        //prend en entrée l'arraylist d'ASCII du texte en clair + arraylist d'ASCII de la clé de sécurité
        //retourne une arraylist ASCII chiffré en additionnant la sécurité et le texte en clair
        int iterText = 0;
        int iterSecu = 0;
        ArrayList<Integer> asciiChiffre = new ArrayList<Integer>();

        while(iterText < asciiText.size())
        {
            asciiChiffre.add(asciiText.get(iterText)+ asciiSecu.get(iterSecu));
            iterText++;
            iterSecu = (iterSecu + 1) % asciiSecu.size();//utilisation du modulo pour boucler sur la clé sécurité
        }
        return asciiChiffre;
    }

    public ArrayList<Integer> DechiffrerAscii(ArrayList<Integer> asciiSecu, ArrayList<Integer> asciiChiffr)
    {
        //méthode pour déchiffrer le code César
        //prend en entrée l'arraylist d'ASCII chiffré + arraylist d'ASCII de la clé de sécurité
        //retourne une arraylist ASCII déchiffrée en soustrayant la sécurité au chiffré
        ArrayList<Integer> dechiffrement = new ArrayList<Integer>();
        int iterSecu = 0;
        for(int chiff : asciiChiffr)
        {
            dechiffrement.add(chiff - asciiSecu.get(iterSecu));
            iterSecu = (iterSecu+1)% asciiSecu.size(); //utilisation du modulo pour boucler sur la clé sécurité
        }
        return dechiffrement;
    }
}
