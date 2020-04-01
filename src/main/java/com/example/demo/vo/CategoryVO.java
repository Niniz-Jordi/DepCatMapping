package com.example.demo.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Data
@Component
/***직종별 관련단어 사전 구현 vo***/
public class CategoryVO {
    @SerializedName("cat_key")
    private String cat_key;
    @SerializedName("cat_name")
    private String cat_name;
    @SerializedName("primary_keywords")
    private String primary_keywords;
    @SerializedName("related_words_count")
    private int related_words_count;
    @SerializedName("related_words")
    private HashMap<String,Integer> related_words;

    public int compareTo(CategoryVO categoryVO) {
        int x = Integer.parseInt(this.getCat_key());
        int y = Integer.parseInt(categoryVO.getCat_key());
        return x - y;
    }
}