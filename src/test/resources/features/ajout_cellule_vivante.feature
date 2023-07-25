Feature: Ajout d'une cellule vivante

  On veut pouvoir ajouter une cellule vivante a la main apres l'initialisation

  Scenario: Ajout d'une cellule apres l'initialisation
    Given Une grille de jeu initialisée avec une taille de 10;10
    When Une cellule est créée aux coordonnées 5;5
    Then La cellule 5;5 doit être vivante

  Scenario: Ajout d'une cellule sur une cellule deja vivante
    Given Une grille de jeu initialisée avec une taille de 10;10
    And Une cellule vivante aux coordonnées 5;5
    When Une cellule est créée aux coordonnées 5;5
    Then La cellule 5;5 doit être vivante

