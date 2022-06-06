# T01 Academic: A Deja Vu
Pada tugas kali ini anda akan mengembangkan beberapa kelas dari sebuah persoalan yang pernah anda temui sebelumnya, a deja vu.

### Academic
Butet baru saja bertemu dengan salah seorang dosen pemrograman yang memintanya untuk mengembangkan suatu program sederhana untuk mensimulasikan entitas-entitas di lingkup dunia akademik. Sebenarnya, sang dosen telah mengembangkan desain dasar dari simulator dan Butet hanya diminta untuk mengimplementasikannya. Sebagai langkah awal, simulator hanya akan menangani beberapa entitas yang definisinya sudah jelas, yakni mata kuliah (```course```), mahasiswa (```student```), dan rencana studi (```enrollment```).

Berikut adalah rincian entitas dalam simulator:
1. Sebuah ```course``` memiliki kode mata kuliah (```code```), nama mata kuliah (```name```), kredit (```credit```), dan nilai minimum (```passing grade```). Aturan besaran nilai kredit adalah ```0 < credit <= 8```.
2. Seorang ```student``` memiliki NIM (```id```), nama mahasiswa ```name```, angkatan (```year```), dan program studi (```study program```).
3. Sebuah ```enrollment``` adalah relasi antara ```course``` dan ```student```. Sebuah ```course``` dapat dikontrak oleh banyak ```student``` dan seorang ```student``` dapat mengontrak banyak ```course```. Suatu ```enrollment``` terikat pada suatu ```semester``` di suatu tahun akademik ```academic year```. Sebuah ```enrellment``` memiliki sebuah ```course```, ```student```, ```academic year```, ```semester```, dan nilai yang diperoleh mahasiswa bersangkutan (```grade```).
4. Terdapat tiga semester, ganjil (```odd```), genap (```even```), dan pendek (```short```).
5. Terdapat delapan opsi nilai huruf (```grade```): ```A```, ```AB```, ```B```, ```BC```, ```C```, ```D```, ```E```, ```T```. Untuk mengantisipasi situasi di mana nilai belum dimasukkan, maka by default di-set dengan ```None```. Untuk setiap nilai huruf dapat dikonversi menjadi nilai angka ```4.0``` untuk nilai huruf ```A```, ```3.5``` untuk nilai huruf ```AB```, ```3.0``` untuk nilai huruf ```B```, ```2.5``` untuk nilai huruf ```BC```, ```2.0``` untuk nilai huruf ```C```, ```1.0``` untuk nilai huruf ```D```, dan ```0.0``` untuk nilai huruf ```E```. Untuk nilai huruf ```T``` dan ketika nilai belum diberikan (```None```) maka akan diberi nilai angka ```0.0```.

## Task 01: Refining The Empty Class 
Berikutnya, lengkapi definisi dari tiga buah class berikut:
1. ```academic.model.Course``` yang merepresentasikan entitas ```course```.
2. ```academic.model.Student``` yang merepresentasikan entitas ```student```.
3. ```academic.model.Enrollment``` yang merepresentasikan entitas ```enrollment```.

## Task 01: Add More 
Tugas pertama anda adalah mengembangkan sebuah driver class (```academic.driver.Driver1```) yang mampu menyimulasikan kemampuan penyimpanan multiple ```academic.model.Course```. Gunakan array sebagai media penyimpanan. Lebih lanjut, driver juga harus memiliki kemampuan untuk menerima baris-baris masukan interaktif dari pengguna. Setiap baris masukan merepresentasikan data sebuah course. Sebuah baris masukan terdiri atas 4 segmen yang diseparasi dengan ```#```. Keempat segmen merepresentasikan data yang diperlukan untuk membentuk sebuah course.

Pada saat eksekusi, driver akan terus-menerus membaca baris masukan hingga diperintahkan untuk berhenti. Perintah berhenti ditandai dengan ```---```. Perhatikan contoh berikut.

Pada tugas ini anda diminta untuk mengembangkan sebuah driver (```academic.driver.Driver1```) yang mampu menyimulasikan kemampuan penyimpanan multiple pada semua entitas (```academic.model.Course```, ```academic.model.Student```, dan ```academic.model.Enrollment```). Gunakan array sebagai media penyimpanan. Lebih lanjut, driver juga harus memiliki kemampuan untuk menerima baris-baris masukan interaktif dari pengguna. Setiap baris masukan merepresentasikan data sebuah entitas. Sebuah baris masukan terdiri atas 5 segmen yang diseparasi dengan ```#```. Keempat segmen terakhir merepresentasikan data yang diperlukan untuk membentuk sebuah course. Untuk membedakan instruksi, ditambahkan sebuah segmen pada bagian awal input dengan spesifikasi sebagai berikut:
1. ```course-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Course```.
2. ```student-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Student```.
3. ```enrollment-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Enrollment```.


## Task 04: When Things Go Wrong (30 pts)

Sebuah ```enrollment``` hanya dapat dilakukan bila ```course``` dan ```student``` yang terlibat sudah terlebih dahulu didaftarkan. Bila belum didaftarkan, maka upaya ```enrollment``` harus dibatalkan karena ```course``` atau ```student``` yang terlibat **does not exist**. Pada tugas ini anda diminta untuk mengembangkan suatu mekanisme penanganan eksepsi pada saat ```course``` atau ```student``` invalid. Tuliskan solusi anda pada ```academic.driver.Driver2```.


Pemeriksaan terhadap validitas terlebih dahulu dilakukan terhadap ```course``` kemudian ```student```.


# Q01 Advanced Data Integrity
Pada quiz pemrograman ini anda akan mengembangkan pekerjaan sebelumnya terkait Academic Simulator, **T03**. Spesifikasi-spesifikasi dari pekerjaan sebelumnya tetap digunakan.

## Task 01: Additional Entity (```academic.driver.Driver1```, 40 pts)

Pada tugas ini anda diminta untuk menambahkan sebuah entitas baru ke dalam simulator yang merepresentasikan dosen (```lecturer```). Seorang dosen dapat dideskripsikan dengan NIDN (```id```), nama dosen (```name```), inisial (```initial```), alamat email (```email```), dan program studi (```study program```). Seorang dosen hanya terdaftar pada tepat satu program studi (```study program```).

Kembangkan sebuah driver (```academic.driver.Driver1```) yang merupakan kelanjutan dari **T03-Task 04**. Selain fitur-fitur yang sudah dikembangkan pada **T03-Task 04**, lengkapi driver anda dengan fitur untuk mendaftarkan entitas dosen. Perintah yang digunakan ditandai dengan token ```lecturer-add``` yang diikuti dengan beberapa segmen data. Perlu diingat bahwa seorang dosen diidentifikasi dari NIDN-nya. Setiap dosen juga memiliki inisial serta email yang unik. 

Di akhir eksekusi, driver akan menampilkan entitas-entitas dosen yang pernah diregistrasi. Daftar dosen ditampilkan sebelum solusi menampilkan daftar mata kuliah. 


## Task 02: Updating Related Entities (```academic.driver.Driver2```, 60 pts)

Pada tugas ini anda diminta untuk melakukan modifikasi solusi terhadap entitas mata kuliah (```course```) dengan menambahkan informasi dosen pengampu. Sebuah mata kuliah diampu oleh paling sedikit satu orang dosen tanpa batasan maksimum.

Untuk memenuhi requirement tersebut, maka perlu dilakukan adaptasi pada format masukkan untuk melakukan registrasi sebuah mata kuliah dengan menambahkan sebuah segmen tambahan, daftar dosen (```lecturer-initial-list```). 

Pada situasi mata kuliah diampu oleh lebih dari satu dosen, maka inisial dosen ditulis dengan tanda koma (```,```) sebagai separator. Perhatikan contoh berikut.


Penambahan informasi pengampu juga memengaruhi format luaran. Informasi seorang dosen pengampu ditampilkan inisial dan alamat email. Dalam situasi terdapat lebih dari satu pengampu maka di tulis dengan semicolon (```;```) sebagai separator. Berikut contoh luaran.


# M01 Academic Stats

Pada ujian tengah semester ini, anda diminta untuk mengembangkan beberapa fitur tambahan dalam Academic Simulator. Pada Tugas-tugas sebelumnya anda telah mengembangkan berbagai fitur manajemen data untuk beberapa entitas yang berada di lingkungan akademik, seperti dosen (```lecturer```), mata kuliah (```course```), mahasiswa (```student```), dan rencana studi (```enrollment```). Di akhir eksekusi, solusi anda telah mampu secara otomatis menampilkan seluruh data dari entitas-entitas yang tersimpan.

Dalam menyelesaikan ujian ini, anda diperbolehkan untuk mendefinisikan kelas-kelas lain yang menurut anda diperlukan. 

## Task 01: Grading (academic.driverDriver1, 40pts)

Pada tugas ini anda diminta untuk mengembangkan sebuah fitur yang memampukan pengguna mengeset nilai (```grade```) yang diperoleh seorang mahasiswa pada suatu mata kuliah. Nilai yang diberikan berupa nilai huruf, yakni ```A```, ```AB```, ```B```, ```BC```, ```C```, ```D```, dan ```E```.

Untuk mengeset nilai, pengguna akan memasukkan sebaris perintah dengan format sebagai berikut.

```bash
enrollment-grade#<course-code>#<student-id>#<academic-year>#<semester>#<grade>
```

Baris masukan terdiri atas 6 segmen yang diseparasi dengan hash sign (```#```). Segmen pertama adalah perintah yang diberikan dan diikuti dengan serangkaian data terkait rencana studi (```enrollment```) dan nilai (```grade```) yang diberikan. Simulator kemudian akan terlebih dahulu mencari rencana studi (```enrollment```) yang sesuai, bila ditemukan maka dilakukan update terhadap nilai dari rencana studi tersebut. Bila tidak, maka perintah diabaikan dan solusi menuju ke perintah berikutnya. Tidak ada keluaran apapun setelah Simulator selesai mengerjakan perintah ini.



## Task 02: Student's GPA (academic.driverDriver1, 60pts)

Tugas ini merupakan kelanjutan dari **Task 01**. Pada tugas ini anda diminta untuk mengembangkan sebuah fitur yang akan menampilkan info lengkap mengenai seorang mahasiswa beserta performa akademiknya. Performa akademik direpresentasikan dalam bentuk Indeks Prestasi Kumulatif (IPK) atau dikenal juga dengan Grade Point Average (GPA). Silakan untuk melihat mekanisme penghitungan IPK pada Buku Pedoman Akademik. IPK ditulis dalam 2 digit nilai presisi.

Untuk menjalankan fitur ini, pengguna akan memberikan sebuah baris masukan dengan format sebagai berikut.

```bash
student-details#<student-id>
```

Baris masukan terdiri atas 2 segmen yang diseparasi dengan hash sign (```#```). Segmen pertama adalah perintah yang diberikan dan diikuti dengan sebuah nomor induk mahasiswa (```student-id```) yang akan ditampilkan detil informasinya. Bila mahasiswa dimaksud belum tersimpan dalam Simulator, maka perintah akan diabaikan dan Simulator meneruskan ke baris masukan berikutnya. Sebaliknya, bila mahasiswa dengan identitas dimaksud tersimpan di dalam Simulator, maka Simulator akan menampilkan detil informasi dari yang bersangkutan beserta performa akademiknya. Berikut adalah format keluarannya.

```bash
<student-id>|<name>|<year>|<study-program>|<gpa>|<total-credit>
```


# T05 Advanced Academic Stats

Tugas ini merupakan pengembangan dari hasil pekerjaan anda pada UTS yll (M01). Pada tugas ini anda diminta untuk menyelesaikan dua persoalan. Yang pertama anda diminta untuk menganalisis potensi penerapan prinsip inheritance pada solusi terdahulu. Sementara pada bagian kedua, anda diminta untuk mengembangkan sebuah fitur baru ke dalam simulator.

## Task 01: Applying Inheritance (academic.driverDriver1, 60pts)

Pada tugas ini anda diminta untuk menganalisis pekerjaan anda sebelumnya guna mencari aspek-aspek di mana inheritance berpotensi diaplikasikan. Anda dapat menerapkan pendekatan top-down maupun bottom-up untuk menemukan potensi tersebut.

Bila telah menemukan, tuangkan ide anda dalam sebuah Class Diagram yang nantinya akan dipresentasikan dalam laporan.

Tahap terakhir adalah realisasikan ide anda dengan me-refactor codebase anda.

## Task 02: Student's GPA (academic.driverDriver2, 40pts)

Tugas ini merupakan kelanjutan dari **Task 01**. Pada tugas ini anda diminta untuk me-revisit solusi anda sehingga mampu menangani kasus mengulang mata kuliah berulang. Sebagai contoh, seorang mahasiswa telah mengambil sebuah mata kuliah (misal Basisdata) pada dua semester berbeda. Pada pengambilan pertama mendapat nilai BC dan berikutnya mendapatkan nilai A. Merujuk pada Peraturan Akademik, nilai yang akan diakui adalah yang terakhir. Dengan demikian, perhitungan performa akademik juga akan menggunakan nilai terakhir. Perhatikan contoh berikut.

**Input**

```bash
lecturer-add#0130058501#Parmonangan Rotua Togatorop#PAT#mona.togatorop@del.ac.id#Information Systems
lecturer-add#0114129002#Iustisia Natalia Simbolon#IUS#iustisia.simbolon@del.ac.id#Informatics
lecturer-add#0124108201#Rosni Lumbantoruan#RSL#rosni@del.ac.id#Information Systems
course-add#12S1101#Dasar Sistem Informasi#3#D#IUS
course-add#12S2102#Basisdata#4#C#PAT,IUS,RSL
student-add#12S20001#Marcelino Manalu#2020#Information Systems
student-add#12S20002#Yoga Sihombing#2020#Information Systems
student-add#12S20003#Marcel Simanjuntak#2020#Information Systems
enrollment-add#12S1101#12S20001#2020/2021#odd
enrollment-add#12S1101#12S20002#2020/2021#odd
enrollment-add#12S1101#12S20003#2020/2021#odd
enrollment-grade#12S1101#12S20001#2020/2021#odd#B
enrollment-grade#12S1101#12S20002#2020/2021#odd#B
enrollment-grade#12S1101#12S20003#2020/2021#odd#B
enrollment-add#12S2102#12S20001#2021/2022#odd
enrollment-add#12S2102#12S20002#2021/2022#odd
enrollment-add#12S2102#12S20003#2021/2022#odd
enrollment-grade#12S2102#12S20001#2021/2022#odd#B
enrollment-grade#12S2102#12S20002#2021/2022#odd#AB
enrollment-grade#12S2102#12S20003#2021/2022#odd#BC
enrollment-add#12S2102#12S20003#2022/2023#odd
enrollment-grade#12S2102#12S20003#2022/2023#odd#AB
student-details#12S20001
student-details#12S20002
student-details#12S20003
---
```

**Output**

```bash
12S20001|Marcelino Manalu|2020|Information Systems|3.00|7
12S20002|Yoga Sihombing|2020|Information Systems|3.29|7
12S20003|Marcel Simanjuntak|2020|Information Systems|3.29|7
0130058501|Parmonangan Rotua Togatorop|PAT|mona.togatorop@del.ac.id|Information Systems
0114129002|Iustisia Natalia Simbolon|IUS|iustisia.simbolon@del.ac.id|Informatics
0124108201|Rosni Lumbantoruan|RSL|rosni@del.ac.id|Information Systems
12S1101|Dasar Sistem Informasi|3|D|IUS (iustisia.simbolon@del.ac.id)
12S2102|Basisdata|4|C|PAT (mona.togatorop@del.ac.id);IUS (iustisia.simbolon@del.ac.id);RSL (rosni@del.ac.id)
12S20001|Marcelino Manalu|2020|Information Systems
12S20002|Yoga Sihombing|2020|Information Systems
12S20003|Marcel Simanjuntak|2020|Information Systems
12S1101|12S20001|2020/2021|odd|B
12S1101|12S20002|2020/2021|odd|B
12S1101|12S20003|2020/2021|odd|B
12S2102|12S20001|2021/2022|odd|B
12S2102|12S20002|2021/2022|odd|AB
12S2102|12S20003|2021/2022|odd|BC
12S2102|12S20003|2022/2023|odd|AB
```

