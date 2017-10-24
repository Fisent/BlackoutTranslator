package com.company;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void loadJSON(String filename){


    }

    public static void main(String[] args) throws IOException {
        String jsonString = "";
        File f = new File("Blackout.json");
        Scanner scan  = new Scanner(f);
        while(scan.hasNextLine()){
            jsonString += scan.nextLine();
        }


        JSONObject object = new JSONObject(jsonString);
        JSONArray array = object.getJSONArray("Packages");
    }
}
