/**
 * 
 */
import java.io.*;
import java.net.*;

/**
 * @author �ﳿ�
 *
 */
public class MyTcp {
	private BufferedReader reader; // ����BufferedReader����
	private ServerSocket server; // ����ServerSocket����
	private Socket socket; // ����Socket����socket
	private int port = 8998;
	
			void getserver() {
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				while (true){
					try {
						server = new ServerSocket(port); // ʵ����Socket����
						System.out.println("�������׽����Ѿ������ɹ�"); // �����Ϣ
						while (true) { // ����׽���������״̬
							System.out.println("�ȴ��ͻ���������"); // �����Ϣ
							socket = server.accept(); // ʵ����Socket����
							port++;
							System.out.println(port);
							reader = new BufferedReader(new InputStreamReader(socket
									.getInputStream())); // ʵ����BufferedReader����
							getClientMessage(); // ����getClientMessage()����
						}
					} catch (Exception e) {
						e.printStackTrace(); // ����쳣��Ϣ
					}
				}
			}});
		t.start();
	}
	
	private void getClientMessage() {
		try {
			while (true) { // ����׽���������״̬
				if (reader.ready()) {
					// ��ÿͻ�����Ϣ
					System.out.println("�ͻ���:" + reader.readLine());
				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
		try {
			if (reader != null) {
				reader.close(); // �ر���
			}
			if (socket != null) {
				socket.close(); // �ر��׽���
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MyTcp tcp = new MyTcp(); // �����������
		tcp.getserver(); // ���÷���
	}

}
