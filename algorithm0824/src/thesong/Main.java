package thesong;

public class Main {
	static String m="CC#BCC#BCCCCC#BCC#B";
	static String[] musicinfos= {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

	public static void main(String[] args) {
		m = convert(m);
		System.out.println(m);
		int maxLength =0;
		String answer ="";
		boolean flag = false;
		for (int i = 0; i < musicinfos.length; i++) {
			String[] music = musicinfos[i].split(",");
			String song = convert(music[3]);
			System.out.println(song);
			int playedTime =playedTime(music[0],music[1]);
			System.out.println(playedTime);
			String playedSong = extend(song,playedTime);
			System.out.println(playedSong);
			if(playedSong.contains(m)&&playedTime>maxLength) {
				maxLength = playedTime;
				answer = music[2];
				flag = true;
			}
			
		}
		if(!flag) {
			answer = "(NONE)";
		}
		System.out.println(answer);
		
	}

	static int playedTime(String start, String stop) {
		String[] st = start.split(":");
		String[] end = stop.split(":");
		int stTime = Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
		int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
		return endTime - stTime;

	}

	static String extend(String x, int play) {
		if (play >= x.length() * 2) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <play; i++) {
				sb.append(x.charAt(i%x.length()));
			}
			return sb.toString();
		} else if (play <= x.length()) {
			return x.substring(0, play);
		} else {
			return x + x.substring(0, play - x.length());
		}
	}

	static String convert(String x) {
		// c#=2,d#=4,f#=7,g#=9,a#=B
		// c=1,d=3,e=5,f=6,g=8,a=A,b=C
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < x.length() - 1; i++) {
			char c = x.charAt(i);
			if (x.charAt(i + 1) != '#') {
				switch (c) {
				case 'C': {
					sb.append('1');
					break;
				}
				case 'D': {
					sb.append('3');
					break;
				}
				case 'E': {
					sb.append('5');
					break;
				}
				case 'F': {
					sb.append('6');
					break;
				}
				case 'G': {
					sb.append('8');
					break;
				}
				case 'A': {
					sb.append('A');
					break;
				}
				case 'B': {
					sb.append('C');
					break;
				}

				}
			} else {
				switch (c) {
				case 'C': {
					sb.append('2');
					break;
				}
				case 'D': {
					sb.append('4');
					break;
				}
				case 'F': {
					sb.append('7');
					break;
				}
				case 'G': {
					sb.append('9');
					break;
				}
				case 'A': {
					sb.append('B');
					break;
				}
				}
				i++;
			}
		}
		if (x.charAt(x.length() - 1) != '#') {
			char c = x.charAt(x.length() - 1);
			switch (c) {
			case 'C': {
				sb.append('1');
				break;
			}
			case 'D': {
				sb.append('3');
				break;
			}
			case 'E': {
				sb.append('5');
				break;
			}
			case 'F': {
				sb.append('6');
				break;
			}
			case 'G': {
				sb.append('8');
				break;
			}
			case 'A': {
				sb.append('A');
				break;
			}
			case 'B': {
				sb.append('C');
				break;
			}

			}
		}
		return sb.toString();

	}
}
