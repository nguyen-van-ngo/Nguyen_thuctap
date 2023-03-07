package com.example.demothuctap.controllers;

import com.example.demothuctap.service.serviceinterface.CenterService;
import com.example.demothuctap.models.entity.FresherCenter;
import com.example.demothuctap.models.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Autowired
    CenterService centerService;
    @GetMapping
    public ResponseEntity<ResponseObject> getAllCenter() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","Nhan thong tin trung tam thanh cong",
                        Collections.singletonList(centerService.getAllCenter()))
        );
    }
    @PostMapping(path = "/add/fresher/{centerCode}")
    public FresherCenter addFresherToCenter(@PathVariable String centerCode,
                                            @RequestParam String fresherId) {
        return centerService.addFresherToCenter(centerCode,fresherId);
    }
    @GetMapping(path = "/fresher/{centerCode}")
    public ResponseEntity<ResponseObject> getAllFresherOfCenter(@PathVariable String centerCode) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Da nhan tat ca fresher trong trung tam " + centerCode,
                        Collections.singletonList(centerService.getListFresherOfCenter(centerCode)))
        );
    }

}
