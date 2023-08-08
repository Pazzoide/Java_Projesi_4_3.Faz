import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManager extends Database {
    static Scanner Consol = new Scanner(System.in);
    private static int numara = 1000;

    public static void ShowUserMenu() throws InterruptedException {
        while (true) {
            System.out.println("\u001B[1;34m" + "=== USER PANELİ ===" + "\u001B[0m");
            System.out.println("\u001B[1;36m" + "1- Kitap İşlemleri");
            System.out.println("2- Yönetimden Talepte Bulun");
            System.out.println("3- Taleplerimi Görüntüle");
            System.out.println("4- Oturumu Sonlandır" + "\u001B[0m");
            System.out.print("\u001B[1;33m" + "Seçiminiz:" + "\u001B[0m");
            String Secim = Consol.nextLine();
            switch (Secim) {
                case "1":
                    System.out.println("\u001B[1;32m" + "Yükleniyor..." + "\u001B[0m");
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(100);
                        System.out.print(">");
                    }
                    System.out.println();
                    UserBookMenu();
                    break;
                case "2":
                    YonetimdenTalep();
                    break;
                case "3":
                    TalepleriGoruntule();
                    break;
                case "4":
                    System.out.println("\u001B[1;32m" + "Oturum Kapatılıyor..." + "\u001B[0m");
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(100);
                        System.out.print(">");
                    }
                    System.out.println();
                    Helper.AnaMenu();
                    break;
                default:
                    System.out.println("\u001B[1;31m" + "HATALI SEÇİM, TEKRAR DENEYİNİZ" + "\u001B[0m");
            }
        }
    }

    private static void UserBookMenu() throws InterruptedException {
        while (true) {
            System.out.println("\u001B[1;34m" + "=== KİTAP İŞLEMLERİ ===" + "\u001B[0m");
            System.out.println("\u001B[1;36m" + "1- Kitap Listesi");
            System.out.println("2- Yazardan Kitap Bul");
            System.out.println("3- Kitap Türü veya Yayın Tarihinden Kitap Bul");
            System.out.println("4- Kitap Ödünç Al");
            System.out.println("5- Kitap İade Et");
            System.out.println("A- Bir Önceki Menü" + "\u001B[0m");
            System.out.print("\u001B[1;33m" + "Seçiminiz:" + "\u001B[0m");
            String Secim = Consol.nextLine();
            switch (Secim.toUpperCase()) {
                case "1":
                    BookProcessing.KitapListesiYazdir();
                    break;
                case "2":
                    BookProcessing.YazardanKitapBul();
                    break;
                case "3":
                    BookProcessing.TurVeyaYayinIleKitapBul();
                    break;
                case "4":
                    BookProcessing.KitapOduncAl();
                    break;
                case "5":
                    BookProcessing.KitapIadeEt();
                    break;
                case "A":
                    System.out.println("\u001B[1;32m" + "Yükleniyor..." + "\u001B[0m");
                    for (int i = 0; i < 20; i++) {
                        Thread.sleep(100);
                        System.out.print(">");
                    }
                    System.out.println();
                    ShowUserMenu();
                    break;
                default:
                    System.out.println("\u001B[1;31m" + "HATALI SEÇİM, TEKRAR DENEYİNİZ" + "\u001B[0m");
            }
        }
    }

    private static void YonetimdenTalep() throws InterruptedException {
        System.out.println("=== TALEPTE BULUN ===");
        String tcNO = "";

        while (true) {
            System.out.print("TC Numaranızı Giriniz : ");
            tcNO = Consol.nextLine();
            System.out.print("Kontrol Ediliyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            System.out.println();
            if (!MemberProcessing.intControl(tcNO)) {
                System.out.println("\033[1;31m" + "TC NO SADECE RAKAMLARDAN OLUŞMALIDIR" + "\033[0m\n");
            } else if (UyelerMap.containsKey(tcNO)) {
                System.out.println("\033[1;32m" + "TC NO KABUL EDİLDİ" + "\033[0m\n");
                break;
            } else {
                System.out.println("\033[1;31m" + "HATALI TC NO ya da ÜYELİK MEVCUT DEĞİL!" + "\033[0m\n");
                return;
            }
        }

        System.out.print("\033[1;33m" + "!! TALEBİNİZİ YAZARKEN !! \n" +
                "- DOĞRU BİR ÜSLUP KULLANINIZ.\n- BİRDEN FAZLA TALEBİNİZ VARSA MADDELER HALİNDE YAZINIZ.\n- TALEPLERİNİZE BİR KONU BAŞLIĞI YAZINIZ örn: (KİTAP TALEBİ vb.) \n" +
                "- TALEP YAZINIZIN SONUNA İLETİŞİM BİLGİLERİNİZİ EKLEYİNİZ (E-posta ve Telefon)\n " + "\033[0m");
        System.out.print("\033[1;32m" + "\n-Talebinizi yazınız-" + "\033[0m\n");
        System.out.print("TALEP : ");
        String talep = Consol.nextLine();

        LocalDateTime suan = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.YYYY hh:mm:ss");

        String basvuruNo = "BSVR" + numara++;
        String basvuruTarihi = suan.format(f);
        String guncelTalep = "\033[1;36mBaşvuru Tarihi : \033[0m" + basvuruTarihi +
                "\033[1;36m\nBaşvuru NO     : \033[0m" + basvuruNo +
                "\033[1;36m\n-Başvuru Metni-   \033[0m\n" + talep;
        if (!TumTalepler.containsKey(tcNO)) {
            TumTalepler.put(tcNO, YonetimeTalepler = new ArrayList<>());
        }
        YonetimeTalepler = TumTalepler.get(tcNO);
        YonetimeTalepler.add(guncelTalep);
        System.out.println("\033[1;32m\n" + "TALEBİNİZ BAŞARIYLA KAYIT ALTINA ALINDI\n- 15 İŞ GÜNÜ İÇİNDE TARAFINIZA TALEBİNİZ İLE İLGİLİ GERİ DÖNÜŞ SAĞLANACAKTIR -" + "\033[0m\n");
    }

    private static void TalepleriGoruntule() throws InterruptedException {
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
}
