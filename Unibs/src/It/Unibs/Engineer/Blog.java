package It.Unibs.Engineer;
import java.util.ArrayList;
/**
 * This class is used to add Post in blog and compare if there are other equal post in the same blog. 
 * @author Andrea
 *
 */
public class Blog {

	String name, url;
	ArrayList<Post> postList;

   public Blog(String name, String url){
		this.name = name;
		this.url = url;
		postList = new ArrayList<>();
	}
   
  /**
   * @return name of url and the number of post.
   */
   public String toString(){
	   	return (name + " - " + url + " " + "number post " + postList.size() + " ");
   }
   /**
    * This method is used to add post into a collection and search if there are
    * equal post. If so, it assigns a number to the post.
    * @param p
    */
   public void addPost(Post p){
	   postList.add(p);
	   for(int i = 0; i < postList.size(); i++){
		   if(p.equals(postList.get(i)))
			   p.number++;		   
	   }
   }
   /**
    * This method return description of blog, with all his post.
    * @return output
    */
   public String toStringFull(){
	   String output;
	   output = toString();
	   for(int i = 0; i < postList.size(); i++){
		   output = output + postList.get(i).toString(url);
	   }
	   return output;
   }
	   
   
}
