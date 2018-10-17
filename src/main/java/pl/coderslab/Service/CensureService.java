package pl.coderslab.Service;

public class CensureService {

    private static String[] toCensure = {"cholera","cholerna","motyla noga"};

    public static String censure(String text){
        for(String word : toCensure){
            text = text.replaceAll(word, "***");
        }
        return text;
    }
}
