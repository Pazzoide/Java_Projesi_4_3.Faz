import java.util.Scanner;

public class AdminManager {
    static Scanner Consol = new Scanner(System.in);
    public static void ShowAdminMenu() throws InterruptedException{
        while (true){
            System.out.println("\u001B[1;34m"+"=== ADMIN PANELİ ==="+"\u001B[0m");
            System.out.println("\u001B[1;36m"+"1- Üye İşlemleri");
            System.out.println("2- Kitap İşlemleri");
            System.out.println("3- Oturumu Sonlandır"+"\u001B[0m");
            System.out.print("\u001B[1;33m"+"Seçiminiz:"+"\u001B[0m");
            String Secim=Consol.nextLine();
            switch (Secim){
                case "1":AdminMemberMenu(); break;
                case "2":AdminBookMenu(); break;
                case "3":Helper.AnaMenu(); break;
                default: System.out.println("\u001B[1;31m"+"HATALI SEÇİM, TEKRAR DENEYİNİZ"+"\u001B[0m");
            }
        }
    }
    private static void AdminMemberMenu()throws InterruptedException{
        String Secim="";
        while (!Secim.equalsIgnoreCase("A")){
            System.out.println("\u001B[1;34m"+"=== ÜYE İŞLEMLERİ ==="+"\u001B[0m");
            System.out.println("\u001B[1;36m"+"1- Üye Listesi Yazdır");
            System.out.println("2- Soyisimden Üye Bul");
            System.out.println("3- Şehre Göre Üye Bul");
            System.out.println("4- Üye Ekleme");
            System.out.println("5- Kimlik No ile Kayıt Silme");
            System.out.println("6- Kayıt Taleplerini Görüntüle");
            System.out.println("7- Üye Taleplerini Görüntüle");
            System.out.println("A- Bir Önceki Menü"+"\u001B[0m");
            System.out.print("\u001B[1;33m"+"Seçiminiz:"+"\u001B[0m");
            Secim=Consol.nextLine();
            switch (Secim){
                case "1":MemberProcessing.UyeListesiYazdir(); break;
                case "2":MemberProcessing.SoyisimdenUyeBul(); break;
                case "3":MemberProcessing.SehreGoreUyeBul(); break;
                case "4":MemberProcessing.UyeEkleme(); break;
                case "5":MemberProcessing.TcNoIleUyeSil(); break;
                case "6":MemberProcessing.KayitTalepYazdir(); break;
                case "7":MemberProcessing.YonetimTalepKontrol(); break;
                case "A":ShowAdminMenu(); break;
                default: System.out.println("\u001B[1;31m"+"HATALI SEÇİM, TEKRAR DENEYİNİZ"+"\u001B[0m");
            }
        }
    }
    private static void AdminBookMenu()throws InterruptedException{
        String Secim="";
        while (!Secim.equalsIgnoreCase("A")){
            System.out.println("\u001B[1;34m"+"=== KİTAP İŞLEMLERİ ==="+"\u001B[0m");
            System.out.println("\u001B[1;36m"+"1- Kitap Listesi");
            System.out.println("2- Yazardan Kitap Bul");
            System.out.println("3- Kitap Türü veya Yayın Tarihinden Kitap Bul");
            System.out.println("4- Kitap Ekle");
            System.out.println("5- Kitap Sil");
            System.out.println("6- Kitap Ödünç Al");
            System.out.println("7- Kitap İade Et");
            System.out.println("A- Bir Önceki Menü"+"\u001B[0m");
            System.out.print("\u001B[1;33m"+"Seçiminiz:"+"\u001B[0m");
            Secim=Consol.nextLine();
            switch (Secim){
                case "1":BookProcessing.KitapListesiYazdir(); break;
                case "2":BookProcessing.YazardanKitapBul(); break;
                case "3":BookProcessing.TurVeyaYayinIleKitapBul(); break;
                case "4":BookProcessing.KitapEkle(); break;
                case "5":BookProcessing.IsimleKitapSil(); break;
                case "6":BookProcessing.KitapOduncAl(); break;
                case "7":BookProcessing.KitapIadeEt(); break;
                case "A":ShowAdminMenu(); break;
                default: System.out.println("\u001B[1;31m"+"HATALI SEÇİM, TEKRAR DENEYİNİZ"+"\u001B[0m");
            }
        }
    }
}
