# -Programowanie_zespolowe_2018_gr3

## Wirtualna uczelnia napisana w JavaFX
Nasza aplikacja będzie miała za zadanie obsługiwanie pracowników oraz studentów uczelni.
Dzięki aplikacji będziemy mieli możliwość :
- dodawać, usuwać edytować i sprawdzać plan zajęć
- dodawać, usuwać edytować i sprawdzać listę studentów i prowadzących zajęcia
- przydzielać studentom prowadzących zajęcia
- przydzielać przedmioty do prowadzącego
- generować PDF z ocenami dla ucznia i prowadzącego
- generowanie listy studentów danego roku do PDF
- wyświetlenia planu zajęć przy użyciu kalendarza oraz tabeli
## Aplikacja będzie posiadać 4 grupy użytkowników :
- student : z dostępem do sprawdzania ocen, planu zajęć, danych osobowych oraz
generowania ocen do PDF
- prowadzący: z dostępem do wprowadzania i zmiany ocen, generowania ich do PDF,
planu zajęć
- dziekanat: z dostępem do modyfikacji planu zajęć, dodawania i wyszukiwania
studentów, przydzielania im prowadzących oraz wyświetlania i modyfikacji danych
studenta(dane osobowe, oceny)
- administrator : nadaje uprawnienia, zarządza całym systemem oraz ma dostęp do
wszystkich funkcji dostępnych dla pozostałych użytkowników
## Do zrealizowania projektu użyjemy następujących narzędzi:
- Jira- narzędzie do organizowania pracy i obowiązków
- Github - narzędzie do publikowania napisanego kodu
- Java - język programowania, w którym powstanie projekt
- MariaDB - narzędzie do tworzenia bazy danych

## Schemat UML 

![alt text](https://github.com/mjochab/-Programowanie_zespolowe_2018_gr3/blob/master/UML.PNG)


## Wygląd okna logowania:
- okno będzie zawierać 2 komunikaty (Label) Login i Hasło
- przycisk (Button) Zaloguj!
- jedno pole do wpisywania (TextField) username
- jedno szyfrowane pole do wpisywania (PasswordField) password
