package kr.human.thread6;

public class TransferThread extends Thread {
    SharedArea sharedArea;
    TransferThread(SharedArea area) {   // 생성자
        sharedArea = area;
    }
    public void run() {
       // 은행 업무 창구에서 입출금이 이루어지고 있다. 
    	for (int cnt = 0; cnt < 12; cnt++) {
			// 동기화 블록 : 작업 전환이 이루어지지 말아라
			sharedArea.transfer();
		}
    }
}
