package com.music;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "music")
public class Music {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	@Column(name = "music_name")
	private String MusicName;
	@Column(name = "artist")
	private String Artist;
	@Column(name = "genre")
	private String Genere;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMusicName() {
		return MusicName;
	}
	public void setMusicName(String musicName) {
		MusicName = musicName;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String artist) {
		Artist = artist;
	}
	public String getGenere() {
		return Genere;
	}
	public void setGenere(String genere) {
		Genere = genere;
	}
	

}
