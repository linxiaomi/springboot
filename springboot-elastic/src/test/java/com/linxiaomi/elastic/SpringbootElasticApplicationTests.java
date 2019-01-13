package com.linxiaomi.elastic;

import com.linxiaomi.elastic.bean.Article;
import com.linxiaomi.elastic.bean.Book;
import com.linxiaomi.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticApplicationTests {

	@Autowired
	JestClient jestClient;

	@Autowired
	BookRepository bookRepository;

	@Test
	public void test01() {
		Book book = new Book();
		book.setId(1);
		book.setBookName("红楼梦");
		book.setAuthor("曹雪芹");
		bookRepository.index(book);

		for (Book book : bookRepository.findByBookNameLike("红")) {
			System.out.println(book.getBookName());
		}
	}

	@Test
	public void contextLoads() {

		// 执行完以下代码后，可以用http://192.168.1.107:9200/linxiaomi/news/1 来验证

		// 1、给ES中索引(保存)一个文档
		Article article = new Article();
		article.setId(1);
		article.setTile("good news");
		article.setAuthor("hanhan");
		article.setContent("Hello World");

		Index index = new Index.Builder(article).index("linxiaomi").type("news").build();

		try {
			jestClient.execute(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void search() {

		// 查询表达式
		String json = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"content\" : \"hello\"\n" +
				"        }\n" +
				"    }\n" +
				"}";
		// 构建搜索功能
		Search build = new Search.Builder(json).addIndex("linxiaomi").addType("news").build();
		// 执行
		try {
			SearchResult searchResult = jestClient.execute(build);
			System.out.println(searchResult.getJsonString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

