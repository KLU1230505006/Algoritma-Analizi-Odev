import java.util.*;

class Mahalle {
    private String ad;
    private double nufusYogunlugu;
    private double ulasimAltyapisi;
    private double maliyet;
    private double cevreselEtki;
    private double sosyalFayda;

    public Mahalle(String ad, double nufusYogunlugu, double ulasimAltyapisi, double maliyet, double cevreselEtki, double sosyalFayda) {
        this.ad = ad;
        this.nufusYogunlugu = nufusYogunlugu;
        this.ulasimAltyapisi = ulasimAltyapisi;
        this.maliyet = maliyet;
        this.cevreselEtki = cevreselEtki;
        this.sosyalFayda = sosyalFayda;
    }

    public String getAd() {
        return ad;
    }

    public double getNufusYogunlugu() {
        return nufusYogunlugu;
    }

    public double getUlasimAltyapisi() {
        return ulasimAltyapisi;
    }

    public double getMaliyet() {
        return maliyet;
    }

    public double getCevreselEtki() {
        return cevreselEtki;
    }

    public double getSosyalFayda() {
        return sosyalFayda;
    }
}

public class TransportPlanning {
    public static void main(String[] args) {
        List<Mahalle> mahalleler = Arrays.asList(
                new Mahalle("A", 1500.0, 5.0, 1000000.0, 2.0, 8.0),
                new Mahalle("B", 2000.0, 3.0, 1500000.0, 5.0, 5.0),
                new Mahalle("C", 1000.0, 8.0, 800000.0, 5.0, 3.0)
        );

        Map<String, Double> agirliklar = Map.of(
                "nufus_yogunlugu", 0.25,
                "ulasim_altyapisi", 0.20,
                "maliyet", 0.25,
                "cevresel_etki", 0.15,
                "sosyal_fayda", 0.15
        );

        Map<String, Double> puanlar = new HashMap<>();
        double minPuan = Double.MAX_VALUE, maxPuan = Double.MIN_VALUE;

        for (Mahalle mahalle : mahalleler) {
            double puan = 0.0;
            puan += mahalle.getNufusYogunlugu() * agirliklar.get("nufus_yogunlugu");
            puan += mahalle.getUlasimAltyapisi() * agirliklar.get("ulasim_altyapisi");
            puan += mahalle.getMaliyet() * agirliklar.get("maliyet");
            puan += mahalle.getCevreselEtki() * agirliklar.get("cevresel_etki");
            puan += mahalle.getSosyalFayda() * agirliklar.get("sosyal_fayda");

            puanlar.put(mahalle.getAd(), puan);
            if (puan < minPuan) minPuan = puan;
            if (puan > maxPuan) maxPuan = puan;
        }


        System.out.println("Mahallelerin Puanları:");
        for (Map.Entry<String, Double> entry : puanlar.entrySet()) {
            System.out.printf("Mahalle %s Puanı: %.2f\n", entry.getKey(), entry.getValue());
        }


        Map<String, Double> scaledPuanlar = new HashMap<>();
        for (Map.Entry<String, Double> entry : puanlar.entrySet()) {
            scaledPuanlar.put(entry.getKey(), (entry.getValue() - minPuan) / (maxPuan - minPuan));
        }


        Map<String, Double> normalizePuanlar = softmax(scaledPuanlar);


        System.out.println("\nNormalize Edilmiş Puanlar:");
        for (Map.Entry<String, Double> entry : normalizePuanlar.entrySet()) {
            System.out.printf("Mahalle %s Normalize Puanı: %.4f\n", entry.getKey(), entry.getValue());
        }


        String enUygunMahalle = normalizePuanlar.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("\nEn Uygun Güzergah: Mahalle " + enUygunMahalle);
    }


    public static Map<String, Double> softmax(Map<String, Double> puanlar) {
        Map<String, Double> softmaxPuanlar = new HashMap<>();


        double maxPuan = puanlar.values().stream().max(Double::compare).orElse(0.0);

        double sumExp = 0.0;
        Map<String, Double> expValues = new HashMap<>();


        for (Map.Entry<String, Double> entry : puanlar.entrySet()) {
            double expPuan = Math.exp(entry.getValue() - maxPuan);
            expValues.put(entry.getKey(), expPuan);
            sumExp += expPuan;
        }


        for (Map.Entry<String, Double> entry : expValues.entrySet()) {
            softmaxPuanlar.put(entry.getKey(), entry.getValue() / sumExp);
        }

        return softmaxPuanlar;
    }
}