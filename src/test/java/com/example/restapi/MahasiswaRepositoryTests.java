package com.example.restapi;

import com.example.restapi.entity.MahasiswaEntity;
import com.example.restapi.repository.MahasiswaRepository;
import com.example.restapi.service.MahasiswaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class MahasiswaRepositoryTests {

    @Autowired
    private MahasiswaRepository repository;

//    @Test
//    public void testFindMahasiswaByKelas() {
//        String kelas = "TIF16A";
//        List<MahasiswaEntity> list = repository.findByKelas(kelas);
//        list.forEach(System.out::println);
//    }

//    @Test
//    public void testGetMahasiswaAndDosen() {
//        int limit = 10;
//        MahasiswaEntity list = repository.getMahasiswaAndDosen(limit);
//        list.(System.out::println);
//
//    }
}
