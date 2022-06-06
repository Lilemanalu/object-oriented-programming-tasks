# T02 Academic Simulator
Pada tugas kali ini anda akan mengembangkan pekerjaan sebelumnya terkait Academic Simulator. Spesifikasi-spesifikasi dari pekerjaan sebelumnya tetap digunakan dalam tugas kali ini.

## Task 01: Add More Courses (20 pts)
Tugas pertama anda adalah mengembangkan sebuah driver class (```academic.driver.Driver1```) yang mampu menyimulasikan kemampuan penyimpanan multiple ```academic.model.Course```. Gunakan array sebagai media penyimpanan. Lebih lanjut, driver juga harus memiliki kemampuan untuk menerima baris-baris masukan interaktif dari pengguna. Setiap baris masukan merepresentasikan data sebuah course. Sebuah baris masukan terdiri atas 4 segmen yang diseparasi dengan ```#```. Keempat segmen merepresentasikan data yang diperlukan untuk membentuk sebuah course.

Pada saat eksekusi, driver akan terus-menerus membaca baris masukan hingga diperintahkan untuk berhenti. Perintah berhenti ditandai dengan ```---```. Perhatikan contoh berikut.

**Input:**
```bash
12S2203#Object-oriented Programming#3#C
10S1002#Pemrograman Prosedural#2#D
---

```

Setelah diperintahkan untuk berhenti, driver kemudian akan menampilkan semua courses yang tersimpan. Setiap course ditampilkan dalam satu baris keluaran dengan simbol ```|``` sebagai data separator.

**Output:**
```bash
12S2203|Object-oriented Programming|3|C
10S1002|Pemrograman Prosedural|2|D

```

## Task 02: Add More Students (20 pts)
Tugas kedua anda pada prinsipnya sama dengan **Task 01**, perbedaan terdapat pada entity yang dioperasikan yakni ```academic.model.Student``` dan driver yang ditulis (```academic.driver.Driver2```). Perhatikan contoh berikut.

**Input:**
```bash
12S20999#Wiro Sableng#2020#Information Systems
12S20111#Jaka Sembung#2019#Information Systems
---

```

**Output:**
```bash
12S20999|Wiro Sableng|2020|Information Systems
12S20111|Jaka Sembung|2019|Information Systems

```

## Task 03: Add More Enrollments (20 pts)
Tugas ketiga anda pada prinsipnya sama dengan **Task 01** dan **Task 02**, perbedaan terdapat pada entity yang dioperasikan yakni ```academic.model.Enrollment``` dan driver yang ditulis (```academic.driver.Driver3```). Perhatikan contoh berikut.

**Input:**
```bash
12S2203#12S20999#2021/2022#even
12S2203#12S20111#2020/2021#even
---

```

**Output:**
```bash
12S2203|12S20999|2021/2022|even|None
12S2203|12S20111|2020/2021|even|None

```

## Task 04: Add More Everything (40 pts)
Tugas keempat merupakan penggabungan dari **Task 01**, **Task 02**, dan **Task 03**. Pada tugas ini anda diminta untuk mengembangkan sebuah driver (```academic.driver.Driver4```) yang mampu menyimulasikan kemampuan penyimpanan multiple pada semua entitas (```academic.model.Course```, ```academic.model.Student```, dan ```academic.model.Enrollment```). Untuk membedakan instruksi, ditambahkan sebuah segmen pada bagian awal input dengan spesifikasi sebagai berikut:
1. ```course-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Course```.
2. ```student-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Student```.
3. ```enrollment-add``` dimaksudkan untuk menambah sebuah entitas ```academic.model.Enrollment```.
Perhatikan contoh berikut.

**Input:**
```bash
course-add#12S2203#Object-oriented Programming#3#C
course-add#10S1002#Pemrograman Prosedural#2#D
student-add#12S20999#Wiro Sableng#2020#Information Systems
enrollment-add#12S2203#12S20999#2021/2022#even
student-add#12S20111#Jaka Sembung#2019#Information Systems
enrollment-add#12S2203#12S20111#2020/2021#even
---

```

**Output:**
```bash
12S2203|Object-oriented Programming|3|C
10S1002|Pemrograman Prosedural|2|D
12S20999|Wiro Sableng|2020|Information Systems
12S20111|Jaka Sembung|2019|Information Systems
12S2203|12S20999|2021/2022|even|None
12S2203|12S20111|2020/2021|even|None

```

Pada saat mengampilkan keluaran, terlebih dahulu ditampilkan entitas ```academic.model.Course```, kemudian ```academic.model.Student```, dan diikuti dengan ```academic.model.Enrollment```.

** How to compile and run?
Sebelum melakukan kompilasi, pastikan posisi dari current directory anda adalah pada direktori ```bin```. Bila direktori tersebut tidak ada, silakan ditambahkan secara manual.

Untuk mengkompilasi pekerjaan anda, gunakan perintah berikut:

```bash
cd bin
javac ..\src\academic\driver\*.java ..\src\academic\model\*.java -d .

```

Selanjutnya, untuk mengeksekusi pekerjaan anda, gunakan perintah berikut:

```bash
java academic.driver.Driver

```

Sesuaikan driver class yang akan dieksekusi.

## Reporting
Lakukan pertemuan dengan pair anda untuk mendiskusikan persoalan dan pengembangan solusi. Rekaman dari pertemuan tersebut menjadi bagian dari artefak tugas yang harus dikumpulkan. Durasi rekaman minimal **30 menit**.

Presentasikan pekerjaan anda dalam sebuah video. Pada presentasi:
1. Jabarkan solusi anda kelas-per-kelas.
2. Berikan rationale dari setiap implementasi yang anda hasilkan serta berikan argumen mengapa pilihan implementasi anda merupakan pilihan terbaik.
3. Jabarkan alir eksekusi dari solusi anda.
4. Demonstrasikan pekerjaan anda.
5. Tunjukkan hasil yang anda peroleh dari GitHub Classroom.
6. Sebutkan kendala yang dihadapi dalam pengerjaan tugas kali ini.

Note: Semakin tajam argumen dan penjabaran anda semakin mudah penilaian dilakukan.

Kriteria Video Presentasi:
+ Fullscreen (taskbar terlihat).
+ Suara jernih dan dapat dengan jelas terdengar.
+ Posting video anda di YouTube, di-set "Not For Kids" dengan visibility Unlisted.

## Submission
1. ```src/academic/model/Course.java```;
2. ```src/academic/model/Student.java```;
3. ```src/academic/model/Enrollment.java```;
4. ```src/academic/driver/Driver1.java```;
5. ```src/academic/driver/Driver2.java```;
6. ```src/academic/driver/Driver3.java```;
7. ```src/academic/driver/Driver4.java```;
8. changelog.txt

## How to submit?
Please see https://youtu.be/ZOhgmVjWFyo
