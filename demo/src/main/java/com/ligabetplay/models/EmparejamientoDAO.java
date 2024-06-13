package com.ligabetplay.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmparejamientoDAO {
    private static final String FILE_PATH = "emparejamientos.json";
    private List<Emparejamiento> emparejamientos;
    private Gson gson;

    public EmparejamientoDAO() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        emparejamientos = loadEmparejamientos();
    }

    private List<Emparejamiento> loadEmparejamientos() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type lisType = new TypeToken<ArrayList<Equipo>>() {}.getType();
            return gson.fromJson(reader, lisType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Si el archivo no existe, devolver una lista vacia
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveEmparejamientos() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(emparejamientos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEmparejamiento(Emparejamiento emparejamiento) {
        emparejamientos.add(emparejamiento);
        saveEmparejamientos();
    }

    public List<Emparejamiento> readEmparejamientos() {
        return new ArrayList<>(emparejamientos);
    }

    // public void updateEmparejamiento (Emparejamiento udpadateEmparejamiento) {
    //     for (int i = 0; i < emparejamientos.size(); i++) {
    //         if (emparejamientos.get(i).getEquipo1() == udpadateEquipo.getNombre()) {
    //             emparejamientos.set(i, udpadateEquipo);
    //             saveEmparejamientos();
    //             return;
    //         }
    //     }
    // }

    // public void deleteEmparejamiento(String nombre) {
    //     emparejamientos.removeIf(equipo -> equipo.getNombre() == nombre);
    //     saveEmparejamientos();
    // }


}