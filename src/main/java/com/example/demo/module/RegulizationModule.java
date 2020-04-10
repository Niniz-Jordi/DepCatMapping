package com.example.demo.module;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegulizationModule {
    /****Tf-idf module***/
    public static double tf_idf(List<String> doc, List<List<String>> docs, String term){
        double result = 0;
        double n = 0;
        for(String word : doc){
            if(term.equalsIgnoreCase(word)){
                result++;
            }
        }
        for (List<String> document : docs) {
            for (String word : document) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return (result / doc.size()) * (Math.log(docs.size() / (n+1)));
    }

    /***category regulization module***/
    /***factor = 한 부서의 모수가 너무 작으면 그 부서가 너무 강해지는 것을 방지***/
    public static Double category_regularization(int count, int category_count_all, int factor){
        return (double)count / (double)(category_count_all+factor);
    }

    public static Double corpus_regularization(Integer count, Integer depth3_diff_count, Integer depth2_diff_count, Integer depth1_diff_count){
        return  (count) / ( (double)depth3_diff_count + (double)(depth2_diff_count + 30)*10 + (depth1_diff_count + 10)*50 );
    }

    /**count to percent module**/
    public static ArrayList<Double> count_to_percent(List<Double> count){
        ArrayList<Double> percent = new ArrayList<>();
        Double sum=count.stream().mapToDouble(Double::doubleValue).sum();
        for(Double d:count){
            if(sum == 0.0) percent.add(0.0);
            else percent.add(d/sum*100);
        }
        return percent;
    }

    /**count to percent module2**/
    public static ArrayList<HashMap<String,String>> count_to_percent2(List<HashMap<String,Double>> count){
        ArrayList<HashMap<String,String>> percent = new ArrayList<>();
        Double sum = 0.0;
        for(HashMap<String,Double> cnt:count){
            for(String key:cnt.keySet()){
                sum+=cnt.get(key);
            }
        }
        for(HashMap<String,Double> cnt:count){
            HashMap<String,String> tmp = new HashMap<>();
            for(String key:cnt.keySet()){
                if(sum == 0.0) tmp.put(key,String.format("%.1f",0.0)+"%");
                else tmp.put(key,String.format("%.1f",cnt.get(key)/sum*100)+"%");
            }
            percent.add(tmp);
        }
        return percent;
    }

    public static Double corpus_regularization2(Integer k,Integer count,HashMap<Integer,Integer> category_token_nm){
        Integer depth1_diff = 0,depth2_diff=0,depth3_diff=0;
        for(Integer key:category_token_nm.keySet()){
            if(key/100 == k/100) depth3_diff += category_token_nm.get(key);
            else if(key/10000 == k/10000) depth2_diff += category_token_nm.get(key);
            else depth1_diff += category_token_nm.get(key);
        }
        if(count==null) return 0.0;
        else return count/((depth3_diff+10)*0.1+(depth2_diff+30)*0.3+depth1_diff);
    }

}