import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by mudzso on 2017.04.21..
 */
public class FileReaderAndAnalyzerUnitTest {

    @Test
    public void testReadFunction1(){
        String result = "";
        FilePartReader filePartReader = new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",7,7);
        try {
            result = filePartReader.readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("cccc dddd aaaa bbbb.",result);


    }

    @Test
    public void testReadFunction2(){
        String result = "";
        FilePartReader filePartReader = new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",1,2);
        try {
            result = filePartReader.readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("The sun views extend which is not shining. Butter combines greatly with old chickpeas.",result);


    }

    @Test
    public void testReadFunction3(){
        String result = "";
        FilePartReader filePartReader = new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",2,4);
        try {
            result = filePartReader.readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Butter combines greatly with old chickpeas. Est fatalis racana, cesaris. The skiff drinks with death, blow the brig before it screams.",result);


    }

    @Test
    public void testAbcSort1(){
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",7,7));

        List<String>goodOrder = Arrays.asList("aaaa","bbbb","cccc","dddd");
        ArrayList<String> result= fileWordAnalyzer.wordsByAbc();
        assertEquals(goodOrder,result);



    }


    @Test
    public void testAbcSort2(){
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",8,8));

        List<String>goodOrder = Arrays.asList("aaaa","aaab","aaac","aaad");
        ArrayList<String> result= fileWordAnalyzer.wordsByAbc();
        assertEquals(goodOrder,result);



    }


    @Test
    public void testAbcSort3(){
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",7,8));

        List<String>goodOrder = Arrays.asList("aaaa","aaaa","aaab","aaac","aaad","bbbb","cccc","dddd");
        ArrayList<String> result= fileWordAnalyzer.wordsByAbc();
        assertEquals(goodOrder,result);



    }



    @Test
    public void testSubString1(){
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",6,6));

        List<String>subString = Arrays.asList("confucius");
        ArrayList<String> result= fileWordAnalyzer.wordsContainingSubString("fu");
        assertEquals(subString,result);



    }


    @Test
    public void testSubString2(){
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(new FilePartReader(
                "/home/mudzso/IdeaProjects/Testdriven/TestFile2.txt",6,6));

        List<String>subString = Arrays.asList("confucius","says","stop","sit");
        ArrayList<String> result= fileWordAnalyzer.wordsContainingSubString("s");
        assertEquals(subString,result);



    }









}
