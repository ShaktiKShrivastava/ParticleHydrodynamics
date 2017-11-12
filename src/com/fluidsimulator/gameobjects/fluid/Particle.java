package com.fluidsimulator.gameobjects.fluid;

//importing a 2d vector
import com.badlogic.gdx.math.Vector2;

public class Particle {
	
	//density in the current table
	public float density;
	//density in the nearby table, all tables are 3X3 in dimension
	public float nearDensity;
	
	public float pressure;
	public float nearPressure;
	
	public float mass;
	
	public Vector2 prevPos = new Vector2(0,0);
	public Vector2 pos = new Vector2(0,0);
	
	public Vector2 velocity = new Vector2(0,0);
	
	public int type = 1;
	
	public long spawnTime;
	
	//RGB values for this vector
	public int rGrad = 255;
	public int gGrad = 255;
	public int bGrad = 255;
	
	public Particle() {
		this(0,0);
	}
	
	public Particle(float posX, float posY) {
		this.pos.set(posX, posY);
		this.spawnTime = System.currentTimeMillis();
	}
	
	public Particle(Vector2 newPos) {
		this.pos.set(newPos);
	}
	
	public void setRGrad(int value) {
		if (value < 0)
			value = 0;
		this.rGrad = value;
	}
	
	public void setGGrad(int value) {
		if (value < 0)
			value = 0;
		this.gGrad = value;
	}
	
	public void setBGrad(int value) {
		if (value < 0)
			value = 0;
		this.bGrad = value;
	}
}
