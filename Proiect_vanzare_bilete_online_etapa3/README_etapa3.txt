Proiect: Vanzare de bilete online

ETAPA3:

Am adaugat claselor Serviceconcert, Servicesport, Servicetheatre si Client cate 4 metode pentru operatii de C.R.U.D a unei baze de date. (De cele 4 metode din Client nu am nevoie, 
dar le-am adaugat deoarece se cerea definirea metodelor pentru minim 4 clase).

Astfel, fiecare din clasele enumerate mai sus are: 
-o metoda care creeaza un tabel in baza de date pentru tipul respectiv de "bilet" (daca nu exista)
-o metoda care insereaza o linie noua in tabel
-o metoda care updateaza informatiile din tabel
-o metoda care sterge o linie din tabel


Interfata grafica se poate accesa ruland main-ul clasei interfaceticket. Va aparea o fereastra cu 3 optiuni de bilet si un buton. Dupa selectarea unei optiuni, se va deschide o noua 
fereastra (care trebuie marita manual) in care se pot completa datele unui bilet. La apasarea butonului, aceste date sunt salvate in baza de date in tabelul corespunzator biletului ales.

Toate actiunile ce implica modificarea tabelelor apar in Audit.csv, alaturi de data si ora executarii si de numele thread-urilor metodelor care le-au apelat.

Codul din Main este pentru testarea metodelor.