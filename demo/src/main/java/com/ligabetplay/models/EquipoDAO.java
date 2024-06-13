package com.ligabetplay.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {
    private static final String FILE_PATH = "equioos.json";
    private List<Equipo> equipos;
    private Gson gson;

    public EquipoDAO() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        equipos = loadEquipos();
    }

    private List<Equipo> loadEquipos() {
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

    private void saveEquipos() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(equipos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEquipo(Equipo equipo) {
        equipos.add(equipo);
        saveEquipos();
    }

    public List<Equipo> readEquipos() {
        return new ArrayList<>(equipos);
    }

    public void updateEquipo (Equipo udpadateEquipo) {
        for (int i = 0; i < equipos.size(); i++) {
            if (equipos.get(i).getNombre() == udpadateEquipo.getNombre()) {
                equipos.set(i, udpadateEquipo);
                saveEquipos();
                return;
            }
        }
    }

    public void deleteEquipo(String nombre) {
        equipos.removeIf(equipo -> equipo.getNombre() == nombre);
        saveEquipos();
    }


}