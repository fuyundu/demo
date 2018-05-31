package java8.lambda;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// D:\Java\bin\jvisualvm.exe 找到线程可视化工具
public class TestDeadLock {
	private static Lock lockA = new ReentrantLock();
	private static Lock lockB = new ReentrantLock();

	public static void main(String[] args) {

		// 第一个线程
		new Thread(() -> {
			try {
				// 先拿到锁A,之后休眠2秒后再去获得锁B
				lockA.lock();
				// 休眠2秒
				TimeUnit.SECONDS.sleep(2);
				
				try {
					// 获得锁B
					lockB.lock();
				}finally {
					// 必须在finally里解锁
					lockB.unlock();
				}
				
			}catch(Exception e) {
				
			}finally {
				// 必须在finally里解锁
				lockA.unlock();
			}
		}).start();
		
		// 第二个线程
		
		new Thread(() ->{
			// 首先获取锁B,休眼两秒后再获取锁A
			try {
				lockB.lock();
				TimeUnit.SECONDS.sleep(2);
				
				try {
					lockA.lock();
				}finally {
					lockA.unlock();
				}
			}catch(Exception e) {
				
			}finally {
				lockB.unlock();
			}
			
		}).start();
	}
}
