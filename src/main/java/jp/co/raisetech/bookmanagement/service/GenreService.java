package jp.co.raisetech.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.raisetech.bookmanagement.entity.Genre;
import jp.co.raisetech.bookmanagement.mapper.GenreMapper;

@Service
public class GenreService {
	
	@Autowired
	GenreMapper mapper;
	
	// ジャンルリストを取得
	public List<Genre> getGenreList() {
		return mapper.selectAll();
	}

}
