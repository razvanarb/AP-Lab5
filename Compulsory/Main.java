package Lab5.Compulsory;

public class Main {

    public static void main(String[] args) throws Exception {

        Catalog catalog1 = new Catalog("Cat1");
        LocalDoc lDoc1 = new LocalDoc("Local Doc 1", "C:\\Users\\Razvand\\Desktop\\NTD1.txt");
        ExtDoc extDoc1= new ExtDoc("External Doc 1", "https://profs.info.uaic.ro/~acf/java/labs/lab_05.html");

        catalog1.addDocument(lDoc1);
        catalog1.addDocument(extDoc1);

        System.out.println(lDoc1.getId());
        System.out.println(extDoc1.getId());

        lDoc1.view();
        extDoc1.view();

        catalog1.save("C:\\Users\\Razvand\\Desktop\\Catalogul_" + catalog1.getName());
        catalog1.load( "C:\\Users\\Razvand\\Desktop\\Catalogul_Cat1");
        catalog1.printCatalog();

    }
}
