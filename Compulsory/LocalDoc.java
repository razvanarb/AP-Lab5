package Lab5.Compulsory;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LocalDoc extends Document {

    private String path;

    public LocalDoc(String name, String path) {
        super(name);
        this.path= path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void view() throws IOException {
        Desktop.getDesktop().open(new File(path));
        System.out.println(this.getPath() +" opened successfully");
    }
}
