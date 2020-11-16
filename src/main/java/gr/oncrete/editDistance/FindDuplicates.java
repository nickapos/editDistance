package gr.oncrete.editDistance;
import edu.stanford.nlp.util.EditDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FindDuplicates {
    List<String> fileNames;
    HashMap<String,ArrayList> duplicates;
    public FindDuplicates(List incomingFilenames){
        this.fileNames=incomingFilenames;
        duplicates=new HashMap<String, ArrayList>();
    }

    private boolean compareStrings(String a, String b){
        EditDistance ed=new EditDistance();
        double distance=ed.score(a,b);
        System.out.println( "String a is:"+a+ " String b is:"+b+" Edit Distance is:"+ distance);
        if(distance< 10){
            return true;
        }
            return false;

    }

    public void findDuplicates(){
        fileNames.forEach(firstName -> {
            System.out.println("Looking for duplicates for:"+firstName);
            fileNames.forEach(secondName ->{
                    if(this.compareStrings(firstName,secondName)){
                        if(duplicates.get(firstName)==null){
                            ArrayList newDup = new ArrayList();
                            newDup.add(secondName);
                            duplicates.put(firstName,newDup);
                        }else{
                            ArrayList dup=duplicates.get(firstName);
                            dup.add(secondName);
                        }
                    }
            });
        });
    }
}
