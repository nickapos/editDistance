package gr.oncrete.editDistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFilesFromDirectory {
    ArrayList<String> filenames;
    String scanPath;

    public ReadFilesFromDirectory(String scanPath) {
        filenames = new ArrayList<>();
        this.scanPath = scanPath;
        this.readFiles();
    }

    public void readFiles() {

        try (Stream<Path> paths =Files.walk(Paths.get(this.scanPath))){
            filenames= (ArrayList<String>) paths.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> getFilenames(){
        return filenames;
    }
}
