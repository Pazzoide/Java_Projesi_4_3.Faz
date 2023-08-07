public class Runner {
    public static void main(String[] args)throws InterruptedException {
        Database.baslangicKitaplarVeritabaniOlustur();
        Database.baslangicUyelerVeritabaniOlustur();
        Database.oduncKitaplarVeritabaniOlustur();
        Database.UyeTalepleriVeritabaniOlustur();
        Helper.AnaMenu();
    }
}
