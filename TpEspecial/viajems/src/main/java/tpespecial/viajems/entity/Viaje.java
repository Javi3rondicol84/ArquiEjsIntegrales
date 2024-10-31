package tpespecial.viajems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Viaje {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idViaje;
    private Long idMonopatin;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private double kilometros;
    private String parada;
    private boolean pausa;
    private LocalTime tiempoPausado;
    private double precio;
    private double tarifaExtra;

    public Viaje(Long idMonopatin, LocalDate fechaIni, LocalDate fechaFin, LocalTime horaInicio, LocalTime horaFin, double kilometros, String parada, boolean pausa, LocalTime tiempoPausado, double precio, double tarifaExtra) {
        this.idMonopatin = idMonopatin;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.kilometros = kilometros;
        this.parada = parada;
        this.pausa = pausa;
        this.tiempoPausado = tiempoPausado;
        this.precio = precio;
        this.tarifaExtra = tarifaExtra;
    }

    public Viaje() {
    }

    /*public Long getIdViaje() {
        return idViaje;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public LocalTime getTiempoPausado() {
        return tiempoPausado;
    }

    public void setTiempoPausado(LocalTime tiempoPausado) {
        this.tiempoPausado = tiempoPausado;
    }*/
}
