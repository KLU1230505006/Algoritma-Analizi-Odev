# Ulaşım Planlama ve Mahalle Seçimi Projesi

Bu proje, belirli kriterlere göre mahallelerin ulaşım planlaması için uygunluğunu değerlendiren bir Java uygulamasıdır. Proje, mahallelerin nüfus yoğunluğu, ulaşım altyapısı, maliyet, çevresel etki ve sosyal fayda gibi faktörlerini dikkate alarak en uygun mahalleyi seçmektedir.

## Proje Açıklaması

Proje, aşağıdaki adımları içerir:

1. **Mahalle Sınıfı (`Mahalle`)**: Her mahalle, adı, nüfus yoğunluğu, ulaşım altyapısı, maliyet, çevresel etki ve sosyal fayda gibi özelliklere sahiptir.

2. **Puanlama Sistemi**: Her mahalle, belirli ağırlıklara sahip kriterlere göre puanlanır. Bu puanlar, mahallelerin genel uygunluklarını belirler.

3. **Normalizasyon**: Puanlar, `softmax` fonksiyonu kullanılarak normalize edilir. Bu, puanların olasılık dağılımına dönüştürülmesini sağlar.

4. **En Uygun Mahalle Seçimi**: Normalize edilmiş puanlara göre en uygun mahalle seçilir.

## Kullanım

Projeyi çalıştırmak için aşağıdaki adımları izleyin:

1. **Java Geliştirme Ortamı**: Projeyi çalıştırmak için Java Development Kit (JDK) yüklü olmalıdır.

2. **Kodu Derleme ve Çalıştırma**:
   - Proje dizininde terminali açın.
   - `javac TransportPlanning.java` komutu ile kodu derleyin.
   - `java TransportPlanning` komutu ile programı çalıştırın.

3. **Çıktılar**:
   - Program, her mahallenin ham puanlarını ve normalize edilmiş puanlarını ekrana yazdırır.
   - En uygun mahalle, normalize edilmiş puanlara göre belirlenir ve ekrana yazdırılır.

Mahallelerin Puanları:
Mahalle A Puanı: 437500.00
Mahalle B Puanı: 575000.00
Mahalle C Puanı: 332500.00

Normalize Edilmiş Puanlar:
Mahalle A Normalize Puanı: 0.3132
Mahalle B Normalize Puanı: 0.4142
Mahalle C Normalize Puanı: 0.2726

En Uygun Güzergah: Mahalle B


u, bir dizi sayıyı olasılık dağılımına dönüştüren bir normalizasyon yöntemidir. Bu fonksiyon, özellikle makine öğrenmesi modellerinde çok sınıflı sınıflandırma problemlerinde kullanılır.
`softmax` fonksiyonu, her bir girdi değerini üstel bir fonksiyona tabi tutar ve daha sonra bu değerleri toplamlarına böler.
Bu işlem, her bir değerin 0 ile 1 arasında bir değer almasını ve tüm değerlerin toplamının 1 olmasını sağlar.

Projede, `softmax` fonksiyonu, mahallelerin puanlarını normalize etmek ve her bir mahallenin seçilme olasılığını hesaplamak için kullanılmıştır.
Bu sayede, en uygun mahalle seçimi daha objektif bir şekilde yapılabilmektedir.
