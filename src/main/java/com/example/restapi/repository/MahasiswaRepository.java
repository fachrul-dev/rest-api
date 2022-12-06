package com.example.restapi.repository;

import com.example.restapi.dto.DosenDto;
import com.example.restapi.dto.KampusDto;
import com.example.restapi.dto.MahasiswaDosen;
import com.example.restapi.entity.MahasiswaEntity;
import com.example.restapi.model.BaseResponse;
import com.example.restapi.model.BaseResponseV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MahasiswaRepository extends JpaRepository<MahasiswaEntity, Integer> {


    @Query(value = "select * from mahasiswa as m  inner join dosen as d on m.id_dosen = d.id where m.kelas = :kelas", nativeQuery = true)
    MahasiswaEntity findByKelas(@Param("kelas") String kelas);

    @Query(value = "select m.nama,d.nama_dosen as namaDosen from mahasiswa as m  inner join dosen as d on m.id_dosen = d.id", nativeQuery = true)
    ArrayList<MahasiswaDosen> getMahasiswaAndDosen();

//    @Query(value = "select * from mahasiswa as m  inner join dosen as d on m.id_dosen = d.id", nativeQuery = true)


    @Query(value = "select new com.example.restapi.dto.DosenDto() from dosen", nativeQuery = true)
    BaseResponse<DosenDto> getAllDosen();
}
