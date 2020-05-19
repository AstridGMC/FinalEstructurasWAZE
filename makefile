JFLAGS = -g
JCC = javac
JVM= java
.SUFFIXES: .java .class
.java.class:
	$(JCC) $(JFLAGS) $*.java

CLASSES = \
	waze/guatemala/WazeGuatemala.java \
	Backend/Dato.java \
	Backend/LectorArchivo.java \
	Backend/Nodo.java \
	Backend/Recorrido.java \
	Backend/Grafos/Vertice.java \	
	Backend/Grafos/Arista.java \
	Backend/Grafos/Grafos.java \
	Backend/Arbol.java \
	UI/ElegirMedio.java \
	UI/Ventana1.java \
	UI/Principal.java 

 
default: classes

classes: $(CLASSES:.java=.class)


run: classes
	$(JVM) $(WazeGuatemala)

clean:
	$(RM) *.class


