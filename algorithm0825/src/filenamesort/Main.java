package filenamesort;

public class Main {
	static String[] files= {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File[] files2 = new File[files.length];
		for (int i = 0; i < files.length; i++) {
			files2[i] = new File(files[i]);
		}
		for (int i = 1; i < files2.length; i++) {
			File sorting = files2[i];
			int target = i-1;
			while(target>=0&&compare(sorting,files2[target])) {
				files2[target+1] = files2[target];
				target--;
			}
			files2[target+1] = sorting;
		}
		String[] answer = new String[files.length];
		int i =0;
		for(File f:files2) {
			String name = f.head+f.num;
			if(f.tail!=null) {
				name += f.tail;
			}
			answer[i++] = name;
		}
		for(String e: answer) {
			System.out.println(e);
		}
	}
	static boolean compare(File a,File b) {
		if(a.head.toLowerCase().equals(b.head.toLowerCase())) {
			return(Integer.parseInt(a.num)<Integer.parseInt(b.num)?true:false);
		}else {
			return a.head.compareToIgnoreCase(b.head)<0?true:false;
		}
	}

}

class File{
	String head;
	String num;
	String tail=null;
	File(String x){
		int numIdx=0;
		int numIdx2=0;
		for (int i = 0; i < x.length(); i++) {
			if(Character.isDigit(x.charAt(i))) {
				numIdx = i;
				break;
			}
		}
		numIdx2= numIdx;
		for (int i = numIdx; i < x.length(); i++) {
			if(!Character.isDigit(x.charAt(i))) {
				break;
			}
			numIdx2++;
		}
		this.head=x.substring(0, numIdx);
		this.num = x.substring(numIdx,numIdx2);
		if(!(numIdx2==x.length())) {
			this.tail = x.substring(numIdx2, x.length());
		}
	}
}
