import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Database {
    static Map<String,String>UyelerMap=new HashMap<>();
    static Map<String,String>KitaplarMap=new HashMap<>();
    static Map<String,String>OduncKitaplarMap=new HashMap<>();
    static Map<String,String>KayitTalepleriMap=new HashMap<>();
    static ArrayList<String> YonetimeTalepler;
    static Map<String, ArrayList<String>> TumTalepler = new TreeMap<>();
    public static void baslangicUyelerVeritabaniOlustur() {
        UyelerMap.put("469922399405", "Ali, Can, İzmir, 2008");
        UyelerMap.put("165776787406", "Hikmet, Ran, Ankara, 2000");
        UyelerMap.put("143244487408", "Ayşe, Can, Mersin, 1995");
        UyelerMap.put("648643787403", "Ahmet, Yesil, Adana, 2003");
        UyelerMap.put("123245967407", "Zehra, Kara, İzmir, 1979");
        UyelerMap.put("124366976453", "Betül, Usluer, İstanbul, 2005");
        UyelerMap.put("125422676778", "Oktay, Sarı, İstanbul, 1999");
        UyelerMap.put("129390405664", "Bahtiyar, Gül, Siirt, 1983");
        UyelerMap.put("654322503029", "Ali Hikmet, Yaşar, İzmir, 1983");
        UyelerMap.put("212454369848", "Nermin, Tan, Ankara, 1983");
    }
    public static void baslangicKitaplarVeritabaniOlustur() {
        KitaplarMap.put("A Tale of Two Cities", "Charles Dickens, TARIH, 1859");
        KitaplarMap.put("Ten Little Niggers", "Agatha Christie, POLISIYE, 1939");
        KitaplarMap.put("Le Petit Prince", "Antoine de Saint-Exupery, KURGU, 1943");
        KitaplarMap.put("The Hobbit", "J. R. R. Tolkien, KURGU, 1937");
        KitaplarMap.put("The Lord of the Rings", "J. R. R. Tolkien, KURGU, 1954-1955");
        KitaplarMap.put("Hong lou meng", "Cao Xueqin, DESTAN, 1759-1791");
        KitaplarMap.put("Simyaci", "Paulo Coelho, ROMAN, 1988");
        KitaplarMap.put("Hayvan Ciftligi", "George Orwell, ROMAN, 1945");
        KitaplarMap.put("Bindokuzyuzseksendort", "George Orwell, ROMAN, 1949");
        KitaplarMap.put("Harry Potter", "J.K. Rowling, KURGU, 1997");
    }
    public static void oduncKitaplarVeritabaniOlustur(){
        OduncKitaplarMap.put("The Hobbit", "J. R. R. Tolkien, KURGU, 1937");
        OduncKitaplarMap.put("The Lord of the Rings", "J. R. R. Tolkien, KURGU, 1954-1955");
        OduncKitaplarMap.put("Harry Potter", "J.K. Rowling, KURGU, 1997");
    }
    public static void UyeTalepleriVeritabaniOlustur(){
        KayitTalepleriMap.put("469922399499", "Burhan, Şengül, İzmir, 1995");
        KayitTalepleriMap.put("165776787498", "Fatih, Karahanlı, Samsun, 1994");
        KayitTalepleriMap.put("143244487497", "Secan, Işık, Batman, 1990");
    }
}
