package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaDto {

    private int id;

    private String nama;

    private String alamat;

    private String kelas;

    private String email;

    private int id_dosen;

    private String nama_dosen;
}
