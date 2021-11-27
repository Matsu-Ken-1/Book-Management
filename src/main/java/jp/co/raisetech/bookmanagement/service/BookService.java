package jp.co.raisetech.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.raisetech.bookmanagement.entity.BookForm;
import jp.co.raisetech.bookmanagement.mapper.BookMapper;

@Service
public class BookService {
	
	@Autowired
	BookMapper mapper;
	
	// 本のリストを全件取得
	public List<BookForm> getBookList() {
		return mapper.selectAll();
	}
	
	// 本の登録
	public int create(BookForm book) {
		return mapper.insert(book);
	}
	
	// 本の削除
	public int delete(Long id) {
		return mapper.delete(id);
	}

}
