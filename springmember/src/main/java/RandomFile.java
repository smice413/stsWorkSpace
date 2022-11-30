import java.util.UUID;

public class RandomFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "clock.jpg";
		String extension = filename.substring(filename.lastIndexOf("."), filename.length()); //.jpg가 저장됨
		System.out.println("extension:"+extension);
		
		UUID uuid = UUID.randomUUID(); //첨부파일의 중복 문제를 해결함. 난수를 발생시킴
		System.out.println("uuid:"+uuid);
		
		String newfilename = uuid.toString() + extension; //난수값 String으로 변환+.jpg가 newfilename에 저장
		System.out.println("newfilename:"+newfilename);
		
	}

}
