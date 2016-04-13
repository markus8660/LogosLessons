package aaa;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Main {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();

		session.getTransaction().begin();

		// session.save(new Author("joras"));

		// Author author = new Author("john");
		//
		// List<Book> books = new ArrayList<>();
		// books.add(new Book("one"));
		// books.add(new Book("two"));
		//
		// author.setBooks(books);
		// session.persist(author);

		// Book book = session.get(Book.class, 1);
		// System.out.println(book);

		// System.out.println(session.createQuery("from Author").list());
		// System.out.println(session.createQuery("select a.name from Author
		// a").list());
		//
		// System.out.println(session.createCriteria(Author.class).add(Restrictions.between("id",
		// 1, 2)).list());

		// Author authorMerge = session.get(Author.class, 1);
		//
		// List<Book> books = new ArrayList<Book>();
		//
		// Book book = session.get(Book.class, 1);
		// Book book2 = session.get(Book.class, 2);
		// books.add(book);
		// books.add(book2);
		//
		// authorMerge.setBooks(books);
		// session.merge(authorMerge);

		// Book book = session.get(Book.class, 1);
		// Book book2 = session.get(Book.class, 2);
		//
		// Author author = session.get(Author.class, 1);
		//
		//
		// book.setAuthor(author);
		// book2.setAuthor(author);
		//
		// session.merge(book2);
		// session.merge(book);

		System.out.println();
		Query query = session.createQuery("from Author a join a.books");
		List<Object[]> objects = query.list();
		for (Object[] object : objects) {
			for (Object object2 : object) {
				System.out.println((Author) object2);
			}

		}

		// MAPPING!
		session.getTransaction().commit();

		session.close();

		factory.close();

	}

}
