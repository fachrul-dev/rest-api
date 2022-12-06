package com.example.restapi.controller;

import com.example.restapi.dto.DosenDto;
import com.example.restapi.dto.KampusDto;
import com.example.restapi.dto.MahasiswaDosen;
import com.example.restapi.dto.MahasiswaDto;
import com.example.restapi.entity.MahasiswaEntity;
import com.example.restapi.model.BaseResponse;
import com.example.restapi.model.BaseResponseV2;
import com.example.restapi.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService service;

    @PostMapping("/add")
    private BaseResponse<MahasiswaEntity> addMahasiswa(@RequestBody @Valid MahasiswaEntity body){

            try {
                  return BaseResponse.ok(service.addMahasiswa(body));
            } catch (Exception e) {
                e.printStackTrace();
                return BaseResponse.internalError();
            }




    }

    @PostMapping("/findkelas")
    private MahasiswaEntity findMahasiswaByKelas (@RequestBody MahasiswaDto kelas) {
        return service.getMahasiswaByKelas(kelas);
    }

    @PostMapping("/add/v1")
    private BaseResponseV2 addMahasiswaV1(@RequestBody @Valid MahasiswaDto body){
        return service.saveDataMahasiswa(body);
    }

    @PostMapping("/add/v2")
    private ResponseEntity<MahasiswaEntity> addMahasiswaV2(@RequestBody @Valid MahasiswaDto body){
        return new ResponseEntity<>(service.addMahasiswa2(body), HttpStatus.CREATED);
    }

    @GetMapping("/getMahasiswaAndDosen")
    private BaseResponseV2 getMahasiswaAndDoses(){
        return service.getMahasiswaAndDosen();
    }

    @GetMapping("/getAllDosen")
    private BaseResponse<DosenDto> getAllDoses(){
        return service.getAllDosen();
    }

    @GetMapping("/get")
    private BaseResponse<List<MahasiswaEntity>> getMahasiswa(){
        try {
            return BaseResponse.ok(service.getMahasiswa());
        } catch (Exception e) {
            return BaseResponse.internalError();
        }

    }

    @GetMapping("/get/v1")
    private BaseResponseV2 getMahasiswav1(){
        return service.getDataMahasiswa();
    }

    @DeleteMapping("/delete/{id}")
    private void deleteMahasiswa(@PathVariable int id) {
       service.deleteMahasiswa(id);
    }


}
