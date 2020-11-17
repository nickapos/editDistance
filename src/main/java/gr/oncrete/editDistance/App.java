package gr.oncrete.editDistance;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {


        // Create a Scanner object to read input.
        Scanner console = new Scanner(System.in);
        System.out.println("Please provide the path that will be scanned");
        String scanPath=console.next();
        ReadFilesFromDirectory readFiles= new ReadFilesFromDirectory(scanPath);
        ArrayList<String> filenames= readFiles.getFilenames();
        FindDuplicates findDup = new FindDuplicates(filenames);
        findDup.toJson();


    }
}
