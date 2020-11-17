package gr.oncrete.editDistance;

import edu.stanford.nlp.util.EditDistance;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;


public class FindDuplicates {
    private final ArrayList<String> fileNames;
    private HashMap<String, ArrayList<String>> duplicates;

    public FindDuplicates(ArrayList<String> incomingFilenames) {
        this.fileNames = incomingFilenames;
        duplicates = new HashMap<>();
        this.findDuplicates();
    }

    private boolean compareStrings(String a, String b) {
        EditDistance ed = new EditDistance();
        double distance = ed.score(a, b);
        //System.out.println("String a is:" + a + " String b is:" + b + " Edit Distance is:" + distance);
        //return true if two strings are close to each other
        return distance < 10;

    }

    public void findDuplicates() {
        fileNames.forEach(firstName -> {
            //System.out.println("Looking for duplicates for:" + firstName);
            fileNames.forEach(secondName -> {
                if (!firstName.equals(secondName) && this.compareStrings(firstName, secondName)) {
                    if (duplicates.get(firstName) == null) {
                        ArrayList<String> newDup = new ArrayList<>();
                        newDup.add(secondName);
                        duplicates.put(firstName, newDup);
                    } else {
                        ArrayList<String> dup = duplicates.get(firstName);
                        dup.add(secondName);
                    }
                }
            });
        });
    }

   public void toJson() {
        JSONObject jsonObject = new JSONObject(duplicates);

        // writing the JSONObject into a file(info.json)
        try {
            FileWriter fileWriter = new FileWriter("duplicates.json");
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        System.out.println("Found "+duplicates.keySet().size()+" duplicate references");
    }
}

