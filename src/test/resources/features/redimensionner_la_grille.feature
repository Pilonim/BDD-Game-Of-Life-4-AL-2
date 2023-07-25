Feature: Redimension de la grille de jeu

  On veut pouvoir redimenssionner la grille de jeu sans affecter l'etat des cellule qui sont dedans

  Rule: La grille doit être redimenssioner en gardant l'etat de toutes les cellules a l'interrieur du redimenssionnement

    Scenario: Redimensionner une grille avec que des cellules mortes
      Given Une grille de jeu initialisée avec une taille de 10;10
      When On redimensionne la grille en 5;5
      Then La taille de la grille est de 5;5
      And Toutes les cellules de la grille sont mortes

    Scenario: Redimensionner une grille avec des cellules en vie a l'interrieur du redimenssionnement
      Given Une grille de jeu initialisée avec une taille de 10;10
      And Une cellule vivante aux coordonnées 2;2
      When On redimensionne la grille en 5;5
      Then La cellule 2;2 doit être vivante

    Scenario: Redimensionner une grille avec des cellules en vie a l'exterieur du redimenssionnement
      Given Une grille de jeu initialisée avec une taille de 10;10
      And Une cellule vivante aux coordonnées 8;8
      When On redimensionne la grille en 5;5
      Then Toutes les cellules de la grille sont mortes