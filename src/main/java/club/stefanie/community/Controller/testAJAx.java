package club.stefanie.community.controller;

import club.stefanie.community.model.Category;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class testAJAx {
    @PostMapping("/test")
    @ResponseBody
    public String test(@RequestBody Category category){
        System.out.println("AHAHA");
        List<Category> ls= new ArrayList<>();
        ls.add(category);
        Category category1 = new Category();
        category1.setId(165165);
        category1.setName("ssss");
        ls.add(category1);


        JSONObject jsonObject= new JSONObject();
        return jsonObject.toJSONString(ls);
    }
    @RequestMapping("/get")
    public String get(){
        return "getOne";
    }
    @ResponseBody
    @GetMapping("/getOneCategory")
    public String getOneCategory(){
        Category category = new Category();
        category.setId(10);
        category.setName("wangpanjie");
        JSONObject jsonObject= new JSONObject();

        return jsonObject.toJSONString(category);
    }
    @ResponseBody
    @PostMapping("/getManyCategory")
    public String getManyCategory(){
        List<Category> ls = new ArrayList<>();
        Category category;
        for(int i =0;i<10;i++){
            category = new Category();
            category.setName("wang"+i);
            category.setId(i);
            ls.add(category);
        }

        JSONObject jsonObject = new JSONObject();

        System.out.println("IMOK");
        return jsonObject.toJSON(ls).toString();
    }
}
