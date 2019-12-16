package com.arpgalaxy.bolg.controller;

import com.arpgalaxy.bolg.dao.ArticlesRepository;
import com.arpgalaxy.bolg.entity.Articles;
import com.arpgalaxy.bolg.tools.FileToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class EditController {
    @Autowired
    ArticlesRepository articlesRepository;

    @RequestMapping("/savetext")
    @ResponseBody
    public String mdText(@RequestParam(value = "textarea") String str,@RequestParam(value = "articleTitle") String articleTitle){
////        System.out.println(str);


        Date date = new Date();
        if (articleTitle!=""){
            Articles articles = new Articles();
            articles.setUserId(1);

            articles.setArticleDate(date);
            articles.setArticlePath("E://BolgFile/"+articleTitle);
            articles.setArticleOverview("dasdasdasdasdadasdasd");
            articles.setArticleTitle(articleTitle);
            articlesRepository.save(articles);

            FileToString.string2File(str,"E://BolgFile/"+articleTitle+".txt");
            File file = new File("E://BolgFile/"+articleTitle+".txt");
            FileToString.file2String(file,"UTF-8");
            return "《"+articleTitle+"》"+"--------"+date.toString();
        }else {
            return "不能为空文件名！！！"+"-------"+date.toString();
        }
    }
    @RequestMapping("/readtext")
    public String readText(@RequestParam(value = "articleTitle") String articleTitle, Map<String,Object> map){
////        System.out.println(str);
        if (articleTitle!=""){
            List<Articles> articlesList = articlesRepository.findByName(articleTitle);

            File file = new File(articlesList.get(0).getArticlePath()+".txt");

//            map=new HashMap<String, Object>();
            map.put("articleText",FileToString.file2String(file,"UTF-8"));
            return "articlemain";
        }else {
            return "articlemain";
        }
    }
    @RequestMapping("/getDefultArticleList")
    @ResponseBody
    public List<Articles> getDefultArticleList(){
        List<Articles> articlesList = articlesRepository.findByLikeName("socket");
        return articlesList;
    }

    @RequestMapping("/toedit")
    public String toEdit(){

        return "edit";
    }

    @RequestMapping("/toindex")
    public String toIndex(HttpServletRequest request, HttpServletResponse httpServletResponse){

        System.out.println(request.getRemoteAddr());
        return "index";
    }
}
