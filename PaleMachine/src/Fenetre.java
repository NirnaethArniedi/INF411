// INF421a - L. Castelli Aleardi (2010)

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* permet de dessiner des points 2d */
class Fenetre extends Canvas {
	static int xLocation = 0;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// double latmin = 41.0 ,latmax = 52.0 ,lonmin = -6, lonmax = 10.0;
    double xMin = 2.0 ,xMax = 62.0 ,yMin = 0, yMax = 60.0; // coordinate range
	
	ConcurrentLinkedQueue<Point2D> points=new ConcurrentLinkedQueue<Point2D>();
	ConcurrentLinkedQueue<Point2D> redPoints=new ConcurrentLinkedQueue<Point2D>();
	ConcurrentLinkedQueue<Point2D> bluePoints=new ConcurrentLinkedQueue<Point2D>();
	ConcurrentLinkedQueue<GridCell> cellules=new ConcurrentLinkedQueue<GridCell>();
   
    // Constructeur
    public Fenetre(LinkedList<Point2D> points) {
    this.points.addAll(points);
	Frame f = new Frame("Fenetre");
	f.add(this);
	f.setSize(300, 300);
	f.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    System.exit(0);
		}
	    });
	f.setLocation(xLocation, 0);
	xLocation+=300;
	f.setVisible(true);
    }

    public int tY(double y, double yMin, double yMax, int h) {
    	return h- (int)((y-yMin)/(yMax-yMin)*h);
    }
    
    public int tX(double x, double xMin, double xMax, int w) {
    	return (int) ((x-xMin)/(xMax-xMin)*w);
    }

    // dessiner un point
    public void dessine(Graphics g, Point2D p,double xMin,double yMin, double xMax, double yMax, int w, int h) {
    	if(p==null) return;
    	double x=p.getX();
    	double y=p.getY();
    	g.fillOval(tX(x,xMin,xMax,w)-2,tY(y,yMin,yMax,h)-2,4,4);
    } 

    // dessiner un disque
    public void dessineCercle(Graphics g, Point2D p,double xMin,double yMin, double xMax, double yMax, int w, int h) {
    	if(p==null) return;
    	double x=p.getX();
    	double y=p.getY();
    	g.fillOval(tX(x,xMin,xMax,w)-2,tY(y,yMin,yMax,h)-2,6,6);
    } 

    // dessiner un disque
    public void dessineCellule(Graphics g, GridCell c,double xMin,double yMin, double xMax, double yMax, int w, int h) {
    	if(c==null) return;
    	Point2D p=new Point2D(c.x, c.y);
    	Point2D q=new Point2D(c.x+c.R, c.y+c.R);
    	double P_x=p.getX();
    	double P_y=p.getY();
    	double Q_x=q.getX();
    	double Q_y=q.getY();
    	g.drawLine(tX(P_x,xMin,xMax,w),tY(P_y,yMin,yMax,h),tX(Q_x,xMin,xMax,w),tY(P_y,yMin,yMax,h));
    	g.drawLine(tX(P_x,xMin,xMax,w),tY(P_y,yMin,yMax,h),tX(P_x,xMin,xMax,w),tY(Q_y,yMin,yMax,h));
    	g.drawLine(tX(P_x,xMin,xMax,w),tY(Q_y,yMin,yMax,h),tX(Q_x,xMin,xMax,w),tY(Q_y,yMin,yMax,h));
    	g.drawLine(tX(Q_x,xMin,xMax,w),tY(P_y,yMin,yMax,h),tX(Q_x,xMin,xMax,w),tY(Q_y,yMin,yMax,h));
    } 

    // dessiner une ville avec la couleur c
    void dessinePointColore(Graphics g, Color c) {
    	g.setColor(c);
    }
    
    public void addRedPoint(Point2D p) {
    	if(p==null) {
    		System.out.println("error: null point");
    		return;
    	}
    	this.redPoints.add(p);
    	this.repaint();
    }

    public void addBluePoint(Point2D p) {
    	if(p==null) {
    		System.out.println("error: null point");
    		return;
    	}
    	this.bluePoints.add(p);
    	this.repaint();
    }

    public void addRedPoint(LinkedList<Point2D> l) {
    	if(l==null) {
    		System.out.println("error: no point list defined");
    		return;
    	}
    	this.redPoints.addAll(l);
    	this.repaint();
    }

    public void addCell(GridCell c) {
    	if(c==null) {
    		System.out.println("error: no grid cell defined");
    		return;
    	}
    	this.cellules.add(c);
    	this.repaint();
    }
	
    public void paint(Graphics g) {
    	//g.setColor(Color.black);

    	ConcurrentLinkedQueue<Point2D> l=this.points;
    	int h=this.getHeight();
    	int w=this.getWidth();
    	
        Iterator< Point2D > iterator = l.iterator();
        while ( iterator.hasNext() ) {
             Object element=iterator.next();
             Point2D p=(Point2D)element;
             dessine(g,p,xMin,yMin,xMax,yMax,w,h);
        }
        

        g.setColor(Color.blue);
        iterator = this.bluePoints.iterator();
        while ( iterator.hasNext() ) {
             Object element=iterator.next();
             Point2D p=(Point2D)element;
             dessineCercle(g,p,xMin,yMin,xMax,yMax,w,h);
        }

        g.setColor(Color.red);
        iterator = this.redPoints.iterator();
        while ( iterator.hasNext() ) {
             Object element=iterator.next();
             Point2D p=(Point2D)element;
             dessine(g,p,xMin,yMin,xMax,yMax,w,h);
        }

        g.setColor(Color.blue);
        Iterator<GridCell> cellIterator = this.cellules.iterator();
        while (cellIterator.hasNext()) {
             Object element=cellIterator.next();
             GridCell c=(GridCell)element;
             dessineCellule(g,c,xMin,yMin,xMax,yMax,w,h);
        }
        

    }
    
    public void init() {
    	if(this.points==null) {
    		throw new Error("Lecture donnees a' completer");
    		//this.villes=ListeVille.lireVilles();
    	}
    }
    
    public static Point2D[] readPointCoordinates(String filename){
    	Point2D[] result=null;
    	double x, y;
    	File file;
    	FileReader readfic;
    	BufferedReader input;
    	String line;
    	System.out.print("Reading coordinates from input file: ");
    	try{
    		System.out.print(filename+" ...");
    		file = new File(filename);
    		readfic = new FileReader(file);
    		input = new BufferedReader(readfic);
            
            line=input.readLine(); // first line gives the number of points
            StringTokenizer tok = new StringTokenizer(line);
            int N=Integer.parseInt(tok.nextToken());
            
            result=new Point2D[N];
            
            int i=0;
            //System.out.println("Reading vertices..."+N);
            while(i<N) {
                line=input.readLine();
                tok = new StringTokenizer(line);

                x=(new Double(tok.nextToken())).doubleValue();
                y=(new Double(tok.nextToken())).doubleValue();
                //z=(new Double(tok.nextToken())).doubleValue();
                
                result[i]=new Point2D(x,y);
                //System.out.println(""+result[i]);
                i++;
            }
            System.out.println(" done");
            input.close();
	}
	catch(FileNotFoundException e){
	    //Efichier.erreur(e);
	}
	catch(IOException e){
	    //Efichier.erreur(e);
	}
	
	return result;
    }
    
    // petit test
    public static void main(String args[]) {
    	Point2D[] pointArray=readPointCoordinates("france_echantillon.txt");    	
    	
    	LinkedList<Point2D> l=new LinkedList<Point2D>();
    	for(int i=0;i<pointArray.length;i++)
    		l.add(pointArray[i]);
    	
    	Fenetre f = new Fenetre(l);
    	f.addRedPoint(new Point2D(44.0,5.0));
    	f.init();
    	f.repaint();
    }
}
