package goodsquare;

public class Main {

	public static void main(String[] args) {
		int w=3;
		int h=11;
		long total = (long)h*w;
		long deleted = 0;
		for(int x=0; x<w; x++){
            deleted += Math.ceil((double)h*(x+1)/w)-Math.floor((double)h*x/w);
        }
		System.out.println(total-deleted);
	}

}
