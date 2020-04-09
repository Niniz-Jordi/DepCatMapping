package com.example.demo.module;
import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class KomoranModule {
    Komoran komoran;

    public KomoranModule(){
        komoran = new Komoran(DEFAULT_MODEL.FULL);
//        ClassPathResource resource = new ClassPathResource("dictionary/komoran_user_dictionary.txt");
        komoran.setUserDic("C:\\data\\dictionary\\komoran_user_dictionary.txt");
    }
    public List<String> Tokenizer(String str){
        KomoranResult analyzeResultList = komoran.analyze(str);
        return analyzeResultList.getNouns();
    }
}
