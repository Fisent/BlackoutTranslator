package com.company;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static JSONArray getModels() throws FileNotFoundException {
        String jsonString = "";
        File f = new File("Blackout.json");
        Scanner scan  = new Scanner(f);
        while(scan.hasNextLine()){
            jsonString += scan.nextLine();
        }



        JSONObject object = new JSONObject(jsonString);
        JSONArray packages = object.getJSONArray("Packages");
        JSONObject zeroObject = packages.getJSONObject(0);
        return zeroObject.getJSONArray("Models");

    }

    public static void main(String[] args) throws IOException {

        JSONArray models = getModels();
        ArrayList<JSONObject> resultList = new ArrayList<>();

        JSONObject ob;
        for(int i = 0; i<models.length();i++){
            ob = models.getJSONObject(i);
            if(ob.get("Type").equals("EventElement")){
                resultList.add(ob);
            }
        }

        for (JSONObject j : resultList){
            System.out.println(j.getJSONObject("Properties").get("Text"));
        }

    }
}
