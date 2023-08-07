import java.util.Scanner;

public class GuestManager extends Database{
    static Scanner Consol = new Scanner(System.in);
    public static void ShowGuestMenu() throws InterruptedException{
        while (true){
            System.out.println("\u001B[1;34m"+"=== GUEST PANELİ ==="+"\u001B[0m");
            System.out.println("\u001B[1;36m"+"1- Kitap İşlemleri");
            System.out.println("2- Kayıt Talebi Oluştur");
            System.out.println("3- Kayıt Talebimi Göster");
            System.out.println("4- Oturumu Sonlandır"+"\u001B[0m");
            System.out.print("\u001B[1;33m"+"Seçiminiz:"+"\u001B[0m");
            String Secim = Consol.nextLine();
            switch (Secim.toUpperCase()){
                case "1":GuestBookMenu(); break;
                case "2":UyelikTalebiOlustur(); break;
                case "3":KayitTalebiGoster(); break;
                case "4":Helper.AnaMenu(); break;
                default: System.out.println("\u001B[1;31m"+"HATALI SEÇİM, TEKRAR DENEYİNİZ"+"\u001B[0m");
            }
        }
    }
    private static void GuestBookMenu() throws InterruptedException{
        while (true){
            System.out.println("\u001B[1;34m"+"=== KİTAP İŞLEMLERİ ==="+"\u001B[0m");
            System.out.println("\u001B[1;36m"+"1- Kitap Listesi");
            System.out.println("2- Yazardan Kitap Bul");
            System.out.println("3- Kitap Türü veya Yayın Tarihinden Kitap Bul");
            System.out.println("A- Bir Önceki Menü"+"\u001B[0m");
            System.out.print("\u001B[1;33m"+"Seçiminiz:"+"\u001B[0m");
            String Secim = Consol.nextLine();
            switch (Secim.toUpperCase()){
                case "1":BookProcessing.KitapListesiYazdir(); break;
                case "2":BookProcessing.YazardanKitapBul(); break;
                case "3":BookProcessing.TurVeyaYayinIleKitapBul(); break;
                case "A":ShowGuestMenu(); break;
                default: System.out.println("\u001B[1;31m"+"HATALI SEÇİM, TEKRAR DENEYİNİZ"+"\u001B[0m");
            }
        }
    }
    private static void UyelikTalebiOlustur() throws InterruptedException{
        System.out.println("=== ÜYELİK TALEBİ OLUŞTUR ===");
        String tcNO = "";
        while (true) {
            System.out.print("TC NO: ");
            tcNO = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!MemberProcessing.intControl(tcNO)) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            } else {
                System.out.println("\033[1;32mTC NO KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String isim = "";
        while (true) {
            System.out.print("İSİM: ");
            isim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!MemberProcessing.strControl(isim)) {
                System.out.println("\033[1;31mİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mİSİM KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String soyisim = "";
        while (true) {
            System.out.print("SOYİSİM: ");
            soyisim = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!MemberProcessing.strControl(soyisim)) {
                System.out.println("\033[1;31mSOYİSİM RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mSOYİSİM KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String Sehir = "";
        while (true) {
            System.out.print("ŞEHİR: ");
            Sehir = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!MemberProcessing.strControl(Sehir)) {
                System.out.println("\033[1;31mŞEHİR RAKAM VEYA UYGUNSUZ KARAKTER İÇEREMEZ\033[0m");
            } else {
                System.out.println("\033[1;32mŞEHİR KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String dYili = "";
        while (true) {
            System.out.print("DOĞUM YILI: ");
            dYili = Consol.nextLine();
            System.out.println("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            if (!MemberProcessing.intControl(dYili)) {
                System.out.println("\033[1;31mDOĞUM YILI SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            } else {
                System.out.println("\033[1;32mDOĞUM YILI KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String UyeBilgileri = isim + " , " + soyisim + " , " + Sehir + " , " + dYili;
        UyelerMap.put(tcNO, UyeBilgileri);
        System.out.println("İşleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\033[1;32m=== ÜYE TALEBİ ALINDI ===\033[0m");
    }
    private static void KayitTalebiGoster() throws InterruptedException{
        String tcNo = "";
        boolean HataliGiris = false;
        while (!HataliGiris) {
            try {
                System.out.print("TC Numaranızı Giriniz : ");
                tcNo = Consol.nextLine();
                Long.parseLong(tcNo);
                HataliGiris = true;
            } catch (NumberFormatException e) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            }
        }
        if (KayitTalepleriMap.containsKey(tcNo)) {
            System.out.println("Aranıyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            System.out.println("\u001B[1;32mTalebiniz işlem sırasındadır. Başvuru bilgileriniz aşağıdaki gibidir.\u001B[0m");
            System.out.println(KayitTalepleriMap.get(tcNo) + "\n");

        } else {
            System.out.println("\033[1;31mTALEP BULUNAMADI\033[0m");
        }
    }
}
