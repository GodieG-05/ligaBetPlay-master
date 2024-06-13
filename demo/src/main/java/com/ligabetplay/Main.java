package com.ligabetplay;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ligabetplay.models.Emparejamiento;
import com.ligabetplay.models.EmparejamientoDAO;
import com.ligabetplay.models.Equipo;
import com.ligabetplay.models.EquipoDAO;
public class Main {
    public static void main(String[] args) {
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        EquipoDAO equipoDAO = new EquipoDAO();
        Scanner sc = new Scanner(System.in);
        String menu = """
                ************************
                ***   LIGA BETPLAY   ***
                ************************
                [1] -> Registrar equipos
                [2] -> Registrar fecha
                [3] -> Modulo de equipos
                [4] -> Reporte
                [5] -> Salir
                Seleccion:     
                """;
        boolean isActive = true;
        while (isActive) {
            System.out.println(menu);
            try {
                int opMenu = sc.nextInt();
                sc.nextLine();
                switch (opMenu) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        int respuesta = 0;
                        while (respuesta == 0){
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            boolean tamañoListaEquipos = true;
                            while (tamañoListaEquipos) {
    
                                System.out.println("Ingrese nombre del equipo");
                                String nombreEquipo = sc.nextLine();
                                boolean equipoExiste = false;
                                for (Equipo equipo : equipos) {  
                                    if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                                        equipoExiste = true;
                                        break;
                                    }
                                }
                                if (equipoExiste) {
                                    System.out.println("El equipo ya existe");
                                } else {
                                    Equipo myTeam = new Equipo(nombreEquipo, 0,0,0,0,0,0,0);
                                    equipoDAO.createEquipo(myTeam);;                                    
                                };
                                if (equipos.size()%2 == 0){
                                    tamañoListaEquipos = false;
                                };
                            }
                            System.out.println("Para ingresar otro par de equipos presione 0");
                            try {
                                respuesta = sc.nextInt();
                                sc.nextLine();
                                
                            } catch (InputMismatchException e){
                                sc.next();
                                break;
                            };
                        }
                        System.out.print("\033[H\033[2J");
                        System.out.flush(); 
                        break;
    
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        ArrayList<Emparejamiento> emparejamientos = new ArrayList<Emparejamiento>();
                        EmparejamientoDAO emparejamientoDAO = new EmparejamientoDAO();
                        for (int i = 0; i < equipos.size() -1; i++){
                            for (int j = i+1; j < equipos.size(); j++){
                               Emparejamiento emparejamiento = new Emparejamiento(equipos.get(i), equipos.get(j));
                               emparejamientoDAO.createEmparejamiento(emparejamiento);
                            }
                        }   
                        emparejamientos.forEach(emparejamiento ->{
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("********** PARTIDO **********");
                            System.out.println("*** " + emparejamiento.toString() + " *** \n");
                            System.out.println("Ingrese goles anotados por " + emparejamiento.getEquipo1());
                            int goles1 = 0;
                            goles1 = sc.nextInt();
                            System.out.println("Ingrese goles anotados por " + emparejamiento.getEquipo2());;
                            int goles2 = 0;
                            goles2 = sc.nextInt();
                            sc.nextLine();
                            int pj1 = 1;
                            int pj2 = 1;
                            pj1 = emparejamiento.getEquipo1().getPJ() + pj1;
                            pj2 = emparejamiento.getEquipo2().getPJ() + pj2;
                            int gf1 = emparejamiento.getEquipo1().getGF() + goles1;
                            int gf2 = emparejamiento.getEquipo2().getGF() + goles2;
                            int gc1 = emparejamiento.getEquipo1().getGC() + goles2;
                            int gc2 = emparejamiento.getEquipo2().getGC() + goles1;
                            emparejamiento.getEquipo1().setPJ(pj1);
                            emparejamiento.getEquipo2().setPJ(pj2);
                            emparejamiento.getEquipo1().setGF(gf1);
                            emparejamiento.getEquipo2().setGF(gf2);
                            emparejamiento.getEquipo1().setGC(gc1);
                            emparejamiento.getEquipo2().setGC(gc2);
                            int tp = 0;
                            int pg = 0;
                            int pp = 0;
                            int pe1 = 0;
                            int pe2 = 0;
                            if (goles1 > goles2) {
                                pg = emparejamiento.getEquipo1().getPG() +1;
                                pp = emparejamiento.getEquipo2().getPP() + 1;
                                tp = emparejamiento.getEquipo1().getTP() +3;
                                emparejamiento.getEquipo1().setPG(pg);
                                emparejamiento.getEquipo2().setPP(pp);
                                emparejamiento.getEquipo1().setTP(tp);
                            } else if (goles1 < goles2) {
                                pg = emparejamiento.getEquipo2().getPG() +1;
                                pp = emparejamiento.getEquipo1().getPP() + 1;
                                tp = emparejamiento.getEquipo2().getTP() +3;
                                emparejamiento.getEquipo2().setPG(pg);
                                emparejamiento.getEquipo1().setPP(pp);
                                emparejamiento.getEquipo2().setTP(tp);
                            } else {
                                pe1 = emparejamiento.getEquipo1().getPE() +1;
                                pe2 = emparejamiento.getEquipo2().getPE() +1;
                                emparejamiento.getEquipo1().setPE(pe1);
                                emparejamiento.getEquipo2().setPE(pe2);
                                tp = emparejamiento.getEquipo1().getTP() +1;
                                emparejamiento.getEquipo1().setTP(tp);
                                tp = emparejamiento.getEquipo2().getTP() +1;
                                emparejamiento.getEquipo2().setTP(tp);
                            }
                            equipos.forEach(equipo ->{
                                System.out.println(String.format("\nEquipo: %s | PJ: %d | PG: %d | PE: %d | PP: %d | GF: %d | GC: %d | TP: %d |" , equipo.getNombre(), equipo.getPJ(), equipo.getPG(), equipo.getPE(), equipo.getPP(), equipo.getGF(), equipo.getGC(), equipo.getTP()));
                            });
                        });
                        System.out.println("\nHa terminado de asignar los resultados");
                        System.out.println("Presione enter para continuar");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        break;
                    case 3:
                        String menu2 = """
                            *************************
                            *** MÓDULO DE EQUIPOS ***
                            *************************
                            [1] -> Registrar Jugadores
                            [2] -> Registrar Cuerpo Técnico
                            [3] -> Registrar Cuerpo Médico
                            [4] -> Salir
                            Seleccion:     
                            """;
                            boolean isActive2 = true;
                            while (isActive2) {
                                System.out.println(menu2);
                                try {
                                    int opMenu2 = sc.nextInt();
                                    sc.nextLine();
                                    switch (opMenu2) {
                                        case 1:
                                    }    
                                } catch (InputMismatchException e){
                                    sc.next();
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush(); 
                                    System.out.println("La opción ingresada no es válida");
                                };        
                            }            
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        Equipo equipoMasGf = null;
                        Equipo equipoMasPt = null;
                        Equipo equipoMasPg = null;
                        int totalGoles = 0;
                        for (Equipo equipo : equipos) {
                            // Equipo con mas goles 
                            if (equipoMasGf == null || equipo.getGF() > equipoMasGf.getGF()) {
                                equipoMasGf = equipo;
                            }
                            // Equipo con mas puntos
                            if (equipoMasPt == null || equipo.getTP() > equipoMasPt.getTP()) {
                                equipoMasPt = equipo;
                            }
                            // Equipo con mas partidos ganados
                            if (equipoMasPg == null || equipo.getPG() > equipoMasPg.getPG()) {
                                equipoMasPg = equipo;
                            }
                            // Cantidad de goles anotados por todos los equipos
                            totalGoles += equipo.getGF();
                        }
                        // Promedio de goles anotados en el torneo
                        double promedioGoles = (double) totalGoles / equipos.size();
                        
                        System.out.println("A. EQUIPO QUE MAS GOLES ANOTÒ: " + (equipoMasGf != null ? equipoMasGf.getNombre() + " | " + equipoMasGf.getGF() + " goles |" : "N/A"));
                        System.out.println("B. EQUIPO CON MAS PUNTOS: " + (equipoMasPt != null ? equipoMasPt.getNombre() + " | " + equipoMasPt.getTP() + " TP |": "N/A"));
                        System.out.println("C. EQUIPO CON MAS PARTIDOS GANADOS: " + (equipoMasPg != null ? equipoMasPg.getNombre() + " | " + equipoMasPg.getPG() + " PG |": "N/A"));
                        System.out.println("D. TOTAL DE GOLES ANOTADOS EN EL TORNEO: " + (totalGoles));
                        System.out.println("E. PROMEDIO DE GOLES ANOTADOS EN EL TORNEO: " + (promedioGoles) + "\n");
                        System.out.println("Presione enter para continuar");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        System.out.flush(); 
                        break;
                    case 5:
                        isActive = false;
                        break;
                    default:
                        System.out.print("\033[H\033[2J");
                        System.out.flush(); 
                        System.out.println("La opción ingresada no es válida");
                        break;
                };
            } catch (InputMismatchException e){
                sc.next();
                System.out.print("\033[H\033[2J");
                System.out.flush(); 
                System.out.println("La opción ingresada no es válida");
            };
        } sc.close();
    } 
}