package jp.co.raisetech.bookmanagement.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.raisetech.bookmanagement.entity.BookForm;
import jp.co.raisetech.bookmanagement.service.BookService;

@Controller
@RequestMapping("/")
public class BookController {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	BookService service;
	
	// コンストラクタ
	@Autowired
	public BookController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// 一覧画面の表示
	@GetMapping("/index")
	public String index(Model model) {
		List<BookForm> list = service.getBookList();
		model.addAttribute("list", list);
		return "/index";
	}
	
	// 新規入力フォームの表示
	@GetMapping("/form")
	public String form(@ModelAttribute BookForm bookform) {
		return "/form";
	}
	
	// 新規入力データの保存
	@PostMapping("/")
	public String create(BookForm bookForm) {
//		String sql = "INSERT INTO bookinfo(genre, bookname, author, publisher, comment) VALUES(?, ?, ?, ?, ?);";
//		jdbcTemplate.update(sql, bookForm.getGenre(), bookForm.getBookname(), bookForm.getAuthor(), bookForm.getPublisher(), bookForm.getComment());
		service.create(bookForm);
		return "redirect:/index";
	}
	
	// 編集フォームの表示
	@GetMapping("/edit/{id}")
//	public String edit(@ModelAttribute BookForm bookForm, @PathVariable Long id) {
	public String edit(Model model, @PathVariable Long id) {
//		String sql = "SELECT * FROM bookinfo WHERE id = " + id;
//		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		BookForm bookForm = service.findById(id);
//		bookForm.setId((int)bookForm.getId());
//		bookForm.setGenre((String)bookForm.getGenre());
//		bookForm.setBookname((String)bookForm.getBookname());
//		bookForm.setAuthor((String)bookForm.getAuthor());
//		bookForm.setPublisher((String)bookForm.getPublisher());
//		bookForm.setComment((String)bookForm.getComment());
//		BeanUtils.copyProperties(bookForms, bookForm);
		model.addAttribute("bookForm", bookForm);
		return "/edit";
	}
	
	// 編集データの保存
	@PostMapping("/edit/{id}")
	public String update(BookForm bookForm, @PathVariable int id) {
//		String sql = "UPDATE bookinfo SET genre = ?, bookname = ?, author = ?, publisher = ?, comment = ? WHERE id = " + id;
//		jdbcTemplate.update(sql, bookForm.getGenre(), bookForm.getBookname(), bookForm.getAuthor(), bookForm.getPublisher(), bookForm.getComment());
		service.update(bookForm, id);
		return "redirect:/index";
	}
	
	// データの削除
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
//		String sql = "DELETE from bookinfo WHERE id = " + id;
//		jdbcTemplate.update(sql);
		service.delete(id);
		return "redirect:/index";
	}
	
}
