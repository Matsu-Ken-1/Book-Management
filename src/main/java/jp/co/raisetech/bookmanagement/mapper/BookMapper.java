package jp.co.raisetech.bookmanagement.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.raisetech.bookmanagement.entity.BookForm;

@Mapper
public interface BookMapper {
	
	// 全件検索
	public List<BookForm> selectAll();
	
	// 指定IDの情報取得
	public BookForm findById(@Param("id") Long id);
	
	// 本の登録
	public int insert(@Param("book") BookForm book);
	
	// 本の更新
	public int update(@Param("book") BookForm book, @Param("id") int id);
	
	// 本の削除
	public int delete(@Param("id") Long id);

}
