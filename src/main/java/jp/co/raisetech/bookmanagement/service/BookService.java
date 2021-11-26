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
	
	// ブックリストを全件取得
	public List<BookForm> getBookList() {
		return mapper.selectAll();
	}

}
