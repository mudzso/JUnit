import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mudzso on 2017.04.21..
 */
public class FilePartReader {
    private String filePath;
    private  int fromLine;
    private  int toLine;

    public FilePartReader(String filePath, int fromLine, int toLine) {
        if (toLine<fromLine||fromLine<1)throw new IllegalArgumentException();
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read()throws IOException{
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String readLines()throws IOException{
        String result = "";
        List<String>lines= Arrays.asList(read().split("\n"));
        for (int i = fromLine-1; i <toLine ; i++) {
            String row = lines.get(i);
            if (lines.get(i).contains(".") && i != toLine -1) row = lines.get(i) + " ";
            result += row;

        }
        return result;
    }
}
