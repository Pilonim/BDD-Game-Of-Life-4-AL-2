Feature: Evolution d'une cellule vivante au fil des generations

  On veut pouvoir observer l'evolution d'une cellule vivante au fil des generations

  Rule: Une cellule vivante possedant deux ou trois voisines vivantes reste vivante

    Scenario: La cellule avec 3 voisins doit rester en vie
      Given Une grille de jeu initialisée avec une taille de 10;10
      And Des cellules vivantes aux coordonnées 2;2 2;3 2;4 3;3
      When On passe a la generation suivante
      Then La cellule 3;3 doit être vivante

    Scenario: La cellule avec 2 voisins doit rester en vie
      Given Une grille de jeu initialisée avec une taille de 10;10
      And Des cellules vivantes aux coordonnées 2;2 2;3 3;3
      When On passe a la generation suivante
      Then La cellule 3;3 doit être vivante

  Rule: une cellule vivante possedant moins de 2 voisins doit mourir

    Scenario: Les cellules doivent mourrir
      Given Une grille de jeu initialisée avec une taille de 10;10
      And Des cellules vivantes aux coordonnées 2;2 2;3
      When On passe a la generation suivante
      Then La cellule 2;3 doit être morte
      And La cellule 2;2 doit être morte

  Rule: une cellule vivante possedant plus de 3 voisines doit mourir

    Scenario: La cellule avec 4 voisins doit mourrir
      Given Une grille de jeu initialisée avec une taille de 10;10
      And Des cellules vivantes aux coordonnées 0;1 1;1 1;2 1;0 2;1
      When On passe a la generation suivante
      Then La cellule 1;1 doit être morte
