package Lab5.Compulsory;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class ExtDoc extends Document {

    private String url;
    public ExtDoc(String name, String url) {
        super(name);
        this.url= url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url= url;
    }

    @Override
    public void view() throws IOException {
        Desktop.getDesktop().browse(URI.create(url));
        System.out.println(this.getUrl() + " opened successfully");
    }
}
