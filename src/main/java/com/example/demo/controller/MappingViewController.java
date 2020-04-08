package com.example.demo.controller;

import com.example.demo.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Controller
public class MappingViewController {
    MappingService mappingService;
    @Autowired
    MappingViewController(MappingService mappingService){
        this.mappingService = mappingService;
    }

    @GetMapping("/home")
    public String print_home(Model model){
        model.addAttribute("result",null);
        return "readingList";
    }

    @GetMapping("/home/result/2depth")
    public String print_result(Model model, @RequestParam("rec_idx") String rec_idx){
        Map<String,Object> mapping_result = mappingService.analysis_2depth_mapping(rec_idx);
        model.addAttribute("result",mapping_result);
        return "readingList";
    }

    @GetMapping("/home/result/3depth")
    public String print_result_3depth(Model model, @RequestParam("rec_idx") String rec_idx){
        Map<String,Object> mapping_result = mappingService.analysis_3depth_mapping(rec_idx);
        model.addAttribute("result",mapping_result);
        return "readingList";
    }

    @GetMapping("/custom")
    public String print_custom(Model model){
        model.addAttribute("table_result",null);
        model.addAttribute("primary_category",null);
        model.addAttribute("secondary_category",null);
        return "readingOne";
    }

    @GetMapping("/custom/result")
    public String print_result_one(Model model, @RequestParam("rec_content") String rec_content){
        Map<String,Object> mapping_result = mappingService.analysis_one_recruit(rec_content);
        List<Map<String,Object>> primary_category = mappingService.get_primary_category();
        model.addAttribute("table_result",mapping_result);
        model.addAttribute("primary_category",primary_category);
        return "readingOne";
    }
}
