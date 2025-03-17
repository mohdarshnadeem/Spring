package com.arsh.SpringDataJpaPart3;

import com.arsh.SpringDataJpaPart3.Question5and6.entities.Author1;
import com.arsh.SpringDataJpaPart3.Question5and6.entities.Book1;
import com.arsh.SpringDataJpaPart3.Question5and6.repos.AuthorRepository1;
import com.arsh.SpringDataJpaPart3.Question7.entities.Author2;
import com.arsh.SpringDataJpaPart3.Question7.entities.Book2;
import com.arsh.SpringDataJpaPart3.Question7.repos.AuthorRepository2;
import com.arsh.SpringDataJpaPart3.Question8.entities.Author3;
import com.arsh.SpringDataJpaPart3.Question8.entities.Book3;
import com.arsh.SpringDataJpaPart3.Question8.repos.AuthorRepository3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringDataJpaPart3ApplicationTests {

	AuthorRepository1 authorRepository1;
	AuthorRepository2 authorRepository2;
	AuthorRepository3 authorRepository3;

	@Autowired
	public SpringDataJpaPart3ApplicationTests(AuthorRepository1 authorRepository1, AuthorRepository2 authorRepository2, AuthorRepository3 authorRepository3) {
		this.authorRepository1 = authorRepository1;
		this.authorRepository2 = authorRepository2;
		this.authorRepository3 = authorRepository3;
	}

	@Test
	public void testCreateAuthor1(){
		Author1 author1 = new Author1();
		author1.setFirstName("Arsh");
		author1.setLastName("Nadeem");

		Book1 book = new Book1();
		book.setName("Where the crawdads sing");

		author1.setBook1(book);
		authorRepository1.save(author1);
	}

	@Test
	public void testCreateAuthor2(){
		Author2 author2 = new Author2();
		author2.setFirstName("Arsh");
		author2.setLastName("Nadeem");

		List<Book2> bookList = new ArrayList<>();
		Book2 book1 = new Book2();
		book1.setName("Where the crawdads sing");
		Book2 book2 = new Book2();
		book2.setName("Gulliver travels");
		bookList.add(book1);
		bookList.add(book2);

		author2.setBook2(bookList);
		authorRepository2.save(author2);
	}

	@Test
	public void testCreateAuthor3(){
		Author3 author1 = new Author3();
		author1.setFirstName("Arsh");
		author1.setLastName("Nadeem");

		Author3 author2 = new Author3();
		author2.setFirstName("Ravi");
		author2.setLastName("Kumar");

		Book3 book1 = new Book3();
		book1.setName("Where the Crawdads Sing");

		Book3 book2 = new Book3();
		book2.setName("Gulliver's Travels");

		author1.setBook3(Arrays.asList(book1,book2));
		author2.setBook3(Arrays.asList(book1));

		authorRepository3.save(author1);
		authorRepository3.save(author2);
	}
}
