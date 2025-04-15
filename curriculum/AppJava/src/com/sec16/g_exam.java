package com.sec16;

public class g_exam {

	public static void main(String[] args) {
		Thread.Builder builder = Thread.ofVirtual().name("my-", 0);

		long start = System.currentTimeMillis();
		
		switch (builder) {
		    case Thread.Builder.OfVirtual v -> {
		        Thread thread = v.start(() -> {
		            System.out.println("실행 중: " + Thread.currentThread());
		            try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        });
		        try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    case Thread.Builder.OfPlatform p -> {
		    	Thread thread = p.start(() -> {
		    		System.out.println("실행 중: " + Thread.currentThread());
		    		try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	});
		    	try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
		long duration = System.currentTimeMillis() - start;
		System.out.println("실행 시간: " + duration + "ms");
	}

}
