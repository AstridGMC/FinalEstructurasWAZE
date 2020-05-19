JCC = javac
JFLAGS = -g
JVM= java

default: WazeGuatemala.class Dato.class LectorArchivo.class Nodo.class Recorrido.class Vertice.class Arista.class Grafos.class Arbol.class ElegirMedio.class Ventana1.class Principal.class

WazeGuatemala.class: waze/guatemala/WazeGuatemala.java
	$(JCC) $(JFLAGS) waze/guatemala/WazeGuatemala.java

Dato.class: Backend/Dato.java
	$(JCC) $(JFLAGS) Backend/Dato.java

LectorArchivo.class: Backend/LectorArchivo.java
	$(JCC) $(JFLAGS) Backend/LectorArchivo.java

Nodo.class: Backend/Nodo.java
	$(JCC) $(JFLAGS) Backend/Nodo.java

Recorrido.class: Backend/Recorrido.java
	$(JCC) $(JFLAGS) Backend/Recorrido.java

Vertice.class: Backend/Grafos/Vertice.java
	$(JCC) $(JFLAGS) Backend/Grafos/Vertice.java

Arista.class: Backend/Grafos/Arista.java
	$(JCC) $(JFLAGS) Backend/Grafos/Arista.java

Grafos.class: Backend/Grafos/Grafos.java
	$(JCC) $(JFLAGS) Backend/Grafos/Grafos.java

Arbol.class:   Backend/Arbol.java
	 $(JCC) $(JFLAGS) Backend/Arbol.java

ElegirMedio.class: UI/ElegirMedio.java
	$(JCC) $(JFLAGS) UI/ElegirMedio.java

Ventana1.class: UI/Ventana1.java
	$(JCC) $(JFLAGS) UI/Ventana1.java
	
Principal.class: UI/Principal.java
	$(JCC) $(JFLAGS) UI/Principal.java


MAIN = waze/guatemala/WazeGuatemala

clean:
	rm -rf Backend/Grafos/*.class
	rm -rf Backend/*.class
	rm -rf UI/*.class
	rm -rf waze/guatemala/*.class

run: $(MAIN).class
	$(JVM) $(MAIN)


