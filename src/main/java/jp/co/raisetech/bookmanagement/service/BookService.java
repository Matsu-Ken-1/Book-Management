package jp.co.raisetech.bookmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.raisetech.bookmanagement.entity.Book;
import jp.co.raisetech.bookmanagement.mapper.BookMapper;

@Service
public class BookService {
	
	@Autowired
	BookMapper mapper;
	
	// 本のリストを全件取得
	public List<Book> getBookList() {
		return mapper.selectAll();
	}
	
	// 指定IDのデータ取得
	public Book findById(int id) {
		return mapper.findById(id);
	}
	
	// 本の登録
	public void create(Book book) {
		mapper.insert(book);
	}
	
	// 本の更新
	public void update(Book book, int id) {
//		return mapper.update(book, id);
		mapper.update(book, id);
	}
	
	// 本の削除
	public void delete(int id) {
//		return mapper.delete(id);
		mapper.delete(id);
	}
	
	// 本の検索
    public List<Book> search(String genre, String bookname, String author){

        List<Book> result = new ArrayList<Book>();

        //すべてブランクだった場合は全件検索する
        if ("".equals(genre) && "".equals(bookname) && "".equals(author)){
            result = mapper.selectAll();
        }
        else {
            //上記以外の場合、BookDataDaoImplのメソッドを呼び出す
            result = mapper.search(genre, bookname, author);
        }
        return result;
    }
	
	

}
