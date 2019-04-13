package com.hunau;

import com.hunau.netty.main.BroadcastMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TtAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(TtAdminApplication.class, args);
		BroadcastMain.broadcastMain();
	}

}
