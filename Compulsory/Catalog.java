package Lab5.Compulsory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    /**
     * The Catalog class implements Serializable in order to make objects serializable
     */

    private String name;
    private List<Document> documents;

    public Catalog(String name)
    {
        this.name= name;
        this.documents= new ArrayList<Document>();
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Adauga un document nou intr-un catalog doar daca acela documente nu se afla deja in catalog.
     *
     * @param doc
     * @throws Exception
     */
    public void addDocument(Document doc) throws Exception {
        if(documents.contains(doc)) {
            throw new Exception("The document is already in the catalog");
        }
        documents.add(doc);
        System.out.println(doc.getName() + " added successfully to the catalog");
    }

    /**
     * Salveaza  catalogul intr-un fisier extern folosind object serialization
     * @param path unde se va salva fisierul
     */
    public void save(String path){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fos);

            out.writeObject(this);
            System.out.println("Catalogul saved successfully");
            out.close();
            fos.close();
        }
        catch (IOException exc) {
            System.out.println("Error: " + exc.getMessage());
        }
    }

    /**
     * Deschide   catalogul aflat la un anumit path folosind object serialization
     * @param path unde este salvat fisierul
     */
    public Catalog load(String path) throws IOException, ClassNotFoundException {
        Catalog cat= null;
        if(!new File(path).exists())
            throw new FileNotFoundException("Cale invalida: " + path + " !");
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fis);
        cat = (Catalog)in.readObject();
        in.close();
        fis.close();
        System.out.println("Catalogul loaded successfully");
        return cat;
    }

    public void printCatalog()
    {
        System.out.println("Catalogul "+ this.getName() + " are urmatoarele documente:");
        for(Document doc : documents)
                System.out.println(doc.getName());

    }
}
