package com.sec07.Proxy;
public class ServiceProxy {
    private RealService realService = new RealService();

    public void request() {
        System.out.println("[Proxy] Logging access...");
        realService.request();
    }
}
