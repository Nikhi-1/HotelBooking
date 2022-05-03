package com.example.myhotels.Util;

import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("hotels.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
    public static List<Hotel> getRestaurantList(Context context){
        ObjectMapper mapper = new ObjectMapper();
        String json = loadJSONFromAsset(context);
        try{
            return Arrays.asList(mapper.readValue(json, Hotel[].class));


        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
