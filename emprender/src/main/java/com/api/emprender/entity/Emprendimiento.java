package com.api.emprender.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ingrese nombre de Emprendimiento")
    private String nombre;
    @NotEmpty(message = "Ingrese descripcion de Emprendimiento")
    private String descripcion;
    @NotEmpty(message = "Ingrese Contenido de Emprendimiento")
    private String contenido;
    @CreationTimestamp
    private LocalDate fechaDeCreacion;
    private LocalDate fechaDeModificacion;
    private Double objetivo;
    private Boolean publicado;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean activo = true;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario owner;
    private String url;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "emprendimiento_id",
            joinColumns = @JoinColumn(name = "emprendimiento_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tags> tags = new ArrayList<Tags>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "emprendimientoId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Voto> votos = new ArrayList<Voto>();
    private Integer contadorDeVotos = 0;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Evento> eventos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public LocalDate getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public void setFechaDeModificacion(LocalDate fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public Double getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Double objetivo) {
        this.objetivo = objetivo;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getOwner() {
        return owner.getUsername();
    }

    public void setOwner() {
        setOwner();
    }

    public void setOwner(Usuario owner) {
        this.owner = owner;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public void addTags(Tags tag) {
        tags.add(tag);
        tag.getEmprendimientos().add(this);
    }

    public void addEvento(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Voto> getVotos() {
        return votos;
    }

    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

    public Integer getContadorDeVotos() {
        return contadorDeVotos;
    }

    public void setContadorDeVotos(Integer contadorDeVotos) {
        this.contadorDeVotos = contadorDeVotos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void agregarEvento(Evento evento) {
        if (this.eventos == null) {
            this.eventos = new ArrayList<>();
        }
        this.eventos.add(evento);

    }

    public Boolean getPublicado() {
        return publicado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Emprendimiento(Long id, String nombre, String descripcion, String contenido, LocalDate fechaDeCreacion, LocalDate fechaDeModificacion, Double objetivo, Boolean publicado, Boolean activo, Usuario owner, String url, List<Tags> tags, List<Voto> votos, Integer contadorDeVotos, List<Evento> eventos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.objetivo = objetivo;
        this.publicado = publicado;
        this.activo = activo;
        this.owner = owner;
        this.url = url;
        this.tags = tags;
        this.votos = votos;
        this.contadorDeVotos = contadorDeVotos;
        this.eventos = eventos;
    }
    public Emprendimiento() {

    }

    @Override
    public String toString() {
        return "Emprendimiento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contenido='" + contenido + '\'' +
                ", fechaDeCreacion=" + fechaDeCreacion +
                ", fechaDeModificacion=" + fechaDeModificacion +
                ", objetivo=" + objetivo +
                ", publicado=" + publicado +
                ", activo=" + activo +
                ", owner=" + owner +
                ", url='" + url + '\'' +
                ", tags=" + tags +
                ", votos=" + votos +
                ", contadorDeVotos=" + contadorDeVotos +
                ", eventos=" + eventos +
                '}';
    }
}
