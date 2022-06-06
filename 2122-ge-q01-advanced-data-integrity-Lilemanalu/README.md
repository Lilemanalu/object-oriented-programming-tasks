# Q01 Advanced Data Integrity
Pada quiz pemrograman ini anda akan mengembangkan pekerjaan sebelumnya terkait Academic Simulator, **T03**. Spesifikasi-spesifikasi dari pekerjaan sebelumnya tetap digunakan.

## Task 01: Additional Entity (```academic.driver.Driver1```, 40 pts)

Pada tugas ini anda diminta untuk menambahkan sebuah entitas baru ke dalam simulator yang merepresentasikan dosen (```lecturer```). Seorang dosen dapat dideskripsikan dengan NIDN (```id```), nama dosen (```name```), inisial (```initial```), alamat email (```email```), dan program studi (```study program```). Seorang dosen hanya terdaftar pada tepat satu program studi (```study program```).

Kembangkan sebuah driver (```academic.driver.Driver1```) yang merupakan kelanjutan dari **T03-Task 04**. Selain fitur-fitur yang sudah dikembangkan pada **T03-Task 04**, lengkapi driver anda dengan fitur untuk mendaftarkan entitas dosen. Perintah yang digunakan ditandai dengan token ```lecturer-add``` yang diikuti dengan beberapa segmen data. Perlu diingat bahwa seorang dosen diidentifikasi dari NIDN-nya. Setiap dosen juga memiliki inisial serta email yang unik. Berikut adalah contoh perintah untuk menambahkan sebuah entitas dosen.

```bash
lecturer-add#0130058501#Parmonangan Rotua Togatorop#PAT#mona.togatorop@del.ac.id#Information Systems
lecturer-add#0114129002#Iustisia Natalia Simbolon#IUS#iustisia.simbolon@del.ac.id#Informatics
---

```

Di akhir eksekusi, driver akan menampilkan entitas-entitas dosen yang pernah diregistrasi. Daftar dosen ditampilkan sebelum solusi menampilkan daftar mata kuliah. Berikut adalah sebuah contoh luaran yang merepresentasikan sebuah entitas dosen.

```bash
0130058501|Parmonangan Rotua Togatorop|PAT|mona.togatorop@del.ac.id|Information Systems
0114129002|Iustisia Natalia Simbolon|IUS|iustisia.simbolon@del.ac.id|Informatics

```

## Task 02: Updating Related Entities (```academic.driver.Driver2```, 60 pts)

Pada tugas ini anda diminta untuk melakukan modifikasi solusi terhadap entitas mata kuliah (```course```) dengan menambahkan informasi dosen pengampu. Sebuah mata kuliah diampu oleh paling sedikit satu orang dosen tanpa batasan maksimum.

Untuk memenuhi requirement tersebut, maka perlu dilakukan adaptasi pada format masukkan untuk melakukan registrasi sebuah mata kuliah dengan menambahkan sebuah segmen tambahan, daftar dosen (```lecturer-initial-list```). Sebuah

```bash
course-add#kode#nama#sks#passing-grade#lecturer-initial-list
---

```

Pada situasi mata kuliah diampu oleh lebih dari satu dosen, maka inisial dosen ditulis dengan tanda koma (```,```) sebagai separator. Perhatikan contoh berikut.

```bash
lecturer-add#0130058501#Parmonangan Rotua Togatorop#PAT#mona.togatorop@del.ac.id#Information Systems
lecturer-add#0114129002#Iustisia Natalia Simbolon#IUS#iustisia.simbolon@del.ac.id#Informatics
lecturer-add#0124108201#Rosni Lumbantoruan#RSL#rosni@del.ac.id#Information Systems
course-add#12S2102#Basisdata#4#C#PAT,IUS,RSL
---

```

Penambahan informasi pengampu juga memengaruhi format luaran. Informasi seorang dosen pengampu ditampilkan inisial dan alamat email. Dalam situasi terdapat lebih dari satu pengampu maka di tulis dengan semicolon (```;```) sebagai separator. Berikut contoh luaran.

```bash
0130058501|Parmonangan Rotua Togatorop|PAT|mona.togatorop@del.ac.id|Information Systems
0114129002|Iustisia Natalia Simbolon|IUS|iustisia.simbolon@del.ac.id|Informatics
0124108201|Rosni Lumbantoruan|RSL|rosni@del.ac.id|Information Systems
12S2102|Basisdata|4|C|PAT (mona.togatorop@del.ac.id);IUS (iustisia.simbolon@del.ac.id);RSL (rosni@del.ac.id)

```

## Reporting
Lakukan pertemuan dengan pair anda untuk mendiskusikan persoalan dan pengembangan solusi. Rekaman dari pertemuan tersebut menjadi bagian dari artefak tugas yang harus dikumpulkan. Durasi rekaman minimal **30 menit**.

Presentasikan pekerjaan anda dalam sebuah video. Pada presentasi:
1. Jabarkan solusi anda kelas-per-kelas (yang anda tambahkan atau modifikasi).
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
1. ```src/academic/model/*.java```;
2. ```src/academic/driver/*.java```;
3. changelog.txt

## How to submit?
Please see https://youtu.be/ZOhgmVjWFyo
