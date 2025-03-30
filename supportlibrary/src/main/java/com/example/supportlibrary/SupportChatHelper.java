package com.example.supportlibrary;

import android.content.Context;
import android.content.res.AssetManager;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SupportChatHelper {
    public static String getSupportChatMessage(Context context) {
        String json = loadJSONFromAsset(context, "credentials.json");
        if (json == null) return "Error loading message";

        try {
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject.getString("supportChat");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing message";
        }
    }
    private static String loadJSONFromAsset(Context context, String fileName) {
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader reader = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}