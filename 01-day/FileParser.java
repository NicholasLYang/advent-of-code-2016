import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
//import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileParser {

    public ArrayList<String> parseFile (String fileName){
        String fileContents;
        ArrayList<String> directions = new ArrayList<String>();
        try {
            fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
            System.out.println("FILE CONTENTS: ");
            System.out.println(fileContents);
            fileContents = fileContents.replace("\n", "");
            directions.addAll(Arrays.asList(fileContents.split(", ")));
        }
        catch (Exception E) {
            System.out.println("Couldn't load file");
        }

        return directions;
    }

}
