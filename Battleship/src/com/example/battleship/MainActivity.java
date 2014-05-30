package com.example.battleship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
<<<<<<< HEAD
	
	//##### GLOBAL VARIABLES ###//
=======
>>>>>>> CG
	//The graph of the players area
	public Graph aGraph;
	public boolean[][] aAttacks;
	//The graph of the opponents area
	public Graph bGraph;
	public boolean[][] bAttacks;
<<<<<<< HEAD
	//Screen size
=======
	
	
	
>>>>>>> CG
	public int sizeX, sizeY;
	//The main menu
	public View main;
	//The main game area
	public aView game;
	//The attack view
	public bView attack;
<<<<<<< HEAD
	//Current View
=======
>>>>>>> CG
	public int curView;
	//Single Player boolean
	public boolean singlePlayer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This is where we are creating our view
        singlePlayer = false;
        //Set up boards
        game = new aView(getApplicationContext());
        attack = new bView(getApplicationContext());
        setContentView(R.layout.activity_main);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        sizeX = size.x;
        sizeY = size.y;
        
        //Setting up the system that listens to touch game board
        game.setOnTouchListener(new View.OnTouchListener(){
        	@Override
        	public boolean onTouch(View v, MotionEvent event){
        		
        		//Determining Which Square the user has clicked and marking it as clicked
<<<<<<< HEAD
        		float y = (event.getY() / (sizeY / 15));
        		
        		//If you touch the bottom part of the screen, do this:
=======
        		float x =(event.getX() / (sizeX / 10));
        		float y = (event.getY() / (sizeY / 12));
        		
>>>>>>> CG
        		if(y >= 10){
        			setContentView(attack);
        			curView = 3;
        		}
        		return true;
        	}
        });
<<<<<<< HEAD
        
        //Setting up the system that listens to touch for attack board
=======
>>>>>>> CG
        attack.setOnTouchListener(new View.OnTouchListener(){
        	@Override
        	public boolean onTouch(View v, MotionEvent event){
        		
        		//Determining Which Square the user has clicked and marking it as clicked
        		float x =(event.getX() / (sizeX / 10));
<<<<<<< HEAD
        		float y = (event.getY() / (sizeY / 15));
=======
        		float y = (event.getY() / (sizeY / 12));
>>>>>>> CG
        		
        		if(y < 10 && x < 10){
        			aGraph.touch((int)x,(int)y);
        			aAttacks[(int)x][(int)y] = true;
        	        attack.invalidate();
        		}
<<<<<<< HEAD
        		// 
=======
>>>>>>> CG
        		else if(y >= 10){
        			setContentView(game);
        			curView = 3;
        		}
        		return true;
        	}
        });
        
        //Creating the graph that tracks the back of the screen
        aGraph = new Graph();
        //Boolean graph for attacks [Hit/NoHit]
        aAttacks = new boolean[10][10];
        bAttacks = new boolean[10][10];
        
<<<<<<< HEAD
=======
        aAttacks = new boolean[10][10];
        bAttacks = new boolean[10][10];
        
>>>>>>> CG
        for(int i = 0; i < 10; i++){
        	for(int j = 0; j < 10; j++){
        		aAttacks[i][j] = false;
        		bAttacks[i][j] = false;
        	}
        }
<<<<<<< HEAD
=======
        
>>>>>>> CG
        curView = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onBackPressed() {
    	//curView:
    	// 0 ==
    	// 1 ==
    	// 2 ==
    	// 3 ==
		if(curView == 0 || curView == 1){
			setContentView(R.layout.activity_main);
			if(curView == 1)
				curView = 0;
		}
		else if(curView == 2){
			setContentView(R.layout.activity_main);
			curView = 0;
    	}
		else{
			setContentView(game);
			curView = 2;
		}    
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    // View Class \\ 
    //Allow us to dynamically determine our users screen size and load the view accordingly.
    //Necessary in order to do work on the canvas (how the background and sensor system work)
    public class aView extends View{
	    
    	LinearLayout layout;
    	Button attack;
		Paint paint = new Paint();
		Bitmap boat = BitmapFactory.decodeResource(getResources(), R.drawable.temp_boat);
    	
    	public aView(Context context){
    		super(context);    		
    		this.setBackgroundResource(R.drawable.background1);
    	}
	
		@Override
    	protected void onDraw(Canvas canvas){
    		super.onDraw(canvas);
    		//If we want to have extra things drawn on the screen, this is where the code should go

    		//This first segment is devoted to drawing the button at the bottom
    		paint.setStyle(Paint.Style.FILL);
    		paint.setColor(Color.RED);
    		//Attack Button Size
    		float lx = 0;
    		float rx = getWidth();
    		float ty = getHeight() - (getHeight()/15);
    		float by = getHeight();
    		canvas.drawRect(lx, ty, rx, by, paint);
    		//Draw "ATTACK!" on button
    		paint.setColor(Color.BLACK);
    		paint.setTextSize(20);
    		canvas.drawText("ATTACK!", rx/2, ((ty + by)/2), paint);
    		
    		//Fill graph
    		for(int i = 0; i < 10; i++){
    			for(int j = 0; j < 10; j++){
    				// fill Water
    				if(aGraph.graph[i][j].tag == "water"){
    					lx = i * (sizeX / 10);
    					rx = lx + (sizeX / 10);
    					by = j * (sizeY / 15);
    					ty = by + (sizeY / 15);
    		    		paint.setColor(Color.BLUE);
    					canvas.drawRect(lx, ty, rx, by, paint);
    				}
    				// fill Boat
    				else if(aGraph.graph[i][j].tag == "boat"){
    					canvas.drawBitmap(boat, 0, 0, paint);
    				}
    				// fill Hits
    				if(aGraph.graph[i][j].state == 1){
    					lx = i * (sizeX / 10);
    					rx = lx + (sizeX / 10);
    					by = j * (sizeY / 15);
    					ty = by + (sizeY / 15);
    					// draw Hit
    					if(aGraph.graph[i][j].tag == "ship"){
    						paint.setColor(Color.RED);
    					}
    					// draw miss
    					else{
    						paint.setColor(Color.WHITE);
    					}
    					canvas.drawRect(lx, ty, rx, by, paint);
    				}
    			}
    		}
    	}
	}
    
    //The view class that is responsible for the attack screen
    public class bView extends View{
	    
    	LinearLayout layout;
    	Button attack;
    	Paint paint = new Paint();
    	
    	public bView(Context context){
    		super(context);    		
    		this.setBackgroundResource(R.drawable.background1);
    	}
    	
    	
    	@Override
    	protected void onDraw(Canvas canvas){
    		super.onDraw(canvas);
    		//If we want to have extra things drawn on the screen, this is where the code should go

    		//This first segment is devoted to drawing the button at the bottom
    		Paint paint = new Paint();
    		paint.setStyle(Paint.Style.FILL);
    		paint.setColor(Color.RED);
    		float lx = 0;
    		float rx = getWidth();
    		float ty = getHeight();
    		ty -= getHeight() / 12;
    		float by = getHeight();
    		canvas.drawRect(lx, ty, rx, by, paint);
    		paint.setColor(Color.BLACK);
    		paint.setTextSize(20);
    		canvas.drawText("ATTACK!", rx/2, ((ty + by) / 2), paint);
    		
    		
    		for(int i = 0; i < 10; i++){
    			for(int j = 0; j < 10; j++){
    				if(aGraph.graph[i][j].tag == "water"){
    					lx = i * (sizeX / 10);
    					rx = lx + (sizeX / 10);
    					by = j * (sizeY / 12);
    					ty = by + (sizeY / 12);
    		    		paint.setColor(Color.BLUE);
    					canvas.drawRect(lx, ty, rx, by, paint);
    				}
    				else if(aGraph.graph[i][j].tag == "boat"){
    					Bitmap boat = BitmapFactory.decodeResource(getResources(), R.drawable.temp_boat);
    					canvas.drawBitmap(boat, 0, 0, paint);
    				}
    				if(aGraph.graph[i][j].state == 1){
    					lx = i * (sizeX / 10);
    					rx = lx + (sizeX / 10);
    					by = j * (sizeY / 12);
    					ty = by + (sizeY / 12);
    					if(aGraph.graph[i][j].tag == "ship"){
    						paint.setColor(Color.RED);
    					}
    					else{paint.setColor(Color.WHITE);}
    					canvas.drawRect(lx, ty, rx, by, paint);
    				}
    			}
    		}
    	}
	
	}
    
    //The view class that is responsible for the attack screen
    public class bView extends View{
	    
    	LinearLayout layout;
    	Button attack;
    	
    	public bView(Context context){
    		super(context);    		
    		this.setBackgroundResource(R.drawable.background1);

    	}
	
    	@Override
    	protected void onDraw(Canvas canvas){
    		super.onDraw(canvas);
    		//If we want to have extra things drawn on the screen, this is where the code should go
    		
    		//This first segment is devoted to drawing the button at the bottom 
    		Paint paint = new Paint();
    		paint.setStyle(Paint.Style.FILL);
    		paint.setColor(Color.RED);
    		float lx = 0;
    		float rx = getWidth();
    		float ty = getHeight();
    		ty -= getHeight() / 12;
    		float by = getHeight();
    		canvas.drawRect(lx, ty, rx, by, paint);
    		paint.setColor(Color.BLACK);
    		paint.setTextSize(20);
    		canvas.drawText("Main", rx/2, ((ty + by) / 2), paint);
    		
<<<<<<< HEAD
    		//This first segment is devoted to drawing the button at the bottom 
    		paint.setStyle(Paint.Style.FILL);
    		paint.setColor(Color.RED);
    		float lx = 0;
    		float rx = getWidth();
    		float ty = getHeight() - (getHeight()/15);
    		float by = getHeight();
    		canvas.drawRect(lx, ty, rx, by, paint);
    		//Draw text
    		paint.setColor(Color.BLACK);
    		paint.setTextSize(20);
    		canvas.drawText("Main", rx/2, ((ty + by)/2), paint);
    		
       		for(int i = 0; i < 10; i++){
    			for(int j = 0; j < 10; j++){
    				if(bGraph.graph[i][j].tag == "water" || bGraph.graph[i][j].tag == "boat" ){
    					lx = i * (sizeX/10);
    					rx = lx + (sizeX / 10);
    					by = j * (sizeY / 15);
    					ty = by + (sizeY / 15);
    		    		paint.setColor(Color.BLUE);
    					canvas.drawRect(lx, ty, rx, by, paint);
    				}
    				if(bGraph.graph[i][j].state == 1){
=======
       		for(int i = 0; i < 10; i++){
    			for(int j = 0; j < 10; j++){
    				//Note this needs to be changed to bGraph once bGraph becomes a real thing (i.e. it is being initialized someplace)
    				if(aGraph.graph[i][j].tag == "water" || aGraph.graph[i][j].tag == "boat" ){
    					lx = i * (sizeX / 10);
    					rx = lx + (sizeX / 10);
    					by = j * (sizeY / 12);
    					ty = by + (sizeY / 12);
    		    		paint.setColor(Color.BLUE);
    					canvas.drawRect(lx, ty, rx, by, paint);
    				}

    				//Note this needs to be changed to bGraph once bGraph becomes a real thing (i.e. it is being initialized someplace)
    				if(aGraph.graph[i][j].state == 1){
>>>>>>> CG
    					lx = i * (sizeX / 10);
    					rx = lx + (sizeX / 10);
    					by = j * (sizeY / 12);
    					ty = by + (sizeY / 12);
<<<<<<< HEAD
    					if(bGraph.graph[i][j].tag == "ship"){
=======
        				//Note this needs to be changed to bGraph once bGraph becomes a real thing (i.e. it is being initialized someplace)
    					if(aGraph.graph[i][j].tag == "ship"){
>>>>>>> CG
    						paint.setColor(Color.RED);
    					}
    					else{paint.setColor(Color.WHITE);}
    					canvas.drawRect(lx, ty, rx, by, paint);
    				}
    			}
    		}
    	}
	}
    
    //##########################################################################################################\\
    //###################################### Button Functions ##################################################\\
    //##########################################################################################################\\
    
	public void main_start_btn(View v){		
        setContentView(R.layout.setup_game);
        curView = 1;
	}
	
	public void setup_start_btn(View v){
		curView = 2;
		if(singlePlayer){
			setContentView(game);
		}
		else{
			setContentView(game);
		}
	}

	public void back_btn(View v){
		if(curView == 0 || curView == 1){
			setContentView(R.layout.activity_main);
			if(curView == 1)
				curView = 0;
		}
		else{
			setContentView(game);
			curView = 2;
		}
	}
	
	public void options_single_player(View v){
		singlePlayer = !singlePlayer;
	}
	
	public void different_btn(View v){
		setContentView(R.layout.options);
	}
	
	//##########################################################################################################\\
    //###################################### Storing Game Data #################################################\\
    //##########################################################################################################\\
	
    public class Graph{
    	Node[][] graph;
    	public Graph(){
    		graph = new Node[10][10];
    		for(int i =0; i < 10; i++){
    			for(int j = 0; j < 10; j++){
    				graph[i][j] = new Node(i,j);
    			}	
    		}
    	}
    	//Called when the user touches the screen.
    	//Takes coordinate of event and toast it
    	public void touch(int x, int y){
    		graph[x][y].state = 1;
    		Context context = getApplicationContext();
    		String temp = "You pressed " + x + ", " + y;
    		Toast toast = Toast.makeText(context, temp, Toast.LENGTH_SHORT);
    		toast.show();
    	}
    }
    
    //Classic CS node data type
    //Sits in a graph, holds information
    public class Node{
    	int x,y;			//Coordinates of the node [0-9][0-9]
<<<<<<< HEAD
    	int state;			//0 = Nothing; 1 = hit         
=======
    	int state;			//0 = Nothing, 1 = hit         I wanted this to be an int in case we get into complex types
>>>>>>> CG
    	String tag;			//
    	public Node(int x, int y){
    		tag = "water";
    		this.x = x;
    		this.y = y;
    		state = 0;
    	}	
    }
}
