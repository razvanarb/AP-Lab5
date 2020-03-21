package Lab5.Compulsory;


import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/**
 * <p>Static count to associate unique IDs to documents.</p>
 *
 * Implements Serializable to allow Catalog to serialize its content
 */
public abstract class Document implements Serializable
{

    private static int count = 1;
    private int id;
    private String name;
   private HashMap<String, String> tags;
   public Document(String name)
   {
       this.name= name;
       this.tags = new HashMap<String, String>();
       id=count++;
   }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.tags.put("title", title);
    }

    public void setAuthor(String author) {
        this.tags.put("author", author);
    }

    public void setYear(int year) {
        this.tags.put("year", String.valueOf(year));
    }

    /**
     *  <p>Abstract method to be implemented in the LocalDoc and ExtDoc classes </p>
     *
     *  It will open the document using the native operating system application
     * @throws IOException
     */
    public abstract void view() throws IOException;
}
