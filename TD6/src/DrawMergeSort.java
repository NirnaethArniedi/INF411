import java.awt.Color;
import maclib.*;

public class DrawMergeSort {

	GrafPort g; // port
	int width; // width of the frame
	int height; // height of the frame

	static int sleepTime = 80; // sleeping time between events
	static int framePosition = 50; // x coordinate of the next frame

	// create a new frame
	public DrawMergeSort(String title, int width, int height) {
		this.g = new GrafPort(title, width, height);
		this.g.getPanel().getParent().setLocation(framePosition, 50);
		this.width = width;
		this.height = height;
		framePosition = framePosition + width + 10;
	}

	// paint a red rectangle
	void paintRed(Rect rect) {
		g.foreColor(Color.RED);
		g.paintRect(rect);
	}
	
	// paint a gray rectangle
	void paintGray(Rect rect) {
		g.foreColor(Color.GRAY);
		g.paintRect(rect);
	}
	
	// paint a black rectangle
	void paintBlack(Rect rect) {
		g.foreColor(Color.BLACK);
		g.paintRect(rect);
	}
	
	// paint a blue rectangle
	void paintBlue(Rect rect) {
		g.foreColor(Color.BLUE);
		g.paintRect(rect);
	}

	// erase a rectangle
	void erase(Rect rect) {
		g.eraseRect(rect);
	}
	
	// create a rectangle on the top of the picture, at position i and of height proportional to t[i]
	Rect rectTop(int[] t, int i) {
		int l = t.length;
		return new Rect((width*i)/l, (height/2*(l-t[i]))/l, (width*(i+1))/l-1, height/2);
	}

	// create a rectangle on the bottom of the picture, at position i and of height proportional to t[i]
	Rect rectBottom(int[] t, int i) {
		int l = t.length;
		return new Rect((width*i)/l, (height/2*(2*l-t[i]))/l, (width*(i+1))/l-1, height);
	}

	// create a rectangle on the bottom of the picture corresponding to the zone between positions i and j
	Rect zoneBottom(int[] t, int i, int j) {
		int l = t.length;
		return new Rect((width*i)/l, height/2, (width*j)/l, height);
	}
	
	// create a rectangle on the bottom of the picture corresponding to the zone between positions i and j
	Rect zoneTop(int[] t, int i, int j) {
		int l = t.length;
		return new Rect((width*i)/l, 0, (width*j)/l, height/2);
	}

	// draw the table t
	void draw(int[] t) {
		for (int i = 0; i < t.length; i++)
			paintBlack(rectTop(t, i));
	}

	// make a pause
	public void pause(int t) {
		try {
			Thread.sleep(sleepTime*t);
		} catch (Exception ex) {
			// System.out.println(ex);
		}
	}

	// draw the merging of t[l..m[ and t[m..r[ into t[l..r[
	void drawMerge(int[] t, int l, int m, int r) {
		int i = l, j = m, L = t.length;
		int[] tmp = new int[L];
		paintGray(zoneBottom(t, l, r));
		for (int k = l; k < r; k++) {
			if (i < m) paintRed(rectTop(t, i));
			if (j < r) paintRed(rectTop(t, j));
			pause(2);
			if (i < m && (j == r || t[i] <= t[j])) {
				tmp[k] = t[i];
				erase(rectTop(t, i));
				paintBlack(rectBottom(tmp, k));
				i++;
			}
			else {
				tmp[k] = t[j];
				erase(rectTop(t, j));
				paintBlack(rectBottom(tmp, k));
				j++;
			}
		}
		for (int k = l; k < r; k++) {
			t[k] = tmp[k];
			paintGray(rectBottom(tmp, k));
			paintBlack(rectTop(t, k));	
			pause(1);
		}
		erase(zoneBottom(t, l, r));
	}
	
	// find the longest run in the table
	int drawFindRun(int[] t, int l) {
		paintRed(rectTop(t, l));
		//paintGray(zoneBottom(t,l,l+1));
		pause(10);
		while (++l < t.length && t[l-1] <= t[l]) {
			paintGray(rectTop(t, l));
			//paintGray(zoneBottom(t,l,l+1));
			pause(10);
		}
		for(int i=0; i<5; i++){
			paintBlue(rectTop(t, l));
			pause(2);
			paintBlack(rectTop(t, l));
			pause(2);
		}
		paintBlue(rectTop(t, l));
		return l;
	}
}
