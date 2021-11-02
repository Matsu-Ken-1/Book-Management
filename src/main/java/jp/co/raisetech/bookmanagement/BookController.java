package jp.co.raisetech.bookmanagement; 

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping
	public String index(Model model) {
		String sql = "SELECT * FROM bookinfo";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		model.addAttribute("list", list);
		return "/index";
	}
	
}
