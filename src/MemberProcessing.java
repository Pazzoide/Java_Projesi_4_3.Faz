import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MemberProcessing extends Database {
    static Scanner Consol = new Scanner(System.in);

    public static void UyeListesiYazdir() throws InterruptedException {
        System.out.print("Üye Listesi Yazdırılıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println(
                "\033[1;36m\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "    =========== ÜYE LİSTESİ ==========\n" +
                        "   TC NO        İSİM - SOYİSİM - ŞEHİR - D.YILI\033[0m");
        for (Map.Entry<String, String> X : UyelerMap.entrySet()) {
            System.out.println(X.getKey() + " - " + X.getValue() + " | ");
        }
    }

    public static void SoyisimdenUyeBul() throws InterruptedException {
        boolean anahtar = true;
        System.out.print("Aradığınız üyenin soyisminin tamamını ya da bir kısmını giriniz: ");
        String uyeSoyad = Consol.nextLine();
        System.out.println(
                "\033[1;36m\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== SOYİSİM İLE ÜYE ARAMA ==========\n" +
                        "   TC NO        İSİM - SOYİSİM - ŞEHİR - D.YILI\033[0m");

        for (Map.Entry<String, String> uyelerEntrySet : UyelerMap.entrySet()) {
            String[] Parca = uyelerEntrySet.getValue().split(", ");
            if (Parca[1].contains(uyeSoyad) || uyeSoyad.equalsIgnoreCase(Parca[1])) {
                System.out.println(uyelerEntrySet.getKey() + " " + uyelerEntrySet.getValue() + " | ");
                anahtar = false;
            }
        }
        if (anahtar) {
            System.out.println("\n\033[1;31mBelirtilen bilgiler ile eşleşen bir üye mevcut değildir.\033[0m\n");
        }
    }

    public static void SehreGoreUyeBul() throws InterruptedException {
        boolean anahtar = true;
        System.out.print("Aranan Şehir Adı: ");
        String Sehir = Consol.nextLine();
        System.out.print("Aranıyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println(
                "\033[1;36m\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== ŞEHİR İLE ÜYE ARAMA ==========\n" +
                        "   TC NO        İSİM - SOYİSİM - ŞEHİR - D.YILI\033[0m");
        for (Map.Entry<String, String> X : UyelerMap.entrySet()) {
            if (X.getValue().contains(Sehir)) {
                System.out.println(X.getKey() + " - " + X.getValue() + " | ");
                anahtar = false;
            }
        }
        if (anahtar) {
            System.out.println("\033[1;31mBelirtilen Şehre Ait Üyelik Mevcut Değildir\033[0m");
        }
    }

    public static void UyeEkleme() throws InterruptedException {
        System.out.println("=== ÜYELİK KAYDI ===");
        String tcNO = "";
        while (true) {
            System.out.print("TC NO: ");
            tcNO = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!intControl(tcNO)) {
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
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!strControl(isim)) {
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
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!strControl(soyisim)) {
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
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!strControl(Sehir)) {
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
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!intControl(dYili)) {
                System.out.println("\033[1;31mDOĞUM YILI SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            } else {
                System.out.println("\033[1;32mDOĞUM YILI KABUL EDİLDİ\033[0m");
                break;
            }
        }
        String UyeBilgileri = isim + " , " + soyisim + " , " + Sehir + " , " + dYili;
        UyelerMap.put(tcNO, UyeBilgileri);
        KayitTalepleriMap.remove(tcNO);
        System.out.print("İşleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        System.out.println("\033[1;32m=== ÜYE KAYDI TAMAMLANDI ===\033[0m");
    }

    public static void TcNoIleUyeSil() throws InterruptedException {
        System.out.println("=== TC NO İLE ÜYE KAYDI SİLME ===");
        String tcNo = "";
        boolean HataliGiris = false;
        while (!HataliGiris) {
            try {
                System.out.print("TC NO: ");
                tcNo = Consol.nextLine();
                Long.parseLong(tcNo);
                HataliGiris = true;
            } catch (NumberFormatException e) {
                System.out.println("\033[1;31mTC NO SADECE RAKAMLARDAN OLUŞMALIDIR\033[0m");
            }
        }
        if (UyelerMap.containsKey(tcNo)) {
            String silinecekUyeBilgisi = UyelerMap.get(tcNo);
            UyelerMap.remove(tcNo);
            System.out.print(silinecekUyeBilgisi + " " + "siliniyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            System.out.println("\033[1;32mÜYE BAŞARIYLA SİLİNDİ\033[0m");
        } else {
            System.out.println("\033[1;31mÜYE BULUNAMADI\033[0m");
        }
    }

    public static void KayitTalepYazdir() throws InterruptedException {
        System.out.println("=== ÜYE KAYIT TALEPLERİ ===");
        System.out.print("Talepler Görüntüleniyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println();
        for (Map.Entry<String, String> X : KayitTalepleriMap.entrySet()) {
            System.out.println(X.getKey() + " " + X.getValue());
        }
    }

    public static void YonetimTalepKontrol() throws InterruptedException {
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
        if (TumTalepler.containsKey(tcNo)) {
            System.out.print("Aranıyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            YonetimeTalepler = TumTalepler.get(tcNo);
            System.out.println("\033[1;36m\n" + "               TALEPLERİNİZ" + "\033[0m");
            for (String talep : YonetimeTalepler) {
                System.out.println("=----------------------------------------=");
                System.out.println(talep);
                System.out.println("\033[1;32m\n" + "TALEBİNİZ İŞLEM SIRASINDADIR.\n-" +
                        " BAŞVURU TARİHİNDEN SONRAKİ 15 İŞ GÜNÜ İÇİNDE TARAFINIZA TALEBİNİZ İLE İLGİLİ GERİ DÖNÜŞ SAĞLANACAKTIR -" + "\033[0m\n");
            }
        } else {
            System.out.println("\033[1;31mTALEP BULUNAMADI\033[0m");
        }
    }

    public static boolean strControl(String str) {
        String regex = "^[a-zA-ZçÇğĞıİöÖşŞü]+$";
        return Pattern.matches(regex, str);
    }

    public static boolean intControl(String str) {
        String regex = "^[0-9]+$";
        return Pattern.matches(regex, str);
    }
}
