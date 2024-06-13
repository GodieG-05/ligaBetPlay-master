package com.ligabetplay.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {
    private static final String FILE_PATH = "jugdores.json";
    private List<Jugador> jugadores;
    private Gson gson;

    public JugadorDAO() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        jugadores = loadJugadores();
    }

    private List<Jugador> loadJugadores() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type lisType = new TypeToken<ArrayList<Jugador>>() {}.getType();
            return gson.fromJson(reader, lisType);
        } catch (FileNotFoundException e) {
            return new ArrayList<>(); // Si el archivo no existe, devolver una lista vacia
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void saveJugadores() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(jugadores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createJugador(Jugador jugador) {
        jugadores.add(jugador);
        saveJugadores();
    }

    public List<Jugador> readJugadores() {
        return new ArrayList<>(jugadores);
    }

    public void updateJugador (Jugador udpadateJugador) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getDorsal() == udpadateJugador.getDorsal()) {
                jugadores.set(i, udpadateJugador);
                saveJugadores();
                return;
            }
        }
    }

    public void deleteJugador(int dorsal) {
        jugadores.removeIf(jugador -> jugador.getDorsal() == dorsal);
        saveJugadores();
    }


}
