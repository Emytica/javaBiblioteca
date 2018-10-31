package it.corsojava.testmaven.vo;

import java.time.LocalDateTime;

public class LibriVo {

	private int id;
	private String nome;
	private String autore;
	private String isbn;
	private String disponibilita;
	private LocalDateTime dataPublicazione;

	public LocalDateTime getDataPublicazione() {
		return dataPublicazione;
	}

	public void setDataPublicazione(LocalDateTime dataPublicazione) {
		this.dataPublicazione = dataPublicazione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDisponibilita() {
		return disponibilita;
	}

	public void setDisponibilita(String disponibilita) {
		this.disponibilita = disponibilita;
	}

	@Override
	public String toString() {
		return "LibriVo [id=" + id + ", nome=" + nome + ", autore=" + autore + ", isbn=" + isbn + ", disponibilita="
				+ disponibilita + "]";
	}

}
