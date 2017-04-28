package bills;


public class ThreadTest extends Thread{

	@Override
	public void run(){
		/*TestCuserBillsRequest cuserRequest = new TestCuserBillsRequest();
		
		cuserRequest.cuserSend();*/
		
		/*TestBuserBillsRequest buserRequest = new TestBuserBillsRequest();
		
		buserRequest.buserBillsend();*/
		
		TestGiroBillsRequest giroRequest = new TestGiroBillsRequest();
		
		giroRequest.giroBillSend();
	}
	
	public static void main(String aargs[]){
		for(int i=0;i<3;i++){
			ThreadTest test = new ThreadTest();
			test.start();
		}
	}
}
