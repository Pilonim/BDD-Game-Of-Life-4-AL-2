Feature: Ajout d'une cellule morte
  On veut pouvoir ajouter une cellule morte a la grille

  Scenario: Ajout d'une cellule morte sur une cellule vivante
    Given Une grille de jeu initialisée avec une taille de 10;10
    And Une cellule vivante aux coordonnées 2;2
    When On ajoute une cellule morte aux coordonnées 2;2
    Then La cellule 2;2 doit être morte

    Scenario: Ajout d'une cellule morte sur une cellule deja morte
      Given Une grille de jeu initialisée avec une taille de 5;5
      When On ajoute une cellule morte aux coordonnées 2;2
      Then La cellule 2;2 doit être morte