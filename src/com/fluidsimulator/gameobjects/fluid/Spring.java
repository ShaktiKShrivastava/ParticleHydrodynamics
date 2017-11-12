package com.fluidsimulator.gameobjects.fluid;

//using 2 particles or vectors, we can create a thread like structure which we call a spring
//Now the concept of a particle has emerged to a thread like structure, defined by 2 end points.
//when this mass hits another, we have to manipulate the distance between the end points and the 
//position of the 2 end points.
public class Spring {
	
	public Particle pi;
	public Particle pj;
	public float restLength;
	public float currentDistance;
	
	public Spring(Particle p1, Particle p2, float restLength) {
		this.pi = p1;
		this.pj = p2;
		this.restLength = restLength;
	}
	
	public void update() {
		//uses the function  float	dst(Vector2 v) of the class vector2 to get the distance between
		//2 vectors
		this.currentDistance = pi.pos.dst(pj.pos);
	}
	
	public boolean contains(Particle p) {
		//hashCode is overridden function in vector2 class defined in java.lang.object which vector2 in  
		//com.badlogic.gdx.math has inherited. It returns unique integer for unique objects
		//thus here we're trying to find out if p and pj, or p and pi are the same particle or not
		return (pi.hashCode() == p.hashCode() || pj.hashCode() == p.hashCode());
	}
}
