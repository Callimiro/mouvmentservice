package com.al.detector.lightdetector.lightservice.web.controller;

import com.al.detector.lightdetector.lightservice.web.dao.LightDetectorDao;
import com.al.detector.lightdetector.lightservice.web.model.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LightDetectorController {
    @Autowired
    public LightDetectorDao lightDetectorDao;

    @RequestMapping(value = "/Light",method = GET)
    public boolean getLight(){
        Iterable<Light> all = lightDetectorDao.findAll();
        int id = 0;
        Date date ;
        boolean state = false;
        for (Light light : all) {
            if (id == 0) {
                id = light.getId();
                date = light.getUpdatetime();
                state = light.isState();
            } else {
                if (light.getId()>id){
                    id = light.getId();
                    date = light.getUpdatetime();
                    state = light.isState();
                }
            }
        }
        return state;
    }

    @RequestMapping(value = "/Light/{state}",method = POST)
    public void setLight(@PathVariable String state){
        long millis=System.currentTimeMillis();
        Date date = new Date(millis);
        boolean s ;
        if(state.equals("true")){
            s = true;
        } else{
            s = false;
        }
        System.out.println(s);
        Light light = new Light(s,date);
        System.out.println("the id is :"+light.getId());
        lightDetectorDao.save(light);
    }
}