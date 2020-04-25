package org.yurii.zhurakovskyi.hibernate.mapping.hibernate_mappings;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("/META-INF/hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Post post1 = new Post();
		post1.setTitle("First post");
		Comment comment1 = new Comment();
		comment1.setAuthorName("Andrew Stevens");
		comment1.setPost(post1);
		Comment comment2 = new Comment();
		comment2.setAuthorName("Oleg Markov");
		comment2.setPost(post1);
		Comment comment3 = new Comment();
		comment3.setAuthorName("George Brown");
		comment3.setPost(post1);
		post1.setComments(new HashSet<>(Arrays.asList(comment1, comment2, comment3)));

		Post post2 = new Post();
		post2.setTitle("Second post");
		Comment comment4 = new Comment();
		comment4.setAuthorName("Andrew Stevens");
		comment4.setPost(post2);
		Comment comment5 = new Comment();
		comment5.setAuthorName("Oleg Markov");
		comment5.setPost(post2);
		Comment comment6 = new Comment();
		comment6.setAuthorName("George Brown");
		comment6.setPost(post2);
		post2.setComments(new HashSet<>(Arrays.asList(comment4, comment5, comment6)));

		Post post3 = new Post();
		post3.setTitle("Third post");
		Comment comment7 = new Comment();
		comment7.setAuthorName("Andrew Stevens");
		comment7.setPost(post3);
		Comment comment8 = new Comment();
		comment8.setAuthorName("Oleg Markov");
		comment8.setPost(post3);
		Comment comment9 = new Comment();
		comment9.setAuthorName("George Brown");
		comment9.setPost(post3);
		post3.setComments(new HashSet<>(Arrays.asList(comment7, comment8, comment9)));

		Transaction transaction = session.beginTransaction();
		session.save(post1);
		session.save(post2);
		session.save(post3);
		transaction.commit();

		Post postFromDataBase1 = (Post) session.get(Post.class, 1);
		System.out.println(postFromDataBase1 + "\n " + postFromDataBase1.getComments() + "\n");

		Post postFromDatabase2 = (Post) session.get(Post.class, 2);
		System.out.println(postFromDatabase2 + "\n " + postFromDatabase2.getComments() + "\n");

		Post postFromDatabase3 = (Post) session.get(Post.class, 3);
		System.out.println(postFromDatabase3 + "\n " + postFromDatabase3.getComments() + "\n");

		Comment commentFromDatabase1 = (Comment) session.get(Comment.class, 1);
		System.out.println(commentFromDatabase1 + "\n " + commentFromDatabase1.getPost() + "\n");
		Comment commentFromDatabase2 = (Comment) session.get(Comment.class, 2);
		System.out.println(commentFromDatabase2 + "\n " + commentFromDatabase2.getPost() + "\n");
		Comment commentFromDatabase3 = (Comment) session.get(Comment.class, 3);
		System.out.println(commentFromDatabase3 + "\n " + commentFromDatabase3.getPost() + "\n");
		Comment commentFromDatabase4 = (Comment) session.get(Comment.class, 4);
		System.out.println(commentFromDatabase4 + "\n " + commentFromDatabase4.getPost() + "\n");
		Comment commentFromDatabase5 = (Comment) session.get(Comment.class, 5);
		System.out.println(commentFromDatabase5 + "\n " + commentFromDatabase5.getPost() + "\n");
		Comment commentFromDatabase6 = (Comment) session.get(Comment.class, 6);
		System.out.println(commentFromDatabase6 + "\n " + commentFromDatabase6.getPost() + "\n");
		Comment commentFromDatabase7 = (Comment) session.get(Comment.class, 7);
		System.out.println(commentFromDatabase7 + "\n " + commentFromDatabase7.getPost() + "\n");
		Comment commentFromDatabase8 = (Comment) session.get(Comment.class, 8);
		System.out.println(commentFromDatabase8 + "\n " + commentFromDatabase8.getPost() + "\n");
		Comment commentFromDatabase9 = (Comment) session.get(Comment.class, 9);
		System.out.println(commentFromDatabase9 + "\n " + commentFromDatabase9.getPost() + "\n");

	}
}
