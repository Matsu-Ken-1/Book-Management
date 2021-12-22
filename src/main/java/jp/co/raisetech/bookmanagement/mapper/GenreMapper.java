package jp.co.raisetech.bookmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.raisetech.bookmanagement.entity.Genre;

@Mapper
public interface GenreMapper {
	
	// 全件検索
	public List<Genre> selectAll();

}
