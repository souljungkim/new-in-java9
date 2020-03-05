import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TryWithResourceImprovements {


    /**************************************************
     * Ready
     **************************************************/
    public static String getResourceFileName(String fileName){
        return TryWithResourceImprovements.class.getClassLoader().getResource(fileName).getFile();
    }



    /**************************************************
     * Test
     **************************************************/
    @Test
    public void main() throws IOException {
        StringBuilder contentsBuilder = new StringBuilder();
        String contents = "", line, separator = System.lineSeparator();

        //1. Defined reader out of try-with-resource
        BufferedReader reader = new BufferedReader( new FileReader( getResourceFileName("test.txt") ) );

        //2. try(reader)
        try (reader){
            assert reader.ready();
            while((line = reader.readLine()) != null){
                contentsBuilder.append(line).append(separator);
            }
            contents = contentsBuilder.toString();
            assert !reader.ready();
            throw new IOException();

        }catch(IOException e){
            //3. Catch Code
        }

        assert contents.startsWith("test on test");
//        reader.ready(); //Maybe It will occur IOException "Stream Closed" After closed
    }

}
