import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mudzso on 2017.04.21..
 */
public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public ArrayList wordsByAbc(){
        String context = "";
        try {
            context = filePartReader.readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = context.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        String tmp;
        for (int i = 0;i < words.length;i++)
        {
            tmp = words[i];
            for (int j = 0;j < words.length;j++)
            {
                if (i == j) continue;
                int x = tmp.compareTo(words[j]);
                if (x < 0)
                {
                    tmp = words[j];
                    words[j] = words[i];
                    words[i] = tmp;
                }
            }
        }
        return new ArrayList<String>(Arrays.asList(words));
    }

    public ArrayList wordsContainingSubString(String subString){
        subString = subString.toLowerCase();
        String context = "";
        ArrayList<String> resultStrings = new ArrayList<>();
        try {
            context = filePartReader.readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] words = context.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        for (int i = 0; i <words.length ; i++) {

            if (words[i].contains(subString))resultStrings.add(words[i]);

        }
    return resultStrings;
    }
}
