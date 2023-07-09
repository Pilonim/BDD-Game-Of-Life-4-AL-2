Feature: Evolution d'une cellule morte au fil des generations

  On veut pouvoir observer l'evolution d'une cellule morte au fil des generations

  Rule: Une cellule morte possedant exactement trois voisines vivantes devient vivante (elle nait)

    Scenario: Une cellule doit naitre
      Given Une grille de jeu initialiser avec une taille de 10;10
      And Des cellules vivantes aux coordonnées 2;2 2;3 2;4
      When On passe a la generation suivante
      Then La cellule 3;3 doit être vivante
      And La cellule 1;3 doit être vivante

    Scenario: Une cellule ne doit pas naitre
      Given Une grille de jeu initialiser avec une taille de 10;10
      When On passe a la generation suivante
      Then Aucune cellule ne doit naître