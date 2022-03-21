### Abstrakcja drzewa liściastego i iglastego

Rozwiązanie zadania znajduje się w pakiecie `tree` znajdującego się w folderze src > main > java.

### Geolokalizacyjna Usługa REST

Rozwiązanie zadania znajduje się w pakiecie `geoloc` znajdującego się w folderze src > main > java.

* Usługa pozwala na rejestrację oraz logowanie użytkowników przy użyciu `Spring Security`. 
* Jako sposób uwierzytelniania zastosowane zostały klucze `JWT`. 
* W celu prostego testowania aplikacji, wykorzystana została baza danych `H2`, umożliwiając korzystanie z bazy lokalnej bez dodatkowej konfiguracji.
* Do obsługi bazy danych po stronie serwera został wykorzystane `JPA & Hibernate`.
* Testy jednostkowe powstały w oparciu o `JUnit`

##### Rejestracja użytkownika
![register](https://i.imgur.com/28UktVx.png)

Rejestracja nie wymaga żadnej autoryzacji. Do serwera przesyłana jest nazwa użytkownika oraz hasło. W wypadku unikatowości nazwy użytkownika, tworzony jest nowy użytkownik w bazie. Hasło przed dodaniem do bazy zostaje zaszyfrowane.

##### Logowanie
![login](https://i.imgur.com/6B8KTjw.png)

Poprawne logowanie zwraca użytkownikowi access token w postaci JWT umożliwiający autoryzację do usługi geolokalizacyjnej.

##### Utworzenie wpisu o geolokalizacji
![addnew](https://i.imgur.com/aR6i8PK.png)

Usługa umożliwia utorzenie wpisu o nowej geolokalizacji zalogowanemu użytkownikowi. Konieczne jest podanie jedynie nazwy urządzenia, długości i szerokości geograficznej. Pozostałe dane konieczne do utworzenia wpisu odczytywane są z access tokena.

##### Wyświetlenie utworzonych geolokacji
![getall](https://i.imgur.com/PuYJ8oB.png)

Usługa wysyła listę utworzonych przez zalogowanego użytkownika geolokacji. Dane o aktualnym użytkowniku odczytywane są z access tokena.
