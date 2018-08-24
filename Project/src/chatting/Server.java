package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class Server {
	
	private ServerSocket server;
	private int port = 50000;
	private Socket socket;
	
	void set() {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("���� ���� �غ� ����");
		}
		
	}
	public void accept() {
		try {
			socket = server.accept();
			System.out.println("����� ���� �Ϸ�");
		} catch (IOException e) {
			System.out.println("����� ���� ����.");
		}
		
	}
	public void receiveByte() {
		byte[] buffer = new byte[1024];//ũ��� ���߿� ���� ����
		int size = socket.getInputStream().read();//���� �������� ũ��
		String text = new String(buffer,0,size);//���� �����͸� ��Ʈ������ ��ȯ�ϴ� ����
		//�����͸� ������ �� ����
	}
	public void receiveStr() {
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		while(true) {
			String line = in.readLine();
			//�����͸� ������ �� ����
		}

	}
	public void receiveObj() {
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());//����ó�� ���� ����
		List<String>list = (List<String>)in.readObject();//���� � ������Ʈ������ ���ؾ� ��
		
	}
	public void receiveImg() {
		ImageInputStream in = ImageIO.createImageInputStream(socket.getInputStream());
		
	}
	public void exit() throws IOException {
		socket.close();
		server.close();
		System.out.println("���� ���� �Ϸ�.");
	}
}
