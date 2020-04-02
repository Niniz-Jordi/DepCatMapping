package com.example.demo.controller;
import com.example.demo.service.MappingService;
import com.example.demo.vo.CategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@RestController
public class MappingController {
    MappingService mappingService;
    MappingController(MappingService mappingService){
        this.mappingService = mappingService;
    }

    @GetMapping("/mapping/3depth")
    public String mapping(){
        mappingService.set_category_vo();
        mappingService.set_12depth_category_vo();
        return "finish";
    }

    @GetMapping("/mapping/2depth")
    public String mapping_2depth(){
        mappingService.set_2depth_category_vo();
        return "finish";
    }

    @GetMapping("/print/3depth")
    public List<CategoryVO> depth3_print(){
        return mappingService.category_print();
    }

    @GetMapping("/print/12depth")
    public String depth12_print(){
        mappingService.set_12depth_category_vo();
        return "finish";
    }
}