package com.example.restapi.repository;

import com.example.restapi.dto.DosenDto;
import com.example.restapi.dto.MahasiswaDosen;
import com.example.restapi.entity.MahasiswaEntity;
import com.example.restapi.model.BaseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MahasiswaRepository extends JpaRepository<MahasiswaEntity, Integer> {

    @Query(value = "select * from mahasiswa as m  inner join dosen as d on m.id_dosen = d.id where m.kelas = :kelas", nativeQuery = true)
    MahasiswaEntity findByKelas(@Param("kelas") String kelas);

    @Query(value = "select new com.example.restapi.dto.MahasiswaDosen(m.nama,d.nama_dosen) from MahasiswaEntity as m  inner join DosenEntity as d on m.id_dosen = d.id")
    List<MahasiswaDosen> getMahasiswaAndDosen();

//    @Query(value = "select * from mahasiswa as m  inner join dosen as d on m.id_dosen = d.id", nativeQuery = true)


    @Query(value = "select new com.example.restapi.dto.DosenDto() from dosen", nativeQuery = true)
    BaseResponse<DosenDto> getAllDosen();
}
