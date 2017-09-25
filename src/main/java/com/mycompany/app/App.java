package com.mycompany.app;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    //Verilen stringin verilen indexleri ve o indexler arasında harf disinda baska bir kar. varsa false donen program
    public static boolean rr(String[] str, int x, int y){
	if(str == null){
		return false;
	}
    	String ss="";
    	for(int i=0; i<str.length; i++){
    		ss += str[i];
    	}
    	ss = ss.toLowerCase();
    	for(int i=x; i<=y; i++){
    		if(!(ss.charAt(i) >= 'a' && ss.charAt(i) <= 'z') ){
    			return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
	  int x = 0;
          while (sc1.hasNext())
          {
            String value = (sc1.next().replaceAll("\\s",""));
            inputList.add(value);
	    x++;
          }

          System.out.println(inputList);
	  String[] inputListStringArray = new String[x];

	  for(int a = 0; a < x; a++){
		inputListStringArray[a] = inputList.get(a);
	  }

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
	  String input3 = req.queryParams("input3").replaceAll("\\s","");
          int input3AsInt = Integer.parseInt(input3);


          boolean result = App.rr(inputListStringArray, input2AsInt, input3AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
