package It.Unibs.Engineer;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * test
 * @author Andrea
 *
 */

public class BlogMain {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner lettore = new Scanner(System.in);
		String name = lettore.nextLine();
		String URL = lettore.nextLine();
		Blog b = new Blog(name, URL);
		System.out.println(b.toString());
		GregorianCalendar date = new GregorianCalendar();
		String title = lettore.nextLine();
		String author = lettore.nextLine();
		String text = lettore.nextLine();
		Post p1 = new Post(title, author, text, date);
		System.out.println(p1.getPermalink());
		String title1 = lettore.nextLine();
		String author1 = lettore.nextLine();
		String text1 = lettore.nextLine();
		Post p2 = new Post(title1, author1, text1, date);
		b.addPost(p1);
		b.addPost(p2);
		System.out.println(b.toStringFull());
	}

}
