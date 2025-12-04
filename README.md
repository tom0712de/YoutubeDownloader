# Readme
## Youtube Downloader ist eine Java Application, die es ermöglicht leicht Video von Youtube runterzuladen
# Features

- Verschiedene Formate (360p,Audio only, Höchst mögliche Auflösung)
- Komplette Playlist mit nur einer Eingabe runterladen
- Durch Multithreading können bei dem Dowloaden einer Playlist mehrere Video auf verschiedenen Threads runtergeladen werden
- Settings werden gespeichert
# Nutzer Anleitung

- Als erstes muss in den Settings der Ziel Path für die Downloads festgelegt werden(/home/user/dir)
- Falls eine Playlist heruntergeladen werden soll, muss der entsprechende Haken gesetzt werden
- Nach dem alles konfiguriert ist muss der Link zu dem Youtube Video oder der Playlist in das TextFeld auf dem Hauptmenü eingefügt werden.

# Sonstige Infos
Der von uns geschriebene Code befindet sich in src/main/java

zum bauen des Projekts kann der Command ./gradlew build ausgeführt werden

oder zum testen ./gradlew run

Dafür muss Gradle und java installiert sein
Außerdem ist in diesem Ordner noch eine Jar
