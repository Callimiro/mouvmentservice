package com.al.detector.lightdetector.lightservice.web.dao;

import com.al.detector.lightdetector.lightservice.web.model.Light;
import org.springframework.data.repository.CrudRepository;

public interface LightDetectorDao extends CrudRepository<Light, Integer> {

}
