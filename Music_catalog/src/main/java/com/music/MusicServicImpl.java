package com.music;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicServicImpl implements MusicService {
	@Autowired
	MusicRepository musicrepo;
	public List<Music> getmusic() {
		// TODO Auto-generated method stub
		
		return musicrepo.findAll();
	}
	
	public List<Music> findByKeyword(String keyword) {
		return musicrepo.findByKeyword(keyword);
	}
	@Override
	public void saveMusic(Music music) {
		// TODO Auto-generated method stub
		this.musicrepo.save(music);
	}
	@Override
	public Music getMusicById(long id) {
		Optional<Music> optional = musicrepo.findById(id);
		Music music = null;
		if (optional.isPresent()) {
			music = optional.get();
		} else {
			throw new RuntimeException(" musicf not found for id :: " + id);
		}
		return music;
	}
	@Override
	public void deleteMusicById(long id) {
		this.musicrepo.deleteById(id);
		
	}


}
