package com.music;

import java.util.List;

public interface MusicService {

	List <Music> getmusic();
	void saveMusic(Music music);
	Music getMusicById(long id);

	void deleteMusicById(long id);
	List <Music> findByKeyword(String keyword);
}
