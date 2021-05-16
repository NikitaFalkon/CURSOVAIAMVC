package com.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Norma;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Converter {

    private final static String baseFile = "normals.json";

    public static void toJSON(ArrayList<Norma> norma) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), norma);
    }

    public static ArrayList<Norma> toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), ArrayList.class);
    }

}