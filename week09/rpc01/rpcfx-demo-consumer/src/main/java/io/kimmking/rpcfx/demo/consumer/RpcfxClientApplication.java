package io.kimmking.rpcfx.demo.consumer;

import io.kimmking.rpcfx.api.Filter;
import io.kimmking.rpcfx.api.LoadBalancer;
import io.kimmking.rpcfx.api.Router;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.client.RpcfxJDKProxy;
import io.kimmking.rpcfx.client.RpcfxByteBuddy;
import io.kimmking.rpcfx.client.RpcfxCglib;
import io.kimmking.rpcfx.demo.api.User;
import io.kimmking.rpcfx.demo.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RpcfxClientApplication {

	// 二方库
	// 三方库 lib
	// nexus, userserivce -> userdao -> user
	//

	public static void main(String[] args) throws Exception {

		// UserService service = new xxx();
		// service.findById

		//JDK 动态代理实现
		UserService userService = RpcfxJDKProxy.create(UserService.class, "http://localhost:8080/");
		User user = userService.findById(1);

		System.out.println("find user id=1 from server: " + user.getName());

		//cglib代理实现
		UserService userService2 = RpcfxCglib.create(UserService.class, "http://localhost:8080/");
		User user2 = userService2.findById(1);
		System.out.println("find user id=2 from server: " + user2.getName());

		//ByteBuddy字节码增强实现
		UserService userService3 = RpcfxByteBuddy.create(UserService.class, "http://localhost:8080/");
		User user3 = userService3.findById(1);
		System.out.println("find user id=3 from server: " + user3.getName());







//		OrderService orderService = Rpcfx.create(OrderService.class, "http://localhost:8080/");
//		Order order = orderService.findOrderById(1992129);
//		System.out.println(String.format("find order name=%s, amount=%f",order.getName(),order.getAmount()));
//
//		//
//		UserService userService2 = Rpcfx.createFromRegistry(UserService.class, "localhost:2181", new TagRouter(), new RandomLoadBalancer(), new CuicuiFilter());

//		SpringApplication.run(RpcfxClientApplication.class, args);
	}

	private static class TagRouter implements Router {
		@Override
		public List<String> route(List<String> urls) {
			return urls;
		}
	}

	private static class RandomLoadBalancer implements LoadBalancer {
		@Override
		public String select(List<String> urls) {
			return urls.get(0);
		}
	}

	@Slf4j
	private static class CuicuiFilter implements Filter {
		@Override
		public boolean filter(RpcfxRequest request) {
			//log.info("filter {} -> {}", this.getClass().getName(), request.toString());
			return true;
		}
	}
}



