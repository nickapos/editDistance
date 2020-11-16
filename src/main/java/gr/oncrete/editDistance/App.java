package gr.oncrete.editDistance;

import edu.stanford.nlp.util.EditDistance;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        //String a="foufoutos";
        //String b="123123foufoutis123123-uiyihi";
        //EditDistance ed=new EditDistance();
        //double distance=ed.score(a,b);
        //System.out.println( "Edit Distance is:"+ distance);
        // Create a Scanner object to read input.
        Scanner console = new Scanner(System.in);
        System.out.println("Please provide the path that will be scanned");
        String scanPath=console.next();
        ReadFilesFromDirectory readFiles= new ReadFilesFromDirectory(scanPath);
        readFiles.readFiles();
        readFiles.printFilenames();


    }
}
