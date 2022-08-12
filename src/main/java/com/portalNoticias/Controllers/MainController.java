package com.portalNoticias.Controllers;

import com.portalNoticias.Models.LogItem;
import com.portalNoticias.Repo.LogItemRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/portalNoticias")
public class MainController {
    @Autowired
    private LogItemRepository logItemRepository;

    @GetMapping("/getWeatherofCali")
    public List<Object> getWeather(){

        String source = "https://api.openweathermap.org/data/2.5/weather?lat=3.437&lon=-76.522&appid=18be9197e1d2d062dcbbf8da69d3da5f";

       Date now = Date.from(Instant.ofEpochSecond(System.currentTimeMillis()));
       String cr = "Weather of Cali resource";
       LogItem item = new LogItem(cr, now);
       logItemRepository.save(item);

        try{
            URLConnection conn = new URL(source).openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //System.out.println(br.lines().collect(Collectors.joining()));
            String s = br.lines().collect(Collectors.joining()).trim();

          //  System.out.println(s);
          //  System.out.println("["+s+"]");

            JSONArray json = new JSONArray("["+s+"]");
          //  System.out.println("informacion obtenida del Servicio Web: " + json);
            return json.toList();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @GetMapping("/getNews")
    public List<Object> getNews(){

        String source = "https://newsapi.org/v2/everything?q=technology&from=2022-08-1&apiKey=8dbd0572da2c4dbda85f63795c4da76f";

        Date now = Date.from(Instant.ofEpochSecond(System.currentTimeMillis()));
        String cr = "News resource";
        LogItem item = new LogItem(cr, now);
        logItemRepository.save(item);

        try{
            URLConnection conn = new URL(source).openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //System.out.println(br.lines().collect(Collectors.joining()));
            String s = br.lines().collect(Collectors.joining());
            JSONArray json = new JSONArray("["+s+"]");
            //System.out.println("informacion obtenida del Servicio Web: " + json);
            return json.toList();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    @GetMapping("/getLog")
    public List<LogItem> getLog(){
        return logItemRepository.findAll();
    }
}
