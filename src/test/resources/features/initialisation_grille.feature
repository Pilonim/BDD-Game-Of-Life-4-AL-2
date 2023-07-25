Feature: Initialiser une grille de jeu

  On veut pouvoir initialiser une grille d'une certaine taille pour commencer un jeu de la vie

  Scenario Outline: Creation d'une grille vide avec une taille donnee
    Given Un jeu de la vie configuré
    When Une grille de taille "<x>" par "<y>" est créée
    Then Toutes les cellules de la grille sont mortes
    Examples:
      | x  | y  |
      | 5  | 3  |
      | 10 | 10 |


  Scenario Outline: Creation d'une grille avec une taille non geree
    Given Un jeu de la vie configuré
    And La taille de grille minimale de 1x1 et maximale de 500x500
    When Une grille de taille "<x>" par "<y>" est créée
    Then Aucune grille n'est créé
    Examples:
      | x                      | y                    |
      | -1                     | -1                   |
      | 0                      | 0                    |
      | 501                    | 501                  |