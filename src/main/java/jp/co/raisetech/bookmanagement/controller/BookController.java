package jp.co.raisetech.bookmanagement.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.raisetech.bookmanagement.entity.Book;
import jp.co.raisetech.bookmanagement.entity.Genre;
import jp.co.raisetech.bookmanagement.service.BookService;
import jp.co.raisetech.bookmanagement.service.GenreService;

@Controller
@RequestMapping("/")
public class BookController {
	
	@Autowired
	BookService service;
	
	@Autowired
	GenreService genre;
	
	// 一覧画面の表示
	@GetMapping("/index")
	public String index(Book book, Model model) {
		List<Book> list = service.getBookList();
		model.addAttribute("list", list);
		return "/index";
	}
	
	// 検索結果の受け取り処理
	@GetMapping("/search")
    public String select(@ModelAttribute("book") Book book, Model model) {

        //bookdataのゲッターで各値を取得する
        List<Book> result = service.search(book.getGenre(),book.getBookname(), book.getAuthor());
        model.addAttribute("list", result);

        return "/index";
    }
	
	// 新規入力フォームの表示
	@GetMapping("/form")
	public String form(@ModelAttribute Book book, Model model) {
		
		// ジャンルのプルダン項目取得
		List<Genre> genreList = genre.getGenreList();
		model.addAttribute("genreList", genreList);
		
		return "/form";
	}
	
	// 新規入力データの保存
	@PostMapping("/")
	public String create(Book book) {
		service.create(book);
		return "redirect:/index";
	}
	
	// 編集フォームの表示
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable int id) {
		Book book = service.findById(id);
		model.addAttribute("book", book);
		return "/edit";
	}
	
	// 編集データの保存
	@PostMapping("/edit/{id}")
	public String update(Book book, @PathVariable int id) {
		service.update(book, id);
		return "redirect:/index";
	}
	
	// データの削除
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/index";
	}
	
}
