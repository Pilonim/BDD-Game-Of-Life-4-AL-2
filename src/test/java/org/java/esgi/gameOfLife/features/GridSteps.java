package org.java.esgi.gameOfLife.features;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.java.esgi.gameOfLife.Grid;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GridSteps {
    private Grid grid;

    @Given("^Un jeu de la vie configuré$")
    public void unJeuDeLaVieConfigure() {
        try {
            Class.forName("org.java.esgi.gameOfLife.Grid");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Grid");
        }
    }

    @When("^Une grille de taille \"([^\"]*)\" par \"([^\"]*)\" est créée$")
    public void uneGrilleDeTailleParEstCree(Integer width, Integer height){
        grid = new Grid(width,height);
    }

    @Then("^Toutes les cellules de la grille sont mortes$")
    public void toutesLesCellulesDeLaGrilleSontMortes() {
        boolean contains = false;
        for(Integer i = 0; i < grid.getGrid().length; i++){
            for (Integer j = 0; j< grid.getGrid()[0].length; j++){
                if(grid.getGrid()[i][j] == 1){
                    contains = true;
                }
            }
        }
        assertFalse(contains);
    }

    @And("^La taille de grille minimale de (\\d+)x(\\d+) et maximale de (\\d+)x(\\d+)$")
    public void laTailleDeGrilleMinimaleDeXEtMaximaleDeX(Integer widthMin, Integer heightMin, Integer widthMax, Integer heightMax) {
        Grid grid = new Grid(widthMin,heightMax);
        assertEquals(grid.getMINSIZE(), widthMin);
        assertEquals(grid.getMAXSIZE(), widthMax);
    }

    @Then("^Aucune grille n'est créé$")
    public void aucuneGrilleNEstCree() {
        assertNull(grid.getGrid());
    }

    @Given("Une grille de jeu initialisée avec une taille de {int};{int}")
    public void uneGrilleDeJeuInitialiserAvecUneTailleDeX(Integer width, Integer height) {
        grid = new Grid(width,height);
    }

    @When("Une cellule est créée aux coordonnées {int};{int}")
    public void uneCelluleEstCréeAuxCoordonnéesX(Integer x1, Integer y1) {
        grid.reAwake(x1,y1);
    }

    @Then("La cellule {int};{int} doit être vivante")
    public void laCelluleXDoitÊtreVivante(Integer x1, Integer y1) {
        assertTrue(grid.isAlive(x1,y1));
    }

    @And("Une cellule vivante aux coordonnées {int};{int}")
    public void uneCelluleVivanteAuxCoordonnéesX(Integer x1, Integer y1) {
        grid.reAwake(x1,y1);
    }

    @And("Des cellules vivantes aux coordonnées {int};{int} {int};{int} {int};{int}")
    public void desCellulesVivantesAuxCoordonnées(Integer x1, Integer y1, Integer x2, Integer y2, Integer x3, Integer y3) {
        grid.reAwake(x1,y1);
        grid.reAwake(x2,y2);
        grid.reAwake(x3,y3);
    }

    @When("On passe a la generation suivante")
    public void onPasseALaGenerationSuivante() {
        grid.nextStep();
    }

    @Then("Aucune cellule ne doit naître")
    public void aucuneCelluleNeDoitNaître() {
        boolean contains = false;
        for(Integer i = 0; i < grid.getGrid().length; i++){
            for (Integer j = 0; j< grid.getGrid()[0].length; j++){
                if(grid.getGrid()[i][j] == 1){
                    contains = true;
                }
            }
        }

        assertFalse(contains);
    }

    @And("Des cellules vivantes aux coordonnées {int};{int} {int};{int} {int};{int} {int};{int}")
    public void desCellulesVivantesAuxCoordonnées(Integer x1, Integer y1, Integer x2, Integer y2, Integer x3, Integer y3, Integer x4, Integer y4) {
        grid.reAwake(x1,y1);
        grid.reAwake(x2,y2);
        grid.reAwake(x3,y3);
        grid.reAwake(x4,y4);

    }

    @And("Des cellules vivantes aux coordonnées {int};{int} {int};{int}")
    public void desCellulesVivantesAuxCoordonnées(Integer x1, Integer y1, Integer x2, Integer y2) {
        grid.reAwake(x1,y1);
        grid.reAwake(x2,y2);
    }

    @Then("La cellule {int};{int} doit être morte")
    public void laCelluleDoitÊtreMorte(Integer x1, Integer y1) {
        assertFalse(grid.isAlive(x1,y1));
    }


    @When("On redimensionne la grille en {int};{int}")
    public void onRedimenssionneLaGrilleEn(Integer x1, Integer y1) {
        grid.resize(x1,y1);
    }

    @Then("La taille de la grille est de {int};{int}")
    public void laTailleDeLaGrilleEstDe(Integer x1, Integer y1) {
        assertEquals(x1, grid.width);
        assertEquals(y1, grid.height);
    }

    @When("On réinitialise la partie avec une taille de {int};{int}")
    public void onRenitialiseLaPartieAvecUneTailleDe(Integer width, Integer height) {
        grid = new Grid(width,height);
    }

    @And("Des cellules vivantes aux coordonnées {int};{int} {int};{int} {int};{int} {int};{int} {int};{int}")
    public void desCellulesVivantesAuxCoordonnées(Integer x1, Integer y1, Integer x2, Integer y2, Integer x3, Integer y3, Integer x4, Integer y4, Integer x5, Integer y5) {
        grid.reAwake(x1,y1);
        grid.reAwake(x2,y2);
        grid.reAwake(x3,y3);
        grid.reAwake(x4,y4);
        grid.reAwake(x5,y5);
    }

    @When("On ajoute une cellule morte aux coordonnées {int};{int}")
    public void onAjouteUneCelluleMorteAuxCoordonnées(Integer x1, Integer y1) {
        grid.kill(x1,y1);
    }
}
