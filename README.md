# 🧠 Panduan Menggunakan Git di Android Studio (Kotlin)

README ini menjelaskan langkah-langkah dasar untuk mengelola proyek Android Studio menggunakan **Git** dan **GitHub**.  
Cocok banget buat kamu yang baru mulai pakai Git di project Kotlin atau Android!

---

## 🪄 1. Cek Status Proyek

Gunakan perintah ini untuk melihat perubahan apa saja yang terjadi di folder proyek kamu.

```bash
git status
📍 Fungsi:

Menampilkan file yang sudah diubah, ditambahkan, atau dihapus.

Menunjukkan file mana yang belum siap di-commit.

💡 Contoh output:

yaml
Salin kode
modified: MainActivity.kt
untracked files: res/drawable/logo.png
🧩 2. Tambahkan Perubahan ke Staging Area
Gunakan perintah ini untuk menyiapkan semua file yang telah kamu ubah agar siap disimpan (commit) ke riwayat Git.

bash
Salin kode
git add .
📍 Fungsi:

Menambahkan semua file yang berubah ke staging area.

Staging area adalah tempat sementara sebelum file benar-benar disimpan melalui commit.

Titik (.) berarti semua perubahan di folder proyek akan ditambahkan sekaligus.

💡 Contoh situasi:
Kamu baru saja mengedit MainActivity.kt, menambah gambar baru di res/drawable/, dan mengubah AndroidManifest.xml.
Daripada menambahkan satu per satu, cukup jalankan:

bash
Salin kode
git add .
📎 Alternatif:
Kalau kamu hanya mau menambahkan file tertentu saja:

bash
Salin kode
git add MainActivity.kt
💾 3. Simpan Perubahan ke Riwayat Git (Commit)
Gunakan perintah ini untuk menyimpan perubahan yang sudah kamu tambahkan ke staging area ke dalam riwayat proyek.

bash
Salin kode
git commit -m "Pesan perubahan kamu di sini"
📍 Fungsi:

Menyimpan snapshot perubahan ke dalam Git history.

Menandai versi proyek kamu dengan pesan penjelasan singkat.

💡 Contoh penggunaan:

bash
Salin kode
git commit -m "fix: memperbaiki tampilan MainActivity"
🗒️ Contoh pesan commit yang baik:

"add: menambahkan halaman login"

"update: mengubah desain layout dashboard"

"fix: memperbaiki error di MainActivity"

"remove: menghapus file tidak terpakai"

🧠 Tips:
Gunakan kata kerja seperti add, update, fix, remove, atau style supaya pesan commit kamu konsisten dan mudah dipahami.

☁️ 4. Kirim Perubahan ke GitHub (Push)
Gunakan perintah ini untuk mengirim hasil commit dari komputer lokal ke repository GitHub.

bash
Salin kode
git push
📍 Fungsi:

Mengunggah semua commit terbaru dari lokal ke repository GitHub.

Menyinkronkan proyek di komputer dengan proyek online di GitHub.

💡 Contoh situasi:
Setelah kamu melakukan beberapa commit di Android Studio, gunakan:

bash
Salin kode
git push
Agar semua perubahanmu tampil di repository GitHub.

⚙️ Catatan:

Pastikan sudah login ke akun GitHub.

Repository lokal sudah terhubung dengan repository GitHub.

Jika baru pertama kali push, Git mungkin akan meminta konfirmasi branch (misalnya main atau master).

✨ Setelah menjalankan git push, semua perubahanmu sudah tersimpan di GitHub!
