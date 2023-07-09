Feature: Renitialiser la partie
  On veut pouvoir renitialiser une partie a tout moment

  Scenario: Renitialiser une partie
    Given Une grille de jeu initialiser avec une taille de 10;10
    And Des cellules vivantes aux coordonnées 2;2 2;2
    When On renitialise la partie avec une taille de 5;5
    Then Toutes les cellules de la grille sont mortes
    And La taille de la grille est de 5;5