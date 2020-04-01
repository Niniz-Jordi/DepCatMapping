package com.example.demo.vo;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class RecruitVO {
    private String rec_idx;
    private String company_nm;
    private String title;

    private String contact_address;
    private String address;
    private String subway_cd;//지하철 코드
    private String loc_mcd;//위치 1depth
    private String loc_bcd;//위치 2depth
    private String loc_mcd_nm;//위치 1depth(서울)
    private String loc_bcd_nm;//위치 2depth(성동구)

    private String ind_key;//업종
    private String cat_key;//직종
    private String keyword;//키워드

    private String description;//보유기술
    private String upjik_bcode_nm;
    private String upjik_code_nm;

    private String rec_division;//모집부서
    private String recruit_contents;//모집 내용
}
