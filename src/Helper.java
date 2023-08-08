import java.util.Scanner;

public class Helper {
    static Scanner Consol = new Scanner(System.in);
    public static String LoggedInUsername;
    public static Authority LoggedInUserRole;
    private static void LoginAndShow(Authority Role) throws InterruptedException{
        while (true){
            System.out.print("\u001B[1;35m"+"Kullanıcı Adı:");
            String Username = Consol.nextLine();
            System.out.print("Şifre:"+"\u001B[0m");
            String Password = Consol.nextLine();
            Role = Authenticator(Username,Password);
            if (Role==Authority.ADMIN){
                LoggedInUsername="Admin";
                LoggedInUserRole=Authority.ADMIN;
                break;
            } else if (Role==Authority.USER) {
                LoggedInUsername="User";
                LoggedInUserRole=Authority.USER;
                break;
            } else if (Role==Authority.GUEST) {
                LoggedInUsername="Guest";
                LoggedInUserRole=Authority.GUEST;
                break;
            }else {
                System.out.println("HATALI KULLANICI ADI VEYA ŞİFRE");
            }
        }
        switch (LoggedInUserRole){
            case ADMIN:System.out.println("\u001B[1;32m"+"Yükleniyor..."+"\u001B[0m");
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }
                System.out.println();
                System.out.println("\u001B[1;32m"+"ADMIN OLARAK GİRİŞ YAPILDI"+"\u001B[0m");
                AdminManager.ShowAdminMenu();
            case USER:System.out.println("\u001B[1;32m"+"Yükleniyor..."+"\u001B[0m");
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }
                System.out.println();
                System.out.println("\u001B[1;32m"+"USER OLARAK GİRİŞ YAPILDI"+"\u001B[0m");
                UserManager.ShowUserMenu();
            case GUEST:System.out.println("\u001B[1;32m"+"Yükleniyor..."+"\u001B[0m");
                for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }
                System.out.println();
                System.out.println("\u001B[1;32m"+"GUEST OLARAK GİRİŞ YAPILDI"+"\u001B[0m");
                GuestManager.ShowGuestMenu();
        }
    }
    private static Authority Authenticator(String Username, String Password){
        if ("Admin".equals(Username)&&"Admin123".equals(Password)){
            return Authority.ADMIN;
        } else if ("User".equals(Username)&&"User123".equals(Password)) {
            return Authority.USER;
        } else if ("Guest".equals(Username)&&"Guest123".equals(Password)) {
            return Authority.GUEST;
        }else {
            return null;
        }
    }
    public static void AnaMenu()throws InterruptedException{
        String Secim="";
        while (!Secim.equalsIgnoreCase("Q")){
            System.out.println("\u001B[1;34m"+"=== TECHNO STUDY CONFLUENCE ==="+"\u001B[0m");
            System.out.println("\u001B[1;36m"+"1- Sistem Girişi");
            System.out.println("2- Kütüphane Bilgileri");
            System.out.println("Q- Çıkış"+"\u001B[0m");
            System.out.print("\u001B[1;33m"+"Seçiminiz:"+"\u001B[0m");
            Secim=Consol.nextLine();
            switch (Secim.toUpperCase()){
                case "1": System.out.println("\u001B[1;32m"+"Yükleniyor..."+"\u001B[0m");
                    for (int i = 0; i < 20; i++) {
                    Thread.sleep(100);
                    System.out.print(">");
                }
                    System.out.println();
                    LoginAndShow(null); break;
                case "2":kutuphaneBilgileriniYazdir(); break;
                case "Q":projeDurdur();
                default: System.out.println("\u001B[1;31m"+"HATALI SEÇİM, TEKRAR DENEYİNİZ"+"\u001B[0m");
            }
        }
    }
    public static void kutuphaneBilgileriniYazdir() throws InterruptedException{
        System.out.print("\u001B[1;32m"+"Kütüphane bilgileri yazdırılıyor ");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">"+"\u001B[0m");
        }
        System.out.println("\u001B[1;35m"+"\n" +
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                "\t\t Kutuphane : " + LibraryInformation.kutuphaneIsim +
                "\n\t\t Adres : " + LibraryInformation.adres +
                "\n\t\t Telefon : " + LibraryInformation.telefon+"\u001B[0m"+"\n");
    }
    public static void projeDurdur()throws InterruptedException {
        System.out.print("\u001B[1;31m"+"Kütüphane projesinden çıkılıyor ");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">"+"\u001B[0m");
        }
        System.exit(0);
    }
}
