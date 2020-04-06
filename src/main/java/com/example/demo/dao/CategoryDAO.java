package com.example.demo.dao;
import com.example.demo.vo.CategoryVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryDAO {
    public static HashMap<String,CategoryVO> txt_to_category(String depth) {
        Path path = Paths.get("C:\\data\\dictionary\\jikjong_"+depth+"depth.txt");
        List<String> list = new ArrayList<String>();
        try {
            list = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,CategoryVO> category = new HashMap<String,CategoryVO>();

        for (int i = 0; i < list.size(); i++) {
            CategoryVO temp = new CategoryVO();
            temp.setCat_key(list.get(i).split("\\|\\*\\|")[0]);
            temp.setCat_name(list.get(i).split("\\|\\*\\|")[1]);
            temp.setPrimary_keywords(list.get(i).split("\\|\\*\\|",5)[3]);
            temp.setRelated_words(new HashMap<String,Integer>());
            category.put(list.get(i).split("\\|\\*\\|")[0],temp);
            temp.setRelated_words_count(0);
        }
        return category;
    }

    public static List<CategoryVO> txt_to_category_list(String depth){
        Path path = Paths.get("C:\\data\\dictionary\\jikjong_"+depth+"depth.txt");
        List<CategoryVO> category = new ArrayList<CategoryVO>();
        List<String> list = new ArrayList<String>();
        try{
            list = Files.readAllLines(path,StandardCharsets.UTF_8);
        }catch(IOException e){
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            CategoryVO temp = new CategoryVO();
            temp.setCat_key(list.get(i).split("\\|\\*\\|")[0]);
            temp.setCat_name(list.get(i).split("\\|\\*\\|")[1]);
            temp.setRelated_words(new HashMap<String, Integer>());
            category.add(temp);
        }
        return category;
    }


    public static List<CategoryVO> category_to_vo(String name){
        Gson gson = new GsonBuilder().create();
        List<CategoryVO> list = new ArrayList<CategoryVO>();
        try{
            String JsonData = new String(Files.readAllBytes(Paths.get("C:\\data\\backup\\"+name+".txt")));
            Type listType = new TypeToken<ArrayList<CategoryVO>>(){}.getType();
            list = gson.fromJson(JsonData,listType);
        }catch(IOException e) { e.printStackTrace(); }
        return list;
    }

    public static void vo_to_category(List<CategoryVO> list, String name) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(list);
        try {
            File myFile = new File("C:\\data\\"+name+".txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(json);
            myOutWriter.close();
            fOut.close();
        }catch(IOException e){ e.printStackTrace(); }
    }



}
