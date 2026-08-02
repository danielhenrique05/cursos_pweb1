package com.daniel.entities; // Substitua pelo pacote correto

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="aula")
public class Aula {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Column(name = "duracao_minutos", nullable = false)
    private Integer duracaoMinutos;

    @Column(name = "ordem", nullable = false)
    private Integer ordem;

    @Column(name = "url_video", nullable = false, length = 200)
    private String urlVideo;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;


  public Aula() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getDuracaoMinutos() {
    return duracaoMinutos;
  }

  public void setDuracaoMinutos(Integer duracaoMinutos) {
    this.duracaoMinutos = duracaoMinutos;
  }

  public Integer getOrdem() {
    return ordem;
  }

  public void setOrdem(Integer ordem) {
    this.ordem = ordem;
  }

  public String getUrlVideo() {
    return urlVideo;
  }

  public void setUrlVideo(String urlVideo) {
    this.urlVideo = urlVideo;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  

}