package jp.co.raisetech.bookmanagement; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BookController {
	
	private JdbcTemplate jdbcTemplate;
	
	// コンストラクタ
	@Autowired
	public BookController(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// 一覧画面の表示
	@GetMapping("/index")
	public String index(Model model) {
		String sql = "SELECT * FROM bookinfo";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
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
		String sql = "INSERT INTO bookinfo(genre, bookname, author, publisher, comment) VALUES(?, ?, ?, ?, ?);";
		jdbcTemplate.update(sql, bookForm.getGenre(), bookForm.getBookname(), bookForm.getAuthor(), bookForm.getPublisher(), bookForm.getComment());
		return "redirect:/index";
	}
	
	// 編集フォームの表示
	@GetMapping("/edit/{id}")
	public String edit(@ModelAttribute BookForm bookForm, @PathVariable int id) {
		String sql = "SELECT * FROM bookinfo WHERE id = " + id;
		Map<String, Object> map = jdbcTemplate.queryForMap(sql);
		bookForm.setId((int)map.get("id"));
		bookForm.setGenre((String)map.get("genre"));
		bookForm.setBookname((String)map.get("bookname"));
		bookForm.setAuthor((String)map.get("author"));
		bookForm.setPublisher((String)map.get("publisher"));
		bookForm.setComment((String)map.get("Comment"));
		return "/edit";
	}
	
	// 編集データの保存
	@PostMapping("/edit/{id}")
	public String update(BookForm bookForm, @PathVariable int id) {
		String sql = "UPDATE bookinfo SET genre = ?, bookname = ?, author = ?, publisher = ?, comment = ? WHERE id = " + id;
		jdbcTemplate.update(sql, bookForm.getGenre(), bookForm.getBookname(), bookForm.getAuthor(), bookForm.getPublisher(), bookForm.getComment());
		return "redirect:/index";
	}
	
	// データの削除
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		String sql = "DELETE from bookinfo WHERE id = " + id;
		jdbcTemplate.update(sql);
		return "redirect:/index";
	}
	
}
