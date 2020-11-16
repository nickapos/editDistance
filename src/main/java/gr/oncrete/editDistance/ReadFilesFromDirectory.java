package gr.oncrete.editDistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFilesFromDirectory {
    List<String> filenames;
    String scanPath;

    public ReadFilesFromDirectory(String scanPath) {
        filenames = new ArrayList<>();
        this.scanPath = scanPath;
        this.readFiles();
    }

    public void readFiles() {

        try (Stream<Path> paths =Files.walk(Paths.get(this.scanPath))){
            filenames=paths.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void printFilenames(){
        filenames.forEach(name -> System.out.println(name) );
    }
    public List getFilenames(){
        return filenames;
    }
}
