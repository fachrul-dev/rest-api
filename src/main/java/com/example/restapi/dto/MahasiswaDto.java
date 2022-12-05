package com.example.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaDto {

    @NotNull(message = "Nama Tidak Boleh Kosong")
    private String nama;

    @Email(message = "Email Not Valid")
    private String email;

    @NotNull(message = "Alamat Tidak Boleh Kosong")
    private String alamat;

    @NotNull(message = "Kelas Tidak Boleh Kosong")
    private String kelas;
}
