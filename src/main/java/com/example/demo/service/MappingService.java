package com.example.demo.service;

import com.example.demo.vo.CategoryVO;
import com.example.demo.vo.RecruitVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MappingService {
    void set_category_vo();
    void set_2depth_category_vo();
    void split_recruit_vo();
    void set_12depth_category_vo();
    List<CategoryVO> category_print();
    Map<String,Object> analysis_2depth_mapping(String rec_idx);
    Map<String,Object> analysis_3depth_mapping(String rec_idx);
    HashMap<String,Object> analysis_one(String rec);
    List<Map<String,Object>> get_primary_category();
    List<Map<String,Object>> get_secondary_category();
    void testAccuracy();
}
