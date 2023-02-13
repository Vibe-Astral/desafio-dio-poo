package br.com.desafiopoo.dominio;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
  private String nome;
  private Set<Conteudo> conteudosinscritos = new LinkedHashSet<>();
  private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

  public void inscreverBootcamp(Bootcamp bootcamp) {
    this.conteudosinscritos.addAll(bootcamp.getConteudos());
    bootcamp.getDevsIncritos().add(this);  
  }

  public void progredir() {
    Optional<Conteudo> conteudo = this.conteudosinscritos.stream().findFirst();
    if(conteudo.isPresent()){
      this.conteudosConcluidos.add(conteudo.get());
      this.conteudosinscritos.remove(conteudo.get());

    }else{
      System.err.println("voce nao esta matriculado em nenhum conteudo  ");
    }
  }

  public double calcularTotalXp() {
    return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Conteudo> getConteudosinscritos() {
    return conteudosinscritos;
  }

  public void setConteudosinscritos(Set<Conteudo> conteudosinscritos) {
    this.conteudosinscritos = conteudosinscritos;
  }

  public Set<Conteudo> getConteudosConcluidos() {
    return conteudosConcluidos;
  }

  public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
    this.conteudosConcluidos = conteudosConcluidos;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((conteudosinscritos == null) ? 0 : conteudosinscritos.hashCode());
    result = prime * result + ((conteudosConcluidos == null) ? 0 : conteudosConcluidos.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Dev other = (Dev) obj;
    if (nome == null) {
      if (other.nome != null)
        return false;
    } else if (!nome.equals(other.nome))
      return false;
    if (conteudosinscritos == null) {
      if (other.conteudosinscritos != null)
        return false;
    } else if (!conteudosinscritos.equals(other.conteudosinscritos))
      return false;
    if (conteudosConcluidos == null) {
      if (other.conteudosConcluidos != null)
        return false;
    } else if (!conteudosConcluidos.equals(other.conteudosConcluidos))
      return false;
    return true;
  }
  
  
}