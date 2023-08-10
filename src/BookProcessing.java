import java.util.EnumSet;
import java.util.Map;
import java.util.Scanner;

public class BookProcessing extends Database {
    static Scanner Consol = new Scanner(System.in);

    public static void KitapListesiYazdir() throws InterruptedException {
        System.out.print("\u001B[1;32m"+"Kitap Listesi Yazdırılıyor..."+"\u001B[0m");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println("                \u001B[1;32m=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("                ======== KİTAP LİSTESİ ========\u001B[0m");
        for (Map.Entry<String, String> X : KitaplarMap.entrySet()) {
            if (OduncKitaplarMap.containsKey(X.getKey())) {
                System.out.print("\033[1;31m" + "\n ÖDÜNÇ VERİLDİ " + "\033[0m");
            } else {
                System.out.print("\033[1;32m" + "\n        MEVCUT " + "\033[0m");
            }
            System.out.print(X.getKey() + " - " + X.getValue() + " | ");
        }
        System.out.println();
    }

    public static void YazardanKitapBul() throws InterruptedException {
        boolean anahtar = true;
        System.out.print("\u001B[1;35m"+"Yazar Adı: "+"\u001B[0m");
        String Yazar = Consol.nextLine();
        System.out.println("\u001B[1;32m"+"Aranıyor..."+"\u001B[0m");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println("                \u001B[1;32m=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("                ======== ARANAN YAZAR ========\u001B[0m");
        for (Map.Entry<String, String> X : KitaplarMap.entrySet()) {
            String[] valueParca = X.getValue().toLowerCase().split(", ");
            if (valueParca[0].contains(Yazar.toLowerCase()) || valueParca[0].equalsIgnoreCase(Yazar)) {
                if (OduncKitaplarMap.containsKey(X.getKey())) {
                    System.out.print("\033[1;31m" + "\n ÖDÜNÇ VERİLDİ " + "\033[0m");
                } else {
                    System.out.print("\033[1;32m" + "\n        MEVCUT " + "\033[0m");
                }
                System.out.print(X.getKey() + " - " + X.getValue() + " | ");
                anahtar = false;
            }
        }
        System.out.println("\n");
        if (anahtar) {
            System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen Yazara Ait Kitap Mevcut Değildir\033[0m\n\n");
        }
    }

    public static void TurVeyaYayinIleKitapBul() throws InterruptedException {
        System.out.println("\033[1;32m" + EnumSet.allOf(BookTypes.class) + "\033[0m");
        System.out.print("\033[1;35m"+"İstediğiniz kitabın türünü yazınız : "+"\u001B[0m");
        String KitapTuru = Consol.nextLine();
        System.out.print("\033[1;35m"+"İstediğiniz kitabın yayın tarihi : "+"\u001B[0m");
        String YayinTarihi = Consol.nextLine();
        System.out.println();
        System.out.println("                \u001B[1;32m=== TECHNO STUDY CONFLUENCE ===");
        System.out.println("                ======== KİTAP LİSTESİ ========\u001B[0m");
        boolean anahtar = true;
        for (Map.Entry<String, String> K : KitaplarMap.entrySet()) {
            String[] eachValuarr = K.getValue().split(", ");
            if (KitapTuru.equalsIgnoreCase(eachValuarr[1]) || YayinTarihi.equalsIgnoreCase(eachValuarr[2])) {
                if (OduncKitaplarMap.containsKey(K.getKey())) {
                    System.out.print("\033[1;31m" + "\n ÖDÜNÇ VERİLDİ " + "\033[0m");
                } else {
                    System.out.print("\033[1;32m" + "\n        MEVCUT " + "\033[0m");
                }
                System.out.print(K.getKey() + " " + K.getValue());
                anahtar = false;
            }
        }
        System.out.println();
        if (anahtar) {
            System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen bilgiler ile eşleşen bir kitap mevcut değildir\033[0m\n\n");
        }
        System.out.println();
    }

    public static void KitapEkle() throws InterruptedException {
        System.out.print("\033[1;35m"+"Kitap Adı: "+"\u001B[0m");
        String kitapAdi = Consol.nextLine();
        System.out.print("\033[1;35m"+"Yazar Adı: "+"\u001B[0m");
        String yazarAdi = Consol.nextLine();
        BookTypes kitapTuru = null;
        while (kitapTuru == null) {
            System.out.print("\033[1;35m"+"Kitap Türü: " + EnumSet.allOf(BookTypes.class) + ": "+"\u001B[0m");
            String kTur = Consol.nextLine().toUpperCase();
            switch (kTur) {
                case "TARİH":
                    kitapTuru = BookTypes.TARIH;
                    break;
                case "POLİSİYE":
                    kitapTuru = BookTypes.POLISIYE;
                    break;
                case "KURGU":
                    kitapTuru = BookTypes.KURGU;
                    break;
                case "ROMAN":
                    kitapTuru = BookTypes.ROMAN;
                    break;
                case "DESTAN":
                    kitapTuru = BookTypes.DESTAN;
                    break;
                case "TANIMLANMAMIŞ TÜR":
                    kitapTuru = BookTypes.TANIMLANMAMIS_TUR;
                    break;
                default:
                    System.out.print("\033[1;31m" + "Hatalı Giriş! Lütfen Kitap Türünü Tekrar Giriniz!\033[0m\n\n");
            }
        }
        System.out.print("\033[1;35m"+"Yayın Tarihi: "+"\u001B[0m");
        int yayinYili = 0;
        boolean GecersizGiris = false;
        while (!GecersizGiris) {
            try {
                yayinYili = Integer.parseInt(Consol.nextLine());
                GecersizGiris = true;
            } catch (NumberFormatException e) {

                System.out.print("\033[1;42m" + "\033[1;31m" + "Hatalı Giriş! Lütfen Sayı Giriniz!\033[0m\n\n");

            }
        }
        String kitapBilgileri = yazarAdi + ", " + kitapTuru + ", " + yayinYili;
        KitaplarMap.put(kitapAdi, kitapBilgileri);

        System.out.println("\033[1;32m\nKitap Başarıyla Eklendi!\033[0m\n");
    }

    public static void IsimleKitapSil() throws InterruptedException {
        System.out.print("\033[1;35m"+"Silinecek kitabin ismini giriniz: "+"\u001B[0m");
        String silinecekKitap = Consol.nextLine();
        String silinecekValue = KitaplarMap.get(silinecekKitap);
        String sonucValue = KitaplarMap.remove(silinecekKitap);
        System.out.print(silinecekKitap + " Siliniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.print("\033[1;42m" + "\033[1;31m" + "İstediğiniz kitap ismi bulunamadı!\033[0m\n\n");
        }
    }

    public static void KitapOduncAl() throws InterruptedException {
        System.out.print("\033[1;35m"+"Ödünç almak istediğiniz kitabın ismini giriniz: "+"\u001B[0m");
        String kitapAdi = Consol.nextLine();
        if (!OduncKitaplarMap.containsKey(kitapAdi)) {
            if (KitaplarMap.containsKey(kitapAdi)) {
                System.out.println("\033[1;32m\n" + kitapAdi + " adlı kitap ödünç olarak verilmiştir." + "\033[0m\n");
                OduncKitaplarMap.put(kitapAdi, "");
            } else {
                System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen isim ile bir kitap mevcut değildir!\033[0m\n\n");
            }
        } else {
            System.out.print("\033[1;42m" + "\033[1;31m" + kitapAdi + " adlı kitap daha önce ödünç alınmış!\033[0m\n" +
                    "\033[1;42m" + "\033[1;31m" + "İade edildikten sonra ödünç alabilirsiniz.. \033[0m\n");
        }
    }

    public static void KitapIadeEt() throws InterruptedException {
        System.out.println("\033[1;35m"+"İade etmek istediğiniz kitabın ismini giriniz: "+"\u001B[0m");
        String kitapAdi = Consol.nextLine();
        if (KitaplarMap.containsKey(kitapAdi) && OduncKitaplarMap.containsKey(kitapAdi)) {
            System.out.println("\033[1;32m\n" + kitapAdi + " adlı kitap iade alınmıştır." + "\033[0m\n");
            OduncKitaplarMap.remove(kitapAdi);
        } else {
            System.out.print("\033[1;42m" + "\033[1;31m" + "Belirtilen isim ile bir kitap mevcut değildir!\033[0m\n\n");
        }
    }
}
