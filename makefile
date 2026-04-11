# Variables
JC = javac
JRE = java
# La classe qui contient le "public static void main"
MAIN_CLASS = Main

# Liste des fichiers .class
OFILES = Main.class \
         Accueil.class \
         Case.class \
         Jeu.class \
		 Taille.class \
		 ControleurPageTaille.class \
		 ControleurAccueil.class \
		 configFenetre.class \
		 Grille.class \
		 etatCase.class \
		 ControleurValider.class \
		 ControleurCase.class \
		 configTaille.class \
		 fenetreResultat.class \
		 compteurMines.class \
		 ControleurResultat.class \
		 ControleurMenu.class

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

Jeu.class : Jeu.java
	${JC} Jeu.java

Taille.class : Taille.java
	${JC} Taille.java

ControleurPageTaille.class : ControleurPageTaille.java
	${JC} ControleurPageTaille.java

ControleurAccueil.class : ControleurAccueil.java	
	${JC} ControleurAccueil.java

configFenetre.class : configFenetre.java
	${JC} configFenetre.java

Grille.class : configFenetre.java
	${JC} configFenetre.java

etatCase.class : configFenetre.java
	${JC} configFenetre.java

ControleurValider.class : configFenetre.java
	${JC} configFenetre.java

ControleurCase.class : ControleurCase.java
	${JC} ControleurCase.java

configTaille.class : ControleurCase.java
	${JC} ControleurCase.java

fenetreResultat.class : ControleurCase.java
	${JC} ControleurCase.java

compteurMines.class : ControleurCase.java
	${JC} ControleurCase.java

ControleurResultat.class : ControleurCase.java
	${JC} ControleurCase.java

ControleurMenu.class : ControleurMenu.java
	${JC} ControleurMenu.java




# Lancer le programme
# On précise le "classpath" (le point .) pour dire à Java de chercher ici
run : but
	${JRE} -cp . ${MAIN_CLASS}

# Nettoyage
clean :
	rm -f *.class

mrproper : clean but

.PHONY : but clean mrproper run