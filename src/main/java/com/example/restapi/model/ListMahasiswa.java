package com.example.restapi.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class ListMahasiswa<T> {

    private T mahasiswa;

    private int total;
}
