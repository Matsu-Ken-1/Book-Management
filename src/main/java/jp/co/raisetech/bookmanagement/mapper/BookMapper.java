package jp.co.raisetech.bookmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.raisetech.bookmanagement.entity.BookForm;

@Mapper
public interface BookMapper {
	
	// 全件検索
	public List<BookForm> selectAll();
	
	// 本の登録
	public int insert(@Param("book") BookForm book);
	
	// 本の削除
	public int delete(@Param("id") Long id);

}
