package com.example.restapi.service;

import com.example.restapi.dto.DosenDto;
import com.example.restapi.dto.KampusDto;
import com.example.restapi.dto.MahasiswaDosen;
import com.example.restapi.dto.MahasiswaDto;
import com.example.restapi.entity.MahasiswaEntity;
import com.example.restapi.model.BaseResponse;
import com.example.restapi.model.BaseResponseV2;
import com.example.restapi.model.ListMahasiswa;
import com.example.restapi.repository.MahasiswaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@Slf4j
public class MahasiswaServiceImpl implements MahasiswaService{

    @Autowired
    private MahasiswaRepository repository;


    @Override
    public MahasiswaEntity addMahasiswa(MahasiswaEntity body) {
        return repository.save(body);
    }

    @Override
    public MahasiswaEntity getMahasiswaByKelas(MahasiswaDto kelas) {
        return repository.findByKelas(kelas.getKelas());
    }

    @Override
    public BaseResponseV2 getMahasiswaAndDosen() {
        BaseResponseV2 baseResponseV2 = new BaseResponseV2<>();

        try {
            log.info("data {}" ,repository.getMahasiswaAndDosen().size());
            log.info("bebas apa {}", repository.getMahasiswaAndDosen().isEmpty()?"kosong":repository.getMahasiswaAndDosen());
            baseResponseV2.setSuccess(true);
            baseResponseV2.setMessage("berhhasil");
            baseResponseV2.setData(repository.getMahasiswaAndDosen());
            return  baseResponseV2;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return BaseResponseV2.builder()
                .success(false)
                .message("Gagal")
                .data(null).build();
    }

    @Override
    public BaseResponse<DosenDto> getAllDosen() {
        return repository.getAllDosen();
    }

    @Override
    public MahasiswaEntity addMahasiswa2(MahasiswaDto body) {
        MahasiswaEntity mahasiswa = MahasiswaEntity.builder()
                .nama(body.getNama())
                .kelas(body.getKelas())
                .email(body.getEmail())
                .alamat(body.getAlamat())
                .build();
        return repository.save(mahasiswa);
    }

    @Override
    public List<MahasiswaEntity> getMahasiswa() {
        return repository.findAll();
    }

    @Override
    public List<MahasiswaEntity> getMahasiswa2() {
        return null;
    }


    public void deleteMahasiswa(int id) {
       repository.deleteById(id);
    }

    @Override
    public BaseResponseV2 saveDataMahasiswa(MahasiswaDto body) {
        List<MahasiswaEntity> mahasiswa = Collections.singletonList(repository.save(MahasiswaEntity.builder()
                .nama(body.getNama())
                .alamat(body.getAlamat())
                .email(body.getEmail())
                .kelas(body.getKelas())
                .build()));
        return BaseResponseV2.builder()
                .success(true)
                .message("Success")
                .data(ListMahasiswa.builder().mahasiswa(mahasiswa).total(mahasiswa.size()).build())
                .build();
    }

    @Override
    public BaseResponseV2 getDataMahasiswa() {
        List<MahasiswaEntity> mahasiswa = repository.findAll();
        return BaseResponseV2.builder()
                .success(true)
                .message("Success")
                .data(ListMahasiswa.builder().mahasiswa(mahasiswa).total(mahasiswa.size()).build())
                .build();
    }


}
