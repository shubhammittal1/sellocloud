package com.bmp.model.app.api;

import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bmp.oms.service.api.VendorApiService;

@Component
public class TrackingConsumer implements Runnable {

    @Resource(name = "trackingQueue")
    private BlockingQueue<String> queue;

    @Resource(name = "vendorApiServiceImpl")
    private VendorApiService vendorApiService;

    @Override
    public void run() {
        while (true) {
            try {
                String courierAwb = queue.take();
                System.out.println("Processing AWB: " + courierAwb);
                vendorApiService.getVendorApiCall(null, null, courierAwb);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



/*public class TrackingConsumer implements Runnable {

    private BlockingQueue<String> queue;
    
    @Autowired
	@Qualifier("vendorApiServiceImpl")
	private VendorApiService vendorApiService;
    

    public TrackingConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // take() blocks until data is available
                String courierAwb = queue.take();

                System.out.println("Processing webhookId: " + courierAwb);

                // Call your processing logic here
                processWebhook(courierAwb);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void processWebhook(String courierAwb) {
        // DB fetch + business logic
    	try {
			ResponseBean responseBean = vendorApiService.getVendorApiCall(null, null, courierAwb);
			if(ResponseStatus.FAIL.equals(responseBean.getStatus())) {
				System.out.println("Processed webhook Fail: " + courierAwb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // System.out.println("Processed webhook: " + webhookKey);
    }
}*/
