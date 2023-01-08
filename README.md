# Process
Dosya tarafından okunan algoritmalarımızda çalışacak işlerimizi temsil eder. Her processin unique bir id’si, öncelik değeri, geliş zamanı ve burst time’ı vardır.

# ReadBuffer
Verilen dosyayı okumak ve proses listesine eklemek için kullanılan sınıftır. getProcesses metoduyla verilen dosya yoluna göre önce dosyayı açar. readLine metoduyla satırları teker teker okuyup virgüle göre satırdaki değerleri ayırır. Ayırdığı değerleri yeni bir proses oluşturup ilgili alanına ekler. Oluşturulan proses, proses listesine eklenir. Bütün satırlar okunduktan sonra proses listesi geri döndürülür. cloneInputProcesses metoduyla parametre olarak verilen proses listesi yeni bir proses listesine kopyalanıp oluşturulan yeni liste geri döndürülür.

# ReadyQueue
İçinde proses listesi bulunduran bir sınıftır. Dequeue metoduyla queue’nun başındaki yani ilk eklenen prosesi queue’dan çıkarır ve bu prosesi geri döner. Peek metoduyla sıranın başındaki prosesi geri döner. Enqueue metodu ile önce parametre olarak gelen proses liste içinde var mı kontrol eder. Yoksa queue’yu dolaşarak gelen prosesin öncelik değeri ile sıradaki prosesin öncelik değerlerini karşılaştırır ve prosesin öncelik değerine göre sıranın içine yerleştirir. Contain private bir metottur ve enqueue metodunda kullanılır. Parametre olarak aldığı proses ile queue içindeki proseslerin id’lerini karşılaştırarak prosesin listede olup olmadığını bool bir şekilde döner. 

# ProcessProcessing
Proseslerin işlenmesiyle ilgili bilgileri tutan sınıftır. İlgili prosesin id’sini, önceliğini, giriş ve çıkış zamanlarını, patlama zamanını, kalan zamanını ve prosesin statüsünü tutar. toString metoduyla ilgili prosesin istenilen bilgilerini string bir şekilde döndürür.

# Scheduling


# Builder


# Main
Programın başladığı sınıftır. Burada ilgili sınıfların nesneleri oluşturulur. Dosya yolu ReadBuffer nesnesine verilir ve proses listesi alınır. Bu proses listesi Scheduling algoritmasına gönderilir. Gelen ProcessProcessing listesini ve değerlerini toString metoduyla ekrana basar.
