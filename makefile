# Variables
JC = javac
JRE = java
# La classe qui contient le "public static void main"
MAIN_CLASS = Main

# Liste des fichiers .class
OFILES = Main.class \
         Accueil.class \
         Case.class \
         ControleurPageJeu.class \
		 ControleurQuitter.class \
         Jeu.class

# Règle par défaut
but : ${OFILES}

# Dépendances et compilation
# En Java, on compile le .java pour obtenir le .class
Main.class : Main.java
	${JC} Main.java

Accueil.class : Accueil.java
	${JC} Accueil.java

Case.class : Case.java
	${JC} Case.java

ControleurPageJeu.class : ControleurPageJeu.java
	${JC} ControleurPageJeu.java

Jeu.class : Jeu.java
	${JC} Jeu.java

ControleurQuitter.class : ControleurQuitter.java
	${JC} ControleurQuitter.java

# Lancer le programme
# On précise le "classpath" (le point .) pour dire à Java de chercher ici
run : but
	${JRE} -cp . ${MAIN_CLASS}

# Nettoyage
clean :
	rm -f *.class

mrproper : clean but

.PHONY : but clean mrproper run