package com.example.restapi.service;

import com.example.restapi.dto.DosenDto;
import com.example.restapi.dto.MahasiswaDosen;
import com.example.restapi.dto.MahasiswaDto;
import com.example.restapi.entity.MahasiswaEntity;
import com.example.restapi.model.BaseResponse;
import com.example.restapi.model.BaseResponseV2;

import java.util.List;

public interface MahasiswaService {

    MahasiswaEntity addMahasiswa(MahasiswaEntity body);

    MahasiswaEntity getMahasiswaByKelas(MahasiswaDto kelas);

    List<MahasiswaDosen> getMahasiswaAndDosen();

    BaseResponse<DosenDto> getAllDosen();

    MahasiswaEntity addMahasiswa2(MahasiswaDto body);

    List<MahasiswaEntity> getMahasiswa();

    List<MahasiswaEntity> getMahasiswa2();


    void deleteMahasiswa(int id);

    BaseResponseV2 saveDataMahasiswa(MahasiswaDto body);

    BaseResponseV2 getDataMahasiswa();
}
