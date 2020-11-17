package gr.oncrete.editDistance;

import edu.stanford.nlp.util.EditDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FindDuplicates {
    List<String> fileNames;
    HashMap<String, ArrayList> duplicates;

    public FindDuplicates(List incomingFilenames) {
        this.fileNames = incomingFilenames;
        duplicates = new HashMap<String, ArrayList>();
        this.findDuplicates();
    }

    private boolean compareStrings(String a, String b) {
        EditDistance ed = new EditDistance();
        double distance = ed.score(a, b);
        //System.out.println("String a is:" + a + " String b is:" + b + " Edit Distance is:" + distance);
        //return true if two strings are close to each other
        if (distance < 10) {
            return true;
        }
        return false;

    }

    public void findDuplicates() {
        fileNames.forEach(firstName -> {
            //System.out.println("Looking for duplicates for:" + firstName);
            fileNames.forEach(secondName -> {
                if (firstName != secondName && this.compareStrings(firstName, secondName)) {
                    if (duplicates.get(firstName) == null) {
                        ArrayList newDup = new ArrayList();
                        newDup.add(secondName);
                        duplicates.put(firstName, newDup);
                    } else {
                        ArrayList dup = duplicates.get(firstName);
                        dup.add(secondName);
                    }
                }
            });
        });
    }

    public void printDuplicates() {

        for (String key : duplicates.keySet()) {
            System.out.println("\nPrinting duplicates for:" + key);
            List a = duplicates.get(key);
            a.forEach(name -> System.out.println(name));
        }
    }
}
