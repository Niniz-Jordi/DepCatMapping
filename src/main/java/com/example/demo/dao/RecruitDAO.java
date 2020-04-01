package com.example.demo.dao;

import com.example.demo.vo.CategoryVO;
import com.example.demo.vo.RecruitVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class RecruitDAO {
    public static List<RecruitVO> textToRecruitVO(){
        List<RecruitVO> recruitVO = new ArrayList<RecruitVO>();
        for(int i=1;i<41;i++){
            Path path = Paths.get("C:\\data\\recruit_search\\" + i + ".txt");
            List<String> list = new ArrayList<String>();
            try {
                list = Files.readAllLines(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int j = 0; j < list.size(); j += 25) {
                RecruitVO temp = new RecruitVO();
                temp.setRec_idx(list.get(j).split("__>",2)[1]);
                temp.setCompany_nm(list.get(j+1).split("__>",2)[1]);
                temp.setTitle(list.get(j+5).split("__>",2)[1]);
                temp.setContact_address(list.get(j+6).split("__>",2)[1]);
                temp.setAddress(list.get(j+7).split("__>",2)[1]);
                temp.setSubway_cd(list.get(j+8).split("__>",2)[1]);

                temp.setLoc_bcd(list.get(j+9).split("__>",2)[1]);
                temp.setLoc_mcd(list.get(j+10).split("__>",2)[1]);
                temp.setLoc_bcd_nm(list.get(j+11).split("__>",2)[1]);
                temp.setLoc_mcd_nm(list.get(j+12).split("__>",2)[1]);

                temp.setInd_key(list.get(j+13).split("__>",2)[1]);
                temp.setCat_key(list.get(j+14).split("__>",2)[1]);
                temp.setKeyword(list.get(j+15).split("__>",2)[1]);
                temp.setDescription(list.get(j+20).split("__>",2)[1]);
                temp.setUpjik_bcode_nm(list.get(j+21).split("__>",2)[1]);
                temp.setUpjik_code_nm(list.get(j+22).split("__>",2)[1]);

                temp.setRec_division(list.get(j+23).split("__>",2)[1]);
                temp.setRecruit_contents(list.get(j+24).split("__>",2)[1]);

                recruitVO.add(temp);
            }
        }
        return recruitVO;
    }

    public static void RecruitVOtoText(HashMap<String, RecruitVO> list, String name) {
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
        }catch(IOException e){ }
    }

}
