package com.heptalist.demo.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.ReplicatedMapConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

	private static final Logger log = LoggerFactory.getLogger(CacheConfiguration.class);

	@Bean
	public Config config(){
		Config config = new Config().setInstanceName("hazelcast-instance");
		config.getManagementCenterConfig().setEnabled(true).setUrl("http://localhost:8090/hazelcast-mancenter");
		ReplicatedMapConfig replicatedMapConfig = config.getReplicatedMapConfig("instruments");
		replicatedMapConfig.setInMemoryFormat(InMemoryFormat.OBJECT);

		JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		joinConfig.getMulticastConfig().setEnabled(true);
		joinConfig.getTcpIpConfig().setEnabled(false);
		return config;
	}

}
