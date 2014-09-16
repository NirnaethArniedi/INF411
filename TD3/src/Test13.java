
public class Test13 {
	public static void main(String[] args) {
		System.out.println("Testing quad-tree decoding");
		System.out.println("decoding: " + QuadTree.encodeQuadTreeToString(QuadTree.decodeQuadTreeFromString("*1*10010*1110")));
	}
}
