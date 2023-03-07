package com.example.demothuctap.controllers;

import com.example.demothuctap.service.serviceinterface.FresherService;
import com.example.demothuctap.models.mapper.FresherDTO;
import com.example.demothuctap.models.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/fresher")
public class FresherController {
    @Autowired
    FresherService fresherService;

    @GetMapping("/all")
    public @ResponseBody ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","thanh cong",
                        Collections.singletonList(fresherService.getFresher()))
        );
    }
    @PostMapping("/add")
    public @ResponseBody ResponseEntity<ResponseObject> addFresher(@RequestBody FresherDTO fresherDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "thanh cong",
                        fresherService.addFresher(fresherDTO))
        );
    }
    @PutMapping("/put")
    public @ResponseBody ResponseEntity<ResponseObject> editFresher(@RequestBody FresherDTO fresherDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "thanh cong",
                        fresherService.editFresher(fresherDTO))
        );
    }
    @DeleteMapping("/delete/{fresherId}")
    public ResponseEntity<ResponseObject> delete(@PathVariable String fresherId) {
        fresherService.deleteFresher(fresherId);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","thanh cong","")
        );
    }
    @GetMapping("/transcript")
    public ResponseEntity<ResponseObject> getTranscript(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK","thanh cong",
                        Collections.singletonList(fresherService.getTranscript()))
        );
    }
}

