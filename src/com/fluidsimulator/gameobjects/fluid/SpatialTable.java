package com.fluidsimulator.gameobjects.fluid;

import java.util.ArrayList;
import java.util.Iterator;

//SpatialTable is of type generic, and it implements the runnable inteface so that you can iterate over it
abstract public class SpatialTable<V> implements Iterable<V> {
	
	//nearby table size
	private static final int DEFAULT_NEARBY_SIZE = 50;
	private final ArrayList<V> table;
	private ArrayList<V> voidList = new ArrayList<V>(1);
	// the nearby elements table, awesome!!!
	private ArrayList<V>[][] nearby;
	private int row;
	private int column;
	private int i;
	private int j;
	private int tempSize;
	private int z;
	private int x;
	private int y;
	private int xPrev;
	private int yPrev;
	
	//they are created in FluidSimulatorJava code when an object of this class is instantiated
	abstract protected int posX(V value);
	abstract protected int posY(V value);
	abstract protected int prevPosX(V value);
	abstract protected int prevPosY(V value);
	
	//explicitly tell the compiler that the following methods are legal and valid for the
	//data type that we're going to pass
	@SuppressWarnings("unchecked")
	public SpatialTable(int column, int row) {
		this.row = row; 
		this.column = column;
		table = new ArrayList<V>((row*column)/2);
		nearby = new ArrayList[column][row];
	}
	
	//initialize the table with default size
	public void initialize() {
		for (i = 0; i < column; ++i) {
			for (j = 0; j < row; ++j) {
				nearby[i][j] = new ArrayList<V>(DEFAULT_NEARBY_SIZE);
			}
		}
	}
	
	//append any particle to the table and identify its position in space
	public boolean add(V value) {
		addInterRadius(value);
		table.add(value);
		return true;
	}
	
	public Iterator<V> iterator() {
		return table.iterator();
	}
	
	 //Get an item from table.
	public V get(int i) {
		return table.get(i);
	}
	
	public boolean remove(V value) {
		table.remove(value);
		return true;
	}
	
	public void clear() {
		for (i = 0; i < column; ++i) {
			for (j = 0; j < row; ++j) {
				nearby[i][j].clear();
				nearby[i][j] = null;
			}
		}
		table.clear();
	}
	
	public int size() {
		return table.size();
	}
	
	//returns an array of nearby vectors in this table's range
	public ArrayList<V> nearby(V value) {
		x = posX(value);
		y = posY(value);
		if (!inRange(x, y)) 
			return voidList; 
		return nearby[x][y];
	}

	public void updatePosition(V value) {
		x = posX(value);
		y = posY(value);
		xPrev = prevPosX(value);
		yPrev = prevPosY(value);
		if (inRange(xPrev, yPrev))
			nearby[xPrev][yPrev].remove(value);
		if (inRange(x, y))
			nearby[x][y].add(value);
	}
	
	public int sizeNearby(V value) {
		return nearby(value).size();
	}

	//updates the spatial relationship of objects
	public void rehash() {
		for (i=0; i<column; i++) {
			for (j=0; j<row; j++) {
				if (nearby[i][j] != null)
					nearby[i][j].clear();
			}
		}
		tempSize = table.size();
		for (z=0; z<tempSize; z++) {
			addInterRadius(table.get(z));
		}
	}
	
	//Add element to its position and neighbor cells.
	private void addInterRadius(V value) {
		for (i = -1; i < 2; ++i) {
			for (j = -1; j < 2; ++j) {
				x = posX(value)+i;
				y = posY(value)+j;
				if (inRange(x, y))
					nearby[x][y].add(value);
			}
		}
	}
	
	//self explanatory
	private boolean inRange(float x, float y) {
		return (x > 0 && x < column && y > 0 && y < row);
	}

}
