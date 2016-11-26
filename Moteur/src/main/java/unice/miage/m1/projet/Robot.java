package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Robot implements IRobot {
	private int vie;
	private Color couleur;
	private int vitesse;
	private Point position;
	private float cap ; 
	private int positionScore ;
	
	/** plugin deplacement */
	private IPluginDeplacement pluginDeplacement;
	private ArrayList<IPluginGraphique> pluginsgraphique ; 
	private IPluginAttaque pluginattaque ;
	
	public Robot(IPluginDeplacement d,  ArrayList<IPluginGraphique> g, IPluginAttaque a) {
		// Nombre de points de vie d'un robot
		vie = 100;

		vitesse = 10;

		// Couleur aléatoire du robot
		float randomr = (float) (Math.random()); // opacite de la couleur rouge
		float randomv = (float) (Math.random()); // opacite de la couleur vert
		float randomb = (float) (Math.random()); // opacite de la couleur bleu

		couleur = new Color(randomr, randomv, randomb);

		// Position aléatoire du robot
		int x = (int) (Math.random() * 500);
		int y = (int) (Math.random() * 500);
		position = new Point(x, y);

		// Récupération du plugin permettant de déplacer le robot
		 pluginDeplacement = d;
		 pluginsgraphique = g; 
		 pluginattaque = a ;
		 
	
	}

	
	
	public Robot() {
		vie = 100;

		vitesse = 10;

		// Couleur aléatoire du robot
		float randomr = (float) (Math.random()); // opacite de la couleur rouge
		float randomv = (float) (Math.random()); // opacite de la couleur vert
		float randomb = (float) (Math.random()); // opacite de la couleur bleu

		couleur = new Color(randomr, randomv, randomb);

		// Position aléatoire du robot
		int x = (int) (Math.random() * 500);
		int y = (int) (Math.random() * 500);
		position = new Point(x, y);
		pluginsgraphique = new ArrayList<IPluginGraphique>()  ;

	}



	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getPtMouvement() {
		return vitesse;
	}

	public void setPtMouvement(int ptMouvement) {
		this.vitesse = ptMouvement;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	public float getCap() {
		return cap;
	}

	public void setCap(float cap) {
		this.cap = cap;
	}
	  public void tourner(float deltaC) {
			this.cap = this.getCap() + deltaC;
		}
	
	 
	public int getPositionScore() {
		return positionScore;
	}



	public void setPositionScore(int positionScore) {
		this.positionScore = positionScore;
	}



	public IPluginDeplacement getPluginDeplacement() {
		return pluginDeplacement;
	}

	public void setPluginDeplacement(IPluginDeplacement pluginDeplacement) {
		this.pluginDeplacement = pluginDeplacement;
	}
	
	public void setPluginGraphique(IPluginGraphique plugingraphique) {
		this.pluginsgraphique.add(plugingraphique);
	}

	public void paint(Graphics g) {
		for (IPluginGraphique decor : pluginsgraphique) {
		decor.paint(g, this);
		}
	}

	public void deplacement() {
		// position = pluginDeplacement.deplacement(this);
		if (pluginDeplacement != null) {
			position = pluginDeplacement.deplacement(this,vitesse);
		}
	}
	  
	
	public void attaque() {

	}
}
