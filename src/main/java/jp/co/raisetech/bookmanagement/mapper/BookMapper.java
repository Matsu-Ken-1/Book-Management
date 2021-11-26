package jp.co.raisetech.bookmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.raisetech.bookmanagement.entity.BookForm;

@Mapper
public interface BookMapper {
	
	// 全件検索
	public List<BookForm> selectAll();

}
