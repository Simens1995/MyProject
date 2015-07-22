package It.Unibs.Engineer;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * This class is used to create a post.
 * @author Andrea
 *
 */
public class Post {
	String title, author, text;
	GregorianCalendar date;
	int number = 0;
	
   
	public Post(String title, String author, String text, GregorianCalendar date){
		this.title = title;
		this.author = author;
		this.text = text;
		this.date = date;
	}
	/**
	 * @return description of post
	 */
	public String toString(){
		return (title + " of " + author + " - " + text + " - published on " + this.date.get(Calendar.DAY_OF_MONTH) + "/" + (this.date.get(Calendar.MONTH)+1) + "/" + this.date.get(Calendar.YEAR));
	}
	/**
	 * 
	 * @return permalink
	 */
	public String getPermalink(){
		String t;
		t =title.toLowerCase().replaceAll("[^a-zA-Z_]", "").replaceAll(" ", "-");
		 return ("/" + t + (number != 0 ? number : "") + ".html" + " ");
	}
	/**
	 * 
	 * @param url
	 * @return description of post plus url and permalink
	 */
	public String toString(String url){
		return (title + " of " + author + " - published on " + this.date.get(Calendar.DAY_OF_MONTH) + "/" + (this.date.get(Calendar.MONTH)+1) + "/" + this.date.get(Calendar.YEAR) + " " + url + getPermalink() + " ");
	}

}
