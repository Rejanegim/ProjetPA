package unice.miage.m1.projet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public interface IRobot {

	public static final int xMax = 650; // abscisse maximun de la fenetre
	public static final int yMax = 600; // ordonnee maximun de la fenetre

	public Point getPosition();

	public void setPosition(Point position);

	public void paint(Graphics g);

	public Color getCouleur();

	public void setCouleur(Color c);

	public float getCap();

	public void setCap(float cap);

	public void tourner(float deltaC);

	public void deplacement();

	public void attaque(ArrayList<IRobot> listRobots);

	public int getVie();

	public void setVie(int vie);

	public void setPluginDeplacement(IPluginDeplacement pluginDeplacement);

	public void setPluginGraphique(IPluginGraphique plugingraphique);

	public void setPluginattaque(IPluginAttaque pluginattaque);

	public IPluginAttaque getPluginattaque();

	public IPluginDeplacement getPluginDeplacement();

	public IPluginGraphique getPluginsgraphique();

}
